/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.common.entity.CommonResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.entity.CommonVehicleImage;
import com.jeesite.modules.common.service.CommonVehicleImageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 车辆图片表Controller
 * @author mayuhu
 * @version 2019-08-13
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonVehicleImage")
public class CommonVehicleImageController extends BaseController {

	@Autowired
	private CommonVehicleImageService commonVehicleImageService;
	
	/**
	 * 获取数据
	 */
//	@ModelAttribute
//	public CommonVehicleImage get(String id, boolean isNewRecord) {
//		return commonVehicleImageService.get(id, isNewRecord);
//	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(CommonVehicleImage commonVehicleImage, Model model) {
		model.addAttribute("commonVehicleImage", commonVehicleImage);
		return "modules/common/commonVehicleImageList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CommonVehicleImage> listData(CommonVehicleImage commonVehicleImage, HttpServletRequest request, HttpServletResponse response) {
		commonVehicleImage.setPage(new Page<>(request, response));
		Page<CommonVehicleImage> page = commonVehicleImageService.findPage(commonVehicleImage);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(CommonVehicleImage commonVehicleImage, Model model) {
		model.addAttribute("commonVehicleImage", commonVehicleImage);
		return "modules/common/commonVehicleImageForm";
	}

	/**
	 * 保存车辆图片表
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CommonVehicleImage commonVehicleImage) {
		commonVehicleImageService.save(commonVehicleImage);
		return renderResult(Global.TRUE, text("保存车辆图片表成功！"));
	}
	
	/**
	 * 删除车辆图片表
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CommonVehicleImage commonVehicleImage) {
		commonVehicleImageService.delete(commonVehicleImage);
		return renderResult(Global.TRUE, text("删除车辆图片表成功！"));
	}


	/**
	 * 替换车的某一个体图片
	 * @param image
	 * @param commonVehicleImage
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "updateVehicleImage", method= RequestMethod.POST)
	@ResponseBody
	public CommonResult updateVehicleImage(MultipartFile image, CommonVehicleImage commonVehicleImage) throws IOException {
		return commonVehicleImageService.updateVehicleImage(image, commonVehicleImage);
	}

	@RequestMapping(value = "deleteVehicleImage")
	@ResponseBody
	public CommonResult deleteVehicleImage(CommonVehicleImage commonVehicleImage) throws IOException {
		return commonVehicleImageService.deleteVehicleImage(commonVehicleImage);
	}
	
}