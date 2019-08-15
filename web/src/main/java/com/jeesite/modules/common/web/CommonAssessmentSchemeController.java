/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.io.FileUtils;
import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.CommonAssessment;
import com.jeesite.modules.common.entity.CommonBasicScheme;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.util.FilePathUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public CommonAssessmentScheme get(String id, boolean isNewRecord) {
//		return commonAssessmentSchemeService.get(id, isNewRecord);
//	}
//
//	/**
//	 * 查询列表
//	 */
//	@RequestMapping(value = {"list", ""})
//	public String list(CommonAssessmentScheme commonAssessmentScheme, Model model) {
//		model.addAttribute("commonAssessmentScheme", commonAssessmentScheme);
//		return "modules/common/commonAssessmentSchemeList";
//	}
//
//	/**
//	 * 查询列表数据
//	 */
//	@RequestMapping(value = "listData")
//	@ResponseBody
//	public Page<CommonAssessmentScheme> listData(CommonAssessmentScheme commonAssessmentScheme, HttpServletRequest request, HttpServletResponse response) {
//		commonAssessmentScheme.setPage(new Page<>(request, response));
//		Page<CommonAssessmentScheme> page = commonAssessmentSchemeService.findPage(commonAssessmentScheme);
//		return page;
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@RequestMapping(value = "form")
//	public String form(CommonAssessmentScheme commonAssessmentScheme, Model model) {
//		model.addAttribute("commonAssessmentScheme", commonAssessmentScheme);
//		return "modules/common/commonAssessmentSchemeForm";
//	}
//
//	/**
//	 * 保存考核方案表
//	 */
//	@PostMapping(value = "save")
//	@ResponseBody
//	public String save(@Validated CommonAssessmentScheme commonAssessmentScheme) {
//		commonAssessmentSchemeService.save(commonAssessmentScheme);
//		return renderResult(Global.TRUE, text("保存考核方案表成功！"));
//	}
//
//	/**
//	 * 删除考核方案表
//	 */
//	@RequestMapping(value = "delete")
//	@ResponseBody
//	public String delete(CommonAssessmentScheme commonAssessmentScheme) {
//		commonAssessmentSchemeService.delete(commonAssessmentScheme);
//		return renderResult(Global.TRUE, text("删除考核方案表成功！"));
//	}

	/**
	 * 加载分页考核方案数据
	 * @param commonAssessmentScheme
	 * @return
	 */
	@ApiOperation(value = "加载分页考核方案数据")
	@ApiImplicitParam(name = "commonAssessmentScheme", value = "查询方案的条件对象", required = true, dataType="CommonAssessmentScheme")
	@Log(operationName = "加载分页考核方案数据")
	@RequestMapping(value = "listCommonAssessmentScheme")
	@ResponseBody
	public CommonResult listCommonAssessmentScheme(CommonAssessmentScheme commonAssessmentScheme) {
		Page<CommonAssessmentScheme> page = commonAssessmentSchemeService.findPage(commonAssessmentScheme);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, page);
	}

	/**
	 * 加载列表考核方案数据
	 * @param commonAssessmentScheme
	 * @return
	 */
	@ApiOperation(value = "加载列表考核方案数据")
	@ApiImplicitParam(name = "commonAssessmentScheme", value = "查询方案的条件对象", required = true, dataType="CommonAssessmentScheme")
	@Log(operationName = "加载列表考核方案数据")
	@RequestMapping(value = "listCommonAssessmentSchemeOnly")
	@ResponseBody
	public CommonResult listCommonAssessmentSchemeOnly(CommonAssessmentScheme commonAssessmentScheme) {
		commonAssessmentScheme.setDataStatus("0");
		List<CommonAssessmentScheme> list = commonAssessmentSchemeService.findList(commonAssessmentScheme);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, list);
	}

	/**
	 * 保存、更新考核方案
	 * @param commonAssessmentScheme
	 * @return
	 */
	@ApiOperation(value = "保存、更新考核方案")
	@ApiImplicitParam(name = "commonAssessmentScheme", value = "保存或者更新的对象", required = true, dataType="CommonAssessmentScheme")
	@Log(operationName = "保存、更新考核方案", operationType = Log.OPERA_TYPE_ADD_OR_UPD)
	@RequestMapping(value = "saveCommonAssessmentScheme")
	@ResponseBody
	public CommonResult saveCommonAssessment(CommonAssessmentScheme commonAssessmentScheme){
		return commonAssessmentSchemeService.saveCommonAssessmentScheme(commonAssessmentScheme);
	}

	/**
	 * 根据id加载考核方案
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据id加载考核方案")
	@ApiImplicitParam(name = "id", value = "方案的id", required = true, dataType="String")
	@Log(operationName = "根据id加载考核方案")
	@RequestMapping(value = "loadCommonAssessmentScheme")
	@ResponseBody
	public CommonResult loadCommonAssessmentScheme(String id){
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, commonAssessmentSchemeService.get(id));
	}

	/**
	 * 删除考核方案
	 * @param json
	 * @return
	 */
	@ApiOperation(value = "删除考核方案")
	@ApiImplicitParam(name = "json", value = "删除方案的json数据", required = true, dataType="String")
	@Log(operationName = "删除考核方案", operationType = Log.OPERA_TYPE_DEL)
	@RequestMapping(value = "deleteCommonAssessmentScheme")
	@ResponseBody
	public CommonResult deleteCommonAssessment(String json){
		return commonAssessmentSchemeService.deleteCommonAssessmentScheme(json);
	}

	/**
	 * 更新考核方案状态
	 * @param commonAssessmentScheme
	 * @return
	 */
	@ApiOperation(value = "更新考核方案状态")
	@ApiImplicitParam(name = "commonAssessmentScheme", value = "要更新状态的对象", required = true, dataType="CommonAssessmentScheme")
	@Log(operationName = "更新考核方案状态", operationType = Log.OPERA_TYPE_UPD)
	@RequestMapping(value = "updateCommonAssessmentSchemeStatus")
	@ResponseBody
	public CommonResult updateCommonAssessmentSchemeStatus(CommonAssessmentScheme commonAssessmentScheme){
		return commonAssessmentSchemeService.updateCommonAssessmentSchemeStatus(commonAssessmentScheme);
	}

	/**
	 * 上传评分表样例
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@ApiOperation(value = "上传评分表样例")
	@ApiImplicitParam(name = "file", value = "评分样例文件", required = true, dataType="MultipartFile")
	@Log(operationName = "上传评分表样例", operationType = Log.OPERA_TYPE_OTHER)
	@RequestMapping(value = "uploadSchemeTable")
	@ResponseBody
	public CommonResult uploadSchemeTable(MultipartFile file) throws IOException {
		String end = FileUtils.getFileExtension(file.getOriginalFilename());
		if(!end.equals("xls")&&end.equals("xlsx")){
			return new CommonResult(CodeConstant.WRONG_FILE, "文件名后缀不正确!");
		}
		File x = new File(FilePathUtil.getFileSavePath("schemeTable")+"schemeTable"+System.currentTimeMillis()+"."+end);
		file.transferTo(x);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, "上传成功", x.getName());
	}



}