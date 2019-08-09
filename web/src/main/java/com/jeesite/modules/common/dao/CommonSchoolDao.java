/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.CommonSchool;

/**
 * 院校表DAO接口
 * @author mayuhu
 * @version 2019-08-05
 */
@MyBatisDao
public interface CommonSchoolDao extends CrudDao<CommonSchool> {
	
}