/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.ArrayList;
import java.util.List;

import com.jeesite.modules.aa.vo.VehicleInstallVO;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.sys.entity.DictData;
import com.jeesite.modules.sys.utils.DictUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.VehicleInstallInfo;
import com.jeesite.modules.aa.dao.VehicleInstallInfoDao;

/**
 * 车辆加装信息Service
 * @author chenlitao
 * @version 2019-07-03
 */
@Service
@Transactional(readOnly=true)
public class VehicleInstallInfoService extends CrudService<VehicleInstallInfoDao, VehicleInstallInfo> {

	/**
	 * 根据考生id加载车辆加装信息
	 * @param examUserId 考生id
	 * @return
	 */
	public CommonResult findList(String examUserId){
		List<DictData> ddList = DictUtils.getDictList("aa_vehicle_install_type");
		VehicleInstallInfo vehicleInstallInfo = new VehicleInstallInfo();
		vehicleInstallInfo.setExamUserId(examUserId);
		List<VehicleInstallInfo> vehicleInstallInfoList = this. findList(vehicleInstallInfo);
		List<VehicleInstallVO> vehicleInstallVOList = new ArrayList<>();
		VehicleInstallVO vehicleInstallVO = null;
		for(DictData dd : ddList){
			vehicleInstallVO = new VehicleInstallVO();
			vehicleInstallVO.setProjectName(dd.getDictLabel());
			vehicleInstallVO.setProject(dd.getDictValue());
			vehicleInstallVO.setSort(dd.getTreeSort());
			for(VehicleInstallInfo vii : vehicleInstallInfoList){
				if(vii == null || vii.getProject() == null || vii.getProject().trim().length() <= 0){
					continue;
				}
				if(dd.getDictValue().equals(vii.getProject())){
					vehicleInstallVO.setVehicleInstallId(vii.getId());
					vehicleInstallVO.setSelected(true);
					break;
				}
			}
			vehicleInstallVOList.add(vehicleInstallVO);
		}
		CommonResult comRes = new CommonResult();
		comRes.setData(vehicleInstallVOList);
		return comRes;
	}

	/**
	 * 保存加装信息
	 * @param examUserId 考生id
	 * @param vehicleInstallVOList 待保存的加装信息
	 * @return
	 */
	@Transactional
	public CommonResult saveAndDelete(String examUserId, List<VehicleInstallVO> vehicleInstallVOList){
		VehicleInstallInfo vehicleInstallInfo = new VehicleInstallInfo();
		vehicleInstallInfo.setExamUserId(examUserId);
		List<VehicleInstallInfo> vehicleInstallInfoList = this. findList(vehicleInstallInfo);
		if(vehicleInstallVOList == null){
			vehicleInstallVOList = new ArrayList<>();
		}
		//执行删除和更新
		if(vehicleInstallInfoList != null && vehicleInstallInfoList.size() > 0){
			for(VehicleInstallInfo vii : vehicleInstallInfoList){
				boolean isNeedDelete = true;
				for(VehicleInstallVO vivo : vehicleInstallVOList){
					if(vii.getId().equals(vivo.getVehicleInstallId())){
						vii.setProject(vivo.getProject());
						this.save(vii);
						isNeedDelete = false;
						break;
					}
				}
				if(isNeedDelete){
					this.delete(vii);
				}
			}
		}
		//执行新增
		for(VehicleInstallVO vivo : vehicleInstallVOList){
			if(vivo.getVehicleInstallId() == null || vivo.getVehicleInstallId().trim().length() <= 0){
				VehicleInstallInfo vii = new VehicleInstallInfo();
				vii.setProject(vivo.getProject());
				this.save(vii);
			}
		}
		return new CommonResult();
	}

	/**
	 * 获取单条数据
	 * @param vehicleInstallInfo
	 * @return
	 */
	@Override
	public VehicleInstallInfo get(VehicleInstallInfo vehicleInstallInfo) {
		return super.get(vehicleInstallInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param vehicleInstallInfo 查询条件
	 * @param vehicleInstallInfo.page 分页对象
	 * @return
	 */
	@Override
	public Page<VehicleInstallInfo> findPage(VehicleInstallInfo vehicleInstallInfo) {
		return super.findPage(vehicleInstallInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param vehicleInstallInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(VehicleInstallInfo vehicleInstallInfo) {
		super.save(vehicleInstallInfo);
	}
	
	/**
	 * 更新状态
	 * @param vehicleInstallInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(VehicleInstallInfo vehicleInstallInfo) {
		super.updateStatus(vehicleInstallInfo);
	}
	
	/**
	 * 删除数据
	 * @param vehicleInstallInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(VehicleInstallInfo vehicleInstallInfo) {
		super.delete(vehicleInstallInfo);
	}
	
}