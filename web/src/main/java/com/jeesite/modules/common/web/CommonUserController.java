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
import com.jeesite.modules.common.entity.CommonUser;
import com.jeesite.modules.common.service.CommonUserService;

/**
 * common_userController
 * @author lvchangwei
 * @version 2019-07-16
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonUser")
public class CommonUserController extends BaseController {

	@Autowired
	private CommonUserService commonUserService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CommonUser get(String id, boolean isNewRecord) {
		return commonUserService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(CommonUser commonUser, Model model) {
		model.addAttribute("commonUser", commonUser);
		return "modules/common/commonUserList";
	}

	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CommonUser> listData(CommonUser commonUser, HttpServletRequest request, HttpServletResponse response) {
		commonUser.setPage(new Page<>(request, response));
		Page<CommonUser> page = commonUserService.findPage(commonUser);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(CommonUser commonUser, Model model) {
		model.addAttribute("commonUser", commonUser);
		return "modules/common/commonUserForm";
	}

	/**
	 * 保存common_user
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CommonUser commonUser) {
		commonUserService.save(commonUser);
		return renderResult(Global.TRUE, text("保存common_user成功！"));
	}
	
	/**
	 * 删除common_user
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CommonUser commonUser) {
		commonUserService.delete(commonUser);
		return renderResult(Global.TRUE, text("删除common_user成功！"));
	}

	/**
	 * 用户登录功能
	 */

	/**
	 * 删除common_user
	 */
	@RequestMapping(value = "login")
	@ResponseBody
	public CommonResult login(CommonUser commonUser) {
		CommonResult comRes = new CommonResult();
		//用户名
		String userName = commonUser.getUserName();
		//密码
		String password = commonUser.getPassword();
		//判断是否输入用户名
		if(null==userName || "".equals(userName)){
			comRes.setMsg("请求失败");
			comRes.setData("请输入用户名");
			return comRes;
		}
		//判断密码是否为空
		if(null==password || "".equals(password)){
			comRes.setMsg("请求失败");
			comRes.setData("请输入密码");
			return comRes;
		}
		//根据用户名查找用户信息
		CommonUser user = commonUserService.getByEntityUserName(userName);
		if(null==user.getUserName()){

		}


		return comRes;
	}

}