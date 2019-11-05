/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.VehicleSeries;
import com.jeesite.modules.common.dao.VehicleSeriesDao;

/**
 * 车辆车系表Service
 * @author chenlitao
 * @version 2019-07-04
 */
@Service
@Transactional(readOnly=true)
public class VehicleSeriesService extends CrudService<VehicleSeriesDao, VehicleSeries> {
	
	/**
	 * 获取单条数据
	 * @param vehicleSeries
	 * @return
	 */
	@Override
	public VehicleSeries get(VehicleSeries vehicleSeries) {
		return super.get(vehicleSeries);
	}
	
	/**
	 * 查询分页数据
	 * @param vehicleSeries 查询条件
	 *
	 * @return
	 */
	@Override
	public Page<VehicleSeries> findPage(VehicleSeries vehicleSeries) {
		return super.findPage(vehicleSeries);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param vehicleSeries
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(VehicleSeries vehicleSeries) {
		super.save(vehicleSeries);
	}
	
	/**
	 * 更新状态
	 * @param vehicleSeries
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(VehicleSeries vehicleSeries) {
		super.updateStatus(vehicleSeries);
	}
	
	/**
	 * 删除数据
	 * @param vehicleSeries
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(VehicleSeries vehicleSeries) {
		super.delete(vehicleSeries);
	}

    public VehicleSeries getByEntity(VehicleSeries vehicleSeries) {
		return dao.getByEntity(vehicleSeries);
    }
}