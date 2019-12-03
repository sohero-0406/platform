/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.CommonAccessoryCategory;
import com.jeesite.modules.common.entity.CommonResult;

import java.util.List;

/**
 * 配件分类表DAO接口
 * @author mayuhu
 * @version 2019-08-12
 */
@MyBatisDao
public interface CommonAccessoryCategoryDao extends CrudDao<CommonAccessoryCategory> {

    List<CommonAccessoryCategory> findPartsForVehicleParts();

    List<String> findNameByPartsCode(String code);
}