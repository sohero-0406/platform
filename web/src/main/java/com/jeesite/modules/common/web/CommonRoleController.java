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
import com.jeesite.modules.common.entity.CommonRole;
import com.jeesite.modules.common.service.CommonRoleService;

/**
 * common_roleController
 * @author mayuhu
 * @version 2019-08-05
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonRole")
public class CommonRoleController extends BaseController {

	@Autowired
	private CommonRoleService commonRoleService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CommonRole get(String id, boolean isNewRecord) {
		return commonRoleService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(CommonRole commonRole, Model model) {
		model.addAttribute("commonRole", commonRole);
		return "modules/common/commonRoleList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CommonRole> listData(CommonRole commonRole, HttpServletRequest request, HttpServletResponse response) {
		commonRole.setPage(new Page<>(request, response));
		Page<CommonRole> page = commonRoleService.findPage(commonRole);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(CommonRole commonRole, Model model) {
		model.addAttribute("commonRole", commonRole);
		return "modules/common/commonRoleForm";
	}

	/**
	 * 保存common_role
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CommonRole commonRole) {
		commonRoleService.save(commonRole);
		return renderResult(Global.TRUE, text("保存common_role成功！"));
	}
	
	/**
	 * 删除common_role
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CommonRole commonRole) {
		commonRoleService.delete(commonRole);
		return renderResult(Global.TRUE, text("删除common_role成功！"));
	}
	
}