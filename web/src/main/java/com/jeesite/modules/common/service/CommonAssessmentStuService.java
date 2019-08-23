/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.utils.excel.ExcelExport;
import com.jeesite.common.utils.excel.annotation.ExcelField;
import com.jeesite.modules.common.dao.CommonAssessmentDao;
import com.jeesite.modules.common.dao.CommonAssessmentSchemeDao;
import com.jeesite.modules.common.dao.CommonUserDao;
import com.jeesite.modules.common.entity.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
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

    /**
     * 根据对象条件加载分页的考生数据
     * @param commonAssessmentStu
     * @return
     */
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

    /**
     * 导出考生分数，并返回一个Excel的导出对象
     * @param commonAssessmentStu
     * @return
     */
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
		headerList.add("考核项目");
		headerWidthList.add(2070);
		headerList.add("考核分数");
		headerWidthList.add(2080);
		headerList.add("总分");
		headerWidthList.add(2110);
		headerList.add("是否通过");
		headerWidthList.add(2120);

//		CommonAssessment commonAssessment = commonAssessmentService.get(commonAssessmentStu.getAssessmentId());
//		CommonAssessmentScheme commonAssessmentScheme = commonAssessmentSchemeService.get(commonAssessment.getAssessmentSchemeId());
//		//JSONArray schemeDetails = JSONArray.parseArray(commonAssessmentScheme.getSchemeDetails());
//		for (int i = 0; i < schemeDetails.size(); i++) {
//			JSONObject oneSubject = schemeDetails.getJSONObject(i);
//			headerList.add(oneSubject.getString("title")+"成绩");
//			headerWidthList.add(2070+i);
//		}

		//int rowNum = 1;
		Map<String, JSONArray> map = new HashedMap();
		ExcelExport ee = new ExcelExport("导出成绩表", null, headerList, headerWidthList);
		List<CommonAssessmentStu> commonAssessmentStuList = dao.findAssessmentStuListByCondition(commonAssessmentStu);
		for (int i = 0; i < commonAssessmentStuList.size(); i++) {
			CommonAssessmentStu cas = commonAssessmentStuList.get(i);
//			JSONArray schemeDetails = null;
//			if(map.get(cas.getAssessmentId())==null){
//				CommonAssessment ca = commonAssessmentService.get(cas.getAssessmentId());
//				CommonAssessmentScheme commonAssessmentScheme = commonAssessmentSchemeService.get(ca.getAssessmentSchemeId());
//				schemeDetails = JSONArray.parseArray(commonAssessmentScheme.getSchemeDetails());
//				map.put(cas.getAssessmentId(), schemeDetails);
//			}else{
//				schemeDetails = map.get(cas.getAssessmentId());
//			}
			Row row = ee.addRow();
			int tempRowNum = row.getRowNum();
			ee.addCell(row, 0, cas.getLoginName());
			ee.addCell(row, 1, cas.getTrueName());
			ee.addCell(row, 2, cas.getSchoolName());
			ee.addCell(row, 3, cas.getMajorName());
			ee.addCell(row, 4, cas.getClassName());
			ee.addCell(row, 5, cas.getAssessmentName());
			ee.addCell(row, 6, cas.getAssessmentDate());
			ee.addCell(row, 9, cas.getTotalScore());
			ee.addCell(row, 10, "2".equals(cas.getDataStatus())?"通过":"未通过");
			JSONArray scoreDetails = JSONArray.parseArray(cas.getScoreDetails());
			for (int j = 0; j < scoreDetails.size(); j++) {
				JSONObject jsonObject = scoreDetails.getJSONObject(j);
				ee.addCell(row, 7, jsonObject.getString("title"));
				ee.addCell(row, 8, jsonObject.getString("gainScore"));
				if(j<scoreDetails.size()-1){
					row = ee.addRow();
				}
			}
			ee.addMergedRegionList(cellRangeAddressList(tempRowNum, scoreDetails.size()));
			//rowNum = schemeDetails.size();
		}
		return ee;
	}

	private List<CellRangeAddress> cellRangeAddressList(int startRowNum, int endRowNum){
		List<CellRangeAddress> cellRangeAddressList = new ArrayList<>();
		endRowNum = startRowNum+endRowNum-1;
		cellRangeAddressList.add(new CellRangeAddress(startRowNum, endRowNum, 0, 0));
		cellRangeAddressList.add(new CellRangeAddress(startRowNum, endRowNum, 1, 1));
		cellRangeAddressList.add(new CellRangeAddress(startRowNum, endRowNum, 2, 2));
		cellRangeAddressList.add(new CellRangeAddress(startRowNum, endRowNum, 3, 3));
		cellRangeAddressList.add(new CellRangeAddress(startRowNum, endRowNum, 4, 4));
		cellRangeAddressList.add(new CellRangeAddress(startRowNum, endRowNum, 5, 5));
		cellRangeAddressList.add(new CellRangeAddress(startRowNum, endRowNum, 6, 6));
		cellRangeAddressList.add(new CellRangeAddress(startRowNum, endRowNum, 9, 9));
		cellRangeAddressList.add(new CellRangeAddress(startRowNum, endRowNum, 10, 10));
		return cellRangeAddressList;
	}

    /**
     * 根据用户id和考核名称，加载考核日期
     * @param commonUserId
     * @param assessmentName
     * @return
     */
    public CommonResult loadAssessmentDateList(String commonUserId, String assessmentName) {
		CommonUser loginUser = commonUserService.get(commonUserId);
		if(!"2".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.ERROR_DATA, "您传入的参数不正确");
		}

		List<String> assessmentDateList = dao.loadDateList(loginUser.getSchoolId(), assessmentName);

		return new CommonResult(assessmentDateList);
    }

    /**
     * 根据用户id、考核名称、考核日期，加载考核时间
     * @param commonUserId
     * @param assessmentName
     * @param assessmentDate
     * @return
     */
	public CommonResult loadAssessmentTimeList(String commonUserId, String assessmentName, String assessmentDate) {
		CommonUser loginUser = commonUserService.get(commonUserId);
		if(!"2".equals(loginUser.getRoleId())){
			return new CommonResult(CodeConstant.ERROR_DATA, "您传入的参数不正确");
		}
		List<String> assessmentTimeList = dao.loadTimeList(loginUser.getSchoolId(), assessmentName, assessmentDate);
		return new CommonResult(assessmentTimeList);
	}

    /**
     * 加载一个考生信息
     * @param serverExamStuId
     * @return
     */
	public CommonResult loadOneExamStu(String serverExamStuId) {
		CommonAssessmentStu commonAssessmentStu = super.get(serverExamStuId);
		if(commonAssessmentStu==null){
			return new CommonResult(CodeConstant.ERROR_DATA, "您传入的参数不正确");
		}
		CommonAssessment commonAssessment = commonAssessmentService.get(commonAssessmentStu.getAssessmentId());
		commonAssessmentStu.setAssessmentName(commonAssessment.getAssessmentName());
		return new CommonResult(commonAssessmentStu);
	}


	public List<CommonAssessmentStu> findAssessmentStuListInAssessment(CommonAssessmentStu con) {
		return dao.findAssessmentStuListInAssessment(con);
	}
}
