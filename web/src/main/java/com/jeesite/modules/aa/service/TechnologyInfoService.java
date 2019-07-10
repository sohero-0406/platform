/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.TechnologyInfo;
import com.jeesite.modules.aa.dao.TechnologyInfoDao;

/**
 * 技术状况项目表Service
 * @author lvchangwei
 * @version 2019-07-04
 */
@Service
@Transactional(readOnly=true)
public class TechnologyInfoService extends CrudService<TechnologyInfoDao, TechnologyInfo> {
	
	/**
	 * 获取单条数据
	 * @param technologyInfo
	 * @return
	 */
	@Override
	public TechnologyInfo get(TechnologyInfo technologyInfo) {
		return super.get(technologyInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param technologyInfo 查询条件
	 * @param technologyInfo.page 分页对象
	 * @return
	 */
	@Override
	public Page<TechnologyInfo> findPage(TechnologyInfo technologyInfo) {
		return super.findPage(technologyInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param technologyInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TechnologyInfo technologyInfo) {
		super.save(technologyInfo);
	}
	
	/**
	 * 更新状态
	 * @param technologyInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TechnologyInfo technologyInfo) {
		super.updateStatus(technologyInfo);
	}
	
	/**
	 * 删除数据
	 * @param technologyInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TechnologyInfo technologyInfo) {
		super.delete(technologyInfo);
	}
	
}