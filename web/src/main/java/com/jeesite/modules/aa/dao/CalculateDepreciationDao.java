/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.aa.entity.CalculateDepreciation;

/**
 * 折旧率估值法DAO接口
 * @author chenlitao
 * @version 2019-07-05
 */
@MyBatisDao
public interface CalculateDepreciationDao extends CrudDao<CalculateDepreciation> {
	
}