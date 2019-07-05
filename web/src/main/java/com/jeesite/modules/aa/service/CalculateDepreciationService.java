/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.CalculateDepreciation;
import com.jeesite.modules.aa.dao.CalculateDepreciationDao;

/**
 * 折旧率估值法Service
 * @author chenlitao
 * @version 2019-07-05
 */
@Service
@Transactional(readOnly=true)
public class CalculateDepreciationService extends CrudService<CalculateDepreciationDao, CalculateDepreciation> {
	
	/**
	 * 获取单条数据
	 * @param calculateDepreciation
	 * @return
	 */
	@Override
	public CalculateDepreciation get(CalculateDepreciation calculateDepreciation) {
		return super.get(calculateDepreciation);
	}
	
	/**
	 * 查询分页数据
	 * @param calculateDepreciation 查询条件
	 * @param calculateDepreciation.page 分页对象
	 * @return
	 */
	@Override
	public Page<CalculateDepreciation> findPage(CalculateDepreciation calculateDepreciation) {
		return super.findPage(calculateDepreciation);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param calculateDepreciation
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CalculateDepreciation calculateDepreciation) {
		super.save(calculateDepreciation);
	}
	
	/**
	 * 更新状态
	 * @param calculateDepreciation
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CalculateDepreciation calculateDepreciation) {
		super.updateStatus(calculateDepreciation);
	}
	
	/**
	 * 删除数据
	 * @param calculateDepreciation
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CalculateDepreciation calculateDepreciation) {
		super.delete(calculateDepreciation);
	}
	
}