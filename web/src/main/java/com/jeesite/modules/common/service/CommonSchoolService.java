/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.CommonSchool;
import com.jeesite.modules.common.dao.CommonSchoolDao;

/**
 * 院校表Service
 * @author mayuhu
 * @version 2019-08-05
 */
@Service
@Transactional(readOnly=true)
public class CommonSchoolService extends CrudService<CommonSchoolDao, CommonSchool> {
	
	/**
	 * 获取单条数据
	 * @param commonSchool
	 * @return
	 */
	@Override
	public CommonSchool get(CommonSchool commonSchool) {
		return super.get(commonSchool);
	}
	
	/**
	 * 查询分页数据
	 * @param commonSchool 查询条件 commonSchool.page 分页对象
	 * @return
	 */
	@Override
	public Page<CommonSchool> findPage(CommonSchool commonSchool) {
		return super.findPage(commonSchool);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonSchool
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonSchool commonSchool) {
		super.save(commonSchool);
	}
	
	/**
	 * 更新状态
	 * @param commonSchool
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonSchool commonSchool) {
		super.updateStatus(commonSchool);
	}
	
	/**
	 * 删除数据
	 * @param commonSchool
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonSchool commonSchool) {
		super.delete(commonSchool);
	}

	public CommonSchool getByEntity(CommonSchool commonSchool){
		return dao.getByEntity(commonSchool);
	}


}