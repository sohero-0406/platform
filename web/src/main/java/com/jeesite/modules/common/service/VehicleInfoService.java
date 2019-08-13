/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.entity.Page;
import com.jeesite.common.io.FileUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.dao.VehicleInfoDao;
import com.jeesite.modules.common.entity.*;
import com.jeesite.modules.common.util.CommonUserUtil;
import com.jeesite.modules.common.util.FilePathUtil;
import com.jeesite.modules.common.util.PageUtils;
import com.jeesite.modules.job.p.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 车辆配置全表Service
 * @author chenlitao
 * @version 2019-07-04
 */
@Service
@Transactional(readOnly=true)
public class VehicleInfoService extends CrudService<VehicleInfoDao, VehicleInfo> {
	@Autowired
	private VehicleInfoDao vehicleInfoDao;

	@Autowired
    private VehicleBrandService vehicleBrandService;
	@Autowired
	private VehicleSeriesService vehicleSeriesService;
	@Autowired
	private CommonUserService commonUserService;
	@Autowired
	private CommonVehicleImageService commonVehicleImageService;
	// 还需要一个厂商service

	/**
	 * 获取单条数据
	 * @param vehicleInfo
	 * @return
	 */
	@Override
	public VehicleInfo get(VehicleInfo vehicleInfo) {
		return super.get(vehicleInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param vehicleInfo 查询条件
	 * @return
	 */
	@Override
	public Page<VehicleInfo> findPage(VehicleInfo vehicleInfo) {
		return super.findPage(vehicleInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param vehicleInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(VehicleInfo vehicleInfo) {
		super.save(vehicleInfo);
	}
	
	/**
	 * 更新状态
	 * @param vehicleInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(VehicleInfo vehicleInfo) {
		super.updateStatus(vehicleInfo);
	}
	
	/**
	 * 删除数据
	 * @param vehicleInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(VehicleInfo vehicleInfo) {
		super.delete(vehicleInfo);
	}

	public List<VehicleInfo> findVehicleName(String chexiId){
		if(chexiId == null || chexiId.trim().length() <= 0){
			return null;
		}
		return vehicleInfoDao.findVehicleName(chexiId);
	}

	public VehicleInfo getByEntity(VehicleInfo vehicleInfo){ return dao.getByEntity(vehicleInfo); }

	/**
	 * 查询车型
	 */
	public VehicleInfo getCarModel(String chexingId){
		return vehicleInfoDao.getCarModel(chexingId);
	}



	public CommonResult findPageByCondition(VehicleInfo vehicleInfo){
        if(!PageUtils.checkPageParams(vehicleInfo)){
            return new CommonResult(CodeConstant.PARA_MUST_NEED, "您未传入分页数据");
        }
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, super.findPage(vehicleInfo));
	}

	@Transactional(readOnly = false)
	public CommonResult saveVehicleList(List<VehicleInfo> vehicleInfoList){
        if(ListUtils.isEmpty(vehicleInfoList)){
            return new CommonResult(CodeConstant.EXCEL_NO_DATA, "您上传的excel没有数据，请检查");
        }
        int okNum = 0;
        int errorNum = 0;
        String msg = "";
        for (VehicleInfo vehicleInfo: vehicleInfoList) {
			VehicleBrand vehicleBrandCon = new VehicleBrand();
			vehicleBrandCon.setPinpai(vehicleInfo.getPinpai());
			VehicleBrand vehicleBrand = vehicleBrandService.get(vehicleBrandCon);
			vehicleInfo.setPinpaiId(vehicleBrand.getId());
			vehicleInfo.setPinpaiLogo(vehicleBrand.getPinpaiLogo());

			VehicleSeries vehicleSeriesCon = new VehicleSeries();
			vehicleSeriesCon.setChexi(vehicleInfo.getChexi());
			VehicleSeries vehicleSeries = vehicleSeriesService.get(vehicleSeriesCon);
			vehicleInfo.setChexiId(vehicleSeries.getId());

			VehicleInfo con = new VehicleInfo();
            con.setChexingmingcheng(vehicleInfo.getChexingmingcheng());
            List<VehicleInfo> exist = super.findList(con);
            if(exist!=null&&exist.size()>0){
                msg += vehicleInfo.getChexingmingcheng()+"已存在！<br/>";
                errorNum++;
            }else{
				super.save(vehicleInfo);
				okNum++;
            }
        }
        JSONObject jo = new JSONObject();
        jo.put("successNum", okNum);
        jo.put("errorNum", errorNum);
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, msg, jo);
    }

    @Transactional(readOnly = false)
	public CommonResult deleteVehicle(String json){
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if("3".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
		}

		JSONObject jsonObject = JSONObject.parseObject(json);
		Integer length =jsonObject.getInteger("length");
		JSONArray ja = JSONArray.parseArray(jsonObject.getString("datas"));
		int deletedNum = 0;
		for (int i = 0; i < length; i++) {
			String id = ja.getString(i);
			VehicleInfo ve = this.get(id);
			super.delete(ve);
			deletedNum++;
		}
		JSONObject object = new JSONObject();
		object.put("deletedNum", deletedNum);
		object.put("notDeletedNum", length- deletedNum);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, object);
	}


	@Transactional(readOnly = false)
	public CommonResult saveVehicleImage(MultipartFile image, String vehicleInfoId) throws IOException {
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(!"1".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
		}
		String end = FileUtils.getFileExtension(image.getOriginalFilename());
		if(!end.equals("jpg")&&end.equals("png")){
			return new CommonResult(CodeConstant.WRONG_FILE, "文件名后缀不正确，请上传jpg或者png文件");
		}
		File x = new File(FilePathUtil.getFileSavePath("vehicleImage")+"vehicleImage_"+vehicleInfoId+"_"+System.currentTimeMillis()+"."+end);
		image.transferTo(x);
		CommonVehicleImage commonVehicleImage = new CommonVehicleImage();
		commonVehicleImage.setVehicleId(vehicleInfoId);
		commonVehicleImage.setImageName(x.getName());
		commonVehicleImageService.save(commonVehicleImage);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, "上传成功", x.getName());
	}


	public CommonResult findImageList(VehicleInfo vehicleInfo){
		if(vehicleInfo==null || StringUtils.isBlank(vehicleInfo.getId())){
			return new CommonResult(CodeConstant.PARA_MUST_NEED, "您需要传入必要的参数");
		}
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(!"1".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
		}
		List<CommonVehicleImage> commonVehicleImageList = commonVehicleImageService.findList(new CommonVehicleImage(vehicleInfo.getId()));
		return new CommonResult(commonVehicleImageList);
	}

}