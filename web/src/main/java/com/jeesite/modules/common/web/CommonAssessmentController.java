/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.constant.CodeConstant;
import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.CommonResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.apache.bcel.classfile.Code;
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
import com.jeesite.modules.common.entity.CommonAssessment;
import com.jeesite.modules.common.service.CommonAssessmentService;
import org.springframework.web.multipart.MultipartFile;

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
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CommonAssessment get(String id, boolean isNewRecord) {
		return commonAssessmentService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(CommonAssessment commonAssessment, Model model) {
		model.addAttribute("commonAssessment", commonAssessment);
		return "modules/common/commonAssessmentList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CommonAssessment> listData(CommonAssessment commonAssessment, HttpServletRequest request, HttpServletResponse response) {
		commonAssessment.setPage(new Page<>(request, response));
		Page<CommonAssessment> page = commonAssessmentService.findPage(commonAssessment);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(CommonAssessment commonAssessment, Model model) {
		model.addAttribute("commonAssessment", commonAssessment);
		return "modules/common/commonAssessmentForm";
	}

	/**
	 * 保存考核表
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CommonAssessment commonAssessment) {
		commonAssessmentService.save(commonAssessment);
		return renderResult(Global.TRUE, text("保存考核表成功！"));
	}
	
	/**
	 * 删除考核表
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CommonAssessment commonAssessment) {
		commonAssessmentService.delete(commonAssessment);
		return renderResult(Global.TRUE, text("删除考核表成功！"));
	}

	/**
	 * 加载考核的分页数据
	 * @param commonAssessment
	 * @return
	 */
	@Log(operationName = "加载考核的分页数据")
	@RequestMapping(value = "listAssessment")
	@ResponseBody
	public CommonResult listAssessment(CommonAssessment commonAssessment) {
		return commonAssessmentService.findPageCommonAssessment(commonAssessment);
	}

	/**
	 * 保存、更新考核
	 * @param commonAssessment
	 * @param userConfig
	 * @return
	 */
	@Log(operationName = "保存、更新考核", operationType = Log.OPERA_TYPE_ADD_OR_UPD)
	@RequestMapping(value = "saveCommonAssessment")
	@ResponseBody
	public CommonResult saveCommonAssessment(CommonAssessment commonAssessment, String userConfig){
		return commonAssessmentService.save(commonAssessment, userConfig);
	}

	/**
	 * 根据id加载考核
	 * @param id
	 * @return
	 */
	@Log(operationName = "根据id加载考核")
	@RequestMapping(value = "loadCommonAssessment")
	@ResponseBody
	public CommonResult loadCommonAssessment(String id){
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, commonAssessmentService.get(id));
	}

	/**
	 * 删除考核
	 * @param json
	 * @return
	 */
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
	@Log(operationName = "根据登录人加载考核名称", operationType = Log.OPERA_TYPE_SEL)
	@RequestMapping(value = "loadAssessmentNameList")
	@ResponseBody
	public CommonResult loadAssessmentNameList(String commonUserId){

		return commonAssessmentService.loadAssessmentNameList(commonUserId);
	}


	
}