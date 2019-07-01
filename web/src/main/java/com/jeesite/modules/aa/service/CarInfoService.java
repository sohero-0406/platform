/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.beans.Transient;
import java.util.List;

import com.jeesite.modules.aa.dao.DelegateUserDao;
import com.jeesite.modules.aa.entity.DelegateUser;
import com.jeesite.modules.aa.entity.PictureUser;
import com.jeesite.modules.aa.vo.BaseInfoVO;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.sys.entity.DictData;
import com.jeesite.modules.sys.service.DictDataService;
import com.jeesite.modules.sys.utils.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.CarInfo;
import com.jeesite.modules.aa.dao.CarInfoDao;

import javax.security.auth.callback.Callback;

/**
 * 委托车辆信息Service
 * @author chenlitao
 * @version 2019-06-29
 */
@Service
@Transactional(readOnly=true)
public class CarInfoService extends CrudService<CarInfoDao, CarInfo> {
	@Autowired
	private DelegateUserService delegateUserService;
	@Autowired
	private PictureUserService pictureUserService;

	/**
	 * 获取单条数据
	 * @param carInfo
	 * @return
	 */
	@Override
	public CarInfo get(CarInfo carInfo) {
		return super.get(carInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param carInfo 查询条件
	 * @param carInfo.page 分页对象
	 * @return
	 */
	@Override
	public Page<CarInfo> findPage(CarInfo carInfo) {
		return super.findPage(carInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param carInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CarInfo carInfo) {
		super.save(carInfo);
	}
	
	/**
	 * 更新状态
	 * @param carInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CarInfo carInfo) {
		super.updateStatus(carInfo);
	}
	
	/**
	 * 删除数据
	 * @param carInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CarInfo carInfo) {
		super.delete(carInfo);
	}

	/**
	 * 保存车辆基本信息和委托方基本系你想
	 * @param baseInfoVO
	 * @param examUserId
	 */
	@Transactional
	public void saveBaseInfo(BaseInfoVO baseInfoVO, String examUserId){
		baseInfoVO.getDelegateUser().setExamUserId(examUserId);
		delegateUserService.save(baseInfoVO.getDelegateUser());

		baseInfoVO.getCarInfo().setExamUserId(examUserId);
		this.save(baseInfoVO.getCarInfo());
	}

	/**
	 * 加载车辆基本信息、委托方基本信息、图片信息、委托书类型列表、燃油种类列表、车身颜色列表
	 * @param examUserId 考生用户id
	 * @param pictureTypeIds 考生图片类型ids，多个id之间用“,”分隔
	 * @return
	 */
	public BaseInfoVO getBaseInfo(String examUserId, String[] pictureTypeIds){
		BaseInfoVO baseInfoVO = new BaseInfoVO();

		//加载证件列表
		List<PictureUser> picList = pictureUserService.findList(examUserId, pictureTypeIds);
		baseInfoVO.setPicList(picList);

		//加载车辆基本信息
		CarInfo carInfo = new CarInfo();
		carInfo.setExamUserId(examUserId);
		List<CarInfo> carInfos = this.findList(carInfo);
		if(carInfos != null && carInfos.size() > 0){
			baseInfoVO.setCarInfo(carInfos.get(0));
		}

		//加载委托方基本信息
		DelegateUser delegateUser = new DelegateUser();
		delegateUser.setExamUserId(examUserId);
		List<DelegateUser> delegateUsers = delegateUserService.findList(delegateUser);
		if(delegateUsers != null && delegateUsers.size() > 0){
			baseInfoVO.setDelegateUser(delegateUsers.get(0));
		}
		//加载委托书类型
		List<DictData> entrustTypeList = DictUtils.getDictList("aa_entrust_file_type");
		baseInfoVO.setEntrustTypeList(entrustTypeList);

		//加载燃油种类
		List<DictData> fuelTypeList = DictUtils.getDictList("aa_fuel_type");
		baseInfoVO.setFuelTypeList(fuelTypeList);

		//加载车身颜色
		List<DictData> colorList = DictUtils.getDictList("aa_vehicle_color");
		baseInfoVO.setColorList(colorList);

		return baseInfoVO;
	}
}