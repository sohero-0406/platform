/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.Calculate;
import com.jeesite.modules.aa.dao.CalculateDao;

/**
 * 计算车辆价值Service
 * @author chenlitao
 * @version 2019-07-04
 */
@Service
@Transactional(readOnly=true)
public class CalculateService extends CrudService<CalculateDao, Calculate> {
	
	/**
	 * 获取单条数据
	 * @param calculate
	 * @return
	 */
	@Override
	public Calculate get(Calculate calculate) {
		return super.get(calculate);
	}
	
	/**
	 * 查询分页数据
	 * @param calculate 查询条件
	 * @param calculate.page 分页对象
	 * @return
	 */
	@Override
	public Page<Calculate> findPage(Calculate calculate) {
		return super.findPage(calculate);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param calculate
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Calculate calculate) {
		super.save(calculate);
	}
	
	/**
	 * 更新状态
	 * @param calculate
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Calculate calculate) {
		super.updateStatus(calculate);
	}
	
	/**
	 * 删除数据
	 * @param calculate
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Calculate calculate) {
		super.delete(calculate);
	}
	
}