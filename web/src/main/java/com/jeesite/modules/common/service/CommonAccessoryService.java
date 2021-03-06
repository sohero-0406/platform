
package com.jeesite.modules.common.service;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.lang.StringUtils;
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

	private  CommonUserService commonUserService;

	@Autowired
	public void setCommonUserService(CommonUserService commonUserService) {
		this.commonUserService = commonUserService;
	}

	/**
	 * 获取单条数据
	 * @param commonAccessory 1
	 * @return 1
	 */
	@Override
	public CommonAccessory get(CommonAccessory commonAccessory) {
		return super.get(commonAccessory);
	}
	
	/**
	 * 查询分页数据
	 * @param commonAccessory 查询条件 commonAccessory.page 分页对象
	 * @return 1
	 */
	@Override
	public Page<CommonAccessory> findPage(CommonAccessory commonAccessory) {
		return super.findPage(commonAccessory);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonAccessory 1
	 */
	@Override
	@Transactional
	public void save(CommonAccessory commonAccessory) {
		super.save(commonAccessory);
	}
	
	/**
	 * 更新状态
	 * @param commonAccessory 1
	 */
	@Override
	@Transactional
	public void updateStatus(CommonAccessory commonAccessory) {
		super.updateStatus(commonAccessory);
	}
	
	/**
	 * 删除数据
	 * @param commonAccessory 1
	 */
	@Override
	@Transactional
	public void delete(CommonAccessory commonAccessory) {
		super.delete(commonAccessory);
	}


	/**
	 * 根据对象条件加载配件分页信息
	 * @param commonAccessory 1
	 * @return 1
	 */
	public CommonResult<Page<CommonAccessory>> findPageByCondition(CommonAccessory commonAccessory){
		if(!PageUtils.checkPageParams(commonAccessory)){
			return new CommonResult<>(CodeConstant.PARA_MUST_NEED, "您未传入分页数据");
		}
		return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, super.findPage(commonAccessory));
	}

	/**
	 * 根据删除的json文件删除数据 （逻辑删除）
	 * @param json 1
	 * @return 1
	 */
	@Transactional
	public CommonResult<JSONObject> deleteCommonCommonAccessory(String json){
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
			int x = length - deletedNum;
			object.put("notDeletedNum", x);
			if(x>0){
				return new CommonResult<>(CodeConstant.DATA_LOCK, "有"+x+"条件数据不符合删除条件，不能删除，符合的已删除", object);
			}else{
				return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, object);
			}
		}else{
			return new CommonResult<>(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
		}

	}


	@Transactional
	public void saveList(List<CommonAccessory> commonAccessoryList){
		dao.insertBatch(commonAccessoryList);
	}

	@Transactional
	public CommonResult<JSONObject> saveByCategoryId(List<CommonAccessory> commonAccessoryList, String categoryId) {
		String loginUserId = PreEntity.getUserIdByToken();
		CommonUser loginUser = commonUserService.get(loginUserId);
		if(!"1".equals(loginUser.getRoleId())){
			return new CommonResult<>(CodeConstant.NO_RIGHT, "您有权限进行该操作");
		}
		if(ListUtils.isEmpty(commonAccessoryList)){
			return new CommonResult<>(CodeConstant.EXCEL_NO_DATA, "您传入的EXCEL表格没有数据");
		}
		List<String> msgList = new ArrayList<>();
		List<CommonAccessory> okCommonAccessoryList = new ArrayList<>();
		String msg = "";
		for (CommonAccessory commonAccessory :commonAccessoryList) {
			int sum = 0;
			String msgX = "编号为\""+commonAccessory.getAccessoryIndex()+"\"的配件:";
			if(StringUtils.isBlank(commonAccessory.getAccessoryIndex())){
				msgX += "编号不能为空;";
				sum++;
			}else {
				if (commonAccessory.getAccessoryIndex().length()>50) {
					msgX += "编号长度不能大于50;";sum++;
				}
			}
			if(StringUtils.isBlank(commonAccessory.getAccessoryName())){
				msgX += "配件品牌不能为空;";sum++;
			}else {
				if (commonAccessory.getAccessoryName().length()>100) {
					msgX += "配件品牌长度不能大于100;";sum++;
				}
			}
			if(StringUtils.isBlank(commonAccessory.getAccessoryLevel())){
				msgX += "配件等级不能为空;";sum++;
			}else {
				if (commonAccessory.getAccessoryLevel().length()>45) {
					msgX += "配件等级长度不能大于45;";sum++;
				}
			}
//			if(StringUtils.isBlank(commonAccessory.getAccessorySpecifications())){
//				msgX += "规格不能为空;";sum++;
//			}else {
			if (commonAccessory.getAccessorySpecifications()!=null&&commonAccessory.getAccessorySpecifications().length()>20) {
				msgX += "规格长度不能大于20;";sum++;
			}
//			}
			if(StringUtils.isBlank(commonAccessory.getAccessoryUnit())){
				msgX += "单位不能为空;";sum++;
			}else {
				if (commonAccessory.getAccessoryUnit().length()>10) {
					msgX += "单位长度不能大于10;";sum++;
				}
			}
			if(StringUtils.isBlank(commonAccessory.getAccessoryPrice())){
				msgX += "指导价不能为空;";sum++;
			}else {
				if (commonAccessory.getAccessoryPrice().length()>20) {
					msgX += "指导价长度不能大于20;";sum++;
				}
			}
			if(StringUtils.isBlank(commonAccessory.getAccessoryPlaceOfOrigin())){
				msgX += "产地不能为空;";sum++;
			}else {
				if (commonAccessory.getAccessoryPlaceOfOrigin().length()>100) {
					msgX += "产地长度不能大于100;";sum++;
				}
			}
			if(StringUtils.isBlank(commonAccessory.getAccessoryImport())){
				msgX += "是否进口不能为空;";sum++;
			}
			if(sum>0){
				msgList.add(msgX);
				msg += msgX+"<br/>";
			}else{
				okCommonAccessoryList.add(commonAccessory);
			}
		}
		if(okCommonAccessoryList.size()>0){
			for (CommonAccessory commonAccessory :commonAccessoryList) {
				commonAccessory.setCategoryId(categoryId);
			}
			this.saveList(okCommonAccessoryList);
		}else{
			JSONObject jo = new JSONObject();
			jo.put("successNum", okCommonAccessoryList.size());
			jo.put("errorNum", commonAccessoryList.size()-okCommonAccessoryList.size());
			jo.put("msgList", msgList);
			return new CommonResult<>(CodeConstant.EXCEL_WRONG_DATA, "excel文件中没有一个数据能正常上传", jo);
		}
		JSONObject jo = new JSONObject();
		jo.put("successNum", okCommonAccessoryList.size());
		jo.put("errorNum", commonAccessoryList.size()-okCommonAccessoryList.size());
		jo.put("msgList", msgList);
		return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, msg, jo);
	}
}