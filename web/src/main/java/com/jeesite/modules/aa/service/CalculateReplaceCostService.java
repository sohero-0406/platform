/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.CalculateReplaceCost;
import com.jeesite.modules.aa.dao.CalculateReplaceCostDao;

/**
 * 重置成本法Service
 * @author chenlitao
 * @version 2019-07-05
 */
@Service
@Transactional(readOnly=true)
public class CalculateReplaceCostService extends CrudService<CalculateReplaceCostDao, CalculateReplaceCost> {
	
	/**
	 * 获取单条数据
	 * @param calculateReplaceCost
	 * @return
	 */
	@Override
	public CalculateReplaceCost get(CalculateReplaceCost calculateReplaceCost) {
		return super.get(calculateReplaceCost);
	}
	
	/**
	 * 查询分页数据
	 * @param calculateReplaceCost 查询条件
	 * @param calculateReplaceCost.page 分页对象
	 * @return
	 */
	@Override
	public Page<CalculateReplaceCost> findPage(CalculateReplaceCost calculateReplaceCost) {
		return super.findPage(calculateReplaceCost);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param calculateReplaceCost
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CalculateReplaceCost calculateReplaceCost) {
		super.save(calculateReplaceCost);
	}
	
	/**
	 * 更新状态
	 * @param calculateReplaceCost
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CalculateReplaceCost calculateReplaceCost) {
		super.updateStatus(calculateReplaceCost);
	}
	
	/**
	 * 删除数据
	 * @param calculateReplaceCost
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CalculateReplaceCost calculateReplaceCost) {
		super.delete(calculateReplaceCost);
	}

    public CalculateReplaceCost getByEntity(CalculateReplaceCost calculateReplaceCost) {
		return dao.getByEntity(calculateReplaceCost);
    }
}