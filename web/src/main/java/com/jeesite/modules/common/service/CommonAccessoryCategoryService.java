/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.modules.common.dao.CommonAccessoryDao;
import com.jeesite.modules.common.dao.CommonUserDao;
import com.jeesite.modules.common.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.dao.CommonAccessoryCategoryDao;

/**
 * 配件分类表Service
 * @author mayuhu
 * @version 2019-08-12
 */
@Service
@Transactional(readOnly=true)
public class CommonAccessoryCategoryService extends CrudService<CommonAccessoryCategoryDao, CommonAccessoryCategory> {

	@Autowired
	private CommonUserService commonUserService;
	@Autowired
	private CommonAccessoryService commonAccessoryService;

	/**
	 * 获取单条数据
	 * @param commonAccessoryCategory
	 * @return
	 */
	@Override
	public CommonAccessoryCategory get(CommonAccessoryCategory commonAccessoryCategory) {
		return super.get(commonAccessoryCategory);
	}
	
	/**
	 * 查询分页数据
	 * @param commonAccessoryCategory 查询条件 commonAccessoryCategory.page 分页对象
	 * @return
	 */
	@Override
	public Page<CommonAccessoryCategory> findPage(CommonAccessoryCategory commonAccessoryCategory) {
		return super.findPage(commonAccessoryCategory);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonAccessoryCategory
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonAccessoryCategory commonAccessoryCategory) {
		super.save(commonAccessoryCategory);
	}
	
	/**
	 * 更新状态
	 * @param commonAccessoryCategory
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonAccessoryCategory commonAccessoryCategory) {
		super.updateStatus(commonAccessoryCategory);
	}
	
	/**
	 * 删除数据
	 * @param commonAccessoryCategory
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonAccessoryCategory commonAccessoryCategory) {
		super.delete(commonAccessoryCategory);
	}


	public CommonResult findPageByCondition(CommonAccessoryCategory commonAccessoryCategory){
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if("1".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, super.findPage(commonAccessoryCategory));
		}
		return new CommonResult(CodeConstant.NO_RIGHT, "您有权限进行该操作");
	}

	@Transactional(readOnly = false)
	public CommonResult saveCategoryAndCommonAccessory(CommonAccessoryCategory commonAccessoryCategory, List<CommonAccessory> commonAccessoryList){
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(!"1".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.NO_RIGHT, "您有权限进行该操作");
		}
		if(ListUtils.isEmpty(commonAccessoryList)){
			return new CommonResult(CodeConstant.EXCEL_NO_DATA, "您传入的EXCEL表格没有数据");
		}
		super.save(commonAccessoryCategory);

		for (int i = 0; i < commonAccessoryList.size(); i++) {
			CommonAccessory commonAccessory = commonAccessoryList.get(i);
			commonAccessory.setCategoryId(commonAccessoryCategory.getId());
			commonAccessoryService.save(commonAccessory);
		}
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, "成功上传"+commonAccessoryList.size()+"条配件信息");
	}

	// 只是逻辑删除
	@Transactional(readOnly = false)
	public CommonResult deleteCommonAccessoryCategory(CommonAccessoryCategory commonAccessoryCategory){
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(!"1".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.NO_RIGHT, "您有权限进行该操作");
		}
		if(commonAccessoryCategory.getId()==null){
			return new CommonResult(CodeConstant.ERROR_DATA, "您传入的数据错误");
		}
		super.delete(commonAccessoryCategory);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	@Transactional(readOnly = false)
	public CommonResult updateCommonAccessoryCategory(CommonAccessoryCategory commonAccessoryCategory){
		if(commonAccessoryCategory.getId()==null){
			return new CommonResult(CodeConstant.ERROR_DATA, "您传入的数据错误");
		}
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(!"1".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.NO_RIGHT, "您有权限进行该操作");
		}
		super.update(commonAccessoryCategory);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

}