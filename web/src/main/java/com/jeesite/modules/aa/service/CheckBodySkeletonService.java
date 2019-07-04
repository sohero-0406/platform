/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.modules.aa.entity.CheckTradableVehicles;
import com.jeesite.modules.aa.entity.VehicleDocumentInfo;
import com.jeesite.modules.aa.vo.CheckBodySkeletonVO;
import com.jeesite.modules.common.entity.ExamUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.CheckBodySkeleton;
import com.jeesite.modules.aa.dao.CheckBodySkeletonDao;
import org.springframework.util.CollectionUtils;

/**
 * 检查车体骨架Service
 *
 * @author lvchangwei
 * @version 2019-07-02
 */
@Service
@Transactional(readOnly = true)
public class CheckBodySkeletonService extends CrudService<CheckBodySkeletonDao, CheckBodySkeleton> {

    @Autowired
    private CheckBodySkeletonDao checkBodySkeletonDao;

    @Autowired
    private CheckTradableVehiclesService checkTradableVehiclesService;

    /**
     * 获取单条数据
     *
     * @param checkBodySkeleton
     * @return
     */
    @Override
    public CheckBodySkeleton get(CheckBodySkeleton checkBodySkeleton) {
        return super.get(checkBodySkeleton);
    }

    /**
     * 查询分页数据
     *
     * @param checkBodySkeleton      查询条件
     * @param checkBodySkeleton.page 分页对象
     * @return
     */
    @Override
    public Page<CheckBodySkeleton> findPage(CheckBodySkeleton checkBodySkeleton) {
        return super.findPage(checkBodySkeleton);
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param checkBodySkeleton
     */
    @Override
    @Transactional(readOnly = false)
    public void save(CheckBodySkeleton checkBodySkeleton) {
        super.save(checkBodySkeleton);
    }

    /**
     * 更新状态
     *
     * @param checkBodySkeleton
     */
    @Override
    @Transactional(readOnly = false)
    public void updateStatus(CheckBodySkeleton checkBodySkeleton) {
        super.updateStatus(checkBodySkeleton);
    }

    /**
     * 删除数据
     *
     * @param checkBodySkeleton
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(CheckBodySkeleton checkBodySkeleton) {
        super.delete(checkBodySkeleton);
    }

    @Transactional
    public void saveBatch(ExamUser examUser, String veliclePicJson) {
        JSONArray jsonArray = JSONObject.parseArray(veliclePicJson);
        if (!CollectionUtils.isEmpty(jsonArray)) {
            for (Object o : jsonArray) {
                JSONObject object = (JSONObject) o;
                CheckBodySkeleton checkBodySkeleton = new CheckBodySkeleton();
                checkBodySkeleton.setExamUserId(examUser.getId());
                checkBodySkeleton.setPaperId(examUser.getPaperId());
                checkBodySkeleton.setTechnologyInfoId(object.getString("project"));
                checkBodySkeleton.setState(object.getString("state"));
                checkBodySkeleton.setDescription(object.getString("description"));
                super.save(checkBodySkeleton);
            }
        }
    }

    /**
     * 判定事故车加载
     */
    public CheckBodySkeletonVO findAccidentVehicle(CheckBodySkeleton checkBodySkeleton) {
        CheckBodySkeletonVO vo = new CheckBodySkeletonVO();
        List<CheckBodySkeleton> list = checkBodySkeletonDao.findAccidentVehicle(checkBodySkeleton);
        vo.setSkeletonList(list);
        CheckTradableVehicles checkTradableVehicles = new CheckTradableVehicles();
        checkTradableVehicles.setExamUserId(checkBodySkeleton.getExamUserId());
        checkTradableVehicles = checkTradableVehiclesService.getByEntity(checkTradableVehicles);
        if (null != checkTradableVehicles) {
            vo.setIsAccident(checkTradableVehicles.getIsAccident());
        }
        return vo;
    }
}