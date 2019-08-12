/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.CommonSoftware;
import com.jeesite.modules.common.dao.CommonSoftwareDao;

/**
 * 软件表Service
 * @author mayuhu
 * @version 2019-08-08
 */
@Service
@Transactional(readOnly=true)
public class CommonSoftwareService extends CrudService<CommonSoftwareDao, CommonSoftware> {
	
	/**
	 * 获取单条数据
	 * @param commonSoftware
	 * @return
	 */
	@Override
	public CommonSoftware get(CommonSoftware commonSoftware) {
		return super.get(commonSoftware);
	}
	
	/**
	 * 查询分页数据
	 * @param commonSoftware 查询条件 commonSoftware.page 分页对象
	 * @param
	 * @return
	 */
	@Override
	public Page<CommonSoftware> findPage(CommonSoftware commonSoftware) {
		return super.findPage(commonSoftware);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonSoftware
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonSoftware commonSoftware) {
		super.save(commonSoftware);
	}
	
	/**
	 * 更新状态
	 * @param commonSoftware
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonSoftware commonSoftware) {
		super.updateStatus(commonSoftware);
	}
	
	/**
	 * 删除数据
	 * @param commonSoftware
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonSoftware commonSoftware) {
		super.delete(commonSoftware);
	}
	
}