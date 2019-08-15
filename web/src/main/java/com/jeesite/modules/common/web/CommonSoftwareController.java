/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.constant.CodeConstant;
import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.CommonResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
import com.jeesite.modules.common.entity.CommonSoftware;
import com.jeesite.modules.common.service.CommonSoftwareService;

import java.util.List;

/**
 * 软件表Controller
 * @author mayuhu
 * @version 2019-08-08
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonSoftware")
public class CommonSoftwareController extends BaseController {

	@Autowired
	private CommonSoftwareService commonSoftwareService;
	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public CommonSoftware get(String id, boolean isNewRecord) {
//		return commonSoftwareService.get(id, isNewRecord);
//	}
//
//	/**
//	 * 查询列表
//	 */
//	@RequestMapping(value = {"list", ""})
//	public String list(CommonSoftware commonSoftware, Model model) {
//		model.addAttribute("commonSoftware", commonSoftware);
//		return "modules/common/commonSoftwareList";
//	}
//
//	/**
//	 * 查询列表数据
//	 */
//	@RequestMapping(value = "listData")
//	@ResponseBody
//	public Page<CommonSoftware> listData(CommonSoftware commonSoftware, HttpServletRequest request, HttpServletResponse response) {
//		commonSoftware.setPage(new Page<>(request, response));
//		Page<CommonSoftware> page = commonSoftwareService.findPage(commonSoftware);
//		return page;
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@RequestMapping(value = "form")
//	public String form(CommonSoftware commonSoftware, Model model) {
//		model.addAttribute("commonSoftware", commonSoftware);
//		return "modules/common/commonSoftwareForm";
//	}
//
//	/**
//	 * 保存软件表
//	 */
//	@PostMapping(value = "save")
//	@ResponseBody
//	public String save(@Validated CommonSoftware commonSoftware) {
//		commonSoftwareService.save(commonSoftware);
//		return renderResult(Global.TRUE, text("保存软件表成功！"));
//	}
//
//	/**
//	 * 删除软件表
//	 */
//	@RequestMapping(value = "delete")
//	@ResponseBody
//	public String delete(CommonSoftware commonSoftware) {
//		commonSoftwareService.delete(commonSoftware);
//		return renderResult(Global.TRUE, text("删除软件表成功！"));
//	}

	/**
	 * 加载软件列表数据
	 * @param commonSoftware
	 * @return
	 */
	@ApiOperation(value = "加载软件列表数据")
	@ApiImplicitParam(name = "commonSoftware", value = "查询软件的条件对象", dataType="CommonSoftware")
	@Log(operationName = "加载软件列表数据")
	@RequestMapping(value = "listCommonSoftwareOnly")
	@ResponseBody
	public CommonResult listCommonSoftwareOnly(CommonSoftware commonSoftware) {
		List<CommonSoftware> list = commonSoftwareService.findList(commonSoftware);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, list);
	}
}