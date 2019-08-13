/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.CommonUser;

import java.util.List;

/**
 * common_userDAO接口
 * @author lvchangwei
 * @version 2019-07-16
 */
@MyBatisDao
public interface CommonUserDao extends CrudDao<CommonUser> {

    //CommonUser findCommonUserById(String commonUserId);

    List<CommonUser> findAssessmentStu(String schoolId, String assessmentId, String assessmentDate, String assessmentTime);

    List<CommonUser> findNormalStu(String schoolId, String majorName, String className);

    CommonUser findByUserName(String userName);

    List<CommonUser> findStuByIdsWithSchoolName(List<String> list);

    List<CommonUser> findStuByExamStuIdsWithSchoolName(List<String> list);

    List<CommonUser> findStuByUserNamesWithSchoolName(List<String> list);

    List<CommonUser> findCommonUserWithSchoolName(CommonUser commonUser);



    List<String> findMajorNameList(String schoolId);

    List<String> findClassNameList(String schoolId, String majorName);

}

