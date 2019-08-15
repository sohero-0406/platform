/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jeesite.modules.common.entity.CommonLog;
import com.jeesite.modules.common.service.CommonLogService;

/**
 * 大平台日志表Controller
 * @author mayuhu
 * @version 2019-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonLog")
public class CommonLogController extends BaseController {

	@Autowired
	private CommonLogService commonLogService;
	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public CommonLog get(String id, boolean isNewRecord) {
//		return commonLogService.get(id, isNewRecord);
//	}
	
//	/**
//	 * 查询列表
//	 */
//	@RequestMapping(value = {"list", ""})
//	public String list(CommonLog commonLog, Model model) {
//		model.addAttribute("commonLog", commonLog);
//		return "modules/common/commonLogList";
//	}
//
//	/**
//	 * 查询列表数据
//	 */
//	@RequestMapping(value = "listData")
//	@ResponseBody
//	public Page<CommonLog> listData(CommonLog commonLog, HttpServletRequest request, HttpServletResponse response) {
//		commonLog.setPage(new Page<>(request, response));
//		Page<CommonLog> page = commonLogService.findPage(commonLog);
//		return page;
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@RequestMapping(value = "form")
//	public String form(CommonLog commonLog, Model model) {
//		model.addAttribute("commonLog", commonLog);
//		return "modules/common/commonLogForm";
//	}
//
//	/**
//	 * 保存大平台日志表
//	 */
//	@PostMapping(value = "save")
//	@ResponseBody
//	public String save(@Validated CommonLog commonLog) {
//		commonLogService.save(commonLog);
//		return renderResult(Global.TRUE, text("保存大平台日志表成功！"));
//	}
//
//	/**
//	 * 删除大平台日志表
//	 */
//	@RequestMapping(value = "delete")
//	@ResponseBody
//	public String delete(CommonLog commonLog) {
//		commonLogService.delete(commonLog);
//		return renderResult(Global.TRUE, text("删除大平台日志表成功！"));
//	}

	/**
	 * 查询分页日志
	 * @param commonLog
	 * @return
	 */
	@ApiOperation(value = "查询日志")
	@ApiImplicitParam(name = "commonLog", value = "查询日志的条件对象", required = true, dataType="CommonLog")
	@Log(operationName = "查询日志")
	@RequestMapping(value = "listLog")
	@ResponseBody
	public CommonResult listLog(CommonLog commonLog){
		return commonLogService.findPageByCondition(commonLog);
	}
	
}