/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.constant.CodeConstant;
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



	@RequestMapping(value = "listAssessment")
	@ResponseBody
	public CommonResult listAssessment(CommonAssessment commonAssessment) {
		return commonAssessmentService.findPageCommonAssessment(commonAssessment);
		//return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, page);
	}


	@RequestMapping(value = "saveCommonAssessment")
	@ResponseBody
	public CommonResult saveCommonAssessment(CommonAssessment commonAssessment, String userConfig){
		return commonAssessmentService.save(commonAssessment, userConfig);

		//return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	@RequestMapping(value = "loadCommonAssessment")
	@ResponseBody
	public CommonResult loadCommonAssessment(String id){
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, commonAssessmentService.get(id));
	}

	@RequestMapping(value = "deleteCommonAssessment")
	@ResponseBody
	public CommonResult deleteCommonAssessment(String json){
		return commonAssessmentService.deleteCommonAssessment(json);
		//return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	/**
	 *
	 * @param commonAssessment 要更新的对象
	 * @param file 上传的评分表文件
	 * @return
	 */
	@RequestMapping(value = "updateCommonAssessmentStatus")
	@ResponseBody
	public CommonResult updateCommonAssessmentStatus(CommonAssessment commonAssessment, MultipartFile file) throws Exception {

		return commonAssessmentService.updateCommonAssessmentStatus(commonAssessment, file);
		//return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	@RequestMapping(value = "uploadScores")
	@ResponseBody
	public CommonResult uploadScores(String scoreInfo){

		return commonAssessmentService.parseScoreInfo(scoreInfo);
	}

	
}