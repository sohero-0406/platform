/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.lang.NumberUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.utils.excel.ExcelImport;
import com.jeesite.modules.common.dao.CommonAssessmentSchemeDao;
import com.jeesite.modules.common.dao.CommonAssessmentStuDao;
import com.jeesite.modules.common.dao.CommonUserDao;
import com.jeesite.modules.common.entity.*;
import com.jeesite.modules.common.util.CommonUserUtil;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.omg.IOP.Codec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.dao.CommonAssessmentDao;
import org.springframework.web.multipart.MultipartFile;

/**
 * 考核表Service
 * @author mayuhu
 * @version 2019-08-05
 */
@Service
@Transactional(readOnly=true)
public class CommonAssessmentService extends CrudService<CommonAssessmentDao, CommonAssessment> {

	@Autowired
	private CommonAssessmentStuService commonAssessmentStuService;
	@Autowired
	private CommonUserService commonUserService;
	@Autowired
	private CommonAssessmentSchemeService commonAssessmentSchemeService;

	/**
	 * 获取单条数据
	 * @param commonAssessment
	 * @return
	 */
	@Override
	public CommonAssessment get(CommonAssessment commonAssessment) {
		return super.get(commonAssessment);
	}
	
	/**
	 * 查询分页数据
	 * @param commonAssessment 查询条件 commonAssessment.page 分页对象
	 *
	 * @return
	 */
	@Override
	public Page<CommonAssessment> findPage(CommonAssessment commonAssessment) {

		return super.findPage(commonAssessment);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonAssessment
	 */
	//@Override
	@Transactional(readOnly=false)
	public CommonResult save(CommonAssessment commonAssessment, String userConfig) {
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(commonAssessment.getId()==null){
			if(CommonUserUtil.isHaveExamRight(loginUser)){
				//commonAssessment.setStatus("2");
				super.save(commonAssessment);
				return saveCommonSchemeStus(commonAssessment, userConfig);
			}else{
				return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
			}
		}else{
			CommonAssessment c = super.get(commonAssessment.getId());
			if(!c.getStatus().equals("0")){
				return new CommonResult(CodeConstant.DATA_LOCK, "该数据不能修改");
			}
			CommonUser creator = commonUserService.get(commonAssessment.getCreateBy());
			if(loginUser.getRoleId().equals("1")||(loginUser.getSchoolId().equals(creator.getSchoolId()))){
				super.update(commonAssessment);
				CommonAssessmentStu con = new CommonAssessmentStu();
				con.setAssessmentId(commonAssessment.getId());
				List<CommonAssessmentStu> stuList = commonAssessmentStuService.findList(con);
				if(ListUtils.isNotEmpty(stuList)){
					for (CommonAssessmentStu stu : stuList) {
						commonAssessmentStuService.phyDelete(stu);
					}
				}
				return saveCommonSchemeStus(commonAssessment, userConfig);
			}else{
				return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
			}
		}

	}

	private CommonResult saveCommonSchemeStus(CommonAssessment commonAssessment, String userConfig) {
		String assessmentId = commonAssessment.getId();
		CommonAssessmentScheme commonAssessmentScheme = commonAssessmentSchemeService.get(commonAssessment.getAssessmentSchemeId());
		JSONArray schemeDetails = JSONArray.parseArray(commonAssessmentScheme.getSchemeDetails());
		JSONArray softUploadedMarks = new JSONArray();
		for (int i = 0; i < schemeDetails.size(); i++) {
			JSONObject jsonObject = schemeDetails.getJSONObject(i);
			JSONArray softDetails = JSONArray.parseArray(jsonObject.getString("softDetails"));
			for (int j = 0; j < softDetails.size(); j++) {
				JSONObject oneSoft = softDetails.getJSONObject(j);
				JSONObject oneMark = new JSONObject();
				oneMark.put("softwareId", oneSoft.getString("softwareId"));
				oneMark.put("mark", "0");
				softUploadedMarks.add(oneMark);
			}
		}
		JSONArray jsonArray = JSONArray.parseArray(userConfig);
		for (int i = 0; i < jsonArray.size() ; i++) {
			JSONObject jo = jsonArray.getJSONObject(i);
			CommonAssessmentStu commonAssessmentStu = new CommonAssessmentStu();
			commonAssessmentStu.setAssessmentId(assessmentId);
			commonAssessmentStu.setCommonUserId(jo.getString("commonUserId"));
			commonAssessmentStu.setLoginName(jo.getString("loginName"));
			commonAssessmentStu.setTrueName(jo.getString("trueName"));
			commonAssessmentStu.setSchoolName(jo.getString("schoolName"));
			commonAssessmentStu.setMajorName(jo.getString("majorName"));
			commonAssessmentStu.setClassName(jo.getString("className"));
			commonAssessmentStu.setAssessmentDate(jo.getString("assessmentDate"));
			commonAssessmentStu.setAssessmentTime(jo.getString("assessmentTime"));
			commonAssessmentStu.setStatus("0");
			commonAssessmentStu.setScoreDetails(commonAssessmentScheme.getSchemeDetails());
			commonAssessmentStu.setSoftUploadedMarks(softUploadedMarks.toJSONString());
			commonAssessmentStuService.save(commonAssessmentStu);
		}
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	/**
	 * 更新状态
	 * @param commonAssessment
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonAssessment commonAssessment) {
		super.updateStatus(commonAssessment);
	}
	
	/**
	 * 删除数据
	 * @param commonAssessment
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonAssessment commonAssessment) {
		super.delete(commonAssessment);
	}

	public CommonResult findPageCommonAssessment(CommonAssessment commonAssessment) {
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(CommonUserUtil.isHaveExamRight(loginUser)){
			Page<CommonAssessment> page = super.findPage(commonAssessment);
			return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, page);
		}
		return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作!");

	}

	@Transactional(readOnly=false)
	public CommonResult deleteCommonAssessment(String json) {
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(CommonUserUtil.isHaveExamRight(loginUser)){
			JSONObject jsonObject = JSONObject.parseObject(json);
			Integer length =jsonObject.getInteger("length");
			JSONArray ja = JSONArray.parseArray(jsonObject.getString("datas"));

			if(loginUser.getRoleId().equals("1")){
				int deletedNum = 0;
				for (int i = 0; i < length; i++) {
					String id = ja.getString(i);
					CommonAssessment ca = this.get(id);
					if(ca!=null&&ca.getStatus().equals("0")){
						this.deleteOneAssessment(ca);
						deletedNum++;
					}
				}
				JSONObject jo = new JSONObject();
				jo.put("deletedNum", deletedNum);
				jo.put("notDeletedNum", length - deletedNum);
				return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, jo);
			}else{
				int deletedNum = 0;
				for (int i = 0; i < length; i++) {
					String id = ja.getString(i);
					CommonAssessment ca = this.get(id);
					if(ca!=null){
						// CommonUser createOne = commonUserDao.getByEntity(new CommonUser(ca.getCreateBy()));
						CommonUser createOne = commonUserService.get(ca.getCreateBy());
						if(loginUser.getSchoolId().equals(createOne.getSchoolId())){
							if(ca.getStatus().equals("0")){
								this.deleteOneAssessment(ca);
								deletedNum++;
							}
						}
					}

				}
				JSONObject jo = new JSONObject();
				jo.put("deletedNum", deletedNum);
				jo.put("notDeletedNum", length - deletedNum);
				return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, jo);
//				CommonUser createOne = commonUserDao.getByEntity(new CommonUser(commonAssessment.getCreateBy()));
//				if(loginUser.getSchoolId().equals(createOne.getSchoolId())){
//					super.delete(commonAssessment);
//					return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
//				}else{
//					return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
//				}
			}
		}else{
			return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
		}
	}

	private void deleteOneAssessment(CommonAssessment ca){
		CommonAssessmentStu con = new CommonAssessmentStu();
		con.setAssessmentId(ca.getId());
		dao.phyDeleteByEntity(ca);
		List<CommonAssessmentStu> commonAssessmentStuList = commonAssessmentStuService.findList(con);
		if(ListUtils.isNotEmpty(commonAssessmentStuList)){
			for (CommonAssessmentStu c : commonAssessmentStuList) {
				commonAssessmentStuService.phyDelete(c);
			}
		}
	}


	@Transactional(readOnly = false)
	public CommonResult updateCommonAssessmentStatus(CommonAssessment commonAssessment, MultipartFile file) throws Exception {
		CommonAssessment ca = super.get(commonAssessment.getId());
		if(file==null){
			if(!commonAssessment.getStatus().equals("5")){ // 以下的情况只是开始考核 和结束考核
				String loginUserId = PreEntity.getUserIdByToken();
				CommonUser loginUser = commonUserService.get(loginUserId);
				CommonUser creator = commonUserService.get(ca.getCreateBy());
				if(CommonUserUtil.isHaveExamRight(loginUser, creator)){
					super.updateStatus(commonAssessment);
					return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
				}else{
					return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
				}
			}else { // 此分支是 统计分数
				return this.calcTotalScore(commonAssessment);
			}
		}else{  // 次分支是上传了评分表
			CommonAssessmentStu commonAssessmentStuCon = new CommonAssessmentStu();
			commonAssessmentStuCon.setAssessmentId(ca.getId());
			List<CommonAssessmentStu> commonAssessmentStuList = commonAssessmentStuService.findList(commonAssessmentStuCon);

			//CommonAssessmentScheme commonAssessmentScheme = commonAssessmentSchemeService.get(ca.getAssessmentSchemeId());
			//JSONArray jsonArray = JSONArray.parseArray(commonAssessmentScheme.getSchemeDetails());
			List<String> msgList = new ArrayList<>();
			for (int j = 0; j < commonAssessmentStuList.size(); j++) {
				CommonAssessmentStu cas = commonAssessmentStuList.get(j);
				JSONArray jsonArray = JSONArray.parseArray(cas.getScoreDetails());
				//JSONArray scoreDetail = new JSONArray();
				for (int i = 0; i < jsonArray.size(); i++) {
					int rowIndex = 1;
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					String title = jsonObject.getString("title");
					ExcelImport ei = new ExcelImport(file, 0, title);
					Row row0 = ei.getRow(0);
					while(ei.getRow(rowIndex)!=null){
						Row row = ei.getRow(rowIndex);
						String userName = ei.getCellValue(row, 0).toString();
						if(userName.length()!=18){
							msgList.add(userName+"长度不是18，请检查");
						}else{
							if(cas.getLoginName().equals(userName)){ //如果一样则代表这一行是该考生的该项的成绩
								JSONArray softDetails = jsonObject.getJSONArray("softDetails");
								int colIndex = 3;
								Object startSoftwareCell = ei.getCellValue(row0, colIndex);
								if(startSoftwareCell==null||"".equals(startSoftwareCell.toString())){
									msgList.add(userName+"下没有任何软件或者主观分数!");
								}else{
									String softwareNameAll = ei.getCellValue(row0, colIndex).toString();
									while(ei.getCellValue(row0, colIndex+1)!=null){
										softwareNameAll += ","+ ei.getCellValue(row0, colIndex+1).toString();
										colIndex++;
									}
									String[] softwareNameArray =  softwareNameAll.split(",");
									for (int n = 0; n < softwareNameArray.length; n++) {
										for (int k = 0; k < softDetails.size(); k++) {
											JSONObject jox = softDetails.getJSONObject(k);
											if(jox.getString("softwareName").equals(softwareNameArray[n])){
												Object obj = ei.getCellValue(row, n+3);
												if(obj==null||!NumberUtils.isParsable(obj.toString())){
													msgList.add(userName+"下的"+softwareNameArray[n]+"分值不能解析书数值");
												}else{
													jox.put("subjScore", obj.toString());
													softDetails.set(k, jox);
												}
												break;
											}
										}
									}
									jsonObject.put("softDetails", softDetails);
									jsonArray.set(i, jsonObject);
								}
							}
						}
						rowIndex++;
					}
				}
				cas.setScoreDetails(jsonArray.toJSONString());
			}
			if(msgList.size()==0){
				for (int j = 0; j < commonAssessmentStuList.size(); j++) {
					commonAssessmentStuService.update(commonAssessmentStuList.get(j));
				}
			}else{
				return new CommonResult(CodeConstant.EXCEL_WRONG_DATA,"数据无法正确解析", msgList);
			}

		}
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	private CommonResult calcTotalScore(CommonAssessment commonAssessment) {
		CommonAssessment ca = super.get(commonAssessment.getId());
		if(!ca.getStatus().equals("4")){
			return new CommonResult(CodeConstant.NO_RIGHT, "数据状态不正确!");
		}
		if(ca.getStatus().equals("5")){
			return new CommonResult(CodeConstant.NO_RIGHT, "分数已统计完毕!");
		}
		CommonAssessmentStu con = new CommonAssessmentStu();
		con.setAssessmentId(ca.getId());
		List<CommonAssessmentStu> commonAssessmentStuList = commonAssessmentStuService.findList(con);
		for (int i = 0; i < commonAssessmentStuList.size(); i++) {
			CommonAssessmentStu cas = commonAssessmentStuList.get(i);
			String scoreDetails = cas.getScoreDetails();
			JSONArray scoreDetails_jsonArray = JSONArray.parseArray(scoreDetails);
			Double totalScore = 0.0;
			int subjectPassNum = 0;
			for (int j = 0; j < scoreDetails_jsonArray.size(); j++) {
				// 循环拿出一项
				JSONObject oneSubject = scoreDetails_jsonArray.getJSONObject(j);
				String weight = oneSubject.getString("weight");
				String passScore = oneSubject.getString("passScore");
				JSONArray softDetails = oneSubject.getJSONArray("softDetails");
				Double oneSubjectScore = 0.0;
				for (int k = 0; k < softDetails.size(); k++) {
					JSONObject oneSoft = softDetails.getJSONObject(k);
					String subjScore = oneSoft.getString("subjScore");
					String objScore = oneSoft.getString("objScore");
					String subjScoreWeight = oneSoft.getString("subjScoreWeight");
					String objScoreWeight = oneSoft.getString("objScoreWeight");
					String softwareWeight = oneSoft.getString("softwareWeight");
					if(!NumberUtils.isParsable(objScore)){
						objScore = "0";
					}
					oneSubjectScore += NumberUtils.mul(NumberUtils.add(NumberUtils.mul(NumberUtils.createDouble(subjScore), NumberUtils.createDouble(subjScoreWeight)/100),
							NumberUtils.mul(NumberUtils.createDouble(objScore), NumberUtils.createDouble(objScoreWeight)/100)), NumberUtils.createDouble(softwareWeight)/100);
				}
				if(NumberUtils.createDouble(passScore)<=oneSubjectScore){
					subjectPassNum++;
				}
				oneSubject.put("gainScore", oneSubjectScore);
				totalScore += NumberUtils.mul(oneSubjectScore, NumberUtils.createDouble(weight)/100);
				scoreDetails_jsonArray.set(i, oneSubject);
			}
			if(subjectPassNum==scoreDetails_jsonArray.size()){
				cas.setStatus("2");
			}else{
				cas.setStatus("2");
			}
			cas.setTotalScore(totalScore.toString());
			cas.setScoreDetails(scoreDetails_jsonArray.toJSONString());
			commonAssessmentStuService.update(cas);
		}
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}


	/**
	 * 解析教师端上传来的某个软件的学生分数，并保存到考生的得分详情里
	 * @param scoreInfo
	 * @return
	 */
	@Transactional(readOnly = false)
	public CommonResult parseScoreInfo(String scoreInfo){
		List<String> msgList = new ArrayList<>();
		List<String> resultMsgList = new ArrayList<>();
		JSONObject jsonObject = null;
		try{
			jsonObject = JSONObject.parseObject(scoreInfo);
		} catch (Exception e){
			return new CommonResult(CodeConstant.ERROR_DATA, "数据无法解析为JSON对象");
		}

		Integer softwareId = jsonObject.getInteger("softwareId");
		if(softwareId==null){
			return new CommonResult(CodeConstant.ERROR_DATA, "数据无法解析出软件标识");
		}
		JSONArray jsonArray = jsonObject.getJSONArray("scores");
		String commonAssessmentStuIds = "";
		int wrongExamStuIdNum = 0;
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
			if(StringUtils.isBlank(object.getString("serverExamStuId"))){
				wrongExamStuIdNum++;
			}else{
				commonAssessmentStuIds = "".equals(commonAssessmentStuIds)?object.getString("serverExamStuId"):(commonAssessmentStuIds+","+object.getString("serverExamStuId"));
			}
		}
		if(wrongExamStuIdNum>0){
			return new CommonResult(CodeConstant.ERROR_DATA, "部分服务器考生标识无法解析");
		}

		CommonAssessmentStu con = new CommonAssessmentStu();
		con.setId_in(commonAssessmentStuIds.split(","));
		List<CommonAssessmentStu> commonAssessmentStuList = commonAssessmentStuService.findList(con);
		Set<String> commonAssessmentSet = new HashSet<>();
		for (int i = 0; i <commonAssessmentStuList.size(); i++) {
			commonAssessmentSet.add(commonAssessmentStuList.get(i).getAssessmentId());
		}
		String[] assessmentIds = new String[commonAssessmentSet.size()];
		Iterator<String> iterator = commonAssessmentSet.iterator();
		int index = 0;
		while(iterator.hasNext()){
			assessmentIds[index] = iterator.next();
		}

		CommonAssessment commonAssessmentCon = new CommonAssessment();
		commonAssessmentCon.setId_in(assessmentIds);
		List<CommonAssessment> commonAssessmentList = dao.findList(commonAssessmentCon);

		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
			String serverExamStuId = object.getString("serverExamStuId");
			String score = object.getString("score");
			if(!NumberUtils.isParsable(score)){
				msgList.add("服务器考生标识为"+serverExamStuId+"的分数无法被解析为数值");
				continue;
			}
			for (int j = 0; j < commonAssessmentStuList.size(); j++) {
				CommonAssessmentStu commonAssessmentStu = commonAssessmentStuList.get(j);
				if(serverExamStuId.equals(commonAssessmentStu.getId())){

					CommonAssessmentScheme commonAssessmentScheme = this.getSchemeByCommonAssessmentList(commonAssessmentList, commonAssessmentStu.getAssessmentId());
					String schemeDetail = commonAssessmentScheme.getSchemeDetails();
					String softUploadedMarks = commonAssessmentStu.getSoftUploadedMarks();
					JSONArray ja = JSONArray.parseArray(schemeDetail);
					for (int k = 0; k < ja.size(); k++) {
						JSONArray softDetails = ja.getJSONObject(k).getJSONArray("softDetails");
						for (int l = 0; l < softDetails.size(); l++) {
							JSONObject oneSoft = softDetails.getJSONObject(l);
							if(softwareId.equals(oneSoft.getInteger("softwareId"))){
								JSONArray softUploadedMarks_array = JSONArray.parseArray(softUploadedMarks);
								int uploadedFlag = 0;
								for (int m = 0; m < softUploadedMarks_array.size(); m++) {
									JSONObject oneMark = softUploadedMarks_array.getJSONObject(m);
									if(oneMark.getString("softwareId").equals(oneSoft.getInteger("softwareId").toString())){
										if("1".equals(oneMark.getString("mark"))){
											resultMsgList.add("身份证好为"+commonAssessmentStu.getLoginName()+"的软件分数已经上传!");
											uploadedFlag = 1;
										}else{
											oneMark.put("mark", "1");
											softUploadedMarks_array.set(m, oneMark);
										}
									}
								}
								if(uploadedFlag==0){
									oneSoft.put("objScore", score);
									softDetails.set(l, oneSoft);
									ja.getJSONObject(k).put("softDetails", softDetails);
								}
								commonAssessmentStu.setSoftUploadedMarks(softUploadedMarks_array.toJSONString());

								break;
							}
						}

					}
					commonAssessmentStu.setScoreDetails(ja.toJSONString());
					commonAssessmentStuList.set(j, commonAssessmentStu);
				}
			}
		}
		if(msgList.size()>0){
			return new CommonResult(CodeConstant.ERROR_DATA, "分数解析错误,所有分户均未上传", msgList);
		}
		for (int j = 0; j < commonAssessmentStuList.size(); j++) {
			commonAssessmentStuService.update(commonAssessmentStuList.get(j));
		}

		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, (commonAssessmentStuList.size()-resultMsgList.size())+"条分数全部解析并上传成功!", resultMsgList);
	}

	private CommonAssessmentScheme getSchemeByCommonAssessmentList(List<CommonAssessment> commonAssessmentList, String commonAssessmentId){
		for (int i = 0; i < commonAssessmentList.size(); i++) {
			if(commonAssessmentList.get(i).getId().equals(commonAssessmentId)){
				return commonAssessmentSchemeService.get(commonAssessmentList.get(i).getAssessmentSchemeId());
			}
		}
		return null;
	}


}