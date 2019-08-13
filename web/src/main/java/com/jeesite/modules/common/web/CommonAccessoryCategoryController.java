/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.codec.EncodeUtils;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.utils.excel.ExcelImport;
import com.jeesite.modules.common.entity.CommonAccessory;
import com.jeesite.modules.common.entity.CommonAssessment;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.util.FilePathUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import com.jeesite.modules.common.entity.CommonAccessoryCategory;
import com.jeesite.modules.common.service.CommonAccessoryCategoryService;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * 配件分类表Controller
 * @author mayuhu
 * @version 2019-08-12
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonAccessoryCategory")
public class CommonAccessoryCategoryController extends BaseController {

	@Autowired
	private CommonAccessoryCategoryService commonAccessoryCategoryService;
	
	/**
	 * 获取数据
	 */
//	@ModelAttribute
//	public CommonAccessoryCategory get(String id, boolean isNewRecord) {
//		return commonAccessoryCategoryService.get(id, isNewRecord);
//	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(CommonAccessoryCategory commonAccessoryCategory, Model model) {
		model.addAttribute("commonAccessoryCategory", commonAccessoryCategory);
		return "modules/common/commonAccessoryCategoryList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CommonAccessoryCategory> listData(CommonAccessoryCategory commonAccessoryCategory, HttpServletRequest request, HttpServletResponse response) {
		commonAccessoryCategory.setPage(new Page<>(request, response));
		Page<CommonAccessoryCategory> page = commonAccessoryCategoryService.findPage(commonAccessoryCategory);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(CommonAccessoryCategory commonAccessoryCategory, Model model) {
		model.addAttribute("commonAccessoryCategory", commonAccessoryCategory);
		return "modules/common/commonAccessoryCategoryForm";
	}

	/**
	 * 保存配件分类表
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CommonAccessoryCategory commonAccessoryCategory) {
		commonAccessoryCategoryService.save(commonAccessoryCategory);
		return renderResult(Global.TRUE, text("保存配件分类表成功！"));
	}
	
	/**
	 * 删除配件分类表
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CommonAccessoryCategory commonAccessoryCategory) {
		commonAccessoryCategoryService.delete(commonAccessoryCategory);
		return renderResult(Global.TRUE, text("删除配件分类表成功！"));
	}


	@RequestMapping(value = "listCommonAccessoryCategory")
	@ResponseBody
	public CommonResult listCommonAccessoryCategory(CommonAccessoryCategory commonAccessoryCategory){
		return commonAccessoryCategoryService.findPageByCondition(commonAccessoryCategory);
	}

	@RequestMapping(value = "uploadCommonAccessoryAndCategory")
	@ResponseBody
	public CommonResult uploadCommonAccessoryAndCategory(MultipartFile file, CommonAccessoryCategory commonAccessoryCategory) throws Exception {
		ExcelImport ei = new ExcelImport(file, 1, 0);
		List<CommonAccessory> commonAccessoryList = ei.getDataList(CommonAccessory.class);
		return commonAccessoryCategoryService.saveCategoryAndCommonAccessory(commonAccessoryCategory, commonAccessoryList);
	}

	@RequestMapping(value = "deleteCommonAccessoryAndCategory")
	@ResponseBody
	public CommonResult deleteCommonAccessoryAndCategory(CommonAccessoryCategory commonAccessoryCategory) {

		return commonAccessoryCategoryService.deleteCommonAccessoryCategory(commonAccessoryCategory);
	}

	@RequestMapping(value = "saveCommonAccessoryAndCategory")
	@ResponseBody
	public CommonResult saveCommonAccessoryAndCategory(CommonAccessoryCategory commonAccessoryCategory) {

		return commonAccessoryCategoryService.updateCommonAccessoryCategory(commonAccessoryCategory);
	}

	@RequestMapping(value = "downTemplate", produces = "application/octet-stream")
	//@RequestMapping(value = "downTemplate")
    @ResponseBody
	public void downTemplate(HttpServletResponse response){
		File file = new File(FilePathUtil.getFileSavePath("template")+"配件基础信息表.xlsx");

		try {
			FileInputStream fileIn = new FileInputStream(file);
			BufferedInputStream is = new BufferedInputStream(fileIn);
			byte[] fileBytes = new byte[1024];
			response.reset();
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename="+ EncodeUtils.encodeUrl("配件基础信息表.xlsx"));
			// 输出文件流
			ServletOutputStream out = response.getOutputStream();
			int len = -1;
			while ((len = is.read(fileBytes, 0, 1024)) != -1) {
				out.write(fileBytes, 0, len);
			}
			is.close();
			out.close();

			fileIn.close();
		} catch (IOException ex) {
			//log.error(ex.getMessage(), ex);
		}

		//return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}



}