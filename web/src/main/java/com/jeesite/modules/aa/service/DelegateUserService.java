/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.DelegateUser;
import com.jeesite.modules.aa.dao.DelegateUserDao;

/**
 * 委托方信息Service
 * @author chenlitao
 * @version 2019-06-29
 */
@Service
@Transactional(readOnly=true)
public class DelegateUserService extends CrudService<DelegateUserDao, DelegateUser> {
	
	/**
	 * 获取单条数据
	 * @param delegateUser
	 * @return
	 */
	@Override
	public DelegateUser get(DelegateUser delegateUser) {
		return super.get(delegateUser);
	}
	
	/**
	 * 查询分页数据
	 * @param delegateUser 查询条件
	 * @param delegateUser.page 分页对象
	 * @return
	 */
	@Override
	public Page<DelegateUser> findPage(DelegateUser delegateUser) {
		return super.findPage(delegateUser);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param delegateUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(DelegateUser delegateUser) {
		super.save(delegateUser);
	}
	
	/**
	 * 更新状态
	 * @param delegateUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(DelegateUser delegateUser) {
		super.updateStatus(delegateUser);
	}
	
	/**
	 * 删除数据
	 * @param delegateUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(DelegateUser delegateUser) {
		super.delete(delegateUser);
	}


	public DelegateUser getByEntity(DelegateUser delegateUser) {
		return dao.getByEntity(delegateUser);
	}
}