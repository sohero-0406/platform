/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.CommonBasicScheme;

/**
 * 方案基本表，目前不做管理使用，只作为基础数据调用，后期能会做出管理界面DAO接口
 * @author mayuhu
 * @version 2019-08-05
 */
@MyBatisDao
public interface CommonBasicSchemeDao extends CrudDao<CommonBasicScheme> {
	
}