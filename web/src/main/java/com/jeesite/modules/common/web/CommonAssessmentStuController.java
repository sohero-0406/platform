/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import com.jeesite.common.utils.excel.ExcelExport;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.CommonAssessmentStu;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.service.CommonAssessmentStuService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 考核学生表Controller
 * @author mayuhu
 * @version 2019-08-05
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonAssessmentStu")
public class CommonAssessmentStuController extends BaseController {

	@Autowired
	private CommonAssessmentStuService commonAssessmentStuService;

	/**
	 * 加载分页考生数据
	 * @param commonAssessmentStu
	 * @return
	 */
	@ApiOperation(value = "加载分页考生数据")
	@ApiImplicitParam(name = "commonAssessmentStu", value = "查询考生的条件对象", required = true, dataType="CommonAssessmentStu")
	@Log(operationName = "加载分页考生数据")
	@RequestMapping(value = "searchStuScore")
	@ResponseBody
	public CommonResult searchStuScore(CommonAssessmentStu commonAssessmentStu) {
		return commonAssessmentStuService.findPageByCondition(commonAssessmentStu);
	}
//	@ApiOperation(value = "加载分页考生数据")
//	//@ApiImplicitParam(name = "commonAssessmentStu", value = "查询考生的条件对象", required = true, dataType="CommonAssessmentStu")
//	@Log(operationName = "加载分页考生数据")
//	@RequestMapping(value = "searchStuScore")
//	@ResponseBody
//	public CommonResult searchStuScore(@RequestBody @ApiParam(name="commonAssessmentStu 查询考生的条件对象",
//												value="{\n\"loginName\":String, // 登录名" +
//														"\n\"trueName\":String, // 姓名" +
//														"\n\"schoolName\":String, // 学校" +
//														"\n\"assessmentDate\":String, // 考核日期" +
//														"\n\"dataStatus\":String, // 是否通过" +
//														"\n\"assessmentName\":String, // 考核名称" +
//														"}", required = true)
//												   CommonAssessmentStu commonAssessmentStu){
//		return commonAssessmentStuService.findPageByCondition(commonAssessmentStu);
//	}

	/**
	 * 导出成绩excel
	 * @param response
	 * @param commonAssessmentStu
	 */
	@ApiOperation(value = "导出成绩excel")
	@ApiImplicitParam(name = "commonAssessmentStu", value = "查询考生的条件对象", required = true, dataType="CommonAssessmentStu")
	@Log(operationName = "导出成绩excel")
	@RequestMapping(value = "exportStuScore")
	public void exportStuScore(HttpServletResponse response,CommonAssessmentStu commonAssessmentStu){
		ExcelExport ee = commonAssessmentStuService.exportStuScore(commonAssessmentStu);
		ee.write(response, "testx.xlsx").close();
	}

	@ApiOperation(value = "根据id返回一个考生对象")
	@ApiImplicitParam(name = "serverExamStuId", value = "一个考生的id", required = true, dataType="String")
	@Log(operationName = "根据id返回一个考生对象", operationType = Log.OPERA_TYPE_SEL)
	@RequestMapping(value = "loadOneExamStu")
	@ResponseBody
	public CommonResult loadOneExamStu(String serverExamStuId){

		return commonAssessmentStuService.loadOneExamStu(serverExamStuId);
	}


	/**
	 * 根据登录人加载考核名称下的考核日期
	 * @param commonUserId
	 * @param assessmentName
	 * @return
	 */
	@ApiOperation(value = "根据登录人加载考核名称下的考核日期")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "commonUserId", value = "用户id", required = true, dataType="String"),
		@ApiImplicitParam(name = "assessmentName", value = "考核名称", required = true, dataType="String")
	})
	@Log(operationName = "根据登录人加载考核名称下的考核日期", operationType = Log.OPERA_TYPE_SEL)
	@RequestMapping(value = "loadAssessmentDateList")
	@ResponseBody
	public CommonResult loadAssessmentDateList(String commonUserId, String assessmentName){

		return commonAssessmentStuService.loadAssessmentDateList(commonUserId, assessmentName);
	}

	/**
	 * 根据登录人加载考核名称下的考核日期下的考核时间
	 * @param commonUserId
	 * @param assessmentName
	 * @param assessmentDate
	 * @return
	 */
	@ApiOperation(value = "根据登录人加载考核名称下的考核日期下的考核时间")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commonUserId", value = "用户id", required = true, dataType="String"),
			@ApiImplicitParam(name = "assessmentName", value = "考核名称", required = true, dataType="String"),
			@ApiImplicitParam(name = "assessmentDate", value = "考核日期", required = true, dataType="String")
	})
	@Log(operationName = "根据登录人加载考核名称下的考核日期下的考核时间", operationType = Log.OPERA_TYPE_SEL)
	@RequestMapping(value = "loadAssessmentTimeList")
	@ResponseBody
	public CommonResult loadAssessmentTimeList(String commonUserId, String assessmentName, String assessmentDate){

		return commonAssessmentStuService.loadAssessmentTimeList(commonUserId, assessmentName, assessmentDate);
	}
	
}