/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.io.FileUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.entity.CommonUser;
import com.jeesite.modules.common.entity.PreEntity;
import com.jeesite.modules.common.util.FilePathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.CommonVehicleImage;
import com.jeesite.modules.common.dao.CommonVehicleImageDao;
import org.springframework.web.multipart.MultipartFile;

/**
 * 车辆图片表Service
 * @author mayuhu
 * @version 2019-08-13
 */
@Service
@Transactional(readOnly=true)
public class CommonVehicleImageService extends CrudService<CommonVehicleImageDao, CommonVehicleImage> {

	@Autowired
	private CommonUserService commonUserService;

	/**
	 * 获取单条数据
	 * @param commonVehicleImage
	 * @return
	 */
	@Override
	public CommonVehicleImage get(CommonVehicleImage commonVehicleImage) {
		return super.get(commonVehicleImage);
	}
	
	/**
	 * 查询分页数据
	 * @param commonVehicleImage 查询条件 commonVehicleImage.page 分页对象
	 * @return
	 */
	@Override
	public Page<CommonVehicleImage> findPage(CommonVehicleImage commonVehicleImage) {
		return super.findPage(commonVehicleImage);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonVehicleImage
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonVehicleImage commonVehicleImage) {
		super.save(commonVehicleImage);
	}
	
	/**
	 * 更新状态
	 * @param commonVehicleImage
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonVehicleImage commonVehicleImage) {
		super.updateStatus(commonVehicleImage);
	}
	
	/**
	 * 删除数据
	 * @param commonVehicleImage
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonVehicleImage commonVehicleImage) {
		super.delete(commonVehicleImage);
	}

	/**
	 * 保存一张车型的图片，并更新数据库
	 * @param image
	 * @param commonVehicleImage
	 * @return
	 * @throws IOException
	 */
	@Transactional(readOnly = false)
	public CommonResult updateVehicleImage(MultipartFile image, CommonVehicleImage commonVehicleImage) throws IOException {
		if(commonVehicleImage==null||StringUtils.isAllBlank(commonVehicleImage.getId(), commonVehicleImage.getVehicleId())){
			return new CommonResult(CodeConstant.PARA_MUST_NEED, "您需要传入必要的参数");
		}
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(!"1".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
		}
		String end = FileUtils.getFileExtension(image.getOriginalFilename());
		if(!end.equals("jpg")&&!end.equals("png")){
			return new CommonResult(CodeConstant.WRONG_FILE, "文件名后缀不正确，请上传jpg或者png文件");
		}
		File x = new File(FilePathUtil.getFileSavePath("vehicleImage")+"vehicleImage_"+commonVehicleImage.getVehicleId()+"_"+System.currentTimeMillis()+"."+end);
		image.transferTo(x);
		commonVehicleImage.setImageName(x.getName());
		super.save(commonVehicleImage);
		return new CommonResult(x.getName());
	}

	/**
	 * 删除已有的一张车型图片
	 * @param commonVehicleImage
	 * @return
	 */
	@Transactional(readOnly = false)
	public CommonResult deleteVehicleImage(CommonVehicleImage commonVehicleImage){
		if(commonVehicleImage==null||StringUtils.isAllBlank(commonVehicleImage.getId())){
			return new CommonResult(CodeConstant.PARA_MUST_NEED, "您需要传入必要的参数");
		}
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(!"1".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
		}
		// 在增加一行删除图片的代码
		FileUtils.deleteFile(FilePathUtil.getFileSavePath("vehicleImage")+this.get(commonVehicleImage.getId()).getImageName());
		dao.phyDelete(commonVehicleImage);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, "删除成功");
	}

	@Transactional(readOnly = false)
	public void saveList(List<CommonVehicleImage> commonVehicleImageList){
		dao.insertBatch(commonVehicleImageList);
	}
	
}