/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.Exam;
import com.jeesite.modules.common.dao.ExamDao;

/**
 * common_examService
 * @author lvchangwei
 * @version 2019-07-10
 */
@Service
@Transactional(readOnly=true)
public class ExamService extends CrudService<ExamDao, Exam> {
	
	/**
	 * 获取单条数据
	 * @param exam
	 * @return
	 */
	@Override
	public Exam get(Exam exam) {
		return super.get(exam);
	}
	
	/**
	 * 查询分页数据
	 * @param exam 查询条件
	 * @param exam.page 分页对象
	 * @return
	 */
	@Override
	public Page<Exam> findPage(Exam exam) {
		return super.findPage(exam);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param exam
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Exam exam) {
		super.save(exam);
	}
	
	/**
	 * 更新状态
	 * @param exam
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Exam exam) {
		super.updateStatus(exam);
	}
	
	/**
	 * 删除数据
	 * @param exam
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Exam exam) {
		super.delete(exam);
	}

	/**
	 *  获取考试信息
	 */
	@Transactional(readOnly=false)
	public List<Exam> getExamInfo() {
		return dao.getExamInfo();
	}
	
}