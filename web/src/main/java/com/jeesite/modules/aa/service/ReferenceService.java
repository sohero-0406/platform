/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.dao.ReferenceDao;
import com.jeesite.modules.aa.entity.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 参照物表Service
 * @author lvchangwei
 * @version 2019-07-16
 */
@Service
@Transactional(readOnly=true)
public class ReferenceService extends CrudService<ReferenceDao, Reference> {

	@Autowired
	private ReferenceDao referenceDao;
	
	/**
	 * 获取单条数据
	 * @param reference
	 * @return
	 */
	@Override
	public Reference get(Reference reference) {
		return super.get(reference);
	}
	
	/**
	 * 查询分页数据
	 * @param reference 查询条件
	 * @param reference.page 分页对象
	 * @return
	 */
	@Override
	public Page<Reference> findPage(Reference reference) {
		return super.findPage(reference);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param reference
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Reference reference) {
		super.save(reference);
	}
	
	/**
	 * 更新状态
	 * @param reference
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Reference reference) {
		super.updateStatus(reference);
	}
	
	/**
	 * 删除数据
	 * @param reference
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Reference reference) {
		super.delete(reference);
	}

}