/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.VehicleDanger;

/**
 * 车辆出险记录表DAO接口
 * @author liangtao
 * @version 2019-07-12
 */
@MyBatisDao
public interface VehicleDangerDao extends CrudDao<VehicleDanger> {
	
}