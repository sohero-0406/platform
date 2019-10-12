/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.CommonAssessment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 考核表DAO接口
 * @author mayuhu
 * @version 2019-08-05
 */
@MyBatisDao
public interface CommonAssessmentDao extends CrudDao<CommonAssessment> {
	List<String> loadNameList(String schoolId);

	List<String> loadNameListBySoftwareId(String schoolId, String softwareIdStr);

	List<String> loadCalcedNameList(@Param("schoolId") String schoolId);

	Integer countConflictNum(String startDate, String endDate, String id);

}