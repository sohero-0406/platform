/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import com.jeesite.modules.aa.vo.VehicleDocumentInfoVO;
import com.jeesite.modules.common.entity.ExamUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.entity.VehicleDocumentInfo;
import com.jeesite.modules.aa.dao.VehicleDocumentInfoDao;

/**
 * 车辆单证信息Service
 *
 * @author lvchangwei
 * @version 2019-07-01
 */
@Service
@Transactional(readOnly = true)
public class VehicleDocumentInfoService extends CrudService<VehicleDocumentInfoDao, VehicleDocumentInfo> {

    /**
     * 获取单条数据
     *
     * @param vehicleDocumentInfo
     * @return
     */
    @Override
    public VehicleDocumentInfo get(VehicleDocumentInfo vehicleDocumentInfo) {
        return super.get(vehicleDocumentInfo);
    }

    /**
     * 查询分页数据
     *
     * @param vehicleDocumentInfo      查询条件
     * @param vehicleDocumentInfo.page 分页对象
     * @return
     */
    @Override
    public Page<VehicleDocumentInfo> findPage(VehicleDocumentInfo vehicleDocumentInfo) {
        return super.findPage(vehicleDocumentInfo);
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param vehicleDocumentInfo
     */
    @Override
    @Transactional(readOnly = false)
    public void save(VehicleDocumentInfo vehicleDocumentInfo) {
        super.save(vehicleDocumentInfo);
    }

    /**
     * 更新状态
     *
     * @param vehicleDocumentInfo
     */
    @Override
    @Transactional(readOnly = false)
    public void updateStatus(VehicleDocumentInfo vehicleDocumentInfo) {
        super.updateStatus(vehicleDocumentInfo);
    }

    /**
     * 删除数据
     *
     * @param vehicleDocumentInfo
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(VehicleDocumentInfo vehicleDocumentInfo) {
        super.delete(vehicleDocumentInfo);
    }

    /**
     * 批量插入
     *
     * @param examUser
     * @param vehicleDocumentInfoVO
     */
    @Transactional
    public void saveBatch(ExamUser examUser, VehicleDocumentInfoVO vehicleDocumentInfoVO) {
        String[] projects = vehicleDocumentInfoVO.getProject();
        String[] states = vehicleDocumentInfoVO.getState();
        Date[] validitys = vehicleDocumentInfoVO.getValidity();
        Stream.iterate(0, i -> i + 1).limit(projects.length).forEach(i -> {
            VehicleDocumentInfo info = new VehicleDocumentInfo(); 
            info.setExamUserId(examUser.getId());
            info.setPaperId(examUser.getPaperId());
            info.setProject(projects[i]);
            info.setState(states[i]);
            info.setValidity(validitys[i]);
            super.save(info);
        });
    }
}