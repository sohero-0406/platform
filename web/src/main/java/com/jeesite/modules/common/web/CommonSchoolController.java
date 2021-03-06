/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.constant.CodeConstant;
import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.CommonAssessment;
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
	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public CommonSchool get(String id, boolean isNewRecord) {
//		return commonSchoolService.get(id, isNewRecord);
//	}
//
//	/**
//	 * 查询列表
//	 */
//	@RequestMapping(value = {"list", ""})
//	public String list(CommonSchool commonSchool, Model model) {
//		model.addAttribute("commonSchool", commonSchool);
//		return "modules/common/commonSchoolList";
//	}
//
//	/**
//	 * 查询列表数据
//	 */
//	@RequestMapping(value = "listData")
//	@ResponseBody
//	public Page<CommonSchool> listData(CommonSchool commonSchool, HttpServletRequest request, HttpServletResponse response) {
//		commonSchool.setPage(new Page<>(request, response));
//		Page<CommonSchool> page = commonSchoolService.findPage(commonSchool);
//		return page;
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@RequestMapping(value = "form")
//	public String form(CommonSchool commonSchool, Model model) {
//		model.addAttribute("commonSchool", commonSchool);
//		return "modules/common/commonSchoolForm";
//	}
//
//	/**
//	 * 保存院校表
//	 */
//	@PostMapping(value = "save")
//	@ResponseBody
//	public String save(@Validated CommonSchool commonSchool) {
//		commonSchoolService.save(commonSchool);
//		return renderResult(Global.TRUE, text("保存院校表成功！"));
//	}
//
//	/**
//	 * 删除院校表
//	 */
//	@RequestMapping(value = "delete")
//	@ResponseBody
//	public String delete(CommonSchool commonSchool) {
//		commonSchoolService.delete(commonSchool);
//		return renderResult(Global.TRUE, text("删除院校表成功！"));
//	}


	/**
	 * 加载分页学校数据
	 * @param commonSchool
	 * @return
	 */
	@ApiOperation(value = "加载分页学校数据")
	@ApiImplicitParam(name = "commonSchool", value = "查询学校的条件对象", required = true, dataType="CommonSchool")
	@Log(operationName = "加载分页学校数据")
	@RequestMapping(value = "listSchool")
	@ResponseBody
	public CommonResult listSchool(CommonSchool commonSchool) {
		Page<CommonSchool> page = commonSchoolService.findPage(commonSchool);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, page);
	}

	/**
	 * 加载列表学校数据
	 * @param commonSchool
	 * @return
	 */
	@ApiOperation(value = "加载列表学校数据")
	@ApiImplicitParam(name = "commonSchool", value = "查询学校的条件对象", dataType="CommonSchool")
	@Log(operationName = "加载列表学校数据")
	@RequestMapping(value = "listSchoolOnly")
	@ResponseBody
	public CommonResult listSchoolOnly(CommonSchool commonSchool) {
		List<CommonSchool> list = commonSchoolService.findList(commonSchool);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, list);
	}

	/**
	 * 保存、更新学校
	 * @param commonSchool
	 * @return
	 */
	@ApiOperation(value = "保存、更新学校")
	@ApiImplicitParam(name = "commonSchool", value = "要保存或更新的学校对象", required = true, dataType="CommonSchool")
	@Log(operationName = "保存、更新学校", operationType = Log.OPERA_TYPE_ADD_OR_UPD)
	@RequestMapping(value = "saveCommonSchool")
	@ResponseBody
	public CommonResult saveCommonSchool(CommonSchool commonSchool){
		commonSchoolService.save(commonSchool);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	/**
	 * 根据id加载学校
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据id加载学校")
	@ApiImplicitParam(name = "id", value = "学校的id", required = true, dataType="String")
	@Log(operationName = "根据id加载学校")
	@RequestMapping(value = "loadCommonSchool")
	@ResponseBody
	public CommonResult loadCommonSchool(String id){
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, commonSchoolService.get(id));
	}

	/**
	 * 删除学校
	 * @param commonSchool
	 * @return
	 */
	@ApiOperation(value = "删除学校")
	@ApiImplicitParam(name = "commonSchool", value = "被删除的学校对象", required = true, dataType="CommonSchool")
	@Log(operationName = "删除学校", operationType = Log.OPERA_TYPE_DEL)
	@RequestMapping(value = "deleteCommonSchool")
	@ResponseBody
	public CommonResult deleteCommonAssessment(CommonSchool commonSchool){
		commonSchoolService.delete(commonSchool);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}


	@ApiOperation(value = "根据json删除学校")
	@ApiImplicitParam(name = "json", value = "删除信息的json数据", required = true, dataType = "String")
	@Log(operationName = "根据json删除学校", operationType = Log.OPERA_TYPE_DEL)
	@RequestMapping(value = "deleteSchool")
	@ResponseBody
	public CommonResult deleteSchool(String json) {

		return commonSchoolService.deleteCommonSchool(json);
	}
	
}