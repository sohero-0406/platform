/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.PictureUser;
import com.jeesite.modules.aa.dao.PictureUserDao;

/**
 * 用户图片表Service
 * @author chenlitao
 * @version 2019-06-29
 */
@Service
@Transactional(readOnly=true)
public class PictureUserService extends CrudService<PictureUserDao, PictureUser> {
	@Autowired
	private PictureUserDao pictureUserDao;

	/**
	 * 加载图片列表
	 * @param examUserId 考生用户id
	 * @param pictureTypeIds 图片类型id
	 * @return 如果examUserId为空，返回null，如果pictureTypeIds为空，返回所有类型的图片信息
	 */
	public List<PictureUser> findList(String examUserId, String[] pictureTypeIds){
		if (examUserId == null || examUserId.trim().length() <= 0){
			return null;
		}
		return pictureUserDao.findListByExamUserId(examUserId, pictureTypeIds);
	}
	/**
	 * 获取单条数据
	 * @param pictureUser
	 * @return
	 */
	@Override
	public PictureUser get(PictureUser pictureUser) {
		return super.get(pictureUser);
	}
	
	/**
	 * 查询分页数据
	 * @param pictureUser 查询条件
	 * @param pictureUser.page 分页对象
	 * @return
	 */
	@Override
	public Page<PictureUser> findPage(PictureUser pictureUser) {
		return super.findPage(pictureUser);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param pictureUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(PictureUser pictureUser) {
		super.save(pictureUser);
	}
	
	/**
	 * 更新状态
	 * @param pictureUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(PictureUser pictureUser) {
		super.updateStatus(pictureUser);
	}
	
	/**
	 * 删除数据
	 * @param pictureUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(PictureUser pictureUser) {
		super.delete(pictureUser);
	}
	
}