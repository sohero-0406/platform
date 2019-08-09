/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.CommonRole;
import com.jeesite.modules.common.dao.CommonRoleDao;

/**
 * common_roleService
 * @author mayuhu
 * @version 2019-08-05
 */
@Service
@Transactional(readOnly=true)
public class CommonRoleService extends CrudService<CommonRoleDao, CommonRole> {
	
	/**
	 * 获取单条数据
	 * @param commonRole
	 * @return
	 */
	@Override
	public CommonRole get(CommonRole commonRole) {
		return super.get(commonRole);
	}
	
	/**
	 * 查询分页数据
	 * @param commonRole 查询条件
	 * @param commonRole.page 分页对象
	 * @return
	 */
	@Override
	public Page<CommonRole> findPage(CommonRole commonRole) {
		return super.findPage(commonRole);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonRole
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonRole commonRole) {
		super.save(commonRole);
	}
	
	/**
	 * 更新状态
	 * @param commonRole
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonRole commonRole) {
		super.updateStatus(commonRole);
	}
	
	/**
	 * 删除数据
	 * @param commonRole
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonRole commonRole) {
		super.delete(commonRole);
	}
	
}