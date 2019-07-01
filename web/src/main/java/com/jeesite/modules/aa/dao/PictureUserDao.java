/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.aa.entity.PictureUser;

import java.util.List;

/**
 * 用户图片表DAO接口
 * @author chenlitao
 * @version 2019-06-29
 */
@MyBatisDao
public interface PictureUserDao extends CrudDao<PictureUser> {
    /**
     * 加载图片列表
     * @param examUserId 考生用户id
     * @param pictureTypeIds 图片类型代号
     * @return 如果examUserId为空，返回null，如果pictureTypeIds为空，返回所有类型的图片信息
     */
	List<PictureUser> findListByExamUserId(String examUserId, String[] pictureTypeIds);
}