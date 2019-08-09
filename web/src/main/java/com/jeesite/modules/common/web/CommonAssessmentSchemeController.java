/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.io.FileUtils;
import com.jeesite.modules.common.entity.CommonAssessment;
import com.jeesite.modules.common.entity.CommonBasicScheme;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.util.FilePathUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.entity.CommonAssessmentScheme;
import com.jeesite.modules.common.service.CommonAssessmentSchemeService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 考核方案表Controller
 * @author mayuhu
 * @version 2019-08-05
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonAssessmentScheme")
public class CommonAssessmentSchemeController extends BaseController {

	@Autowired
	private CommonAssessmentSchemeService commonAssessmentSchemeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CommonAssessmentScheme get(String id, boolean isNewRecord) {
		return commonAssessmentSchemeService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(CommonAssessmentScheme commonAssessmentScheme, Model model) {
		model.addAttribute("commonAssessmentScheme", commonAssessmentScheme);
		return "modules/common/commonAssessmentSchemeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CommonAssessmentScheme> listData(CommonAssessmentScheme commonAssessmentScheme, HttpServletRequest request, HttpServletResponse response) {
		commonAssessmentScheme.setPage(new Page<>(request, response));
		Page<CommonAssessmentScheme> page = commonAssessmentSchemeService.findPage(commonAssessmentScheme);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(CommonAssessmentScheme commonAssessmentScheme, Model model) {
		model.addAttribute("commonAssessmentScheme", commonAssessmentScheme);
		return "modules/common/commonAssessmentSchemeForm";
	}

	/**
	 * 保存考核方案表
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CommonAssessmentScheme commonAssessmentScheme) {
		commonAssessmentSchemeService.save(commonAssessmentScheme);
		return renderResult(Global.TRUE, text("保存考核方案表成功！"));
	}
	
	/**
	 * 删除考核方案表
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CommonAssessmentScheme commonAssessmentScheme) {
		commonAssessmentSchemeService.delete(commonAssessmentScheme);
		return renderResult(Global.TRUE, text("删除考核方案表成功！"));
	}


	@RequestMapping(value = "listCommonAssessmentScheme")
	@ResponseBody
	public CommonResult listCommonAssessmentScheme(CommonAssessmentScheme commonAssessmentScheme) {
		Page<CommonAssessmentScheme> page = commonAssessmentSchemeService.findPage(commonAssessmentScheme);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, page);
	}

	@RequestMapping(value = "listCommonAssessmentSchemeOnly")
	@ResponseBody
	public CommonResult listCommonAssessmentSchemeOnly(CommonAssessmentScheme commonAssessmentScheme) {
		List<CommonAssessmentScheme> list = commonAssessmentSchemeService.findList(commonAssessmentScheme);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, list);
	}


	@RequestMapping(value = "saveCommonAssessmentScheme")
	@ResponseBody
	public CommonResult saveCommonAssessment(CommonAssessmentScheme commonAssessmentScheme){
		return commonAssessmentSchemeService.saveCommonAssessmentScheme(commonAssessmentScheme);

		//return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}


	@RequestMapping(value = "loadCommonAssessmentScheme")
	@ResponseBody
	public CommonResult loadCommonAssessment(String id){
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, commonAssessmentSchemeService.get(id));
	}

	@RequestMapping(value = "deleteCommonAssessmentScheme")
	@ResponseBody
	public CommonResult deleteCommonAssessment(CommonAssessmentScheme commonAssessmentScheme){
		return commonAssessmentSchemeService.deleteCommonAssessmentScheme(commonAssessmentScheme);
		// return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	@RequestMapping(value = "updateCommonAssessmentSchemeStatus")
	@ResponseBody
	public CommonResult updateCommonAssessmentSchemeStatus(CommonAssessmentScheme commonAssessmentScheme){
		return commonAssessmentSchemeService.updateCommonAssessmentSchemeStatus(commonAssessmentScheme);
		//return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	@RequestMapping(value = "uploadSchemeTable")
	@ResponseBody
	public CommonResult uploadSchemeTable(MultipartFile file) throws IOException {

//		System.out.println(file.getContentType());
		String end = FileUtils.getFileExtension(file.getOriginalFilename());
		if(!end.equals("xls")&&end.equals("xlsx")){
			return new CommonResult(CodeConstant.WRONG_FILE, "文件名后缀不正确!");
		}
//		System.out.println(end);
		File x = new File(FilePathUtil.getFileSavePath("schemeTable")+"schemeTable"+System.currentTimeMillis()+"."+end);
		file.transferTo(x);
		//FilePathUtil.getFileSavePath();
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, "上传成功", x.getName());
	}
	
}