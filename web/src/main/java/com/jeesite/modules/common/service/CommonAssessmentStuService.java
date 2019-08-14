/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.utils.excel.ExcelExport;
import com.jeesite.common.utils.excel.annotation.ExcelField;
import com.jeesite.modules.common.dao.CommonAssessmentDao;
import com.jeesite.modules.common.dao.CommonAssessmentSchemeDao;
import com.jeesite.modules.common.dao.CommonUserDao;
import com.jeesite.modules.common.entity.*;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.dao.CommonAssessmentStuDao;

/**
 * 考核学生表Service
 * @author mayuhu
 * @version 2019-08-05
 */
//@As
@Service
@Transactional(readOnly=true)
public class CommonAssessmentStuService extends CrudService<CommonAssessmentStuDao, CommonAssessmentStu> {

	@Autowired
	private CommonUserService commonUserService;
	@Autowired
	private CommonAssessmentService commonAssessmentService;
	@Autowired
	private CommonAssessmentSchemeService commonAssessmentSchemeService;

	/**
	 * 获取单条数据
	 * @param commonAssessmentStu
	 * @return
	 */
	@Override
	public CommonAssessmentStu get(CommonAssessmentStu commonAssessmentStu) {
		return super.get(commonAssessmentStu);
	}
	
	/**
	 * 查询分页数据
	 * @param commonAssessmentStu 查询条件 commonAssessmentStu.page 分页对象
	 * @return
	 */
	@Override
	public Page<CommonAssessmentStu> findPage(CommonAssessmentStu commonAssessmentStu) {
		return super.findPage(commonAssessmentStu);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonAssessmentStu
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonAssessmentStu commonAssessmentStu) {
		super.save(commonAssessmentStu);
	}
	
	/**
	 * 更新状态
	 * @param commonAssessmentStu
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonAssessmentStu commonAssessmentStu) {
		super.updateStatus(commonAssessmentStu);
	}
	
	/**
	 * 删除数据
	 * @param commonAssessmentStu
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonAssessmentStu commonAssessmentStu) {
		super.delete(commonAssessmentStu);
	}

	@Transactional(readOnly=false)
	public void phyDelete(CommonAssessmentStu commonAssessmentStu) {
		dao.phyDelete(commonAssessmentStu);
	}


	public CommonResult findPageByCondition(CommonAssessmentStu commonAssessmentStu){
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(loginUser.getRoleId().equals("1")){ // 如果是超管，就可以全部都查
			Page page = commonAssessmentStu.getPage();
			page.setList(dao.findAssessmentStuListByCondition(commonAssessmentStu));
//			page.setList(dao.findAssessmentStuListByCondition());
//			page.setPageNo(commonAssessmentStu.getPageNo());
//			page.setPageSize(commonAssessmentStu.getPageSize());
//			page.setCount(dao.findAssessmentStuListByConditionCount(commonAssessmentStu));

			return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, page);
		}else{
			// Page page = commonAssessmentStu.getPage();
			Page page = new Page();
			page.setList(dao.findAssessmentStuListByConditionAndSchoolId(commonAssessmentStu, loginUser.getSchoolId()));
			page.setPageNo(commonAssessmentStu.getPageNo());
			page.setPageSize(commonAssessmentStu.getPageSize());
			page.setCount(dao.findAssessmentStuListByConditionAndSchoolIdCount(commonAssessmentStu, loginUser.getSchoolId()));
			return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, page);
		}
	}

	//此导出方法 必须要传入 commonAssessmentStu.assessmentId
	public ExcelExport exportStuScore(CommonAssessmentStu commonAssessmentStu){
        List<String> headerList = new ArrayList<>();
		List<Integer> headerWidthList = new ArrayList<>();
        headerList.add("登录名（身份证号）");
		headerWidthList.add(2000);
        headerList.add("姓名");
		//headerWidthList.add(200);
       // headerList.add("性别");
		headerWidthList.add(2010);
        headerList.add("学校");
		headerWidthList.add(2020);
        headerList.add("专业");
		headerWidthList.add(2030);
        headerList.add("班级");
		headerWidthList.add(2040);
        headerList.add("考核名称");
		headerWidthList.add(2050);
        headerList.add("考核日期");
		headerWidthList.add(2060);
        CommonAssessment commonAssessment = commonAssessmentService.get(commonAssessmentStu.getAssessmentId());
        CommonAssessmentScheme commonAssessmentScheme = commonAssessmentSchemeService.get(commonAssessment.getAssessmentSchemeId());
		JSONArray schemeDetails = JSONArray.parseArray(commonAssessmentScheme.getSchemeDetails());
		for (int i = 0; i < schemeDetails.size(); i++) {
			JSONObject oneSubject = schemeDetails.getJSONObject(i);
			headerList.add(oneSubject.getString("title")+"成绩");
			headerWidthList.add(2070+i);
		}
		headerList.add("总分");
		headerWidthList.add(2110);
		headerList.add("是否通过");
		headerWidthList.add(2120);

		ExcelExport ee = new ExcelExport("导出成绩表", null, headerList, headerWidthList);
		List<CommonAssessmentStu> commonAssessmentStuList = dao.findAssessmentStuListByCondition(commonAssessmentStu);
		for (int i = 0; i < commonAssessmentStuList.size(); i++) {
			CommonAssessmentStu cas = commonAssessmentStuList.get(i);
			Row row = ee.addRow();
			ee.addCell(row, 0, cas.getLoginName());
			ee.addCell(row, 1, cas.getTrueName());
			ee.addCell(row, 2, cas.getSchoolName());
			ee.addCell(row, 3, cas.getMajorName());
			ee.addCell(row, 4, cas.getClassName());
			ee.addCell(row, 5, cas.getAssessmentName());
			ee.addCell(row, 6, cas.getAssessmentDate());
			JSONArray scoreDetails = JSONArray.parseArray(cas.getScoreDetails());
			int colIndex = 7;
			for (int j = 0; j < scoreDetails.size(); j++) {
				JSONObject jsonObject = scoreDetails.getJSONObject(j);
				ee.addCell(row, colIndex, jsonObject.getString("gainScore"));
				colIndex++;
			}
			ee.addCell(row, colIndex, cas.getTotalScore());
			ee.addCell(row, colIndex+1, "2".equals(cas.getDataStatus())?"通过":"未通过");
		}
		return ee;
	}

    public CommonResult loadAssessmentDateList(String commonUserId, String assessmentName) {
		CommonUser loginUser = commonUserService.get(commonUserId);
		if(!"2".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.ERROR_DATA, "您传入的参数不正确");
		}

		List<String> assessmentDateList = dao.loadDateList(loginUser.getSchoolId(), assessmentName);

		return new CommonResult(assessmentDateList);
    }

	public CommonResult loadAssessmentTimeList(String commonUserId, String assessmentName, String assessmentDate) {
		CommonUser loginUser = commonUserService.get(commonUserId);
		if(!"2".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.ERROR_DATA, "您传入的参数不正确");
		}
		List<String> assessmentTimeList = dao.loadTimeList(loginUser.getSchoolId(), assessmentName, assessmentDate);
		return new CommonResult(assessmentTimeList);
	}

	public CommonResult loadOneExamStu(String serverExamStuId) {
		CommonAssessmentStu commonAssessmentStu = super.get(serverExamStuId);
		if(commonAssessmentStu==null){
			return new CommonResult(CodeConstant.ERROR_DATA, "您传入的参数不正确");
		}
		CommonAssessment commonAssessment = commonAssessmentService.get(commonAssessmentStu.getAssessmentId());
		commonAssessmentStu.setAssessmentName(commonAssessment.getAssessmentName());
		return new CommonResult(commonAssessmentStu);
	}
}
