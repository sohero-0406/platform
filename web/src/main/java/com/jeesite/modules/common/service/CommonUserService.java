/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.CommonUser;
import com.jeesite.modules.common.dao.CommonUserDao;

/**
 * common_userService
 * @author lvchangwei
 * @version 2019-07-16
 */
@Service
@Transactional(readOnly=true)
public class CommonUserService extends CrudService<CommonUserDao, CommonUser> {
	
	/**
	 * 获取单条数据
	 * @param commonUser
	 * @return
	 */
	@Override
	public CommonUser get(CommonUser commonUser) {
		return super.get(commonUser);
	}
	
	/**
	 * 查询分页数据
	 * @param commonUser 查询条件
	 * @param commonUser.page 分页对象
	 * @return
	 */
	@Override
	public Page<CommonUser> findPage(CommonUser commonUser) {
		return super.findPage(commonUser);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonUser commonUser) {
		super.save(commonUser);
	}
	
	/**
	 * 更新状态
	 * @param commonUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonUser commonUser) {
		super.updateStatus(commonUser);
	}
	
	/**
	 * 删除数据
	 * @param commonUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonUser commonUser) {
		super.delete(commonUser);
	}

	/**
	 *  依据用户名查找用户信息 getByEntity
	 */
	@Transactional(readOnly=false)
	public CommonUser getByEntityUserName(String userName) {
		CommonUser commonUser = new CommonUser();
		commonUser.setUserName(userName);
		return  dao.getByEntity(commonUser);
	}
	
}