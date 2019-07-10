/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.modules.aa.entity.IdentifyTecDetail;
import com.jeesite.modules.common.entity.ExamUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.IdentifyTec;
import com.jeesite.modules.aa.dao.IdentifyTecDao;
import org.springframework.util.CollectionUtils;

/**
 * 鉴定技术状况Service
 * @author lvchangwei
 * @version 2019-07-04
 */
@Service
@Transactional(readOnly=true)
public class IdentifyTecService extends CrudService<IdentifyTecDao, IdentifyTec> {

	@Autowired
	private IdentifyTecDetailService identifyTecDetailService;
	
	/**
	 * 获取单条数据
	 * @param identifyTec
	 * @return
	 */
	@Override
	public IdentifyTec get(IdentifyTec identifyTec) {
		return super.get(identifyTec);
	}
	
	/**
	 * 查询分页数据
	 * @param identifyTec 查询条件
	 * @param identifyTec.page 分页对象
	 * @return
	 */
	@Override
	public Page<IdentifyTec> findPage(IdentifyTec identifyTec) {
		return super.findPage(identifyTec);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param identifyTec
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(IdentifyTec identifyTec) {
		super.save(identifyTec);
	}
	
	/**
	 * 更新状态
	 * @param identifyTec
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(IdentifyTec identifyTec) {
		super.updateStatus(identifyTec);
	}
	
	/**
	 * 删除数据
	 * @param identifyTec
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(IdentifyTec identifyTec) {
		super.delete(identifyTec);
	}

	/**
	 * 保存鉴定技术状况数据
	 */
	@Transactional
    public void saveData(ExamUser examUser, String itemJson) {
    	IdentifyTec identifyTec = new IdentifyTec();
		identifyTec.setExamUserId(examUser.getId());
		identifyTec.setPaperId(examUser.getPaperId());
		//业务开始
    	JSONObject object = JSONObject.parseObject(itemJson);
    	identifyTec.setType(object.getString("type"));
    	identifyTec.setTotalDeduct(object.getString("totalDeduct"));
    	identifyTec.setDescription(object.getString("description"));
    	super.save(identifyTec);
		JSONArray itemList = JSONObject.parseArray(object.getString("itemList"));
		if (!CollectionUtils.isEmpty(itemList)) {
			for (Object o : itemList) {
				JSONObject item = (JSONObject) o;
				IdentifyTecDetail detail = new IdentifyTecDetail();
				detail.setTechnologyInfoId(item.getString("type"));
				detail.setCode(item.getString("code"));
				detail.setDeductNum(item.getString("deductNum"));
				detail.setDegree(item.getString("degree"));
				detail.setIndentityTecId(identifyTec.getId());
				identifyTecDetailService.save(detail);
			}
		}
    }
}