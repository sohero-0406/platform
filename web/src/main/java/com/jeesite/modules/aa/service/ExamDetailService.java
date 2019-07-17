/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.ExamDetail;
import com.jeesite.modules.aa.dao.ExamDetailDao;

/**
 * 考试详情表Service
 * @author lvchangwei
 * @version 2019-07-09
 */
@Service
@Transactional(readOnly=true)
public class ExamDetailService extends CrudService<ExamDetailDao, ExamDetail> {
	
	/**
	 * 获取单条数据
	 * @param examDetail
	 * @return
	 */
	@Override
	public ExamDetail get(ExamDetail examDetail) {
		return super.get(examDetail);
	}
	
	/**
	 * 查询分页数据
	 * @param examDetail 查询条件
	 * @param examDetail.page 分页对象
	 * @return
	 */
	@Override
	public Page<ExamDetail> findPage(ExamDetail examDetail) {
		return super.findPage(examDetail);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param examDetail
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ExamDetail examDetail) {
		super.save(examDetail);
	}
	
	/**
	 * 更新状态
	 * @param examDetail
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ExamDetail examDetail) {
		super.updateStatus(examDetail);
	}
	
	/**
	 * 删除数据
	 * @param examDetail
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ExamDetail examDetail) {
		super.delete(examDetail);
	}

    public ExamDetail getByEntity(ExamDetail examDetail) {
		return dao.getByEntity(examDetail);
    }

	/**\
	 *  （后台）新建考试 --- 模块选择项
	 */
	@Transactional(readOnly=false)
	public void saveExamInfoDetail(String examId,ExamDetail examDetail) {
		//保存考试id
		examDetail.setExamId(examId);
		super.save(examDetail);
	}
}