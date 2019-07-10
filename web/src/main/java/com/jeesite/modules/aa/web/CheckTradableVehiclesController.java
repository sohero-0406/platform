/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.aa.entity.VehicleDocumentInfo;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.entity.ExamUser;
import com.jeesite.modules.common.utils.UserUtils;
import com.jeesite.modules.sys.entity.DictData;
import com.jeesite.modules.sys.utils.DictUtils;
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
import com.jeesite.modules.aa.entity.CheckTradableVehicles;
import com.jeesite.modules.aa.service.CheckTradableVehiclesService;

import java.util.List;

/**
 * 检查可交易车辆Controller
 * @author lvchangwei
 * @version 2019-07-01
 */
@Controller
@RequestMapping(value = "${adminPath}/aa/checkTradableVehicles")
public class CheckTradableVehiclesController extends BaseController {

	@Autowired
	private CheckTradableVehiclesService checkTradableVehiclesService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CheckTradableVehicles get(String id, boolean isNewRecord) {
		return checkTradableVehiclesService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(CheckTradableVehicles checkTradableVehicles, Model model) {
		model.addAttribute("checkTradableVehicles", checkTradableVehicles);
		return "modules/aa/checkTradableVehiclesList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CheckTradableVehicles> listData(CheckTradableVehicles checkTradableVehicles, HttpServletRequest request, HttpServletResponse response) {
		checkTradableVehicles.setPage(new Page<>(request, response));
		Page<CheckTradableVehicles> page = checkTradableVehiclesService.findPage(checkTradableVehicles);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(CheckTradableVehicles checkTradableVehicles, Model model) {
		model.addAttribute("checkTradableVehicles", checkTradableVehicles);
		return "modules/aa/checkTradableVehiclesForm";
	}

	/**
	 * 保存检查可交易车辆
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public CommonResult save(@Validated CheckTradableVehicles checkTradableVehicles) {
		ExamUser examUser = UserUtils.getExamUser();
		checkTradableVehicles.setExamUserId(examUser.getId());
		checkTradableVehicles.setPaperId(examUser.getPaperId());
		checkTradableVehiclesService.save(checkTradableVehicles);
		return new CommonResult();
	}
	
	/**
	 * 删除检查可交易车辆
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CheckTradableVehicles checkTradableVehicles) {
		checkTradableVehiclesService.delete(checkTradableVehicles);
		return renderResult(Global.TRUE, text("删除检查可交易车辆成功！"));
	}

	/**
	 * 加载可交易车辆判别信息
	 */
	@RequestMapping(value = "getDetail")
	@ResponseBody
	public CommonResult getDetail() {
		ExamUser examUser = UserUtils.getExamUser();
		CheckTradableVehicles checkTradableVehicles = new CheckTradableVehicles();
		checkTradableVehicles.setExamUserId(examUser.getId());
		checkTradableVehicles = checkTradableVehiclesService.getByEntity(checkTradableVehicles);
		CommonResult result = new CommonResult();
		result.setData(checkTradableVehicles);
		return result;
	}

	/**
	 * 保存事故车判定信息
	 */
	@PostMapping(value = "saveIsAccident")
	@ResponseBody
	public CommonResult saveIsAccident(@Validated CheckTradableVehicles checkTradableVehicles) {
		ExamUser examUser = UserUtils.getExamUser();
		checkTradableVehicles.setExamUserId(examUser.getId());
		checkTradableVehicles.setPaperId(examUser.getPaperId());
		checkTradableVehiclesService.saveIsAccident(checkTradableVehicles);
		return new CommonResult();
	}
}