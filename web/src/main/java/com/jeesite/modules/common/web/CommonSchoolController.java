/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.constant.CodeConstant;
import com.jeesite.modules.common.entity.CommonAssessment;
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
import com.jeesite.modules.common.entity.CommonSchool;
import com.jeesite.modules.common.service.CommonSchoolService;

import java.util.List;

/**
 * 院校表Controller
 * @author mayuhu
 * @version 2019-08-05
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonSchool")
public class CommonSchoolController extends BaseController {

	@Autowired
	private CommonSchoolService commonSchoolService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CommonSchool get(String id, boolean isNewRecord) {
		return commonSchoolService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(CommonSchool commonSchool, Model model) {
		model.addAttribute("commonSchool", commonSchool);
		return "modules/common/commonSchoolList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CommonSchool> listData(CommonSchool commonSchool, HttpServletRequest request, HttpServletResponse response) {
		commonSchool.setPage(new Page<>(request, response));
		Page<CommonSchool> page = commonSchoolService.findPage(commonSchool);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(CommonSchool commonSchool, Model model) {
		model.addAttribute("commonSchool", commonSchool);
		return "modules/common/commonSchoolForm";
	}

	/**
	 * 保存院校表
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CommonSchool commonSchool) {
		commonSchoolService.save(commonSchool);
		return renderResult(Global.TRUE, text("保存院校表成功！"));
	}
	
	/**
	 * 删除院校表
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CommonSchool commonSchool) {
		commonSchoolService.delete(commonSchool);
		return renderResult(Global.TRUE, text("删除院校表成功！"));
	}


	@RequestMapping(value = "listSchool")
	@ResponseBody
	public CommonResult listSchool(CommonSchool commonSchool) {
		Page<CommonSchool> page = commonSchoolService.findPage(commonSchool);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, page);
	}

	@RequestMapping(value = "listSchoolOnly")
	@ResponseBody
	public CommonResult listSchoolOnly(CommonSchool commonSchool) {
		List<CommonSchool> list = commonSchoolService.findList(commonSchool);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, list);
	}


	@RequestMapping(value = "saveCommonSchool")
	@ResponseBody
	public CommonResult saveCommonSchool(CommonSchool commonSchool){
		commonSchoolService.save(commonSchool);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	@RequestMapping(value = "loadCommonSchool")
	@ResponseBody
	public CommonResult loadCommonSchool(String id){
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, commonSchoolService.get(id));
	}

	@RequestMapping(value = "deleteCommonSchool")
	@ResponseBody
	public CommonResult deleteCommonAssessment(CommonSchool commonSchool){
		commonSchoolService.delete(commonSchool);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}
	
}