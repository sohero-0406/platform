/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.common.aop.Log;
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
import com.jeesite.modules.common.entity.CommonAccessory;
import com.jeesite.modules.common.service.CommonAccessoryService;

/**
 * 汽车配件表Controller
 * @author mayuhu
 * @version 2019-08-12
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonAccessory")
public class CommonAccessoryController extends BaseController {

	@Autowired
	private CommonAccessoryService commonAccessoryService;
	
	/**
	 * 获取数据
	 */
//	@ModelAttribute
//	public CommonAccessory get(String id, boolean isNewRecord) {
//		return commonAccessoryService.get(id, isNewRecord);
//	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(CommonAccessory commonAccessory, Model model) {
		model.addAttribute("commonAccessory", commonAccessory);
		return "modules/common/commonAccessoryList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CommonAccessory> listData(CommonAccessory commonAccessory, HttpServletRequest request, HttpServletResponse response) {
		commonAccessory.setPage(new Page<>(request, response));
		Page<CommonAccessory> page = commonAccessoryService.findPage(commonAccessory);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(CommonAccessory commonAccessory, Model model) {
		model.addAttribute("commonAccessory", commonAccessory);
		return "modules/common/commonAccessoryForm";
	}

	/**
	 * 保存汽车配件表
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CommonAccessory commonAccessory) {
		commonAccessoryService.save(commonAccessory);
		return renderResult(Global.TRUE, text("保存汽车配件表成功！"));
	}
	
	/**
	 * 删除汽车配件表
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CommonAccessory commonAccessory) {
		commonAccessoryService.delete(commonAccessory);
		return renderResult(Global.TRUE, text("删除汽车配件表成功！"));
	}


	/**
	 * 加载配件分页数据
	 * @param commonAccessory
	 * @return
	 */
	@Log(operationName = "加载配件分页数据")
	@RequestMapping(value = "listCommonAccessory")
	@ResponseBody
	public CommonResult listCommonAccessory(CommonAccessory commonAccessory){
		return commonAccessoryService.findPageByCondition(commonAccessory);
	}

	/**
	 * 删除配件信息
	 * @param json
	 * @return
	 */
	@Log(operationName = "删除配件信息", operationType = Log.OPERA_TYPE_DEL)
	@RequestMapping(value = "deleteCommonAccessory")
	@ResponseBody
	public CommonResult deleteCommonAccessory(String json) {

		return commonAccessoryService.deleteCommonCommonAccessory(json);
	}

	
}