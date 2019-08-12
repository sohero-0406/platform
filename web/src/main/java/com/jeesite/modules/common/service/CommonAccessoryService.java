/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.CommonAccessory;
import com.jeesite.modules.common.dao.CommonAccessoryDao;

/**
 * 汽车配件表Service
 * @author mayuhu
 * @version 2019-08-12
 */
@Service
@Transactional(readOnly=true)
public class CommonAccessoryService extends CrudService<CommonAccessoryDao, CommonAccessory> {
	
	/**
	 * 获取单条数据
	 * @param commonAccessory
	 * @return
	 */
	@Override
	public CommonAccessory get(CommonAccessory commonAccessory) {
		return super.get(commonAccessory);
	}
	
	/**
	 * 查询分页数据
	 * @param commonAccessory 查询条件 commonAccessory.page 分页对象
	 * @return
	 */
	@Override
	public Page<CommonAccessory> findPage(CommonAccessory commonAccessory) {
		return super.findPage(commonAccessory);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonAccessory
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonAccessory commonAccessory) {
		super.save(commonAccessory);
	}
	
	/**
	 * 更新状态
	 * @param commonAccessory
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonAccessory commonAccessory) {
		super.updateStatus(commonAccessory);
	}
	
	/**
	 * 删除数据
	 * @param commonAccessory
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonAccessory commonAccessory) {
		super.delete(commonAccessory);
	}
	
}