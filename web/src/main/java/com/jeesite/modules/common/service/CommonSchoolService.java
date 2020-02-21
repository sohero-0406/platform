/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.modules.common.entity.*;
import com.jeesite.modules.common.util.CommonUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.dao.CommonSchoolDao;

import javax.xml.ws.Action;
import java.util.List;

/**
 * 院校表Service
 * @author mayuhu
 * @version 2019-08-05
 */
@Service
@Transactional(readOnly=true)
public class CommonSchoolService extends CrudService<CommonSchoolDao, CommonSchool> {

	@Autowired
	private CommonUserService commonUserService;
	@Autowired
	private CommonAssessmentService commonAssessmentService;

	/**
	 * 获取单条数据
	 * @param commonSchool
	 * @return
	 */
	@Override
	public CommonSchool get(CommonSchool commonSchool) {
		return super.get(commonSchool);
	}
	
	/**
	 * 查询分页数据
	 * @param commonSchool 查询条件 commonSchool.page 分页对象
	 * @return 1
	 */
	@Override
	public Page<CommonSchool> findPage(CommonSchool commonSchool) {
		return super.findPage(commonSchool);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonSchool 被保存或更新的学校实体
	 */
	@Override
	@Transactional
	public void save(CommonSchool commonSchool) {
		super.save(commonSchool);
	}
	
	/**
	 * 更新状态
	 * @param commonSchool
	 */
	@Override
	@Transactional
	public void updateStatus(CommonSchool commonSchool) {
		super.updateStatus(commonSchool);
	}
	
	/**
	 * 删除数据
	 * @param commonSchool 被删除的学校试题，必须有id
	 */
	@Override
	@Transactional
	public void delete(CommonSchool commonSchool) {
		super.delete(commonSchool);
	}

	public CommonSchool getByEntity(CommonSchool commonSchool){
		return dao.getByEntity(commonSchool);
	}


	@Transactional
	public CommonResult deleteCommonSchool(String json) {

		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(!"1".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
		}

		JSONObject jsonObject = JSONObject.parseObject(json);
		Integer length =jsonObject.getInteger("length");
		JSONArray ja = JSONArray.parseArray(jsonObject.getString("datas"));
		int deletedNum = 0;
		for (int i = 0; i < length; i++) {
			String id = ja.getString(i);
			CommonSchool cu = this.get(id);
			if(cu!=null){
				CommonUser cuCon = new CommonUser();
				cuCon.setSchoolId(id);
				List<CommonUser>  cuList = commonUserService.findList(cuCon);
				CommonAssessment caCon = new CommonAssessment();
				caCon.setSchoolId(id);
				List<CommonAssessment> caList = commonAssessmentService.findList(caCon);
				if(ListUtils.isEmpty(caList)&&ListUtils.isEmpty(cuList)){
					super.delete(cu);
					deletedNum++;
				}
			}
		}
		JSONObject object = new JSONObject();
		object.put("deletedNum", deletedNum);
		int x = length - deletedNum;
		object.put("notDeletedNum", x);
		if(x>0){
			return new CommonResult(CodeConstant.DATA_LOCK, "有"+x+"条件数据不符合删除条件，不能删除，符合的已删除", object);
		}else{
			return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, object);
		}

	}

}