/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jeesite.modules.aa.entity.CalculateKm;
import com.jeesite.modules.aa.service.CalculateKmService;

/**
 * 公里数估值法Controller
 * @author chenlitao
 * @version 2019-07-05
 */
@Controller
@RequestMapping(value = "${adminPath}/aa/calculateKm")
public class CalculateKmController extends BaseController {

	@Autowired
	private CalculateKmService calculateKmService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CalculateKm get(String id, boolean isNewRecord) {
		return calculateKmService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(CalculateKm calculateKm, Model model) {
		model.addAttribute("calculateKm", calculateKm);
		return "modules/aa/calculateKmList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CalculateKm> listData(CalculateKm calculateKm, HttpServletRequest request, HttpServletResponse response) {
		calculateKm.setPage(new Page<>(request, response));
		Page<CalculateKm> page = calculateKmService.findPage(calculateKm);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(CalculateKm calculateKm, Model model) {
		model.addAttribute("calculateKm", calculateKm);
		return "modules/aa/calculateKmForm";
	}

	/**
	 * 保存公里数估值法
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CalculateKm calculateKm) {
		calculateKmService.save(calculateKm);
		return renderResult(Global.TRUE, text("保存公里数估值法成功！"));
	}
	
	/**
	 * 删除公里数估值法
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CalculateKm calculateKm) {
		calculateKmService.delete(calculateKm);
		return renderResult(Global.TRUE, text("删除公里数估值法成功！"));
	}
	
}