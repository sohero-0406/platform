/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.utils.excel.ExcelExport;
import com.jeesite.common.utils.excel.ExcelImport;
import com.jeesite.common.utils.excel.annotation.ExcelField;
import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.service.CommonAssessmentService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 考核表Controller
 * @author mayuhu
 * @version 2019-08-05
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonAssessment")
public class CommonAssessmentController extends BaseController {

	@Autowired
	private CommonAssessmentService commonAssessmentService;
	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public CommonAssessment get(String id, boolean isNewRecord) {
//		return commonAssessmentService.get(id, isNewRecord);
//	}
//
//	/**
//	 * 查询列表
//	 */
//	@RequestMapping(value = {"list", ""})
//	public String list(CommonAssessment commonAssessment, Model model) {
//		model.addAttribute("commonAssessment", commonAssessment);
//		return "modules/common/commonAssessmentList";
//	}
//
//	/**
//	 * 查询列表数据
//	 */
//	@RequestMapping(value = "listData")
//	@ResponseBody
//	public Page<CommonAssessment> listData(CommonAssessment commonAssessment, HttpServletRequest request, HttpServletResponse response) {
//		commonAssessment.setPage(new Page<>(request, response));
//		Page<CommonAssessment> page = commonAssessmentService.findPage(commonAssessment);
//		return page;
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@RequestMapping(value = "form")
//	public String form(CommonAssessment commonAssessment, Model model) {
//		model.addAttribute("commonAssessment", commonAssessment);
//		return "modules/common/commonAssessmentForm";
//	}
//
//	/**
//	 * 保存考核表
//	 */
//	@PostMapping(value = "save")
//	@ResponseBody
//	public String save(@Validated CommonAssessment commonAssessment) {
//		commonAssessmentService.save(commonAssessment);
//		return renderResult(Global.TRUE, text("保存考核表成功！"));
//	}
//
//	/**
//	 * 删除考核表
//	 */
//	@RequestMapping(value = "delete")
//	@ResponseBody
//	public String delete(CommonAssessment commonAssessment) {
	/**
	 * 保存、更新考核
	 * @param commonAssessment
	 * @param userConfig
	 * @return
	 */
	@ApiOperation(value = "保存、更新考核")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commonAssessment", value = "要保存的考核对象", required = true, dataType="CommonAssessment"),
			@ApiImplicitParam(name = "userConfig", value = "前台发来的用户列表json数据", required = true, dataType="String")
	})
	@Log(operationName = "保存、更新考核", operationType = Log.OPERA_TYPE_ADD_OR_UPD)
	@RequestMapping(value = "saveCommonAssessment")
	@ResponseBody
	public CommonResult saveCommonAssessment(CommonAssessment commonAssessment, String userConfig){
		return commonAssessmentService.save(commonAssessment, userConfig);
	}

	/**
	 * 加载考核的分页数据
	 * @param commonAssessment
	 * @return
	 */
	@ApiOperation(value = "加载考核的分页数据")
	@ApiImplicitParam(name = "commonAssessment", value = "查询的考核条件对象", required = true, dataType="CommonAssessment")
	@Log(operationName = "加载考核的分页数据")
	@RequestMapping(value = "listAssessment")
	@ResponseBody
	public CommonResult listAssessment(CommonAssessment commonAssessment) {
		return commonAssessmentService.findPageCommonAssessment(commonAssessment);
	}

	/**
	 * 根据id加载考核
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据id加载考核")
	@ApiImplicitParam(name = "id", value = "考核的id", required = true, dataType="String")
	@Log(operationName = "根据id加载考核")
	@RequestMapping(value = "loadCommonAssessment")
	@ResponseBody
	public CommonResult loadCommonAssessment(String id){
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, commonAssessmentService.loadOneAssessment(id));
	}

	/*
	 * 删除考核
	 * @param json
	 * @return
	 */
	@ApiOperation(value = "删除考核")
	@ApiImplicitParam(name = "json", value = "要删除的考核的json数据", required = true, dataType="String")
	@Log(operationName = "删除考核", operationType = Log.OPERA_TYPE_DEL)
	@RequestMapping(value = "deleteCommonAssessment")
	@ResponseBody
	public CommonResult deleteCommonAssessment(String json){
		return commonAssessmentService.deleteCommonAssessment(json);
	}

	/**
	 * 更新考核状态（包括上传主观评分表）
	 * @param commonAssessment 要更新的对象
	 * @param file 上传的评分表文件
	 * @return
	 */
	@ApiOperation(value = "更新考核状态")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commonAssessment", value = "要更新的考核对象", required = true, dataType="CommonAssessment"),
			@ApiImplicitParam(name = "file", value = "上传的评分结果文件", dataType="MultipartFile")
	})
	@Log(operationName = "更新考核状态", operationType = Log.OPERA_TYPE_UPD)
	@RequestMapping(value = "updateCommonAssessmentStatus")
	@ResponseBody
	public CommonResult updateCommonAssessmentStatus(CommonAssessment commonAssessment, MultipartFile file) throws Exception {

		return commonAssessmentService.updateCommonAssessmentStatus(commonAssessment, file);
	}

	/**
	 * 上传客观评分
	 * @param scoreInfo
	 * @return
	 */
	@ApiOperation(value = "上传客观评分")
	@ApiImplicitParam(name = "scoreInfo", value = "教师端上传来的分数json数据", required = true, dataType="String")
	@Log(operationName = "上传客观评分", operationType = Log.OPERA_TYPE_UPD)
	@RequestMapping(value = "uploadScores")
	@ResponseBody
	public CommonResult uploadScores(String scoreInfo){

		return commonAssessmentService.parseScoreInfo(scoreInfo);
	}

	/**
	 * 根据登录人加载考核名称
	 * @param commonUserId
	 * @return
	 */
	@ApiOperation(value = "根据登录人加载考核名称")
	@ApiImplicitParam(name = "commonUserId", value = "用户id", required = true, dataType="String")
	@Log(operationName = "根据登录人加载考核名称", operationType = Log.OPERA_TYPE_SEL)
	@RequestMapping(value = "loadAssessmentNameList")
	@ResponseBody
	public CommonResult loadAssessmentNameList(String commonUserId){

		return commonAssessmentService.loadAssessmentNameList(commonUserId);
	}

	/**
	 * 加载考核名称
	 *
	 * @return
	 */
	@ApiOperation(value = "加载考核名称")
	@Log(operationName = "加载考核名称", operationType = Log.OPERA_TYPE_SEL)
	@RequestMapping(value = "loadAssessmentNameListWithCalc")
	@ResponseBody
	public CommonResult loadAssessmentNameList(){
		return commonAssessmentService.loadAssessmentNameList();
	}

	/**
	 * 导出用户模板
	 * @param response
	 */
	@ApiOperation(value = "导出上传考生基本信息模板")
	@Log(operationName = "导出上传考生基本信息模板", operationType = Log.OPERA_TYPE_OTHER)
	@RequestMapping(value = "exportUploadMode")
	public void exportUploadMode(HttpServletResponse response) {
		try {
			String fileName = "考生基本信息模板.xlsx";
			List<UserCondition> list = Lists.newArrayList();
			UserCondition userCondition = new UserCondition();
			userCondition.setLoginName("110101199912121558");
			userCondition.setTrueName("王小明");
			userCondition.setAssessmentDate("20190828");
			userCondition.setAssessmentTime("7:30-10:30");
			list.add(userCondition);
			new ExcelExport(null, UserCondition.class, ExcelField.Type.EXPORT).setDataList(list).write(response, fileName).close();
		} catch (Exception e) {
			// addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
	}

	@ApiOperation(value = "下载带有学生新的评分表")
	@ApiImplicitParam(name = "id", value = "考核的id", required = true, dataType="String")
	@Log(operationName = "下载带有学生新的评分表", operationType = Log.OPERA_TYPE_SEL)
	@RequestMapping(value = "downloadStandardScoreMode")
	public void downloadStandardScoreMode(String id, HttpServletResponse response){
		ExcelExport ee = commonAssessmentService.makeExcelMode(id);
		ee.write(response, "评分表.xlsx").close();
	}
	
}