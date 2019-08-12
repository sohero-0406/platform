/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.utils.excel.ExcelExport;
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
import com.jeesite.modules.common.entity.CommonAssessmentStu;
import com.jeesite.modules.common.service.CommonAssessmentStuService;

/**
 * 考核学生表Controller
 * @author mayuhu
 * @version 2019-08-05
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonAssessmentStu")
public class CommonAssessmentStuController extends BaseController {

	@Autowired
	private CommonAssessmentStuService commonAssessmentStuService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CommonAssessmentStu get(String id, boolean isNewRecord) {
		return commonAssessmentStuService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(CommonAssessmentStu commonAssessmentStu, Model model) {
		model.addAttribute("commonAssessmentStu", commonAssessmentStu);
		return "modules/common/commonAssessmentStuList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CommonAssessmentStu> listData(CommonAssessmentStu commonAssessmentStu, HttpServletRequest request, HttpServletResponse response) {
		commonAssessmentStu.setPage(new Page<>(request, response));
		Page<CommonAssessmentStu> page = commonAssessmentStuService.findPage(commonAssessmentStu);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(CommonAssessmentStu commonAssessmentStu, Model model) {
		model.addAttribute("commonAssessmentStu", commonAssessmentStu);
		return "modules/common/commonAssessmentStuForm";
	}

	/**
	 * 保存考核学生表
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CommonAssessmentStu commonAssessmentStu) {
		commonAssessmentStuService.save(commonAssessmentStu);
		return renderResult(Global.TRUE, text("保存考核学生表成功！"));
	}
	
	/**
	 * 删除考核学生表
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CommonAssessmentStu commonAssessmentStu) {
		commonAssessmentStuService.delete(commonAssessmentStu);
		return renderResult(Global.TRUE, text("删除考核学生表成功！"));
	}


	@RequestMapping(value = "searchStuScore")
	@ResponseBody
	public CommonResult searchStuScore(CommonAssessmentStu commonAssessmentStu){
		return commonAssessmentStuService.findPageByCondition(commonAssessmentStu);
	}

	@RequestMapping(value = "exportStuScore")
	public void exportStuScore(HttpServletResponse response,CommonAssessmentStu commonAssessmentStu){
		ExcelExport ee = commonAssessmentStuService.exportStuScore(commonAssessmentStu);
		ee.write(response, "testx.xlsx").close();
	}
	
}