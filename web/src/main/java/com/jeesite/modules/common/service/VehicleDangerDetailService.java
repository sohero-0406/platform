/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.VehicleDangerDetail;
import com.jeesite.modules.common.dao.VehicleDangerDetailDao;

/**
 * 出险记录详情表Service
 * @author liangtao
 * @version 2019-07-12
 */
@Service
@Transactional(readOnly=true)
public class VehicleDangerDetailService extends CrudService<VehicleDangerDetailDao, VehicleDangerDetail> {
	
	/**
	 * 获取单条数据
	 * @param vehicleDangerDetail
	 * @return
	 */
	@Override
	public VehicleDangerDetail get(VehicleDangerDetail vehicleDangerDetail) {
		return super.get(vehicleDangerDetail);
	}
	
	/**
	 * 查询分页数据
	 * @param vehicleDangerDetail 查询条件
	 * @param vehicleDangerDetail.page 分页对象
	 * @return
	 */
	@Override
	public Page<VehicleDangerDetail> findPage(VehicleDangerDetail vehicleDangerDetail) {
		return super.findPage(vehicleDangerDetail);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param vehicleDangerDetail
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(VehicleDangerDetail vehicleDangerDetail) {
		super.save(vehicleDangerDetail);
	}
	
	/**
	 * 更新状态
	 * @param vehicleDangerDetail
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(VehicleDangerDetail vehicleDangerDetail) {
		super.updateStatus(vehicleDangerDetail);
	}
	
	/**
	 * 删除数据
	 * @param vehicleDangerDetail
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(VehicleDangerDetail vehicleDangerDetail) {
		super.delete(vehicleDangerDetail);
	}
	
}