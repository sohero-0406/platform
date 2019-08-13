/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.entity.CommonUser;
import com.jeesite.modules.common.entity.PreEntity;
import com.jeesite.modules.common.util.CommonUserUtil;
import com.jeesite.modules.common.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.CommonAccessory;
import com.jeesite.modules.common.dao.CommonAccessoryDao;

/**
 * 汽车配件表Service
 * @author mayuhu
 * @version 2019-08-12
 */
@Service
@Transactional(readOnly=true)
public class CommonAccessoryService extends CrudService<CommonAccessoryDao, CommonAccessory> {

	@Autowired
	private  CommonUserService commonUserService;

	/**
	 * 获取单条数据
	 * @param commonAccessory
	 * @return
	 */
	@Override
	public CommonAccessory get(CommonAccessory commonAccessory) {
		return super.get(commonAccessory);
	}
	
	/**
	 * 查询分页数据
	 * @param commonAccessory 查询条件 commonAccessory.page 分页对象
	 * @return
	 */
	@Override
	public Page<CommonAccessory> findPage(CommonAccessory commonAccessory) {
		return super.findPage(commonAccessory);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonAccessory
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonAccessory commonAccessory) {
		super.save(commonAccessory);
	}
	
	/**
	 * 更新状态
	 * @param commonAccessory
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonAccessory commonAccessory) {
		super.updateStatus(commonAccessory);
	}
	
	/**
	 * 删除数据
	 * @param commonAccessory
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonAccessory commonAccessory) {
		super.delete(commonAccessory);
	}



	public CommonResult findPageByCondition(CommonAccessory commonAccessory){
		if(!PageUtils.checkPageParams(commonAccessory)){
			return new CommonResult(CodeConstant.PARA_MUST_NEED, "您未传入分页数据");
		}
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, super.findPage(commonAccessory));
	}


	public CommonResult deleteCommonCommonAccessory(String json){
		String commonUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(commonUserId);
		if(CommonUserUtil.isSuperAdmin(loginUser)){
			JSONObject jsonObject = JSONObject.parseObject(json);
			Integer length =jsonObject.getInteger("length");
			JSONArray ja = JSONArray.parseArray(jsonObject.getString("datas"));
			int deletedNum = 0;
			for (int i = 0; i < length; i++) {
				String id = ja.getString(i);
				super.delete(this.get(id));
				deletedNum++;
			}
			JSONObject object = new JSONObject();
			object.put("deletedNum", deletedNum);
			object.put("notDeletedNum", length- deletedNum);
			return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, object);
		}else{
			return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
		}

	}

}