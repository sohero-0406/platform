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
import com.jeesite.modules.aa.entity.PictureType;
import com.jeesite.modules.aa.service.PictureTypeService;

/**
 * 图片类型表Controller
 * @author chenlitao
 * @version 2019-07-01
 */
@Controller
@RequestMapping(value = "${adminPath}/aa/pictureType")
public class PictureTypeController extends BaseController {

	@Autowired
	private PictureTypeService pictureTypeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public PictureType get(String id, boolean isNewRecord) {
		return pictureTypeService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(PictureType pictureType, Model model) {
		model.addAttribute("pictureType", pictureType);
		return "modules/aa/pictureTypeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<PictureType> listData(PictureType pictureType, HttpServletRequest request, HttpServletResponse response) {
		pictureType.setPage(new Page<>(request, response));
		Page<PictureType> page = pictureTypeService.findPage(pictureType);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(PictureType pictureType, Model model) {
		model.addAttribute("pictureType", pictureType);
		return "modules/aa/pictureTypeForm";
	}

	/**
	 * 保存图片类型表
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated PictureType pictureType) {
		pictureTypeService.save(pictureType);
		return renderResult(Global.TRUE, text("保存图片类型表成功！"));
	}
	
	/**
	 * 删除图片类型表
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(PictureType pictureType) {
		pictureTypeService.delete(pictureType);
		return renderResult(Global.TRUE, text("删除图片类型表成功！"));
	}
	
}