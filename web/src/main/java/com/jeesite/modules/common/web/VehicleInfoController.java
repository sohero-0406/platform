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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.entity.VehicleInfo;
import com.jeesite.modules.common.service.VehicleInfoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆配置全表Controller
 * @author chenlitao
 * @version 2019-07-04
 */
@Controller
@RequestMapping(value = "${adminPath}/common/vehicleInfo")
public class VehicleInfoController extends BaseController {

	@Autowired
	private VehicleInfoService vehicleInfoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public VehicleInfo get(String id, boolean isNewRecord) {
		return vehicleInfoService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(VehicleInfo vehicleInfo, Model model) {
		model.addAttribute("vehicleInfo", vehicleInfo);
		return "modules/common/vehicleInfoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<VehicleInfo> listData(VehicleInfo vehicleInfo, HttpServletRequest request, HttpServletResponse response) {
		vehicleInfo.setPage(new Page<>(request, response));
		Page<VehicleInfo> page = vehicleInfoService.findPage(vehicleInfo);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(VehicleInfo vehicleInfo, Model model) {
		model.addAttribute("vehicleInfo", vehicleInfo);
		return "modules/common/vehicleInfoForm";
	}

	/**
	 * 保存车辆配置全表
	 */
	@RequiresPermissions("common:vehicleInfo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated VehicleInfo vehicleInfo) {
		vehicleInfoService.save(vehicleInfo);
		return renderResult(Global.TRUE, text("保存车辆配置全表成功！"));
	}
	
	/**
	 * 删除车辆配置全表
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(VehicleInfo vehicleInfo) {
		vehicleInfoService.delete(vehicleInfo);
		return renderResult(Global.TRUE, text("删除车辆配置全表成功！"));
	}
	@PostMapping(value = "findList")
	@ResponseBody
	public CommonResult findList(String chexiId){
		CommonResult comRes = new CommonResult();
		if(chexiId == null || chexiId.trim().length() <= 0){
			comRes.setCode("1010");
			comRes.setMsg("未按照接口要求进行数据查询！");
			return comRes;
		}
		List<VehicleInfo> vehicleInfoList = vehicleInfoService.findVehicleName(chexiId);

		Map<String, List<VehicleInfo>> map = new HashMap<>();
		List<VehicleInfo> values = null;
		for(VehicleInfo vi : vehicleInfoList){
			String key = vi.getNiankuan();
			if(map.containsKey(key)){
				values = map.get(key);
			}else {
				values = new ArrayList<>();
			}
			values.add(vi);

			map.put(key, values);
		}
		comRes.setData(map);

		return comRes;
	}
}