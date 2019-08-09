/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.CommonAssessmentStu;
import com.jeesite.modules.common.dao.CommonAssessmentStuDao;

/**
 * 考核学生表Service
 * @author mayuhu
 * @version 2019-08-05
 */
@Service
@Transactional(readOnly=true)
public class CommonAssessmentStuService extends CrudService<CommonAssessmentStuDao, CommonAssessmentStu> {
	
	/**
	 * 获取单条数据
	 * @param commonAssessmentStu
	 * @return
	 */
	@Override
	public CommonAssessmentStu get(CommonAssessmentStu commonAssessmentStu) {
		return super.get(commonAssessmentStu);
	}
	
	/**
	 * 查询分页数据
	 * @param commonAssessmentStu 查询条件
	 * @param commonAssessmentStu.page 分页对象
	 * @return
	 */
	@Override
	public Page<CommonAssessmentStu> findPage(CommonAssessmentStu commonAssessmentStu) {
		return super.findPage(commonAssessmentStu);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonAssessmentStu
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonAssessmentStu commonAssessmentStu) {
		super.save(commonAssessmentStu);
	}
	
	/**
	 * 更新状态
	 * @param commonAssessmentStu
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonAssessmentStu commonAssessmentStu) {
		super.updateStatus(commonAssessmentStu);
	}
	
	/**
	 * 删除数据
	 * @param commonAssessmentStu
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonAssessmentStu commonAssessmentStu) {
		super.delete(commonAssessmentStu);
	}
	
}