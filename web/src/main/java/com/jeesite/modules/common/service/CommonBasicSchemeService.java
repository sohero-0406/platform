/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.CommonBasicScheme;
import com.jeesite.modules.common.dao.CommonBasicSchemeDao;

/**
 * 方案基本表，目前不做管理使用，只作为基础数据调用，后期能会做出管理界面Service
 * @author mayuhu
 * @version 2019-08-05
 */
@Service
@Transactional(readOnly=true)
public class CommonBasicSchemeService extends CrudService<CommonBasicSchemeDao, CommonBasicScheme> {
	
	/**
	 * 获取单条数据
	 * @param commonBasicScheme
	 * @return
	 */
	@Override
	public CommonBasicScheme get(CommonBasicScheme commonBasicScheme) {
		return super.get(commonBasicScheme);
	}
	
	/**
	 * 查询分页数据
	 * @param commonBasicScheme 查询条件  commonBasicScheme.page 分页对象
	 *
	 * @return
	 */
	@Override
	public Page<CommonBasicScheme> findPage(CommonBasicScheme commonBasicScheme) {
		return super.findPage(commonBasicScheme);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonBasicScheme
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonBasicScheme commonBasicScheme) {
		super.save(commonBasicScheme);
	}
	
	/**
	 * 更新状态
	 * @param commonBasicScheme
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonBasicScheme commonBasicScheme) {
		super.updateStatus(commonBasicScheme);
	}
	
	/**
	 * 删除数据
	 * @param commonBasicScheme
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonBasicScheme commonBasicScheme) {
		super.delete(commonBasicScheme);
	}


	/**
	 * 根据id删除基本方案
	 * @param id
	 */
	@Transactional(readOnly = false)
	public void deleteById(String id){
		super.delete(this.get(id));
	}

	/**
	 * 根据json信息删除一个或者多个基本方案
	 * @param json
	 */
	@Transactional(readOnly = false)
	public void deleteByJson(String json){
		JSONObject jo = JSONObject.parseObject(json);
		Integer length = jo.getInteger("length");
		JSONArray ja = JSONArray.parseArray(jo.getString("datas"));
		for (int i = 0; i < length; i++) {
			String id = ja.getJSONObject(i).toString();
			super.delete(this.get(id));
		}
	}
	
}