/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.CommonAssessmentStu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 考核学生表DAO接口
 * @author mayuhu
 * @version 2019-08-05
 */
@MyBatisDao
public interface CommonAssessmentStuDao extends CrudDao<CommonAssessmentStu> {

    Long findAssessmentStuListByConditionCount(CommonAssessmentStu commonAssessmentStu);

    List<CommonAssessmentStu> findAssessmentStuListByCondition(CommonAssessmentStu commonAssessmentStu);

    Long findAssessmentStuListByConditionAndSchoolIdCount(@Param("commonAssessmentStu") CommonAssessmentStu commonAssessmentStu, @Param("schoolId") String schoolId);

    List<CommonAssessmentStu> findAssessmentStuListByConditionAndSchoolId(@Param("commonAssessmentStu") CommonAssessmentStu commonAssessmentStu, @Param("schoolId") String schoolId);

    List<String> loadDateList(String schoolId, String assessmentName);

    List<String> loadTimeList(String schoolId, String assessmentName, String assessmentDate);
}