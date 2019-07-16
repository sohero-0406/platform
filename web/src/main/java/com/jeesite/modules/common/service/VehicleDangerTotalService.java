/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.modules.common.entity.VehicleDanger;
import com.jeesite.modules.common.entity.VehicleDangerDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.VehicleDangerTotal;
import com.jeesite.modules.common.dao.VehicleDangerTotalDao;

/**
 * 车辆出险总表Service
 * @author liangtao
 * @version 2019-07-12
 */
@Service
@Transactional(readOnly=true)
public class VehicleDangerTotalService extends CrudService<VehicleDangerTotalDao, VehicleDangerTotal> {

	@Autowired
	private VehicleDangerDetailService vehicleDangerDetailService;

	@Autowired
	private VehicleDangerService vehicleDangerService;


	/**
	 * 获取单条数据
	 * @param vehicleDangerTotal
	 * @return
	 */
	@Override
	public VehicleDangerTotal get(VehicleDangerTotal vehicleDangerTotal) {
		return super.get(vehicleDangerTotal);
	}
	
	/**
	 * 查询分页数据
	 * @param vehicleDangerTotal 查询条件
	 * @return
	 */
	@Override
	public Page<VehicleDangerTotal> findPage(VehicleDangerTotal vehicleDangerTotal) {
		return super.findPage(vehicleDangerTotal);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param vehicleDangerTotal
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(VehicleDangerTotal vehicleDangerTotal) {
		super.save(vehicleDangerTotal);
	}
	
	/**
	 * 更新状态
	 * @param vehicleDangerTotal
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(VehicleDangerTotal vehicleDangerTotal) {
		super.updateStatus(vehicleDangerTotal);
	}
	
	/**
	 * 删除数据
	 * @param vehicleDangerTotal
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(VehicleDangerTotal vehicleDangerTotal) {
		super.delete(vehicleDangerTotal);
	}

	/**
	 * 保存 出险记录详情表与车辆出险记录表
	 * @param recordsArray
	 * @param vehicleDangerTotal
	 */
	@Transactional(readOnly=false)
	public void saveVehicleDangerAndDetail(JSONArray recordsArray,VehicleDangerTotal vehicleDangerTotal) {
		for(Object objArray:recordsArray){
			if(objArray!=null){
				//声明车辆出险记录表实体类
				VehicleDanger vehicleDanger = JSONObject.parseObject(objArray.toString(),VehicleDanger.class);
				vehicleDanger.setCommonVehicleDangerTotalId(vehicleDangerTotal.getId());
				vehicleDangerService.save(vehicleDanger);
				JSONArray resultInfoArray = ((JSONObject)objArray).getJSONArray("resultInfo");
				for(Object objResultInfo:resultInfoArray){
					if(objResultInfo!=null){
						//声明出险记录详情表实体类
						VehicleDangerDetail vehicleDangerDetail = JSONObject.parseObject(objResultInfo.toString(),VehicleDangerDetail.class);
						vehicleDangerDetail.setCommonVehicleDangerId(vehicleDanger.getId());
						vehicleDangerDetailService.save(vehicleDangerDetail);
					}
				}
			}
		}
	}


}