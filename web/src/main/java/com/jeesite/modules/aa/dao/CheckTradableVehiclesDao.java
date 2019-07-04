/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.aa.entity.CheckTradableVehicles;

/**
 * 检查可交易车辆DAO接口
 * @author lvchangwei
 * @version 2019-07-01
 */
@MyBatisDao
public interface CheckTradableVehiclesDao extends CrudDao<CheckTradableVehicles> {

    void saveIsAccident(CheckTradableVehicles checkTradableVehicles);
}