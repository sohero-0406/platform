/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.VehicleSeries;

import java.util.List;

/**
 * 车辆车系表DAO接口
 * @author chenlitao
 * @version 2019-07-04
 */
@MyBatisDao
public interface VehicleSeriesDao extends CrudDao<VehicleSeries> {

    List<VehicleSeries> findListByChexiString();
}