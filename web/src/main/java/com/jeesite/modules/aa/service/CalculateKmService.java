/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.CalculateKm;
import com.jeesite.modules.aa.dao.CalculateKmDao;

/**
 * 公里数估值法Service
 * @author chenlitao
 * @version 2019-07-05
 */
@Service
@Transactional(readOnly=true)
public class CalculateKmService extends CrudService<CalculateKmDao, CalculateKm> {
	
	/**
	 * 获取单条数据
	 * @param calculateKm
	 * @return
	 */
	@Override
	public CalculateKm get(CalculateKm calculateKm) {
		return super.get(calculateKm);
	}
	
	/**
	 * 查询分页数据
	 * @param calculateKm 查询条件
	 * @param calculateKm.page 分页对象
	 * @return
	 */
	@Override
	public Page<CalculateKm> findPage(CalculateKm calculateKm) {
		return super.findPage(calculateKm);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param calculateKm
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CalculateKm calculateKm) {
		super.save(calculateKm);
	}
	
	/**
	 * 更新状态
	 * @param calculateKm
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CalculateKm calculateKm) {
		super.updateStatus(calculateKm);
	}
	
	/**
	 * 删除数据
	 * @param calculateKm
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CalculateKm calculateKm) {
		super.delete(calculateKm);
	}

	public CalculateKm getByEntity(CalculateKm calculateKm) {
		return dao.getByEntity(calculateKm);
	}
}