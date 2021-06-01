package com.jeesite.modules.common.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.entity.Page;
import com.jeesite.common.io.FileUtils;
import com.jeesite.common.lang.NumberUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.service.CrudService;
import com.jeesite.common.utils.excel.ExcelExport;
import com.jeesite.common.utils.excel.ExcelImport;
import com.jeesite.modules.common.dao.CommonAssessmentDao;
import com.jeesite.modules.common.entity.*;
import com.jeesite.modules.common.util.CommonUserUtil;
import com.jeesite.modules.common.util.FilePathUtil;
import com.jeesite.modules.common.util.ThisDateUtil;
import com.jeesite.modules.common.vo.DownLoadFinalZipReqVO;
import com.jeesite.modules.common.vo.ExportUploadScoreVo;
import com.jeesite.modules.common.vo.SoftInVO;
import com.jeesite.modules.common.vo.SoftwareName;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
	@Autowired
	private CommonSchoolService commonSchoolService;
	@Autowired
	private CommonBasicSchemeService commonBasicSchemeService;

	/**
	 * 获取单条数据
	 * @param commonAssessment 1
	 * @return 1
	 */
	@Override
	public CommonAssessment get(CommonAssessment commonAssessment) {
		return super.get(commonAssessment);
	}
	
	/**
	 * 查询分页数据
	 * @param commonAssessment 查询条件 commonAssessment.page 分页对象
	 *
	 * @return 1
	 */
	@Override
	public Page<CommonAssessment> findPage(CommonAssessment commonAssessment) {

		return super.findPage(commonAssessment);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonAssessment 1
	 */
	//@Override
	@Transactional
	public CommonResult save(CommonAssessment commonAssessment, String userConfig) {
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(StringUtils.isBlank(commonAssessment.getStartDate())||StringUtils.isBlank(commonAssessment.getEndDate())){
			return new CommonResult(CodeConstant.PARA_MUST_NEED, "必须传入开始日期和结束日期");
		}
		if(dao.countConflictNum(commonAssessment.getStartDate(), commonAssessment.getEndDate(), commonAssessment.getId(), commonAssessment.getSchoolId(), commonAssessment.getAssessmentSchemeId())>0){
			return new CommonResult(CodeConstant.ERROR_DATA, "开始日期和结束日期不能和其他有重复或者冲突");
		}
		if(commonAssessment.getId()==null){
			if(CommonUserUtil.isHaveExamRight(loginUser)){
				if(StringUtils.isBlank(commonAssessment.getSchoolId())){
					commonAssessment.setSchoolId(loginUser.getSchoolId());
					commonAssessment.setSchoolName(commonSchoolService.get(loginUser.getSchoolId()).getSchoolName());
				}else{
					if(StringUtils.isBlank(commonAssessment.getSchoolName())){
						commonAssessment.setSchoolName(commonSchoolService.get(commonAssessment.getSchoolId()).getSchoolName());
					}
				}
				commonAssessment.setDataStatus("0");
				//super.save(commonAssessment);
				return saveCommonSchemeStus(commonAssessment, userConfig);
			}else{
				return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
			}
		}else{
			CommonAssessment c = super.get(commonAssessment.getId());
			if(!c.getDataStatus().equals("0")){
				return new CommonResult(CodeConstant.DATA_LOCK, "该数据不能修改");
			}
			CommonUser creator = commonUserService.get(commonAssessment.getCreateBy());
			if(loginUser.getRoleId().equals("1")||(loginUser.getSchoolId().equals(creator.getSchoolId()))){
				//super.update(commonAssessment);

				return saveCommonSchemeStus(commonAssessment, userConfig);
			}else{
				return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
			}
		}

	}

	/**
	 * 在考核之下 保存考生数据
	 * @param commonAssessment 1
	 * @param userConfig 1
	 * @return 1
	 */
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
				oneMark.put("projectName", jsonObject.getString("title"));
				oneMark.put("mark", "0");
				softUploadedMarks.add(oneMark);
			}
		}
		String msg = "";
		JSONArray jsonArray = JSONArray.parseArray(userConfig);
		List<CommonAssessmentStu> commonAssessmentStuList = new ArrayList<>();
		for (int i = 0; i < jsonArray.size() ; i++) {
			JSONObject jo = jsonArray.getJSONObject(i);
			CommonAssessmentStu commonAssessmentStu = new CommonAssessmentStu();
			//commonAssessmentStu.setAssessmentId(assessmentId);
			commonAssessmentStu.setCommonUserId(jo.getString("commonUserId"));
			commonAssessmentStu.setLoginName(jo.getString("loginName"));
			commonAssessmentStu.setTrueName(jo.getString("trueName"));
			commonAssessmentStu.setSchoolName(jo.getString("schoolName"));
			commonAssessmentStu.setMajorName(jo.getString("majorName"));
			commonAssessmentStu.setClassName(jo.getString("className"));
			String assessmentDate = jo.getString("assessmentDate");
			if(!ThisDateUtil.checkDateIn(commonAssessment.getStartDate(), commonAssessment.getEndDate(), assessmentDate)){
				msg += commonAssessmentStu.getLoginName()+"的考核日期不在考核的开始日期和结束日期之间!<br/><br/>";
				//break;
			}else{
				commonAssessmentStu.setAssessmentDate(assessmentDate);
			}

			commonAssessmentStu.setAssessmentTime(jo.getString("assessmentTime"));
			commonAssessmentStu.setSchoolId(jo.getString("schoolId"));
			commonAssessmentStu.setDataStatus("0");
			commonAssessmentStu.setScoreDetails(commonAssessmentScheme.getSchemeDetails());
			commonAssessmentStu.setSoftUploadedMarks(softUploadedMarks.toJSONString());
			//commonAssessmentStuService.save(commonAssessmentStu);
			commonAssessmentStuList.add(commonAssessmentStu);
		}
		if(!"".equals(msg)){
			return new CommonResult(CodeConstant.ERROR_DATA, msg);
		}
		if(commonAssessmentStuList.size()==0){
			return new CommonResult(CodeConstant.ERROR_DATA, "没有任何考生数据");
		}

		if(commonAssessment.getId()==null){
			super.save(commonAssessment);
			for (CommonAssessmentStu commonAssessmentStu:commonAssessmentStuList) {
				commonAssessmentStu.setAssessmentId(commonAssessment.getId());
			}
			commonAssessmentStuService.saveList(commonAssessmentStuList);
		}else{
			CommonAssessmentStu con = new CommonAssessmentStu();
			con.setAssessmentId(commonAssessment.getId());
			List<CommonAssessmentStu> stuList = commonAssessmentStuService.findList(con);
			if(ListUtils.isNotEmpty(stuList)){
				for (CommonAssessmentStu stu : stuList) {
					commonAssessmentStuService.phyDelete(stu);
				}
			}
			super.update(commonAssessment);
			for (CommonAssessmentStu commonAssessmentStu:commonAssessmentStuList) {
				commonAssessmentStu.setAssessmentId(commonAssessment.getId());
			}
			commonAssessmentStuService.saveList(commonAssessmentStuList);
		}
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	/**
	 * 更新状态
	 * @param commonAssessment 1
	 */
	@Override
	@Transactional
	public void updateStatus(CommonAssessment commonAssessment) {
		super.updateStatus(commonAssessment);
	}
	
	/**
	 * 删除数据
	 * @param commonAssessment 1
	 */
	@Override
	@Transactional
	public void delete(CommonAssessment commonAssessment) {
		super.delete(commonAssessment);
	}

	/**
	 * 根据条件加载考核分页数据
	 * @param commonAssessment 1
	 * @return 1
	 */
	public CommonResult findPageCommonAssessment(CommonAssessment commonAssessment) {
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(CommonUserUtil.isHaveExamRight(loginUser)){
			if(loginUser.getRoleId().equals("2")){
				commonAssessment.setSchoolId(loginUser.getSchoolId());
			}
			Page<CommonAssessment> page = super.findPage(commonAssessment);
			return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, page);
		}
		return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作!");

	}

	/**
	 * 根据json 删除考核数据
	 * @param json 1
	 * @return 1
	 */
	@Transactional
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
					if(ca!=null&&ca.getDataStatus().equals("0")){
						this.deleteOneAssessment(ca);
						deletedNum++;
					}
				}
				JSONObject jo = new JSONObject();
				jo.put("deletedNum", deletedNum);
				jo.put("notDeletedNum", length - deletedNum);
				if(length - deletedNum>0){
					return new CommonResult(CodeConstant.DATA_LOCK, "有"+(length - deletedNum)+"个考核不符合删除条件，不能删除，符合的已删除", jo);
				}else {
					return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, jo);
				}

			}else{
				int deletedNum = 0;
				for (int i = 0; i < length; i++) {
					String id = ja.getString(i);
					CommonAssessment ca = this.get(id);
					if(ca!=null){
						// CommonUser createOne = commonUserDao.getByEntity(new CommonUser(ca.getCreateBy()));
						CommonUser createOne = commonUserService.get(ca.getCreateBy());
						if(loginUser.getSchoolId().equals(createOne.getSchoolId())){
							if(ca.getDataStatus().equals("0")){
								this.deleteOneAssessment(ca);
								deletedNum++;
							}
						}
					}

				}
				JSONObject jo = new JSONObject();
				jo.put("deletedNum", deletedNum);
				jo.put("notDeletedNum", length - deletedNum);
				if(length - deletedNum>0){
					return new CommonResult(CodeConstant.DATA_LOCK, "有"+(length - deletedNum)+"个考核不符合删除条件", jo);
				}else {
					return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, jo);
				}

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

	/**
	 * 物理删除一个考核数据
	 * @param ca 1
	 */
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

	/**
	 * 更新考核状态 <br/>变为2是开始<br/>变为3是结束<br/>变为4是上传评分表 <br/>变为5是统计总分
	 * @param commonAssessment  1
	 * @param file 1
	 * @return 1
	 * @throws 1
	 */
	@Transactional
	public CommonResult updateCommonAssessmentStatus(CommonAssessment commonAssessment, MultipartFile file) throws Exception {
		CommonAssessment ca = super.get(commonAssessment.getId());
		if(file==null){
			if(!commonAssessment.getDataStatus().equals("5")){ // 以下的情况只是开始考核 和结束考核
				String loginUserId = PreEntity.getUserIdByToken();
				CommonUser loginUser = commonUserService.get(loginUserId);
				CommonUser creator = commonUserService.get(ca.getCreateBy());
				if(CommonUserUtil.isHaveExamRight(loginUser, creator)){
					super.update(commonAssessment);
					return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
				}else{
					return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
				}
			}else { // 此分支是 统计分数
				return this.calcTotalScore(commonAssessment);
			}
		}else{  // 此分支是上传了评分表
			CommonAssessmentStu commonAssessmentStuCon = new CommonAssessmentStu();
			commonAssessmentStuCon.setAssessmentId(ca.getId());
			List<CommonAssessmentStu> commonAssessmentStuList = commonAssessmentStuService.findList(commonAssessmentStuCon);
			int sumx = 0;
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
						if(userName.trim().length()!=18){
							msgList.add(userName.trim()+"长度不是18，请检查");
						}else{
							if(cas.getLoginName().equals(userName.trim())){ //如果一样则代表这一行是该考生的该项的成绩
								JSONArray softDetails = jsonObject.getJSONArray("softDetails");
								int colIndex = 3;
								Object startSoftwareCell = ei.getCellValue(row0, colIndex);
								if(startSoftwareCell==null||"".equals(startSoftwareCell.toString())){
									msgList.add(userName+"下没有任何软件或者主观分数!");
								}else{
									String softwareNameAll = ei.getCellValue(row0, colIndex).toString();
									while(ei.getCellValue(row0, colIndex+1)!=null&&!"".equals(ei.getCellValue(row0, colIndex+1).toString())){
										softwareNameAll += ","+ ei.getCellValue(row0, colIndex+1).toString();
										colIndex++;
									}
									String[] softwareNameArray =  softwareNameAll.split(",");
									for (int n = 0; n < softwareNameArray.length; n++) {
										if(softwareNameArray[n].contains("H5")){
											continue;
										}
										for (int k = 0; k < softDetails.size(); k++) {
											JSONObject jox = softDetails.getJSONObject(k);
											if(jox.getString("softwareName").equals(softwareNameArray[n])){
												Object obj = ei.getCellValue(row, n+3);
												if(obj==null||!NumberUtils.isParsable(obj.toString())){
													msgList.add(userName+"下的"+softwareNameArray[n]+"分值不能解析为数值");
												}else{
													jox.put("subjScore", obj.toString());
													softDetails.set(k, jox);
													sumx++;
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
				commonAssessmentStuList.set(j, cas);
			}
			System.out.println("sumx="+sumx);
			if(msgList.size()==0){
                for (CommonAssessmentStu commonAssessmentStu : commonAssessmentStuList) {
                    commonAssessmentStuService.update(commonAssessmentStu);
                }
				super.update(commonAssessment);
			}else{
				return new CommonResult<>(CodeConstant.EXCEL_WRONG_DATA,"数据无法正确解析", msgList);
			}

		}
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	/**
	 * 计算总分
	 * @param commonAssessment 1
	 * @return 1
	 */
	private CommonResult calcTotalScore(CommonAssessment commonAssessment) {
		CommonAssessment ca = super.get(commonAssessment.getId());
		if(!ca.getDataStatus().equals("4")){
			return new CommonResult(CodeConstant.NO_RIGHT, "数据状态不正确!");
		}
		if(ca.getDataStatus().equals("5")){
			return new CommonResult(CodeConstant.NO_RIGHT, "分数已统计完毕!");
		}
		CommonAssessmentScheme commonAssessmentScheme = commonAssessmentSchemeService.get(ca.getAssessmentSchemeId());
//		Double passScore_scheme = NumberUtils.createDouble(commonAssessmentScheme.getPassScore());

		BigDecimal passScore_scheme = new BigDecimal(commonAssessmentScheme.getPassScore()).setScale(2, BigDecimal.ROUND_HALF_UP);

		String needSinglePass = commonAssessmentScheme.getNeedSinglePass();
		CommonAssessmentStu con = new CommonAssessmentStu();
		con.setAssessmentId(ca.getId());
		List<CommonAssessmentStu> commonAssessmentStuList = commonAssessmentStuService.findList(con);
        for (CommonAssessmentStu cas : commonAssessmentStuList) {
            String scoreDetails = cas.getScoreDetails();
            JSONArray scoreDetails_jsonArray = JSONArray.parseArray(scoreDetails);
            System.out.println(scoreDetails_jsonArray);
            double totalScore = 0.0;
            int subjectPassNum = 0;
            for (int j = 0; j < scoreDetails_jsonArray.size(); j++) {
                // 循环拿出一项
                System.out.println(cas.getId());
                JSONObject oneSubject = scoreDetails_jsonArray.getJSONObject(j);
                String weight = oneSubject.getString("weight");
                String passScore = oneSubject.getString("passScore");
                JSONArray softDetails = oneSubject.getJSONArray("softDetails");
                Double oneSubjectScore = 0.0;
                for (int k = 0; k < softDetails.size(); k++) {
                    JSONObject oneSoft = softDetails.getJSONObject(k);
                    String subjScore = oneSoft.getString("subjScore")==null?"0":oneSoft.getString("subjScore");
                    String objScore = oneSoft.getString("objScore");
                    String subjScoreWeight = oneSoft.getString("subjScoreWeight");
                    String objScoreWeight = oneSoft.getString("objScoreWeight");
                    String softwareWeight = oneSoft.getString("softwareWeight");
                    if (!NumberUtils.isParsable(objScore)) {
                        objScore = "0";
                    }
                    oneSubjectScore += NumberUtils.mul(NumberUtils.add(NumberUtils.mul(NumberUtils.createDouble(subjScore), NumberUtils.createDouble(subjScoreWeight) / 100),
                            NumberUtils.mul(NumberUtils.createDouble(objScore), NumberUtils.createDouble(objScoreWeight) / 100)), NumberUtils.createDouble(softwareWeight) / 100);
                }
                BigDecimal passScore_b = new BigDecimal(passScore).setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal oneSubjectScore_b = new BigDecimal(oneSubjectScore).setScale(2, BigDecimal.ROUND_HALF_UP);
				if(oneSubjectScore_b.compareTo(passScore_b)>=0){
					subjectPassNum++;
				}
//                if (NumberUtils.createDouble(passScore) <= oneSubjectScore) {
//                    subjectPassNum++;
//                }
                BigDecimal bigDecimal = NumberUtils.createBigDecimal(oneSubjectScore.toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
                oneSubject.put("gainScore", bigDecimal.toString());
                totalScore += NumberUtils.mul(oneSubjectScore, NumberUtils.createDouble(weight) / 100);
                scoreDetails_jsonArray.set(j, oneSubject);
            }
            BigDecimal totalScore_b = new BigDecimal(totalScore).setScale(2, BigDecimal.ROUND_HALF_UP);
            if ("0".equals(needSinglePass)) { // 不需要单独每项通过，直接看总分即可
            	if(totalScore_b.compareTo(passScore_scheme)<0){
					cas.setDataStatus("3");
				}else {
					cas.setDataStatus("2");
				}
            } else {
                if (totalScore_b.compareTo(passScore_scheme)>=0 && subjectPassNum == scoreDetails_jsonArray.size()) {
                    cas.setDataStatus("2");
                } else {
                    cas.setDataStatus("3");
                }
            }
            BigDecimal b = new BigDecimal(totalScore).setScale(2, BigDecimal.ROUND_HALF_UP);

            cas.setTotalScore(b.toString());
            cas.setScoreDetails(scoreDetails_jsonArray.toJSONString());
            commonAssessmentStuService.update(cas);
        }
		super.update(commonAssessment);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}


	/**
	 * 解析教师端上传来的某个软件的学生分数，并保存到考生的得分详情里
	 * @param scoreInfo 1
	 * @return 1
	 */
	@Transactional
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
//		Set<String> commonAssessmentSet = new HashSet<>();
//		for (int i = 0; i <commonAssessmentStuList.size(); i++) {
//			commonAssessmentSet.add(commonAssessmentStuList.get(i).getAssessmentId());
//		}
//		String[] assessmentIds = new String[commonAssessmentSet.size()];
//		Iterator<String> iterator = commonAssessmentSet.iterator();
//		int index = 0;
//		while(iterator.hasNext()){
//			assessmentIds[index] = iterator.next();
//		}
//
//		CommonAssessment commonAssessmentCon = new CommonAssessment();
//		commonAssessmentCon.setId_in(assessmentIds);
//		List<CommonAssessment> commonAssessmentList = dao.findList(commonAssessmentCon);

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

					//CommonAssessmentScheme commonAssessmentScheme = this.getSchemeByCommonAssessmentList(commonAssessmentList, commonAssessmentStu.getAssessmentId());
					//String schemeDetail = commonAssessmentScheme.getSchemeDetails();
					String schemeDetail = commonAssessmentStu.getScoreDetails();
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
											resultMsgList.add("身份证号为"+commonAssessmentStu.getLoginName()+"的软件分数已经上传!");
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
        for (CommonAssessmentStu commonAssessmentStu : commonAssessmentStuList) {
            commonAssessmentStuService.update(commonAssessmentStu);
        }

		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, (commonAssessmentStuList.size()-resultMsgList.size())+"条分数全部解析并上传成功!", resultMsgList);
	}

	@Transactional
	public CommonResult parseScoreInfoByProjectName(String scoreInfo) {
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
		String projectName = jsonObject.getString("projectName");
		if(projectName==null){
			return new CommonResult(CodeConstant.ERROR_DATA, "数据无法解析出项目名称");
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
//		Set<String> commonAssessmentSet = new HashSet<>();
//		for (int i = 0; i <commonAssessmentStuList.size(); i++) {
//			commonAssessmentSet.add(commonAssessmentStuList.get(i).getAssessmentId());
//		}
//		String[] assessmentIds = new String[commonAssessmentSet.size()];
//		Iterator<String> iterator = commonAssessmentSet.iterator();
//		int index = 0;
//		while(iterator.hasNext()){
//			assessmentIds[index] = iterator.next();
//		}
//
//		CommonAssessment commonAssessmentCon = new CommonAssessment();
//		commonAssessmentCon.setId_in(assessmentIds);
		// List<CommonAssessment> commonAssessmentList = dao.findList(commonAssessmentCon);

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

					//CommonAssessmentScheme commonAssessmentScheme = this.getSchemeByCommonAssessmentList(commonAssessmentList, commonAssessmentStu.getAssessmentId());
					//String schemeDetail = commonAssessmentScheme.getSchemeDetails();
					String schemeDetail = commonAssessmentStu.getScoreDetails();
					String softUploadedMarks = commonAssessmentStu.getSoftUploadedMarks();
					JSONArray ja = JSONArray.parseArray(schemeDetail);
					for (int k = 0; k < ja.size(); k++) {
						// 表示项目名称一样才进行下面的分数上传操作
						if(ja.getJSONObject(k).getString("title").equals(projectName)){
							JSONArray softDetails = ja.getJSONObject(k).getJSONArray("softDetails");
							for (int l = 0; l < softDetails.size(); l++) {
								JSONObject oneSoft = softDetails.getJSONObject(l);
								if(softwareId.equals(oneSoft.getInteger("softwareId"))){
									JSONArray softUploadedMarks_array = JSONArray.parseArray(softUploadedMarks);
									int uploadedFlag = 0;
									for (int m = 0; m < softUploadedMarks_array.size(); m++) {
										JSONObject oneMark = softUploadedMarks_array.getJSONObject(m);
										if(oneMark.getString("softwareId").equals(oneSoft.getInteger("softwareId").toString())
											&&oneMark.getString("projectName").equals(projectName)){
											if("1".equals(oneMark.getString("mark"))){
												resultMsgList.add("身份证号为"+commonAssessmentStu.getLoginName()+"的软件分数已经上传!");
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

					}
					commonAssessmentStu.setScoreDetails(ja.toJSONString());
					commonAssessmentStuList.set(j, commonAssessmentStu);
				}
			}
		}
		if(msgList.size()>0){
			return new CommonResult(CodeConstant.ERROR_DATA, "分数解析错误,所有分户均未上传", msgList);
		}
		for (CommonAssessmentStu commonAssessmentStu : commonAssessmentStuList) {
			commonAssessmentStuService.update(commonAssessmentStu);
		}

		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, (commonAssessmentStuList.size()-resultMsgList.size())+"条分数全部解析并上传成功!", resultMsgList);
	}

	@Transactional
	public CommonResult parseScoreInfoAll(String scoreInfo) {
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
//		Set<String> commonAssessmentSet = new HashSet<>();
//		for (int i = 0; i <commonAssessmentStuList.size(); i++) {
//			commonAssessmentSet.add(commonAssessmentStuList.get(i).getAssessmentId());
//		}
//		String[] assessmentIds = new String[commonAssessmentSet.size()];
//		Iterator<String> iterator = commonAssessmentSet.iterator();
//		int index = 0;
//		while(iterator.hasNext()){
//			assessmentIds[index] = iterator.next();
//		}
//		CommonAssessment commonAssessmentCon = new CommonAssessment();
//		commonAssessmentCon.setId_in(assessmentIds);
//		List<CommonAssessment> commonAssessmentList = dao.findList(commonAssessmentCon);
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
			String serverExamStuId = object.getString("serverExamStuId");
			String score = object.getString("objScore");
			String score_sub = object.getString("subScore");
			if(!NumberUtils.isParsable(score)){
				msgList.add("服务器考生标识为"+serverExamStuId+"的客观分数无法被解析为数值");
				continue;
			}
			if(!NumberUtils.isParsable(score_sub)){
				msgList.add("服务器考生标识为"+serverExamStuId+"的主观分数无法被解析为数值");
				continue;
			}
			for (int j = 0; j < commonAssessmentStuList.size(); j++) {
				CommonAssessmentStu commonAssessmentStu = commonAssessmentStuList.get(j);
				if(serverExamStuId.equals(commonAssessmentStu.getId())){
					String schemeDetail = commonAssessmentStu.getScoreDetails();
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
									oneSoft.put("subjScore", score_sub);
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
		for (CommonAssessmentStu commonAssessmentStu : commonAssessmentStuList) {
			commonAssessmentStuService.update(commonAssessmentStu);
		}

		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, (commonAssessmentStuList.size()-resultMsgList.size())+"条分数全部解析并上传成功!", resultMsgList);
	}

	/**
	 * 从考核列表里选一个考核返回
	 * @param commonAssessmentList 1
	 * @param commonAssessmentId 1
	 * @return 1
	 */
	private CommonAssessmentScheme getSchemeByCommonAssessmentList(List<CommonAssessment> commonAssessmentList, String commonAssessmentId){
		for (int i = 0; i < commonAssessmentList.size(); i++) {
			if(commonAssessmentList.get(i).getId().equals(commonAssessmentId)){
				return commonAssessmentSchemeService.get(commonAssessmentList.get(i).getAssessmentSchemeId());
			}
		}
		return null;
	}


	/**
	 * 根据用户id 返回 考核名称 (给教师端用)
	 * @param commonUserId 1
	 * @return 1
	 */
	public CommonResult loadAssessmentNameList(String commonUserId){
		CommonUser loginUser = commonUserService.get(commonUserId);
		if(!"2".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.ERROR_DATA, "您传入的参数不正确");
		}

		return new CommonResult(dao.loadNameList(loginUser.getSchoolId()));
	}

	public List<String> loadAssessmentNameListBySchoolId(String schoolId){
		return dao.loadNameList(schoolId);
	}

	public CommonResult<List<String>> loadAssessmentNameList(String commonUserId, String softwareId){
	    if(StringUtils.isBlank(softwareId)||StringUtils.isBlank(commonUserId)){
            return new CommonResult<>(CodeConstant.ERROR_DATA, "您传入的参数不正确");
        }
        CommonUser loginUser = commonUserService.get(commonUserId);
        if(!"2".equals(loginUser.getRoleId())){
            return new CommonResult<>(CodeConstant.ERROR_DATA, "您传入的参数不正确");
        }
        String softwareIdStr = "\"softwareId\":\""+softwareId+"\"";
        List<String> l = dao.loadNameListBySoftwareId(loginUser.getSchoolId(), softwareIdStr);
        return new CommonResult<>(l);
    }

	public CommonResult<List<String>> loadAssessmentNameList(){
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if("3".equals(loginUser.getRoleId())){
			return new CommonResult<>(CodeConstant.ERROR_DATA, "您传入的参数不正确");
		}
		if("1".equals(loginUser.getRoleId())){
			List<String> assessmentNameList = dao.loadCalcedNameList(null);
			return new CommonResult<>(assessmentNameList);
		}else{
			List<String> assessmentNameList = dao.loadCalcedNameList(loginUser.getSchoolId());
			return new CommonResult<>(assessmentNameList);
		}
	}

	public CommonResult loadOneAssessment(String id){
		if(StringUtils.isBlank(id)){
			return new CommonResult(CodeConstant.PARA_MUST_NEED, "id必须传入数据！");
		}
		CommonAssessment commonAssessment = super.get(id);
		if(commonAssessment==null){
			return new CommonResult(CodeConstant.ERROR_DATA, "您传入的数据无法查到结果");
		}
		CommonAssessmentStu con = new CommonAssessmentStu();
		con.setAssessmentId(id);
		List<CommonAssessmentStu> commonAssessmentStuList = commonAssessmentStuService.findAssessmentStuListInAssessment(con);
		commonAssessment.setCommonAssessmentStuList(commonAssessmentStuList);
		return new CommonResult(commonAssessment);
	}

	public ExcelExport makeExcelMode(String id) {
		CommonAssessmentStu commonAssessmentStuCon = new CommonAssessmentStu();
		commonAssessmentStuCon.setAssessmentId(id);
		List<CommonAssessmentStu> commonAssessmentStuList = commonAssessmentStuService.findList(commonAssessmentStuCon);

		List<ExportUploadScoreVo> exportUploadScoreVoList = new ArrayList<>();
		for (CommonAssessmentStu c: commonAssessmentStuList) {
			ExportUploadScoreVo exportUploadScoreVo = new ExportUploadScoreVo();
			exportUploadScoreVo.setUserName(c.getLoginName());
			exportUploadScoreVo.setTrueName(c.getTrueName());
			exportUploadScoreVo.setSchoolName(c.getSchoolName());
			exportUploadScoreVoList.add(exportUploadScoreVo);
		}

//		List<ExportUploadScoreVoH5> exportUploadScoreVoH5List = new ArrayList<>();
//		for (CommonAssessmentStu c: commonAssessmentStuList) {
//			ExportUploadScoreVoH5 exportUploadScoreVoH5 = new ExportUploadScoreVoH5();
//			exportUploadScoreVoH5.setUserName(c.getLoginName());
//			exportUploadScoreVoH5.setTrueName(c.getTrueName());
//			exportUploadScoreVoH5.setSchoolName(c.getSchoolName());
//			//exportUploadScoreVoH5.setSoftwareName("不用输入");
//			exportUploadScoreVoH5List.add(exportUploadScoreVoH5);
//		}


		CommonAssessment commonAssessment = super.get(id);
		CommonAssessmentScheme commonAssessmentScheme = commonAssessmentSchemeService.get(commonAssessment.getAssessmentSchemeId());
		JSONArray schemeDetails = JSONArray.parseArray(commonAssessmentScheme.getSchemeDetails());
		ExcelExport ee = null;
		int created = 0;
		for (int i = 0; i < schemeDetails.size(); i++) {
			JSONObject jsonObject = schemeDetails.getJSONObject(i);
			List<String> headerList = new ArrayList<>();
			List<Integer> headerWidthList = new ArrayList<>();

			headerList.add("登录名（身份证号）");
			headerWidthList.add(20 * 256);
			headerList.add("姓名");
			headerWidthList.add(10 * 256);
			headerList.add("学校");
			headerWidthList.add(40 * 256);
			JSONArray ja = JSONArray.parseArray(jsonObject.getString("softDetails"));
//			if(ja.size()==1&&ja.getJSONObject(0).getString("softwareId").equals("6")){
//				continue;
//			}
			int haveH5 = 0;
			int h5Index = 3;
			for (int j = 0; j < ja.size(); j++) {
				JSONObject jo = ja.getJSONObject(j);
				if(jo.getString("softwareId").equals("6")){
					haveH5 = 1;
					h5Index = h5Index + j;
				}
				headerList.add(jo.getString("softwareName"));
				headerWidthList.add(10 * 256);

			}
			if(created == 0){
				ee = new ExcelExport(jsonObject.getString("title"), null, headerList, headerWidthList);

				ee.makeAnnotationList(ExportUploadScoreVo.class);
				if(haveH5==0){
					ee.setDataList(exportUploadScoreVoList);
				}else{
					for (String s : headerList) {
						System.out.println(s);
					}
					ee.setDataList(exportUploadScoreVoList);
				}
//				ee.setDataList(haveH5==0?exportUploadScoreVoList:exportUploadScoreVoH5List);
				created = 1;
			}else{
				ee.createSheet(jsonObject.getString("title"), null, headerList, headerWidthList);
				//ee.setDataList(exportUploadScoreVoList);
				if(haveH5==0){
					ee.setDataList(exportUploadScoreVoList);
				}else{
					for (String s : headerList) {
						System.out.println(s);
					}
					ee.setDataList(exportUploadScoreVoList);
					for(int ii = 1;ii<=commonAssessmentStuList.size();ii++){
						ee.setCellValue(ii, h5Index, "不需要输入");
					}
				}
			}
		}
		return ee;
	}

	public CommonResult<List<String>> loadProjectNameList(String commonUserId, String assessmentName, String softwareId, String assessmentDate) {

		CommonAssessment caCon = new CommonAssessment();
		caCon.setAssessmentName(assessmentName);
		caCon.setStartDate(assessmentDate);
		caCon.setDataStatus("2");
		if(StringUtils.isNotBlank(commonUserId)){
			CommonUser commonUser = this.commonUserService.get(commonUserId);
			caCon.setSchoolId(commonUser.getSchoolId());
		}
		//CommonAssessment ca = dao.getByEntity(caCon);
		CommonAssessment ca = dao.loadOneByCondition(caCon);
		String casId = ca.getAssessmentSchemeId();
		CommonAssessmentScheme cas = commonAssessmentSchemeService.get(casId);
		JSONArray schemeDetails = JSONArray.parseArray(cas.getSchemeDetails());
		List<String> projectNameList = new ArrayList<>();
		for (int i = 0; i < schemeDetails.size(); i++) {
			JSONObject oneScheme = schemeDetails.getJSONObject(i);
			JSONArray softDetails = JSONArray.parseArray(oneScheme.getString("softDetails"));
			for (int j = 0; j < softDetails.size(); j++) {
				JSONObject oneSoft = softDetails.getJSONObject(j);
				int softId = oneSoft.getIntValue("softwareId");
				if(Integer.toString(softId).equals(softwareId)){
					projectNameList.add(oneScheme.getString("title"));
				}
			}
		}
		return new CommonResult<>(projectNameList);
	}

	@Transactional
	public CommonResult<String> uploadAnswerDetailFile(MultipartFile answerDetailFile, String commonAssessmentStuId, String softwareId, String projectName) {
		File x = new File(FilePathUtil.getFileSavePath("platformPic")+projectName+answerDetailFile.getOriginalFilename());
		try {
			answerDetailFile.transferTo(x);
		} catch (IOException e) {
			e.printStackTrace();
		}
		CommonAssessmentStu commonAssessmentStu = this.commonAssessmentStuService.get(commonAssessmentStuId);
		String schemeDetail = commonAssessmentStu.getScoreDetails();
		JSONArray ja = JSONArray.parseArray(schemeDetail);
		if(StringUtils.isNotBlank(projectName)){
			for (int k = 0; k < ja.size(); k++) {
				JSONObject oneProject = ja.getJSONObject(k);
				if(projectName.equals(oneProject.getString("title"))){
					JSONArray softDetails = oneProject.getJSONArray("softDetails");
					for (int l = 0; l < softDetails.size(); l++) {
						JSONObject oneSoft = softDetails.getJSONObject(l);
						if(softwareId.equals(oneSoft.getInteger("softwareId")+"")){
							oneSoft.put("answerDetailFile", projectName+answerDetailFile.getOriginalFilename());
							softDetails.set(l, oneSoft);
							ja.getJSONObject(k).put("softDetails", softDetails);
							break;
						}
					}
				}
			}
		}else{
			for (int k = 0; k < ja.size(); k++) {
				JSONArray softDetails = ja.getJSONObject(k).getJSONArray("softDetails");
				for (int l = 0; l < softDetails.size(); l++) {
					JSONObject oneSoft = softDetails.getJSONObject(l);
					if(softwareId.equals(oneSoft.getInteger("softwareId")+"")){
						oneSoft.put("answerDetailFile", projectName+answerDetailFile.getOriginalFilename());
						softDetails.set(l, oneSoft);
						ja.getJSONObject(k).put("softDetails", softDetails);
						break;
					}
				}
			}
		}

		commonAssessmentStu.setScoreDetails(ja.toJSONString());
		this.commonAssessmentStuService.update(commonAssessmentStu);
		System.out.println("答题详情文件上传完毕");
		return new CommonResult<>();
	}

	@Transactional
	public CommonResult<String> uploadWorkOrderFile(MultipartFile workOrderFile, String commonAssessmentStuId, String softwareId, String projectName) {
		File x = new File(FilePathUtil.getFileSavePath("platformPic")+projectName+workOrderFile.getOriginalFilename());
		try {
			workOrderFile.transferTo(x);
		} catch (IOException e) {
			e.printStackTrace();
		}
		CommonAssessmentStu commonAssessmentStu = this.commonAssessmentStuService.get(commonAssessmentStuId);
		String schemeDetail = commonAssessmentStu.getScoreDetails();
		JSONArray ja = JSONArray.parseArray(schemeDetail);

		if(StringUtils.isNotBlank(projectName)){
			for (int k = 0; k < ja.size(); k++) {
				JSONObject oneProject = ja.getJSONObject(k);
				if(projectName.equals(oneProject.getString("title"))){
					JSONArray softDetails = oneProject.getJSONArray("softDetails");
					for (int l = 0; l < softDetails.size(); l++) {
						JSONObject oneSoft = softDetails.getJSONObject(l);
						if(softwareId.equals(oneSoft.getInteger("softwareId")+"")){
							oneSoft.put("workOrderFile", projectName+workOrderFile.getOriginalFilename());
							softDetails.set(l, oneSoft);
							ja.getJSONObject(k).put("softDetails", softDetails);
							break;
						}
					}
				}
			}
		}else{
			for (int k = 0; k < ja.size(); k++) {
				JSONArray softDetails = ja.getJSONObject(k).getJSONArray("softDetails");
				for (int l = 0; l < softDetails.size(); l++) {
					JSONObject oneSoft = softDetails.getJSONObject(l);
					if(softwareId.equals(oneSoft.getInteger("softwareId")+"")){
						oneSoft.put("workOrderFile", projectName+workOrderFile.getOriginalFilename());
						softDetails.set(l, oneSoft);
						ja.getJSONObject(k).put("softDetails", softDetails);
						break;
					}
				}
			}
		}
		commonAssessmentStu.setScoreDetails(ja.toJSONString());
		this.commonAssessmentStuService.update(commonAssessmentStu);
		System.out.println("工单上传完毕");
		return new CommonResult<>();
	}

	public CommonResult<List<SoftwareName>> loadSoftListByAssessmentId(String assessmentId) {
		CommonAssessment commonAssessment = this.get(assessmentId);
		CommonAssessmentScheme commonAssessmentScheme = this.commonAssessmentSchemeService.get(commonAssessment.getAssessmentSchemeId());
		String schemeDetail = commonAssessmentScheme.getSchemeDetails();
		JSONArray ja = JSONArray.parseArray(schemeDetail);
		List<SoftwareName> softwareNameList = new ArrayList<>();
		for (int k = 0; k < ja.size(); k++) {
			JSONArray softDetails = ja.getJSONObject(k).getJSONArray("softDetails");
			for (int l = 0; l < softDetails.size(); l++) {
				JSONObject oneSoft = softDetails.getJSONObject(l);
				SoftwareName softwareName = new SoftwareName();
				softwareName.setProjectName(ja.getJSONObject(k).getString("title"));
				softwareName.setSoftId(oneSoft.getInteger("softwareId").toString());
				softwareName.setSoftName(oneSoft.getString("softwareName"));
				softwareNameList.add(softwareName);
			}
		}
		return new CommonResult<>(softwareNameList);
	}

	public void downLoadFinalZip(ZipOutputStream zipOutputStream, DownLoadFinalZipReqVO vo) throws IOException {

//		String schemeDetails = commonAssessmentScheme.getSchemeDetails();
		JSONArray jsonArray_schemeDetails = null;
		CommonAssessmentStu con = new CommonAssessmentStu();
		con.setAssessmentId(vo.getAssessmentId());
		List<CommonAssessmentStu> commonAssessmentStuList = this.commonAssessmentStuService.findList(con);
		for (CommonAssessmentStu commonAssessmentStu : commonAssessmentStuList) {
			String schemeDetail = commonAssessmentStu.getScoreDetails();
			CommonUser commonUser = this.commonUserService.get(commonAssessmentStu.getCommonUserId());
			JSONArray ja = JSONArray.parseArray(schemeDetail);
			if(jsonArray_schemeDetails==null){
				jsonArray_schemeDetails = ja;
			}
			for (int k = 0; k < ja.size(); k++) {
				JSONObject oneProject = ja.getJSONObject(k);
				JSONArray softDetails = oneProject.getJSONArray("softDetails");
				List<SoftInVO> softInVOList = vo.getSoftInVOList();
				for (int l = 0; l < softDetails.size(); l++) {
					JSONObject oneSoft = softDetails.getJSONObject(l);
					for (SoftInVO softInVO : softInVOList) {
						if(softInVO.getProjectName().equals(oneProject.getString("title"))){
							if(softInVO.getSoftwareId().equals(oneSoft.getInteger("softwareId").toString())){
								if("1".equals(softInVO.getIsDownAnswerDetail())){
									if(StringUtils.isNotBlank(oneSoft.getString("answerDetailFile"))){
										File answerDetailFile = new File(FilePathUtil.getFileSavePath("platformPic")+oneSoft.getString("answerDetailFile"));
										FileInputStream fileInputStream = new FileInputStream(answerDetailFile);
										String fileExtension = FileUtils.getFileExtension(oneSoft.getString("answerDetailFile"));
										String zipEntryName = commonUser.getTrueName()
												+commonUser.getUserName()+"/"
												+ oneProject.getString("title")+"/"
												+oneSoft.getString("softwareName")+"/"
												+commonUser.getUserName()+"-"+commonUser.getTrueName()+"-"
												+oneProject.getString("title")+"-"+oneSoft.getString("softwareName")+"-"+"答题详情."+fileExtension;
										System.out.println(zipEntryName);
										ZipEntry z = new ZipEntry(zipEntryName);
										zipOutputStream.putNextEntry(z);
										int readByte;
										byte[] buf = new byte[4096];
										while ((readByte = fileInputStream.read(buf)) != -1) {
											zipOutputStream.write(buf, 0, readByte);
										}
										zipOutputStream.closeEntry();
										fileInputStream.close();
									}
								}
								if("1".equals(softInVO.getIsDownWorkOrder())){
									if(StringUtils.isNotBlank(oneSoft.getString("workOrderFile"))){
										File workOrderFileFile = new File(FilePathUtil.getFileSavePath("platformPic")+oneSoft.getString("workOrderFile"));
										FileInputStream fileInputStream = new FileInputStream(workOrderFileFile);
										String zipEntryName = commonUser.getTrueName()
												+commonUser.getUserName()+"/"
												+ oneProject.getString("title")+"/"
												+oneSoft.getString("softwareName")+"/"+commonUser.getUserName()+"-"+commonUser.getTrueName()+"-"
												+oneProject.getString("title")+"-"+oneSoft.getString("softwareName")+"-"+"考核报告.xls";
										System.out.println(zipEntryName);
										ZipEntry z = new ZipEntry(zipEntryName);
										zipOutputStream.putNextEntry(z);
										int readByte;
										byte[] buf = new byte[4096];
										while ((readByte = fileInputStream.read(buf)) != -1) {
											zipOutputStream.write(buf, 0, readByte);
										}
										zipOutputStream.closeEntry();
										fileInputStream.close();
									}
								}
							}
						}
					}
				}
			}
		}

		CommonAssessment commonAssessment = this.get(vo.getAssessmentId());
		CommonAssessmentScheme commonAssessmentScheme = this.commonAssessmentSchemeService.get(commonAssessment.getAssessmentSchemeId());
		CommonBasicScheme commonBasicScheme = this.commonBasicSchemeService.get(commonAssessmentScheme.getBasicSchemeId());
		// 最后写入一个 成绩的详情excel文件
		ExcelExport ee = new ExcelExport("啦啦", "总表");
		Workbook wb = ee.getWorkbook();
		Sheet sheet = wb.getSheetAt(0);
		sheet.setColumnWidth(0, 256*5);
		sheet.setColumnWidth(1, 256*20);
		sheet.setColumnWidth(2, 256*12);
		sheet.setColumnWidth(3, 256*12);
		sheet.setColumnWidth(4, 256*12);
		sheet.setColumnWidth(5, 256*12);
		sheet.setColumnWidth(6, 256*12);
		sheet.setColumnWidth(7, 256*12);
		sheet.setColumnWidth(8, 256*12);
		sheet.setColumnWidth(9, 256*12);
		sheet.setColumnWidth(10, 256*12);
		sheet.setColumnWidth(11, 256*12);
		sheet.setColumnWidth(12, 256*12);
		sheet.setColumnWidth(13, 256*12);
		sheet.setColumnWidth(14, 256*12);

		List<CellRangeAddress> cellRangeAddressList = this.cellRangeAddressList();
		ee.addMergedRegionList(cellRangeAddressList);
//		CellRangeAddress cellRangeAddress = cellRangeAddressList.get(0);
//		sheet.addMergedRegion(cellRangeAddress);
//		RegionUtil.setBorderBottom(CellStyle.BORDER_DOUBLE, cellRangeAddress, sheet, wb);
//		RegionUtil.setBorderLeft(CellStyle.BORDER_DOUBLE, cellRangeAddress, sheet, wb);
//		RegionUtil.setBorderRight(CellStyle.BORDER_DOUBLE, cellRangeAddress, sheet, wb);
//		RegionUtil.setBorderTop(CellStyle.BORDER_DOUBLE, cellRangeAddress, sheet, wb);
//		RegionUtil.setBottomBorderColor(IndexedColors.RED.getIndex(), cellRangeAddress, sheet, wb);
//		RegionUtil.setLeftBorderColor(IndexedColors.RED.getIndex(), cellRangeAddress, sheet, wb);
//		RegionUtil.setRightBorderColor(IndexedColors.RED.getIndex(), cellRangeAddress, sheet, wb);
//		RegionUtil.setTopBorderColor(IndexedColors.RED.getIndex(), cellRangeAddress, sheet, wb);

//		for (CellRangeAddress cellRangeAddress : cellRangeAddressList) {
//			RegionUtil.setBorderBottom(CellStyle.BORDER_DOUBLE, cellRangeAddress, sheet, wb);
//			RegionUtil.setBorderLeft(CellStyle.BORDER_DOUBLE, cellRangeAddress, sheet, wb);
//			RegionUtil.setBorderRight(CellStyle.BORDER_DOUBLE, cellRangeAddress, sheet, wb);
//			RegionUtil.setBorderTop(CellStyle.BORDER_DOUBLE, cellRangeAddress, sheet, wb);
//			RegionUtil.setBottomBorderColor(IndexedColors.RED.getIndex(), cellRangeAddress, sheet, wb);
//			RegionUtil.setLeftBorderColor(IndexedColors.RED.getIndex(), cellRangeAddress, sheet, wb);
//			RegionUtil.setRightBorderColor(IndexedColors.RED.getIndex(), cellRangeAddress, sheet, wb);
//			RegionUtil.setTopBorderColor(IndexedColors.RED.getIndex(), cellRangeAddress, sheet, wb);
//		}

		Row row = ee.addRow(); // 第一行

		CellStyle style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		makeBlackBorder(style);
		Font titleFont = wb.createFont();
		titleFont.setFontName("宋体");
		titleFont.setFontHeightInPoints((short) 20);
		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(titleFont);
		ee.addCell(row, 0, commonBasicScheme.getScoreFileTitle()).setCellStyle(style);
		for (int i = 1; i < 15; i++) {
			ee.addCell(row, i, "").setCellStyle(style);
		}

		row = ee.addRow(); // 第二行
		style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		makeBlackBorder(style);
		titleFont = wb.createFont();
		titleFont.setFontName("宋体");
		titleFont.setFontHeightInPoints((short) 18);
		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(titleFont);
		ee.addCell(row, 0, commonBasicScheme.getBasicStart()+commonBasicScheme.getBasicName()).setCellStyle(style);
		for (int i = 1; i < 15; i++) {
			ee.addCell(row, i, "").setCellStyle(style);
		}
		row = ee.addRow(); // 第三行
		CellStyle style_b_12 = wb.createCellStyle();
		style_b_12.setAlignment(CellStyle.ALIGN_CENTER);
		style_b_12.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		makeBlackBorder(style_b_12);
		titleFont = wb.createFont();
		titleFont.setFontName("宋体");
		titleFont.setFontHeightInPoints((short) 12);
		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style_b_12.setFont(titleFont);

		String basicName = commonBasicScheme.getBasicName();
		String basicNameX = basicName.substring(basicName.length()-3, basicName.length()-1);
		ee.addCell(row, 0, basicNameX).setCellStyle(style_b_12);
		ee.addCell(row, 1, "").setCellStyle(style_b_12);
		ee.addCell(row, 2, "单元").setCellStyle(style_b_12);
		ee.addCell(row, 3, "1").setCellStyle(style_b_12);
		ee.addCell(row, 4, "").setCellStyle(style_b_12);
		ee.addCell(row, 5, "2").setCellStyle(style_b_12);
		ee.addCell(row, 6, "").setCellStyle(style_b_12);
		ee.addCell(row, 7, "3").setCellStyle(style_b_12);
		ee.addCell(row, 8, "").setCellStyle(style_b_12);
		ee.addCell(row, 9, "4").setCellStyle(style_b_12);
		ee.addCell(row, 10, "").setCellStyle(style_b_12);
		ee.addCell(row, 11, "考核总成绩").setCellStyle(style_b_12);
		ee.addCell(row, 12, "复核成绩总成绩").setCellStyle(style_b_12);
		ee.addCell(row, 13, "总分").setCellStyle(style_b_12);
		ee.addCell(row, 14, "考评情况说明").setCellStyle(style_b_12);
		row = ee.addRow(); // 第四行
//		RegionUtil.setRegionUtil/
		CellStyle style_red_12 = wb.createCellStyle();
		style_red_12.setAlignment(CellStyle.ALIGN_CENTER);
		style_red_12.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		makeBlackBorder(style_red_12);
		titleFont = wb.createFont();
		titleFont.setFontName("宋体");
		titleFont.setFontHeightInPoints((short) 12);
		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		titleFont.setColor(Font.COLOR_RED);
		style_red_12.setFont(titleFont);
		ee.addCell(row, 0, "").setCellStyle(style_red_12);
		ee.addCell(row, 1, "").setCellStyle(style_red_12);
		ee.addCell(row, 2, "").setCellStyle(style_red_12);
		ee.addCell(row, 3, "考核项目一").setCellStyle(style_red_12);
		ee.addCell(row, 4, "").setCellStyle(style_red_12);
		ee.addCell(row, 5, "考核项目二").setCellStyle(style_red_12);
		ee.addCell(row, 6, "").setCellStyle(style_red_12);
		ee.addCell(row, 7, "考核项目三").setCellStyle(style_red_12);
		ee.addCell(row, 8, "").setCellStyle(style_red_12);
		ee.addCell(row, 9, "考核项目四").setCellStyle(style_red_12);
		ee.addCell(row, 10, "").setCellStyle(style_red_12);
		ee.addCell(row, 11, "").setCellStyle(style_red_12);
		ee.addCell(row, 12, "").setCellStyle(style_red_12);
		ee.addCell(row, 13, "").setCellStyle(style_red_12);
		ee.addCell(row, 14, "").setCellStyle(style_red_12);
		row = ee.addRow(); // 第五行
		ee.addCell(row, 0, "").setCellStyle(style_b_12);
		ee.addCell(row, 1, "").setCellStyle(style_b_12);
		ee.addCell(row, 2, "").setCellStyle(style_b_12);
		ee.addCell(row, 3, "考核分数").setCellStyle(style_b_12);
		ee.addCell(row, 4, "复核成绩").setCellStyle(style_b_12);
		ee.addCell(row, 5, "考核分数").setCellStyle(style_b_12);
		ee.addCell(row, 6, "复核成绩").setCellStyle(style_b_12);
		ee.addCell(row, 7, "考核分数").setCellStyle(style_b_12);
		ee.addCell(row, 8, "复核成绩").setCellStyle(style_b_12);
		ee.addCell(row, 9, "考核分数").setCellStyle(style_b_12);
		ee.addCell(row, 10, "复核成绩").setCellStyle(style_b_12);
		ee.addCell(row, 11, "").setCellStyle(style_b_12);
		ee.addCell(row, 12, "").setCellStyle(style_b_12);
		ee.addCell(row, 13, "").setCellStyle(style_b_12);
		ee.addCell(row, 14, "").setCellStyle(style_b_12);



		row = ee.addRow(); // 第六行
		ee.addCell(row, 0, "序号").setCellStyle(style_b_12);
		ee.addCell(row, 1, "准考证号/身份证号").setCellStyle(style_b_12);
		ee.addCell(row, 2, "姓名").setCellStyle(style_b_12);
		ee.addCell(row, 3, jsonArray_schemeDetails.getJSONObject(0).getString("weight")+"%").setCellStyle(style_b_12);
		ee.addCell(row, 4, "").setCellStyle(style_b_12);
		ee.addCell(row, 5, jsonArray_schemeDetails.getJSONObject(1).getString("weight")+"%").setCellStyle(style_b_12);
		ee.addCell(row, 6, "").setCellStyle(style_b_12);
		ee.addCell(row, 7, jsonArray_schemeDetails.getJSONObject(2).getString("weight")+"%").setCellStyle(style_b_12);
		ee.addCell(row, 8, "").setCellStyle(style_b_12);
		ee.addCell(row, 9, jsonArray_schemeDetails.getJSONObject(3).getString("weight")+"%").setCellStyle(style_b_12);
		ee.addCell(row, 10, "").setCellStyle(style_b_12);
		ee.addCell(row, 11, "100").setCellStyle(style_b_12);
		ee.addCell(row, 12, "").setCellStyle(style_b_12);
		ee.addCell(row, 13, "").setCellStyle(style_b_12);
		ee.addCell(row, 14, "").setCellStyle(style_b_12);
		int index = 1;
		CellStyle style_12 = wb.createCellStyle();
		style_12.setAlignment(CellStyle.ALIGN_CENTER);
		style_12.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		makeBlackBorder2(style_12);
		titleFont = wb.createFont();
		titleFont.setFontName("宋体");
		titleFont.setFontHeightInPoints((short) 12);
		style_12.setFont(titleFont);
		int finalPassNum = 0;
		int p1PassNum = 0, p2PassNum = 0, p3PassNum = 0, p4PassNum = 0;
		for (CommonAssessmentStu commonAssessmentStu : commonAssessmentStuList) {
			if("2".equals(commonAssessmentStu.getDataStatus())){
				finalPassNum++;
			}
			String schemeDetail = commonAssessmentStu.getScoreDetails();
			CommonUser commonUser = this.commonUserService.get(commonAssessmentStu.getCommonUserId());
			row = ee.addRow(); // 写入成绩
			ee.addCell(row, 0, index+"").setCellStyle(style_12);
			ee.addCell(row, 1, commonUser.getUserName()).setCellStyle(style_12);
			ee.addCell(row, 2, commonUser.getTrueName()).setCellStyle(style_12);
			JSONArray ja = JSONArray.parseArray(schemeDetail);
			for (int k = 0; k < ja.size(); k++) {
				JSONObject oneDetail = ja.getJSONObject(k);
				String gainScore = oneDetail.getString("gainScore");
				String passScore = oneDetail.getString("passScore");
				ee.addCell(row, k*2 + 3, gainScore).setCellStyle(style_12);
				ee.addCell(row, k*2 + 4, "").setCellStyle(style_12);
				if("1".equals(commonAssessmentScheme.getNeedSinglePass())){
					if(k==0){
						int c = NumberUtils.createBigDecimal(gainScore).compareTo(NumberUtils.createBigDecimal(passScore));
						if(c>=0){
							p1PassNum++;
						}
					}
					if(k==1){
						int c = NumberUtils.createBigDecimal(gainScore).compareTo(NumberUtils.createBigDecimal(passScore));
						if(c>=0){
							p2PassNum++;
						}
					}
					if(k==2){
						int c = NumberUtils.createBigDecimal(gainScore).compareTo(NumberUtils.createBigDecimal(passScore));
						if(c>=0){
							p3PassNum++;
						}
					}
					if(k==3){
						int c = NumberUtils.createBigDecimal(gainScore).compareTo(NumberUtils.createBigDecimal(passScore));
						if(c>=0){
							p4PassNum++;
						}
					}
				}
			}
			ee.addCell(row, 11, commonAssessmentStu.getTotalScore()	);
			ee.addCell(row, 12, "").setCellStyle(style_12);
			ee.addCell(row, 13, "").setCellStyle(style_12);
			ee.addCell(row, 14, "").setCellStyle(style_12);
			index++;
		}
		// 最后数据分析

		row = ee.addRow();
		int r1 = row.getRowNum();

		ee.addCell(row, 0, "数据分析").setCellStyle(style_b_12);
		ee.addCell(row, 1, "").setCellStyle(style_b_12);
		ee.addCell(row, 2, "通过人数").setCellStyle(style_b_12);
		if("1".equals(commonAssessmentScheme.getNeedSinglePass())){
			ee.addCell(row, 3, p1PassNum+"").setCellStyle(style_12);
		}else{
			ee.addCell(row, 3, "").setCellStyle(style_12);
		}
		ee.addCell(row, 4, "").setCellStyle(style_12);
		if("1".equals(commonAssessmentScheme.getNeedSinglePass())){
			ee.addCell(row, 5, p2PassNum+"").setCellStyle(style_12);
		}else{
			ee.addCell(row, 5, "").setCellStyle(style_12);
		}
		ee.addCell(row, 6, "").setCellStyle(style_12);
		if("1".equals(commonAssessmentScheme.getNeedSinglePass())){
			ee.addCell(row, 7, p3PassNum+"").setCellStyle(style_12);
		}else{
			ee.addCell(row, 7, "").setCellStyle(style_12);
		}
		ee.addCell(row, 8, "").setCellStyle(style_12);
		if("1".equals(commonAssessmentScheme.getNeedSinglePass())){
			ee.addCell(row, 9, p4PassNum+"").setCellStyle(style_12);
		}else{
			ee.addCell(row, 9, "").setCellStyle(style_12);
		}
		ee.addCell(row, 10, "").setCellStyle(style_12);
		ee.addCell(row, 11, finalPassNum+"").setCellStyle(style_12);
		ee.addCell(row, 12, "").setCellStyle(style_12);
		ee.addCell(row, 13, "").setCellStyle(style_12);
		ee.addCell(row, 14, "").setCellStyle(style_12);

		row = ee.addRow();

		ee.addCell(row, 0, "").setCellStyle(style_b_12);
		ee.addCell(row, 1, "").setCellStyle(style_b_12);
		ee.addCell(row, 2, "未通过人数").setCellStyle(style_b_12);
		if("1".equals(commonAssessmentScheme.getNeedSinglePass())){
			ee.addCell(row, 3, (commonAssessmentStuList.size()-p1PassNum)+"").setCellStyle(style_12);
		}else{
			ee.addCell(row, 3, "").setCellStyle(style_12);
		}
		ee.addCell(row, 4, "").setCellStyle(style_12);
		if("1".equals(commonAssessmentScheme.getNeedSinglePass())){
			ee.addCell(row, 5, (commonAssessmentStuList.size()-p2PassNum)+"").setCellStyle(style_12);
		}else{
			ee.addCell(row, 5, "").setCellStyle(style_12);
		}
		ee.addCell(row, 6, "").setCellStyle(style_12);
		if("1".equals(commonAssessmentScheme.getNeedSinglePass())){
			ee.addCell(row, 7, (commonAssessmentStuList.size()-p3PassNum)+"").setCellStyle(style_12);
		}else{
			ee.addCell(row, 7, "").setCellStyle(style_12);
		}
		ee.addCell(row, 8, "").setCellStyle(style_12);
		if("1".equals(commonAssessmentScheme.getNeedSinglePass())){
			ee.addCell(row, 9, (commonAssessmentStuList.size()-p4PassNum)+"").setCellStyle(style_12);
		}else{
			ee.addCell(row, 9, "").setCellStyle(style_12);
		}
		ee.addCell(row, 10, "").setCellStyle(style_12);
		ee.addCell(row, 11, (commonAssessmentStuList.size()-finalPassNum)+"").setCellStyle(style_12);
		ee.addCell(row, 12, "").setCellStyle(style_12);
		ee.addCell(row, 13, "").setCellStyle(style_12);
		ee.addCell(row, 14, "").setCellStyle(style_12);

		row = ee.addRow();
		int r2 = row.getRowNum();

		ee.addCell(row, 0, "").setCellStyle(style_b_12);
		ee.addCell(row, 1, "").setCellStyle(style_b_12);
		ee.addCell(row, 2, "通过率").setCellStyle(style_b_12);
		if("1".equals(commonAssessmentScheme.getNeedSinglePass())){
			BigDecimal b1 = NumberUtils.createBigDecimal(p1PassNum+"");
			BigDecimal b2 = NumberUtils.createBigDecimal(commonAssessmentStuList.size()+"");
			BigDecimal b3 = b1.multiply(NumberUtils.createBigDecimal("100")).divide(b2, 2, BigDecimal.ROUND_HALF_UP);
			ee.addCell(row, 3, b3.toString()+"%").setCellStyle(style_12);
		}else{
			ee.addCell(row, 3, "").setCellStyle(style_12);
		}
		ee.addCell(row, 4, "").setCellStyle(style_12);
		if("1".equals(commonAssessmentScheme.getNeedSinglePass())){
			BigDecimal b1 = NumberUtils.createBigDecimal(p2PassNum+"");
			BigDecimal b2 = NumberUtils.createBigDecimal(commonAssessmentStuList.size()+"");
			BigDecimal b3 = b1.multiply(NumberUtils.createBigDecimal("100")).divide(b2, 2, BigDecimal.ROUND_HALF_UP);
			ee.addCell(row, 5, b3.toString()+"%").setCellStyle(style_12);
		}else{
			ee.addCell(row, 5, "").setCellStyle(style_12);
		}
		ee.addCell(row, 6, "").setCellStyle(style_12);
		if("1".equals(commonAssessmentScheme.getNeedSinglePass())){
			BigDecimal b1 = NumberUtils.createBigDecimal(p3PassNum+"");
			BigDecimal b2 = NumberUtils.createBigDecimal(commonAssessmentStuList.size()+"");
			BigDecimal b3 = b1.multiply(NumberUtils.createBigDecimal("100")).divide(b2, 2, BigDecimal.ROUND_HALF_UP);
			ee.addCell(row, 7, b3.toString()+"%").setCellStyle(style_12);
		}else{
			ee.addCell(row, 7, "").setCellStyle(style_12);
		}
		ee.addCell(row, 8, "").setCellStyle(style_12);
		if("1".equals(commonAssessmentScheme.getNeedSinglePass())){
			BigDecimal b1 = NumberUtils.createBigDecimal(p4PassNum+"");
			BigDecimal b2 = NumberUtils.createBigDecimal(commonAssessmentStuList.size()+"");
			BigDecimal b3 = b1.multiply(NumberUtils.createBigDecimal("100")).divide(b2, 2, BigDecimal.ROUND_HALF_UP);
			ee.addCell(row, 9, b3.toString()+"%").setCellStyle(style_12);
		}else{
			ee.addCell(row, 9, "").setCellStyle(style_12);
		}
		ee.addCell(row, 10, "").setCellStyle(style_12);
		BigDecimal b1 = NumberUtils.createBigDecimal(finalPassNum+"");
		BigDecimal b2 = NumberUtils.createBigDecimal(commonAssessmentStuList.size()+"");
		BigDecimal b3 = b1.multiply(NumberUtils.createBigDecimal("100")).divide(b2, 2, BigDecimal.ROUND_HALF_UP);
		ee.addCell(row, 11, b3.toString()+"%").setCellStyle(style_12);
		ee.addCell(row, 12, "").setCellStyle(style_12);
		ee.addCell(row, 13, "").setCellStyle(style_12);
		ee.addCell(row, 14, "").setCellStyle(style_12);

		CellRangeAddress rangeAddress = new CellRangeAddress(r1, r2, 0, 1);
		sheet.addMergedRegion(rangeAddress);

		String zipEntryName = commonBasicScheme.getFileName()+".xlsx";
		ZipEntry z = new ZipEntry(zipEntryName);
		zipOutputStream.putNextEntry(z);
		ee.write(zipOutputStream);
	}

	private void makeBlackBorder(CellStyle style) {
		style.setBorderRight(CellStyle.BORDER_MEDIUM);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_MEDIUM);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(CellStyle.BORDER_MEDIUM);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_MEDIUM);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	}

	private void makeBlackBorder2(CellStyle style) {
		style.setBorderRight(CellStyle.BORDER_MEDIUM);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_MEDIUM);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	}


	private List<CellRangeAddress> cellRangeAddressList(){
		List<CellRangeAddress> cellRangeAddressList = new ArrayList<>();
		cellRangeAddressList.add(new CellRangeAddress(0, 0, 0, 14));
		cellRangeAddressList.add(new CellRangeAddress(1, 1, 0, 14));
		cellRangeAddressList.add(new CellRangeAddress(2, 4, 0, 1));
		cellRangeAddressList.add(new CellRangeAddress(2, 4, 2, 2));
		cellRangeAddressList.add(new CellRangeAddress(2, 2, 3, 4));
		cellRangeAddressList.add(new CellRangeAddress(2, 2, 5, 6));
		cellRangeAddressList.add(new CellRangeAddress(2, 2, 7, 8));
		cellRangeAddressList.add(new CellRangeAddress(2, 2, 9, 10));
		cellRangeAddressList.add(new CellRangeAddress(3, 3, 3, 4));
		cellRangeAddressList.add(new CellRangeAddress(3, 3, 5, 6));
		cellRangeAddressList.add(new CellRangeAddress(3, 3, 7, 8));
		cellRangeAddressList.add(new CellRangeAddress(3, 3, 9, 10));
		cellRangeAddressList.add(new CellRangeAddress(2, 4, 11, 11));
		cellRangeAddressList.add(new CellRangeAddress(2, 4, 12, 12));
		cellRangeAddressList.add(new CellRangeAddress(2, 4, 13, 13));
		cellRangeAddressList.add(new CellRangeAddress(2, 4, 14, 14));
		return cellRangeAddressList;
	}

//    public CommonResult loadAssessmentStuTempList(List<UploadStu> uploadStuList) {
//		commonUserService.fillUserConditionList()
//		return null;
//    }

}