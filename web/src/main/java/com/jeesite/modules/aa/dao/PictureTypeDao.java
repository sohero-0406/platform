/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.aa.entity.PictureType;

/**
 * 图片类型表DAO接口
 * @author chenlitao
 * @version 2019-07-01
 */
@MyBatisDao
public interface PictureTypeDao extends CrudDao<PictureType> {
	
}