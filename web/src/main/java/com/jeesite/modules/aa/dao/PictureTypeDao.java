/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.aa.entity.PictureType;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hslf.blip.PICT;

import java.util.List;

/**
 * 图片类型表DAO接口
 * @author chenlitao
 * @version 2019-07-01
 */
@MyBatisDao
public interface PictureTypeDao extends CrudDao<PictureType> {
    /**
     * 根据主键加载数据
     * @param ids 主键ids，不能为空
     * @return
     */
	List<PictureType> findListByIds(@Param("ids") String[] ids);
}