/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.VehicleBrand;
import com.jeesite.modules.common.dao.VehicleBrandDao;

/**
 * 车辆品牌表Service
 * @author chenlitao
 * @version 2019-07-04
 */
@Service
@Transactional(readOnly=true)
public class VehicleBrandService extends CrudService<VehicleBrandDao, VehicleBrand> {
	
	/**
	 * 获取单条数据
	 * @param vehicleBrand
	 * @return
	 */
	@Override
	public VehicleBrand get(VehicleBrand vehicleBrand) {
		return super.get(vehicleBrand);
	}
	
	/**
	 * 查询分页数据
	 * @param vehicleBrand 查询条件
	 * @param vehicleBrand.page 分页对象
	 * @return
	 */
	@Override
	public Page<VehicleBrand> findPage(VehicleBrand vehicleBrand) {
		return super.findPage(vehicleBrand);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param vehicleBrand
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(VehicleBrand vehicleBrand) {
		super.save(vehicleBrand);
	}
	
	/**
	 * 更新状态
	 * @param vehicleBrand
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(VehicleBrand vehicleBrand) {
		super.updateStatus(vehicleBrand);
	}
	
	/**
	 * 删除数据
	 * @param vehicleBrand
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(VehicleBrand vehicleBrand) {
		super.delete(vehicleBrand);
	}
	
}