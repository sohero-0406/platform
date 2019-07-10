/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.web;

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
import com.jeesite.modules.aa.entity.TechnologyInfo;
import com.jeesite.modules.aa.service.TechnologyInfoService;

/**
 * 技术状况项目表Controller
 * @author lvchangwei
 * @version 2019-07-04
 */
@Controller
@RequestMapping(value = "${adminPath}/aa/technologyInfo")
public class TechnologyInfoController extends BaseController {

	@Autowired
	private TechnologyInfoService technologyInfoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TechnologyInfo get(String id, boolean isNewRecord) {
		return technologyInfoService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(TechnologyInfo technologyInfo, Model model) {
		model.addAttribute("technologyInfo", technologyInfo);
		return "modules/aa/technologyInfoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TechnologyInfo> listData(TechnologyInfo technologyInfo, HttpServletRequest request, HttpServletResponse response) {
		technologyInfo.setPage(new Page<>(request, response));
		Page<TechnologyInfo> page = technologyInfoService.findPage(technologyInfo);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(TechnologyInfo technologyInfo, Model model) {
		model.addAttribute("technologyInfo", technologyInfo);
		return "modules/aa/technologyInfoForm";
	}

	/**
	 * 保存技术状况项目表
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TechnologyInfo technologyInfo) {
		technologyInfoService.save(technologyInfo);
		return renderResult(Global.TRUE, text("保存技术状况项目表成功！"));
	}
	
	/**
	 * 删除技术状况项目表
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TechnologyInfo technologyInfo) {
		technologyInfoService.delete(technologyInfo);
		return renderResult(Global.TRUE, text("删除技术状况项目表成功！"));
	}
	
}