/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;


import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.vo.*;
import io.swagger.annotations.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.service.CommonDocumentService;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 资料表Controller
 * @author jiangyanfei
 * @version 2020-06-16
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonDocument")
@Api(tags = "【教师端】资料下载")
public class CommonDocumentController extends BaseController {

	@Autowired
	private CommonDocumentService commonDocumentService;


	@ApiOperation(value = "选择考核下拉")
	@Log(operationName = "选择考核下拉")
	@RequestMapping(value = "loadAssessList")
	@ResponseBody
	public CommonResult<List<ItemVO>> loadAssessList() {
		return commonDocumentService.loadAssessItemList(null);
	}

	@ApiOperation(value = "选择考核项下拉列表")
	@Log(operationName = "选择考核项下拉列表")
	@RequestMapping(value = "loadAssessItemListByAssessKey")
	@ResponseBody
	public CommonResult<List<ItemVO>> loadAssessItemListByAssessKey(@NotBlank(message = "考核项下拉入参不能为空") @RequestParam(defaultValue = "1") String assessKey) {
		return commonDocumentService.loadAssessItemList(assessKey);
	}


	@ApiOperation(value = "资料筛选")
	@Log(operationName = "资料筛选")
	@RequestMapping(value = "loadDocs")
	@ResponseBody
	public CommonResult<Page<DocumentRespVO>> loadDocs(@Validated DocumentSearchReqVO documentSearchReqVO) {
		return commonDocumentService.loadDocs(documentSearchReqVO);
	}

	@ApiOperation(value = "资料编辑")
	@Log(operationName = "资料编辑")
	@RequestMapping(value = "updateDoc")
	@ResponseBody
	public CommonResult<T> updateDoc(@Validated DocumentUpdateVO documentUpdateVO) {
		return commonDocumentService.updateDoc(documentUpdateVO);
	}

	@ApiOperation(value = "资料加载")
	@Log(operationName = "资料加载")
	@RequestMapping(value = "loadDoc")
	@ResponseBody
	public CommonResult<DocumentRespVO> loadDoc(@NotBlank(message = "资料记录标识不能为空") String id) {
		return commonDocumentService.loadDoc(id);
	}
}