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
import com.jeesite.modules.aa.entity.PictureUser;
import com.jeesite.modules.aa.service.PictureUserService;

/**
 * 用户图片表Controller
 * @author chenlitao
 * @version 2019-06-29
 */
@Controller
@RequestMapping(value = "${adminPath}/aa/pictureUser")
public class PictureUserController extends BaseController {

	@Autowired
	private PictureUserService pictureUserService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public PictureUser get(String id, boolean isNewRecord) {
		return pictureUserService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("aa:pictureUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(PictureUser pictureUser, Model model) {
		model.addAttribute("pictureUser", pictureUser);
		return "modules/aa/pictureUserList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("aa:pictureUser:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<PictureUser> listData(PictureUser pictureUser, HttpServletRequest request, HttpServletResponse response) {
		pictureUser.setPage(new Page<>(request, response));
		Page<PictureUser> page = pictureUserService.findPage(pictureUser);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("aa:pictureUser:view")
	@RequestMapping(value = "form")
	public String form(PictureUser pictureUser, Model model) {
		model.addAttribute("pictureUser", pictureUser);
		return "modules/aa/pictureUserForm";
	}

	/**
	 * 保存用户图片表
	 */
	@RequiresPermissions("aa:pictureUser:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated PictureUser pictureUser) {
		pictureUserService.save(pictureUser);
		return renderResult(Global.TRUE, text("保存用户图片表成功！"));
	}
	
	/**
	 * 删除用户图片表
	 */
	@RequiresPermissions("aa:pictureUser:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(PictureUser pictureUser) {
		pictureUserService.delete(pictureUser);
		return renderResult(Global.TRUE, text("删除用户图片表成功！"));
	}
	
}