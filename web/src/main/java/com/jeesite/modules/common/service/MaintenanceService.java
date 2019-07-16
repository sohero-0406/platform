/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.modules.common.entity.MaintenanceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.Maintenance;
import com.jeesite.modules.common.dao.MaintenanceDao;

/**
 * 车辆维保记录Service
 * @author liangtao
 * @version 2019-07-12
 */
@Service
@Transactional(readOnly=true)
public class MaintenanceService extends CrudService<MaintenanceDao, Maintenance> {

	@Autowired
	private MaintenanceTypeService maintenanceTypeService;
	/**
	 * 获取单条数据
	 * @param maintenance
	 * @return
	 */
	@Override
	public Maintenance get(Maintenance maintenance) {
		return super.get(maintenance);
	}
	
	/**
	 * 查询分页数据
	 * @param maintenance 查询条件
	 * @param maintenance.page 分页对象
	 * @return
	 */
	@Override
	public Page<Maintenance> findPage(Maintenance maintenance) {
		return super.findPage(maintenance);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param maintenance
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Maintenance maintenance) {
		super.save(maintenance);
	}
	
	/**
	 * 更新状态
	 * @param maintenance
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Maintenance maintenance) {
		super.updateStatus(maintenance);
	}
	
	/**
	 * 删除数据
	 * @param maintenance
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Maintenance maintenance) {
		super.delete(maintenance);
	}



	@Transactional(readOnly=false)
	public void saveMaintenanceType(MaintenanceType maintenanceType) {
		maintenanceTypeService.save(maintenanceType);
	}


	/**
	 * 保存车辆维保记录类型表
	 * @param mapDetail
	 * @param id    车辆维保记录主键
	 * @param type  类型（外观覆盖件详细维修记录,重要组成部件详细维修记录,该车所有的详细维修记录）
	 */
	@Transactional(readOnly=false)
	public void saveMaintenanceType(JSONObject mapDetail, String id, String type){
		JSONArray array = JSONArray.parseArray(mapDetail.getString(type));
		for (Object obj : array) {
			if(obj!=null){
				MaintenanceType maintenanceType =  JSONObject.parseObject(obj.toString(),MaintenanceType.class);
				maintenanceType.setMaintenanceId(id);
				maintenanceType.setMaintenanceType(type);
				maintenanceTypeService.save(maintenanceType);
			}
		}
	}
}