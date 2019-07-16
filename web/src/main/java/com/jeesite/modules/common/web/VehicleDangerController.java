/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jeesite.modules.common.entity.VehicleDanger;
import com.jeesite.modules.common.service.VehicleDangerService;

/**
 * 车辆出险记录表Controller
 * @author liangtao
 * @version 2019-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/common/vehicleDanger")
public class VehicleDangerController extends BaseController {

	@Autowired
	private VehicleDangerService vehicleDangerService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public VehicleDanger get(String id, boolean isNewRecord) {
		return vehicleDangerService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(VehicleDanger vehicleDanger, Model model) {
		model.addAttribute("vehicleDanger", vehicleDanger);
		return "modules/common/vehicleDangerList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<VehicleDanger> listData(VehicleDanger vehicleDanger, HttpServletRequest request, HttpServletResponse response) {
		vehicleDanger.setPage(new Page<>(request, response));
		Page<VehicleDanger> page = vehicleDangerService.findPage(vehicleDanger);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(VehicleDanger vehicleDanger, Model model) {
		model.addAttribute("vehicleDanger", vehicleDanger);
		return "modules/common/vehicleDangerForm";
	}

	/**
	 * 保存车辆出险记录表
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated VehicleDanger vehicleDanger) {
		vehicleDangerService.save(vehicleDanger);
		return renderResult(Global.TRUE, text("保存车辆出险记录表成功！"));
	}
	
	/**
	 * 删除车辆出险记录表
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(VehicleDanger vehicleDanger) {
		vehicleDangerService.delete(vehicleDanger);
		return renderResult(Global.TRUE, text("删除车辆出险记录表成功！"));
	}
	
}