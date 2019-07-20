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
import com.jeesite.modules.aa.entity.PlaceFile;
import com.jeesite.modules.aa.service.PlaceFileService;

/**
 * 归档Controller
 * @author liangtao
 * @version 2019-07-20
 */
@Controller
@RequestMapping(value = "${adminPath}/aa/placeFile")
public class PlaceFileController extends BaseController {

	@Autowired
	private PlaceFileService placeFileService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public PlaceFile get(String id, boolean isNewRecord) {
		return placeFileService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(PlaceFile placeFile, Model model) {
		model.addAttribute("placeFile", placeFile);
		return "modules/aa/placeFileList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<PlaceFile> listData(PlaceFile placeFile, HttpServletRequest request, HttpServletResponse response) {
		placeFile.setPage(new Page<>(request, response));
		Page<PlaceFile> page = placeFileService.findPage(placeFile);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(PlaceFile placeFile, Model model) {
		model.addAttribute("placeFile", placeFile);
		return "modules/aa/placeFileForm";
	}

	/**
	 * 保存归档
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated PlaceFile placeFile) {
		placeFileService.save(placeFile);
		return renderResult(Global.TRUE, text("保存归档成功！"));
	}
	
	/**
	 * 删除归档
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(PlaceFile placeFile) {
		placeFileService.delete(placeFile);
		return renderResult(Global.TRUE, text("删除归档成功！"));
	}
	
}