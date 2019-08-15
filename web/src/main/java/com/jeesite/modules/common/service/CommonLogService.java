/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import com.jeesite.common.constant.CodeConstant;
import com.jeesite.modules.common.entity.CommonResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.CommonLog;
import com.jeesite.modules.common.dao.CommonLogDao;

/**
 * 大平台日志表Service
 * @author mayuhu
 * @version 2019-08-10
 */
@Service
@Transactional(readOnly=true)
public class CommonLogService extends CrudService<CommonLogDao, CommonLog> {
	
	/**
	 * 获取单条数据
	 * @param commonLog
	 * @return
	 */
	@Override
	public CommonLog get(CommonLog commonLog) {
		return super.get(commonLog);
	}
	
	/**
	 * 查询分页数据
	 * @param commonLog 查询条件  commonLog.page 分页对象
	 *
	 * @return
	 */
	@Override
	public Page<CommonLog> findPage(CommonLog commonLog) {
		return super.findPage(commonLog);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonLog commonLog) {
		super.save(commonLog);
	}
	
	/**
	 * 更新状态
	 * @param commonLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonLog commonLog) {
		super.updateStatus(commonLog);
	}
	
	/**
	 * 删除数据
	 * @param commonLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonLog commonLog) {
		super.delete(commonLog);
	}

	/**
	 * 根据条件加载分页日期
	 * @param commonLog
	 * @return
	 */
	public CommonResult findPageByCondition(CommonLog commonLog){
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, super.findPage(commonLog));
	}
	
}