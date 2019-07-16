/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.CommonUser;

/**
 * common_userDAO接口
 * @author lvchangwei
 * @version 2019-07-16
 */
@MyBatisDao
public interface CommonUserDao extends CrudDao<CommonUser> {
	
}