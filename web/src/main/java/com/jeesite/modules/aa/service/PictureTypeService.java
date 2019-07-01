/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.PictureType;
import com.jeesite.modules.aa.dao.PictureTypeDao;

/**
 * 图片类型表Service
 * @author chenlitao
 * @version 2019-07-01
 */
@Service
@Transactional(readOnly=true)
public class PictureTypeService extends CrudService<PictureTypeDao, PictureType> {
	
	/**
	 * 获取单条数据
	 * @param pictureType
	 * @return
	 */
	@Override
	public PictureType get(PictureType pictureType) {
		return super.get(pictureType);
	}
	
	/**
	 * 查询分页数据
	 * @param pictureType 查询条件
	 * @param pictureType.page 分页对象
	 * @return
	 */
	@Override
	public Page<PictureType> findPage(PictureType pictureType) {
		return super.findPage(pictureType);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param pictureType
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(PictureType pictureType) {
		super.save(pictureType);
	}
	
	/**
	 * 更新状态
	 * @param pictureType
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(PictureType pictureType) {
		super.updateStatus(pictureType);
	}
	
	/**
	 * 删除数据
	 * @param pictureType
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(PictureType pictureType) {
		super.delete(pictureType);
	}
	
}