/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.aa.entity.Calculate;

/**
 * 计算车辆价值DAO接口
 * @author lvchangwei
 * @version 2019-06-25
 */
@MyBatisDao
public interface CalculateDao extends CrudDao<Calculate> {
	
}