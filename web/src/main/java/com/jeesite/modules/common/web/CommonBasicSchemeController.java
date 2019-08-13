/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.constant.CodeConstant;
import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.CommonAssessmentScheme;
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
import com.jeesite.modules.common.entity.CommonBasicScheme;
import com.jeesite.modules.common.service.CommonBasicSchemeService;

import java.util.List;

/**
 * 方案基本表，目前不做管理使用，只作为基础数据调用，后期能会做出管理界面Controller
 * @author mayuhu
 * @version 2019-08-05
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonBasicScheme")
public class CommonBasicSchemeController extends BaseController {

	@Autowired
	private CommonBasicSchemeService commonBasicSchemeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CommonBasicScheme get(String id, boolean isNewRecord) {
		return commonBasicSchemeService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(CommonBasicScheme commonBasicScheme, Model model) {
		model.addAttribute("commonBasicScheme", commonBasicScheme);
		return "modules/common/commonBasicSchemeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CommonBasicScheme> listData(CommonBasicScheme commonBasicScheme, HttpServletRequest request, HttpServletResponse response) {
		commonBasicScheme.setPage(new Page<>(request, response));
		Page<CommonBasicScheme> page = commonBasicSchemeService.findPage(commonBasicScheme);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(CommonBasicScheme commonBasicScheme, Model model) {
		model.addAttribute("commonBasicScheme", commonBasicScheme);
		return "modules/common/commonBasicSchemeForm";
	}

	/**
	 * 保存方案基本表，目前不做管理使用，只作为基础数据调用，后期能会做出管理界面
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CommonBasicScheme commonBasicScheme) {
		commonBasicSchemeService.save(commonBasicScheme);
		return renderResult(Global.TRUE, text("保存方案基本表，目前不做管理使用，只作为基础数据调用，后期能会做出管理界面成功！"));
	}
	
	/**
	 * 删除方案基本表，目前不做管理使用，只作为基础数据调用，后期能会做出管理界面
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CommonBasicScheme commonBasicScheme) {
		commonBasicSchemeService.delete(commonBasicScheme);
		return renderResult(Global.TRUE, text("删除方案基本表，目前不做管理使用，只作为基础数据调用，后期能会做出管理界面成功！"));
	}

	/**
	 * 加载分页基本方案
	 * @param commonBasicScheme
	 * @return
	 */
	@Log(operationName = "加载分页基本方案")
	@RequestMapping(value = "listCommonBasicScheme")
	@ResponseBody
	public CommonResult listCommonBasicScheme(CommonBasicScheme commonBasicScheme) {
		Page<CommonBasicScheme> page = commonBasicSchemeService.findPage(commonBasicScheme);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, page);
	}

	/**
	 * 加载列表基本方案
	 * @param commonBasicScheme
	 * @return
	 */
	@Log(operationName = "加载列表基本方案")
	@RequestMapping(value = "listCommonBasicSchemeOnly")
	@ResponseBody
	public CommonResult listCommonBasicSchemeOnly(CommonBasicScheme commonBasicScheme) {
		commonBasicScheme.setStatus("0");
		List<CommonBasicScheme> list = commonBasicSchemeService.findList(commonBasicScheme);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, list);
	}

	/**
	 * 保存、更新基本方案
	 * @param commonBasicScheme
	 * @return
	 */
	@Log(operationName = "保存、更新基本方案", operationType = Log.OPERA_TYPE_ADD_OR_UPD)
	@RequestMapping(value = "saveCommonBasicScheme")
	@ResponseBody
	public CommonResult saveCommonBasicScheme(CommonBasicScheme commonBasicScheme){
		commonBasicSchemeService.save(commonBasicScheme);

		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	/**
	 * 根据id加载基本方案
	 * @param id
	 * @return
	 */
	@Log(operationName = "根据id加载基本方案")
	@RequestMapping(value = "loadCommonBasicScheme")
	@ResponseBody
	public CommonResult loadCommonBasicScheme(String id){
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, commonBasicSchemeService.get(id));
	}

	/**
	 * 删除基本方案
	 * @param commonBasicScheme
	 * @return
	 */
	@Log(operationName = "删除基本方案", operationType = Log.OPERA_TYPE_DEL)
	@RequestMapping(value = "deleteCommonBasicScheme")
	@ResponseBody
	public CommonResult deleteCommonBasicScheme(CommonBasicScheme commonBasicScheme){
		commonBasicSchemeService.delete(commonBasicScheme);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	/**
	 * 根据id删除基本方案
	 * @param id
	 * @return
	 */
	@Log(operationName = "根据id删除基本方案", operationType = Log.OPERA_TYPE_DEL)
	@RequestMapping(value = "deleteCommonBasicSchemeById")
	@ResponseBody
	public CommonResult deleteCommonBasicSchemeById(String id){
		commonBasicSchemeService.deleteById(id);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	/**
	 * 根据json信息删除
	 * @param json
	 * @return
	 */
	@Log(operationName = "根据json信息删除", operationType = Log.OPERA_TYPE_DEL)
	@RequestMapping(value = "deleteCommonBasicSchemeByJson")
	@ResponseBody
	public CommonResult deleteCommonBasicSchemeByJson(String json){
		commonBasicSchemeService.deleteByJson(json);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}

	/**
	 * 更新状态
	 * @param commonBasicScheme
	 * @return
	 */
	@Log(operationName = "更新基本方案状态", operationType = Log.OPERA_TYPE_UPD)
	@RequestMapping(value = "updateStatus")
	@ResponseBody
	public CommonResult updateStatus(CommonBasicScheme commonBasicScheme){
		commonBasicSchemeService.updateStatus(commonBasicScheme);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
	}
	
}