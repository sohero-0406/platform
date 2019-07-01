/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.utils.BaiDuAiUtil;
import com.jeesite.modules.aa.entity.PictureType;
import com.jeesite.modules.aa.vo.PictureUserVO;
import com.jeesite.modules.common.entity.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.PictureUser;
import com.jeesite.modules.aa.dao.PictureUserDao;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户图片表Service
 * @author chenlitao
 * @version 2019-06-29
 */
@Service
@Transactional(readOnly=true)
public class PictureUserService extends CrudService<PictureUserDao, PictureUser> {
	@Autowired
	private PictureUserDao pictureUserDao;
	@Autowired
	private PictureTypeService pictureTypeService;

	/**
	 * 上传图片并保存和识别图片信息
	 * <p>图片默认上传至D:/appraisalPic/exam/考试用户id/</p>
	 * @param examUserId 考试用户id
	 * @param picFile 图片文件
	 * @param pictureTypeId 图片类型id
	 * @param id 原图片id
	 * @param needDiscern 是否需要识别，是:1,否:0
	 * 可识别的图片类型包括：身份证正面、车牌照、车辆识别代号（VIN）、
	 * 机动车行驶证正页、机动车登记证1、机动车销售统一发票
	 * @return
	 */
	@Transactional
	public CommonResult saveAndDiscernPicture(String examUserId, MultipartFile picFile, String id, String pictureTypeId, String needDiscern) throws IOException {
		if(picFile == null || picFile.isEmpty()){
			return new CommonResult("1003", "上传失败，请选择文件！");
		}
		//图片默认存储路径
		String filePath = "D:/appraisalPic/exam/" + examUserId + "/";
		PictureType pictureType = pictureTypeService.get(pictureTypeId);
		String fileName = pictureType.getName();
		String originFileName = picFile.getOriginalFilename();
		String fileType = originFileName.substring(originFileName.length() - 4);
		File destFile = new File(filePath + fileName + fileType);
        if(!destFile.getParentFile().exists()){
            destFile.getParentFile().mkdir();
        }
		//执行上传
		picFile.transferTo(destFile);

		//保存图片信息
		PictureUser pictureUser = new PictureUser();

		//如果图片原id存在，则验证原图片是否存在，若存在，则删除
//		String oldUrl = null;
//		if(id != null && id.trim().length() > 0){
//			pictureUser.setId(id);
//			pictureUser = pictureUserDao.get(pictureUser);
////			oldUrl = pictureUser.getUrl();
//			pictureUser.setUrl(filePath + fileName + fileType);
//			pictureUser.setName(fileName);
//		}
		pictureUser.setId(id);
		pictureUser.setExamUserId(examUserId);
		pictureUser.setPictureTypeId(pictureTypeId);
		pictureUser.setUrl(filePath + fileName + fileType);
		pictureUser.setName(fileName);
		this.save(pictureUser);
		//删除原图片（因为新图片的名字和老图片名字一致，不需要执行删除操作）
//		if(oldUrl != null && oldUrl.trim().length()  > 0){
//			File oldFile = new File(oldUrl);
//			if(oldFile.exists()){
//				oldFile.delete();
//			}
//		}

		PictureUserVO pictureUserVO = new PictureUserVO(pictureUser);

		CommonResult comRes = new CommonResult();
		//识别图片信息
		if("1".equals(needDiscern)){
			BaiDuAiUtil baiDuAiUtil = new BaiDuAiUtil();
			String res = baiDuAiUtil.discern(pictureTypeId, filePath + fileName + fileType);
			pictureUserVO.setDetail(res);
		}
		comRes.setData(pictureUserVO);
		return comRes;
	}

    /**
     * 根据考生id和图片父类型id加载图片数据
     * @param examUserId 考生id
     * @param parentTypeIds 图片父类型ids
     * @return
     */
	public CommonResult findPictureByParentTypeId(String examUserId, String[] parentTypeIds){
	    return new CommonResult();
    }
	/**
	 * 加载图片列表
	 * @param examUserId 考生用户id
	 * @param pictureTypeIds 图片类型id
	 * @return 如果examUserId为空，返回null，如果pictureTypeIds为空，返回所有类型的图片信息
	 */
	public List<PictureUser> findList(String examUserId, String[] pictureTypeIds){
		if (examUserId == null || examUserId.trim().length() <= 0){
			return null;
		}
		return pictureUserDao.findListByExamUserId(examUserId, pictureTypeIds);
	}
	/**
	 * 获取单条数据
	 * @param pictureUser
	 * @return
	 */
	@Override
	public PictureUser get(PictureUser pictureUser) {
		return super.get(pictureUser);
	}
	
	/**
	 * 查询分页数据
	 * @param pictureUser 查询条件
	 * @param pictureUser.page 分页对象
	 * @return
	 */
	@Override
	public Page<PictureUser> findPage(PictureUser pictureUser) {
		return super.findPage(pictureUser);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param pictureUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(PictureUser pictureUser) {
		super.save(pictureUser);
	}
	
	/**
	 * 更新状态
	 * @param pictureUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(PictureUser pictureUser) {
		super.updateStatus(pictureUser);
	}
	
	/**
	 * 删除数据
	 * @param pictureUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(PictureUser pictureUser) {
		super.delete(pictureUser);
	}
	
}