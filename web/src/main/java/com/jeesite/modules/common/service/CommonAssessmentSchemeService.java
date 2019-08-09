/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import com.jeesite.common.constant.CodeConstant;
import com.jeesite.modules.common.dao.CommonUserDao;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.entity.CommonUser;
import com.jeesite.modules.common.entity.PreEntity;
import com.jeesite.modules.common.util.CommonUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.CommonAssessmentScheme;
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
	private CommonUserDao commonUserDao;


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
	 * @param commonAssessmentScheme
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonAssessmentScheme commonAssessmentScheme) {

		super.save(commonAssessmentScheme);
	}

	@Transactional(readOnly=false)
	public CommonResult saveCommonAssessmentScheme(CommonAssessmentScheme commonAssessmentScheme) {
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser con = new CommonUser();
		con.setId(loginUserId);
		CommonUser loginUser = commonUserDao.getByEntity(con);
		if(CommonUserUtil.isHaveExamRight(loginUser)){
			super.save(commonAssessmentScheme);
			return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
		}else{
			return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
		}

	}
	
	/**
	 * 更新状态
	 * @param commonAssessmentScheme
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonAssessmentScheme commonAssessmentScheme) {
		super.updateStatus(commonAssessmentScheme);
	}


	@Transactional(readOnly=false)
	public CommonResult updateCommonAssessmentSchemeStatus(CommonAssessmentScheme commonAssessmentScheme) {
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser con = new CommonUser();
		con.setId(loginUserId);
		CommonUser loginUser = commonUserDao.getByEntity(con);
		if(loginUser.getRoleId().equals("1")){
			super.updateStatus(commonAssessmentScheme);
			return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
		}
		if(loginUser.getRoleId().equals("2")&&loginUser.getIsExamRight()==1){
			CommonUser createOne = commonUserDao.getByEntity(new CommonUser(commonAssessmentScheme.getCreateBy()));
			if(loginUser.getSchoolId().equals(createOne.getSchoolId())){
				super.updateStatus(commonAssessmentScheme);
				return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
			}
		}
		return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
	}
	
	/**
	 * 删除数据
	 * @param commonAssessmentScheme
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonAssessmentScheme commonAssessmentScheme) {
		super.delete(commonAssessmentScheme);
	}

	@Transactional(readOnly=false)
	public CommonResult deleteCommonAssessmentScheme(CommonAssessmentScheme commonAssessmentScheme) {
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser con = new CommonUser();
		con.setId(loginUserId);
		CommonUser loginUser = commonUserDao.getByEntity(con);
		if(CommonUserUtil.isHaveExamRight(loginUser)){
			if(loginUser.getRoleId().equals("1")){
				super.delete(commonAssessmentScheme);
				return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
			}else{
				CommonUser createOne = commonUserDao.getByEntity(new CommonUser(commonAssessmentScheme.getCreateBy()));
				if(loginUser.getSchoolId().equals(createOne.getSchoolId())){
					super.delete(commonAssessmentScheme);
					return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
				}else{
					return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
				}
			}
		}else{
			return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
		}
		// super.delete(commonAssessmentScheme);
	}
	
}