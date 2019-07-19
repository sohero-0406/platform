/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.web;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.aa.entity.Tax;
import com.jeesite.modules.aa.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 税率表Controller
 * @author lvchangwei
 * @version 2019-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/aa/tax")
public class TaxController extends BaseController {

	@Autowired
	private TaxService taxService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Tax get(String id, boolean isNewRecord) {
		return taxService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(Tax tax, Model model) {
		model.addAttribute("tax", tax);
		return "modules/aa/taxList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Tax> listData(Tax tax, HttpServletRequest request, HttpServletResponse response) {
		tax.setPage(new Page<>(request, response));
		Page<Tax> page = taxService.findPage(tax);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(Tax tax, Model model) {
		model.addAttribute("tax", tax);
		return "modules/aa/taxForm";
	}

	/**
	 * 保存税率表
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Tax tax) {
		taxService.save(tax);
		return renderResult(Global.TRUE, text("保存税率表成功！"));
	}
	
	/**
	 * 删除税率表
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Tax tax) {
		taxService.delete(tax);
		return renderResult(Global.TRUE, text("删除税率表成功！"));
	}
	
}