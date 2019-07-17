/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.List;

import com.jeesite.modules.aa.entity.ExamScoreClassify;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.ExamScoreDetail;
import com.jeesite.modules.aa.dao.ExamScoreDetailDao;

/**
 * 考试评分详情表Service
 * @author liangtao
 * @version 2019-07-16
 */
@Service
@Transactional(readOnly=true)
public class ExamScoreDetailService extends CrudService<ExamScoreDetailDao, ExamScoreDetail> {
	
	/**
	 * 获取单条数据
	 * @param examScoreDetail
	 * @return
	 */
	@Override
	public ExamScoreDetail get(ExamScoreDetail examScoreDetail) {
		return super.get(examScoreDetail);
	}
	
	/**
	 * 查询分页数据
	 * @param examScoreDetail 查询条件
	 * @param examScoreDetail.page 分页对象
	 * @return
	 */
	@Override
	public Page<ExamScoreDetail> findPage(ExamScoreDetail examScoreDetail) {
		return super.findPage(examScoreDetail);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param examScoreDetail
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ExamScoreDetail examScoreDetail) {
		super.save(examScoreDetail);
	}
	
	/**
	 * 更新状态
	 * @param examScoreDetail
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ExamScoreDetail examScoreDetail) {
		super.updateStatus(examScoreDetail);
	}
	
	/**
	 * 删除数据
	 * @param examScoreDetail
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ExamScoreDetail examScoreDetail) {
		super.delete(examScoreDetail);
	}

	@Transactional(readOnly=false)
	public List<ExamScoreClassify> findData() {
		return  dao.findData();
	}

	
}