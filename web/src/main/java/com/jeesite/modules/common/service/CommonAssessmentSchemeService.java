/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.lang.NumberUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.common.dao.CommonUserDao;
import com.jeesite.modules.common.entity.*;
import com.jeesite.modules.common.util.CommonUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.dao.CommonAssessmentSchemeDao;

/**
 * 考核方案表Service
 * @author mayuhu
 * @version 2019-08-05
 */
@Service
@Transactional(readOnly=true)
public class CommonAssessmentSchemeService extends CrudService<CommonAssessmentSchemeDao, CommonAssessmentScheme> {


	@Autowired
	private CommonUserService commonUserService;
	@Autowired
	private CommonBasicSchemeService commonBasicSchemeService;


	/**
	 * 获取单条数据
	 * @param commonAssessmentScheme
	 * @return
	 */
	@Override
	public CommonAssessmentScheme get(CommonAssessmentScheme commonAssessmentScheme) {
		return super.get(commonAssessmentScheme);
	}
	
	/**
	 * 查询分页数据
	 * @param commonAssessmentScheme 查询条件 commonAssessmentScheme.page 分页对象
	 *
	 * @return
	 */
	@Override
	public Page<CommonAssessmentScheme> findPage(CommonAssessmentScheme commonAssessmentScheme) {
		return super.findPage(commonAssessmentScheme);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonAssessmentScheme 1
	 */
	@Override
	@Transactional
	public void save(CommonAssessmentScheme commonAssessmentScheme) {

		super.save(commonAssessmentScheme);
	}

	/**
	 * 保存方案信息
	 * @param commonAssessmentScheme 1
	 * @return 1
	 */
	@Transactional
	public CommonResult saveCommonAssessmentScheme(CommonAssessmentScheme commonAssessmentScheme) {
		if(StringUtils.isBlank(commonAssessmentScheme.getPassScore())){
			return new CommonResult<>(CodeConstant.ERROR_DATA, "需要设置通过分值");
		}
		String needSinglePass = commonAssessmentScheme.getNeedSinglePass();
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(CommonUserUtil.isHaveExamRight(loginUser)){
			JSONArray schemeDetails = JSONArray.parseArray(commonAssessmentScheme.getSchemeDetails());
			String checkTitleRepeat = this.checkRepeatProjectName(schemeDetails);
			if(checkTitleRepeat!=null){
				return new CommonResult<>(CodeConstant.ERROR_DATA, checkTitleRepeat);
			}
			int schemeWeight = 0;
			for (int i = 0; i < schemeDetails.size(); i++) {
				JSONObject oneScheme = schemeDetails.getJSONObject(i);
				if(oneScheme.getString("title").contains(":")||
						oneScheme.getString("title").contains("：")||
						oneScheme.getString("title").contains("\\")||
						oneScheme.getString("title").contains("/")||
						oneScheme.getString("title").contains("?")||
						oneScheme.getString("title").contains("？")||
						oneScheme.getString("title").contains("*")||
						oneScheme.getString("title").contains("[")||
						oneScheme.getString("title").contains("]")||
						oneScheme.getString("title").length()>31){
					return new CommonResult<>(CodeConstant.ERROR_DATA, oneScheme.getString("title")+"格式不正确，或者长度超过31");
				}
				if(needSinglePass.equals("1")&& NumberUtils.createDouble(oneScheme.getString("passScore"))>100){
					return new CommonResult<>(CodeConstant.ERROR_DATA, oneScheme.getString("title")+"的及格分不能大于100");
				}
				schemeWeight += Integer.parseInt(oneScheme.getString("weight"));
				JSONArray softDetails = JSONArray.parseArray(oneScheme.getString("softDetails"));
				int softWeight = 0;
				for (int j = 0; j < softDetails.size(); j++) {
					JSONObject oneSoft = softDetails.getJSONObject(j);
					softWeight += Integer.parseInt(oneSoft.getString("softwareWeight"));
					int oneSoftWeight = Integer.parseInt(oneSoft.getString("subjScoreWeight")) + Integer.parseInt(oneSoft.getString("objScoreWeight"));
					if(oneSoftWeight!=100){
						return new CommonResult<>(CodeConstant.ERROR_DATA, oneScheme.getString("title")+"下的"+oneSoft.getString("softwareName")+"主客观权重不为100");
					}
					oneSoft.put("answerDetailFile", "");
					oneSoft.put("workOrderFile", "");
					softDetails.set(j, oneSoft);
				}
				if(softWeight!=100){
					return new CommonResult<>(CodeConstant.ERROR_DATA, oneScheme.getString("title")+"的软件权重之和不为100");
				}
				oneScheme.put("softDetails", softDetails);
				schemeDetails.set(i, oneScheme);
			}
			if(schemeWeight!=100){
				return new CommonResult<>(CodeConstant.ERROR_DATA, "各个考核项的权重之和不为100");
			}
			commonAssessmentScheme.setSchemeDetails(schemeDetails.toJSONString());
			if(commonAssessmentScheme.getId()!=null&&!"".equals(commonAssessmentScheme.getId())){
				super.update(commonAssessmentScheme);
			}else{
				super.save(commonAssessmentScheme);
			}
			return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL);
		}else{
			return new CommonResult<>(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
		}

	}

	private String checkRepeatProjectName(JSONArray schemeDetails){
		int num = 0; // 0表示没有重复的名称
		for (int i = 0; i < schemeDetails.size(); i++) {
			JSONObject oneScheme_i = schemeDetails.getJSONObject(i);
			for (int j = 0; j < schemeDetails.size(); j++) {
				JSONObject oneScheme_j = schemeDetails.getJSONObject(j);
				if(i!=j){
					if(oneScheme_i.getString("title").equals(oneScheme_j.getString("title"))){
						num++;
					}
				}
			}
		}
		if(num>0){
			return "有重复的项目名称，无法保存数据！";
		}
		return null;
	}
	
	/**
	 * 更新状态
	 * @param commonAssessmentScheme
	 */
	@Override
	@Transactional
	public void updateStatus(CommonAssessmentScheme commonAssessmentScheme) {
		super.updateStatus(commonAssessmentScheme);
	}


	/**
	 * 更新方案状态 更新的是dataStatus字段
	 * @param commonAssessmentScheme 1
	 * @return 1
	 */
	@Transactional
	public CommonResult updateCommonAssessmentSchemeStatus(CommonAssessmentScheme commonAssessmentScheme) {
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(loginUser.getRoleId().equals("1")){
			super.update(commonAssessmentScheme);
			updateOther(commonAssessmentScheme);
			return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
		}
		if(loginUser.getRoleId().equals("2")&&"1".equals(loginUser.getIsExamRight())){
			//CommonUser createOne = commonUserDao.getByEntity(new CommonUser(commonAssessmentScheme.getCreateBy()));
			CommonUser createOne = commonUserService.get(commonAssessmentScheme.getCreateBy());
			if(loginUser.getSchoolId().equals(createOne.getSchoolId())){
				super.update(commonAssessmentScheme);
				updateOther(commonAssessmentScheme);
				return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
			}
		}
		return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
	}

	private void updateOther(CommonAssessmentScheme commonAssessmentScheme) {
		if ("1".equals(commonAssessmentScheme.getDataStatus())) {
			CommonAssessmentScheme con = new CommonAssessmentScheme();
			con.setBasicSchemeId(commonAssessmentScheme.getBasicSchemeId());
			con.setDataStatus("1");
			List<CommonAssessmentScheme> commonAssessmentSchemeList = super.findList(con);

			for (int i = 0; i < commonAssessmentSchemeList.size(); i++) {
				CommonAssessmentScheme cas = commonAssessmentSchemeList.get(i);
				cas.setDataStatus("0");
				if(!cas.getId().equals(commonAssessmentScheme.getId())){

					System.out.println(cas.getId());
					super.update(cas);
				}
			}
		}
	}

	/**
	 * 删除数据
	 * @param commonAssessmentScheme 1
	 */
	@Override
	@Transactional
	public void delete(CommonAssessmentScheme commonAssessmentScheme) {
		super.delete(commonAssessmentScheme);
	}

	/**
	 * 根据json配置文件删除方案数据
	 * @param json 1
	 * @return 1
	 */
	@Transactional
	public CommonResult deleteCommonAssessmentScheme(String json) {
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if("3".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
		}

		JSONObject jsonObject = JSONObject.parseObject(json);
		Integer length =jsonObject.getInteger("length");
		JSONArray ja = JSONArray.parseArray(jsonObject.getString("datas"));
		int deletedNum = 0;
		for (int i = 0; i < length; i++) {
			String id = ja.getString(i);
			CommonAssessmentScheme commonAssessmentScheme = super.get(id);
			CommonUser creator = commonUserService.get(commonAssessmentScheme.getCreateBy());
			if(CommonUserUtil.isSuperAdmin(loginUser)||CommonUserUtil.isSameSchool(loginUser, creator)){
				super.delete(commonAssessmentScheme);
				deletedNum++;
			}
		}
		JSONObject object = new JSONObject();
		object.put("deletedNum", deletedNum);
		int x = length- deletedNum;
		object.put("notDeletedNum", x);
		if (x>0) {
			return new CommonResult(CodeConstant.DATA_LOCK, "有"+x+"个方案不符合删除条件，不能删除，符合的已删除", object);
		}else{
			return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, object);
		}

	}
	
}