/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.modules.common.dao.CommonAssessmentStuDao;
import com.jeesite.modules.common.dao.CommonUserDao;
import com.jeesite.modules.common.entity.*;
import com.jeesite.modules.common.util.CommonUserUtil;
import com.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.dao.CommonAssessmentDao;

/**
 * 考核表Service
 * @author mayuhu
 * @version 2019-08-05
 */
@Service
@Transactional(readOnly=true)
public class CommonAssessmentService extends CrudService<CommonAssessmentDao, CommonAssessment> {

	@Autowired
	private CommonAssessmentStuDao commonAssessmentStuDao;
	@Autowired
	private CommonUserDao commonUserDao;
	@Autowired
	private CommonAssessmentDao commonAssessmentDao;

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
		CommonUser loginUser = commonUserDao.getByEntity(new CommonUser(loginUserId));
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
			CommonUser creator = commonUserDao.getByEntity(new CommonUser((commonAssessment.getCreateBy())));
			if(loginUser.getRoleId().equals("1")||(loginUser.getSchoolId().equals(creator.getSchoolId()))){
				super.update(commonAssessment);
				CommonAssessmentStu con = new CommonAssessmentStu();
				con.setAssessmentId(commonAssessment.getId());
				List<CommonAssessmentStu> stuList = commonAssessmentStuDao.findList(con);
				if(ListUtils.isNotEmpty(stuList)){
					for (CommonAssessmentStu stu : stuList) {
						commonAssessmentStuDao.phyDelete(stu);
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
			commonAssessmentStuDao.insert(commonAssessmentStu);
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
		CommonUser loginUser = commonUserDao.getByEntity(new CommonUser(loginUserId));
		if(CommonUserUtil.isHaveExamRight(loginUser)){
			Page<CommonAssessment> page = super.findPage(commonAssessment);
			return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, page);
		}
		return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作!");

	}

	@Transactional(readOnly=false)
	public CommonResult deleteCommonAssessment(String json) {
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser con = new CommonUser();
		con.setId(loginUserId);
		CommonUser loginUser = commonUserDao.getByEntity(con);
		if(CommonUserUtil.isHaveExamRight(loginUser)){
			JSONObject jsonObject = JSONObject.parseObject(json);
			Integer length =jsonObject.getInteger("length");
			JSONArray ja = JSONArray.parseArray(jsonObject.getString("datas"));

			if(loginUser.getRoleId().equals("1")){
				int deletedNum = 0;
				for (int i = 0; i < length; i++) {
					String id = ja.getString(i);
					CommonAssessment ca = this.get(id);
					if(ca.getStatus().equals("0")){
						super.delete(this.get(id));
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
					CommonUser createOne = commonUserDao.getByEntity(new CommonUser(ca.getCreateBy()));
					if(loginUser.getSchoolId().equals(createOne.getSchoolId())){
						if(ca.getStatus().equals("0")){
							super.delete(this.get(id));
							deletedNum++;
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



}