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
import com.jeesite.modules.aa.entity.Paper;
import com.jeesite.modules.aa.dao.PaperDao;

/**
 * 试卷Service
 * @author lvchangwei
 * @version 2019-07-16
 */
@Service
@Transactional(readOnly=true)
public class PaperService extends CrudService<PaperDao, Paper> {

	@Autowired
	private PaperDao paperDao;
	
	/**
	 * 获取单条数据
	 * @param paper
	 * @return
	 */
	@Override
	public Paper get(Paper paper) {
		return super.get(paper);
	}
	
	/**
	 * 查询分页数据
	 * @param paper 查询条件
	 * @return
	 */
	@Override
	public Page<Paper> findPage(Paper paper) {
		return super.findPage(paper);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param paper
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Paper paper) {
		super.save(paper);
	}
	
	/**
	 * 更新状态
	 * @param paper
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Paper paper) {
		super.updateStatus(paper);
	}
	
	/**
	 * 删除数据
	 * @param paper
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Paper paper) {
		super.delete(paper);
	}

	/**
	 * 查询试卷列表
	 * @return
	 */
	public List<Paper> getPaperList() {
		return paperDao.getPaperList();
	}

}