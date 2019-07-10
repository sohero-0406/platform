/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.VehicleGradeAssess;
import com.jeesite.modules.aa.dao.VehicleGradeAssessDao;

/**
 * 车辆等级评定Service
 * @author lvchangwei
 * @version 2019-07-09
 */
@Service
@Transactional(readOnly=true)
public class VehicleGradeAssessService extends CrudService<VehicleGradeAssessDao, VehicleGradeAssess> {
	
	/**
	 * 获取单条数据
	 * @param vehicleGradeAssess
	 * @return
	 */
	@Override
	public VehicleGradeAssess get(VehicleGradeAssess vehicleGradeAssess) {
		return super.get(vehicleGradeAssess);
	}
	
	/**
	 * 查询分页数据
	 * @param vehicleGradeAssess 查询条件
	 * @param vehicleGradeAssess.page 分页对象
	 * @return
	 */
	@Override
	public Page<VehicleGradeAssess> findPage(VehicleGradeAssess vehicleGradeAssess) {
		return super.findPage(vehicleGradeAssess);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param vehicleGradeAssess
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(VehicleGradeAssess vehicleGradeAssess) {
		super.save(vehicleGradeAssess);
	}
	
	/**
	 * 更新状态
	 * @param vehicleGradeAssess
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(VehicleGradeAssess vehicleGradeAssess) {
		super.updateStatus(vehicleGradeAssess);
	}
	
	/**
	 * 删除数据
	 * @param vehicleGradeAssess
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(VehicleGradeAssess vehicleGradeAssess) {
		super.delete(vehicleGradeAssess);
	}
	
}