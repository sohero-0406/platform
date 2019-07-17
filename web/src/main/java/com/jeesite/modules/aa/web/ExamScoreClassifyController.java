/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jeesite.modules.aa.entity.ExamScoreClassify;
import com.jeesite.modules.aa.service.ExamScoreClassifyService;

/**
 * 考试评分分类总分数Controller
 * @author liangtao
 * @version 2019-07-16
 */
@Controller
@RequestMapping(value = "${adminPath}/aa/examScoreClassify")
public class ExamScoreClassifyController extends BaseController {

	@Autowired
	private ExamScoreClassifyService examScoreClassifyService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ExamScoreClassify get(String id, boolean isNewRecord) {
		return examScoreClassifyService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(ExamScoreClassify examScoreClassify, Model model) {
		model.addAttribute("examScoreClassify", examScoreClassify);
		return "modules/aa/examScoreClassifyList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ExamScoreClassify> listData(ExamScoreClassify examScoreClassify, HttpServletRequest request, HttpServletResponse response) {
		examScoreClassify.setPage(new Page<>(request, response));
		Page<ExamScoreClassify> page = examScoreClassifyService.findPage(examScoreClassify);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(ExamScoreClassify examScoreClassify, Model model) {
		model.addAttribute("examScoreClassify", examScoreClassify);
		return "modules/aa/examScoreClassifyForm";
	}

	/**
	 * 保存考试评分分类总分数
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ExamScoreClassify examScoreClassify) {
		examScoreClassifyService.save(examScoreClassify);
		return renderResult(Global.TRUE, text("保存考试评分分类总分数成功！"));
	}
	
	/**
	 * 删除考试评分分类总分数
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ExamScoreClassify examScoreClassify) {
		examScoreClassifyService.delete(examScoreClassify);
		return renderResult(Global.TRUE, text("删除考试评分分类总分数成功！"));
	}




}