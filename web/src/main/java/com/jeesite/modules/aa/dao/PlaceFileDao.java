/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.aa.entity.PlaceFile;

/**
 * 归档DAO接口
 * @author liangtao
 * @version 2019-07-20
 */
@MyBatisDao
public interface PlaceFileDao extends CrudDao<PlaceFile> {
	
}