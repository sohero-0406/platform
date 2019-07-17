/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.aa.entity.ExamScoreClassify;
import com.jeesite.modules.aa.entity.ExamScoreDetail;

import java.util.List;

/**
 * 考试评分详情表DAO接口
 * @author liangtao
 * @version 2019-07-16
 */
@MyBatisDao
public interface ExamScoreDetailDao extends CrudDao<ExamScoreDetail> {

    List<ExamScoreClassify> findData();
}