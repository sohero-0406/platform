/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.ExamUser;
import com.jeesite.modules.common.dao.ExamUserDao;

/**
 * common_exam_userService
 * @author lvchangwei
 * @version 2019-06-27
 */
@Service
@Transactional(readOnly=true)
public class ExamUserService extends CrudService<ExamUserDao, ExamUser> {
	
	/**
	 * 获取单条数据
	 * @param examUser
	 * @return
	 */
	@Override
	public ExamUser get(ExamUser examUser) {
		return super.get(examUser);
	}
	
	/**
	 * 查询分页数据
	 * @param examUser 查询条件
	 * @param examUser.page 分页对象
	 * @return
	 */
	@Override
	public Page<ExamUser> findPage(ExamUser examUser) {
		return super.findPage(examUser);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param examUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ExamUser examUser) {
		super.save(examUser);
	}
	
	/**
	 * 更新状态
	 * @param examUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ExamUser examUser) {
		super.updateStatus(examUser);
	}
	
	/**
	 * 删除数据
	 * @param examUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ExamUser examUser) {
		super.delete(examUser);
	}
	
}