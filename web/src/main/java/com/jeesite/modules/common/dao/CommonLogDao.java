/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.CommonLog;

/**
 * 大平台日志表DAO接口
 * @author mayuhu
 * @version 2019-08-10
 */
@MyBatisDao
public interface CommonLogDao extends CrudDao<CommonLog> {
	
}