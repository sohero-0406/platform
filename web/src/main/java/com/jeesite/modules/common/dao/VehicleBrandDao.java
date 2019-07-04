/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.VehicleBrand;

/**
 * 车辆品牌表DAO接口
 * @author chenlitao
 * @version 2019-07-04
 */
@MyBatisDao
public interface VehicleBrandDao extends CrudDao<VehicleBrand> {
	
}