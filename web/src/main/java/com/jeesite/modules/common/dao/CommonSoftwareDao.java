/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.CommonSoftware;

/**
 * 软件表DAO接口
 * @author mayuhu
 * @version 2019-08-08
 */
@MyBatisDao
public interface CommonSoftwareDao extends CrudDao<CommonSoftware> {
	
}