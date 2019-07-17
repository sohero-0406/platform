/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.aa.entity.ExamScoreClassify;

/**
 * 考试评分分类总分数DAO接口
 * @author liangtao
 * @version 2019-07-16
 */
@MyBatisDao
public interface ExamScoreClassifyDao extends CrudDao<ExamScoreClassify> {
	
}