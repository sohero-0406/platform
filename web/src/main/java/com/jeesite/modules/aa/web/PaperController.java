/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.common.entity.CommonResult;
import org.apache.ibatis.annotations.Param;
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
import com.jeesite.modules.aa.entity.Paper;
import com.jeesite.modules.aa.service.PaperService;

import java.util.ArrayList;
import java.util.List;

/**
 * 试卷Controller
 * @author lvchangwei
 * @version 2019-07-16
 */
@Controller
@RequestMapping(value = "${adminPath}/aa/paper")
public class PaperController extends BaseController {

	@Autowired
	private PaperService paperService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Paper get(String id, boolean isNewRecord) {
		return paperService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(Paper paper, Model model) {
		model.addAttribute("paper", paper);
		return "modules/aa/paperList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Paper> listData(Paper paper, HttpServletRequest request, HttpServletResponse response) {
		paper.setPage(new Page<>(request, response));
		Page<Paper> page = paperService.findPage(paper);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(Paper paper, Model model) {
		model.addAttribute("paper", paper);
		return "modules/aa/paperForm";
	}

	/**
	 * 保存试卷
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Paper paper) {
		paperService.save(paper);
		return renderResult(Global.TRUE, text("保存试卷成功！"));
	}
	
	/**
	 * 删除试卷
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Paper paper) {
		paperService.delete(paper);
		return renderResult(Global.TRUE, text("删除试卷成功！"));
	}

	/**
	 * 查询试卷列表
	 */
	@RequestMapping(value = "getPaperList")
	@ResponseBody
	public CommonResult getPaperList() {
		CommonResult comRes = new CommonResult();
		List<Paper> paperList = paperService.getPaperList();
		comRes.setData(paperList);
		return comRes;
	}


	/**
	 * 删除试卷
	 */
	@RequestMapping(value = "deletePaper")
	@ResponseBody
	public CommonResult deletePaper(Paper paper) {
		paperService.delete(paper);
		return new CommonResult();
	}

	
}