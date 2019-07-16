/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.modules.common.entity.MaintenanceType;
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
import com.jeesite.modules.common.entity.Maintenance;
import com.jeesite.modules.common.service.MaintenanceService;

/**
 * 车辆维保记录Controller
 * @author liangtao
 * @version 2019-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/common/maintenance")
public class MaintenanceController extends BaseController {

	@Autowired
	private MaintenanceService maintenanceService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Maintenance get(String id, boolean isNewRecord) {
		return maintenanceService.get(id, isNewRecord);
	}

	/**
	 * 查询列表
	 */

	@RequestMapping(value = {"list", ""})
	public String list(Maintenance maintenance, Model model) {
		model.addAttribute("maintenance", maintenance);
		return "modules/common/maintenanceList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Maintenance> listData(Maintenance maintenance, HttpServletRequest request, HttpServletResponse response) {
		maintenance.setPage(new Page<>(request, response));
		Page<Maintenance> page = maintenanceService.findPage(maintenance);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(Maintenance maintenance, Model model) {
		model.addAttribute("maintenance", maintenance);
		return "modules/common/maintenanceForm";
	}

	/**
	 * 保存车辆维保记录
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Maintenance maintenance) {
		maintenanceService.save(maintenance);
		return renderResult(Global.TRUE, text("保存车辆维保记录成功！"));
	}
	
	/**
	 * 删除车辆维保记录
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Maintenance maintenance) {
		maintenanceService.delete(maintenance);
		return renderResult(Global.TRUE, text("删除车辆维保记录成功！"));
	}


	/**
	 * 车辆维修保养记录保存功能
	 * @param aaa
	 * @return
	 */
	@RequestMapping(value = "car")
	@ResponseBody
	public String list(String aaa) {
		JSONObject obj = JSONObject.parseObject(aaa);
		JSONObject mapResult = obj.getJSONObject("result");
		JSONObject mapData =  mapResult.getJSONObject("data");
		JSONObject mapDetail =  mapData.getJSONObject("detail");
		Maintenance maintenance = JSONObject.parseObject( mapData.getString("detail"),Maintenance.class);
		maintenanceService.save(maintenance);
		String id = maintenance.getId();
		maintenanceService.saveMaintenanceType(mapDetail,id,"outsideAnalyzeRepairRecords"); //外观覆盖件详细维修记录
		maintenanceService.saveMaintenanceType(mapDetail,id,"componentAnalyzeRepairRecords");//重要组成部件详细维修记录
		maintenanceService.saveMaintenanceType(mapDetail,id,"normalRepairRecords");//该车所有的详细维修记录
		return "modules/common/examList";

	}



}