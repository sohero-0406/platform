/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.Exam;

/**
 * common_examDAO接口
 * @author lvchangwei
 * @version 2019-07-10
 */
@MyBatisDao
public interface ExamDao extends CrudDao<Exam> {
	
}