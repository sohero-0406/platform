package com.jeesite.modules.common.web;

import com.google.common.collect.Lists;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.utils.excel.ExcelExport;
import com.jeesite.common.utils.excel.annotation.ExcelField;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.CommonAssessment;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.entity.UserCondition;
import com.jeesite.modules.common.service.CommonAssessmentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 考核表Controller
 * @author mayuhu
 * @version 2019-08-05
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonAssessment")
public class CommonAssessmentController extends BaseController {

	@Autowired
	private CommonAssessmentService commonAssessmentService;

	/**
	 * 保存、更新考核
	 * @param commonAssessment 1
	 * @param userConfig 1
	 * @return 1
	 */
	@ApiOperation(value = "保存、更新考核")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commonAssessment", value = "要保存的考核对象", required = true, dataType="CommonAssessment"),
			@ApiImplicitParam(name = "userConfig", value = "前台发来的用户列表json数据", required = true, dataType="String")
	})
	@Log(operationName = "保存、更新考核", operationType = Log.OPERA_TYPE_ADD_OR_UPD)
	@RequestMapping(value = "saveCommonAssessment")
	@ResponseBody
	public CommonResult saveCommonAssessment(CommonAssessment commonAssessment, String userConfig){
		return commonAssessmentService.save(commonAssessment, userConfig);
	}

	/**
	 * 加载考核的分页数据
	 * @param commonAssessment 1
	 * @return 1
	 */
	@ApiOperation(value = "加载考核的分页数据")
	@ApiImplicitParam(name = "commonAssessment", value = "查询的考核条件对象", required = true, dataType="CommonAssessment")
	@Log(operationName = "加载考核的分页数据")
	@RequestMapping(value = "listAssessment")
	@ResponseBody
	public CommonResult listAssessment(CommonAssessment commonAssessment) {
		return commonAssessmentService.findPageCommonAssessment(commonAssessment);
	}

	/**
	 * 根据id加载考核
	 * @param id 1
	 * @return 1
	 */
	@ApiOperation(value = "根据id加载考核")
	@ApiImplicitParam(name = "id", value = "考核的id", required = true, dataType="String")
	@Log(operationName = "根据id加载考核")
	@RequestMapping(value = "loadCommonAssessment")
	@ResponseBody
	public CommonResult loadCommonAssessment(String id){
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, commonAssessmentService.loadOneAssessment(id));
	}

	/*
	 * 删除考核
	 * @param json
	 * @return
	 */
	@ApiOperation(value = "删除考核")
	@ApiImplicitParam(name = "json", value = "要删除的考核的json数据", required = true, dataType="String")
	@ApiResponse(code = 200, message = "哈哈说得好")
	@Log(operationName = "删除考核", operationType = Log.OPERA_TYPE_DEL)
	@RequestMapping(value = "deleteCommonAssessment")
	@ResponseBody
	public CommonResult deleteCommonAssessment(String json){
		return commonAssessmentService.deleteCommonAssessment(json);
	}

	/**
	 * 更新考核状态（包括上传主观评分表）
	 * @param commonAssessment 要更新的对象
	 * @param file 上传的评分表文件
	 * @return 1
	 */
	@ApiOperation(value = "更新考核状态")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commonAssessment", value = "要更新的考核对象", required = true, dataType="CommonAssessment"),
			@ApiImplicitParam(name = "file", value = "上传的评分结果文件", dataType="MultipartFile")
	})
	@Log(operationName = "更新考核状态", operationType = Log.OPERA_TYPE_UPD)
	@RequestMapping(value = "updateCommonAssessmentStatus")
	@ResponseBody
	public CommonResult updateCommonAssessmentStatus(CommonAssessment commonAssessment, MultipartFile file) throws Exception {

		return commonAssessmentService.updateCommonAssessmentStatus(commonAssessment, file);
	}

	/**
	 * 上传客观评分
	 * @param scoreInfo 1
	 * @return 1
	 */
	@ApiOperation(value = "上传客观评分")
	@ApiImplicitParam(name = "scoreInfo", value = "教师端上传来的分数json数据", required = true, dataType="String")
	@Log(operationName = "上传客观评分", operationType = Log.OPERA_TYPE_UPD)
	@RequestMapping(value = "uploadScores")
	@ResponseBody
	public CommonResult uploadScores(String scoreInfo){

		return commonAssessmentService.parseScoreInfo(scoreInfo);
	}

	@ApiOperation(value = "H5上传所有分数")
	@ApiImplicitParam(name = "scoreInfo", value = "教师端上传来的分数json数据", required = true, dataType="String")
	@Log(operationName = "H5上传所有分数", operationType = Log.OPERA_TYPE_UPD)
	@RequestMapping(value = "uploadScoresAll")
	@ResponseBody
	public CommonResult uploadScoresAll(String scoreInfo){

		return commonAssessmentService.parseScoreInfoAll(scoreInfo);
	}

	@ApiOperation(value = "根据项目名称上传客观评分")
	@ApiImplicitParam(name = "scoreInfo", value = "教师端上传来的分数json数据", required = true, dataType="String")
	@Log(operationName = "根据项目名称上传客观评分", operationType = Log.OPERA_TYPE_UPD)
	@RequestMapping(value = "uploadScoresByProjectName")
	@ResponseBody
	public CommonResult uploadScoresByProjectName(String scoreInfo){
		return commonAssessmentService.parseScoreInfoByProjectName(scoreInfo);
	}

	/**
	 * 根据登录人加载考核名称
	 * @param commonUserId 1
	 * @return 1
	 */
	@ApiOperation(value = "根据登录人加载考核名称")
	@ApiImplicitParam(name = "commonUserId", value = "用户id", required = true, dataType="String")
	@Log(operationName = "根据登录人加载考核名称", operationType = Log.OPERA_TYPE_SEL)
	@RequestMapping(value = "loadAssessmentNameList")
	@ResponseBody
	public CommonResult loadAssessmentNameList(String commonUserId){

		return commonAssessmentService.loadAssessmentNameList(commonUserId);
	}

	@ApiOperation(value = "根据登录人加载考核名称")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commonUserId", value = "用户id", required = true, dataType="String"),
			@ApiImplicitParam(name = "softwareId", value = "软件id", required = true, dataType="String")
	})
	@Log(operationName = "根据登录人加载考核名称")
	@RequestMapping(value = "loadAssessmentNameListBySoftwareId")
	@ResponseBody
	public CommonResult<List<String>> loadAssessmentNameListBySoftwareId(String commonUserId, String softwareId){

		return commonAssessmentService.loadAssessmentNameList(commonUserId, softwareId);
	}


	@ApiOperation(value = "根据登录人加载项目名称")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commonUserId", value = "用户id", required = true, dataType="String"),
			@ApiImplicitParam(name = "assessmentName", value = "考核名称", required = true, dataType="String"),
			@ApiImplicitParam(name = "softwareId", value = "软件id", required = true, dataType="String"),
			@ApiImplicitParam(name = "assessmentDate", value = "考核日期", required = true, dataType="String")
	})
	@Log(operationName = "根据登录人加项目名称")
	@RequestMapping(value = "loadProjectNameList")
	@ResponseBody
	public CommonResult<List<String>> loadProjectNameList(String commonUserId, String assessmentName, String softwareId, String assessmentDate){

		return commonAssessmentService.loadProjectNameList(commonUserId, assessmentName, softwareId, assessmentDate);
	}



	/**
	 * 加载考核名称
	 *
	 * @return 1
	 */
	@ApiOperation(value = "加载考核名称")
	@Log(operationName = "加载考核名称")
	@RequestMapping(value = "loadAssessmentNameListWithCalc")
	@ResponseBody
	public CommonResult<List<String>> loadAssessmentNameList(){
		return commonAssessmentService.loadAssessmentNameList();
	}


	/**
	 * 导出用户模板
	 * @param response 1
	 */
	@ApiOperation(value = "导出上传考生基本信息模板")
	@Log(operationName = "导出上传考生基本信息模板", operationType = Log.OPERA_TYPE_OTHER)
	@RequestMapping(value = "exportUploadMode")
	public void exportUploadMode(HttpServletResponse response) {
		try {
			String fileName = "考生基本信息模板.xlsx";
			List<UserCondition> list = Lists.newArrayList();
			UserCondition userCondition = new UserCondition();
			userCondition.setLoginName("110101199912121558");
			userCondition.setTrueName("王小明");
			userCondition.setAssessmentDate("20190828");
			userCondition.setAssessmentTime("7:30-10:30");
			list.add(userCondition);
			new ExcelExport(null, UserCondition.class, ExcelField.Type.EXPORT).setDataList(list).write(response, fileName).close();
		} catch (Exception e) {
			// addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
	}

	@ApiOperation(value = "下载带有学生新的评分表")
	@ApiImplicitParam(name = "id", value = "考核的id", required = true, dataType="String")
	@Log(operationName = "下载带有学生新的评分表")
	@RequestMapping(value = "downloadStandardScoreMode")
	public void downloadStandardScoreMode(String id, HttpServletResponse response){
		ExcelExport ee = commonAssessmentService.makeExcelMode(id);
		ee.write(response, "评分表.xlsx").close();
	}
	
}