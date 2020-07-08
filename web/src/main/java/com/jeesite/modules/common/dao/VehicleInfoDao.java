/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.VehicleInfo;
import com.jeesite.modules.common.vo.SelectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 车辆配置全表DAO接口
 *
 * @author chenlitao
 * @version 2019-07-04
 */
@MyBatisDao
public interface VehicleInfoDao extends CrudDao<VehicleInfo> {
    /**
     * 根据车系id加载车型名称数据
     *
     * @param chexiId
     * @return
     */
    List<VehicleInfo> findVehicleName(String chexiId);

    VehicleInfo getCarModel(String chexingId);

    List<VehicleInfo> findListWithField(@Param("vehicleInfo") VehicleInfo vehicleInfo, @Param("fieldList") List<SelectVO> fieldList);

    VehicleInfo selectOneWithField(@Param("vehicleInfo") VehicleInfo vehicleInfo, @Param("fieldList") List<SelectVO> fieldList);

    List<String> loadCheXingIds(String chexiId);

    List<VehicleInfo> loadCheXingList(String chexiId);

    List<String> loadJibieList(String chexiId);

    List<VehicleInfo> findAllForAppraisal(@Param("chexi") String chexi);

    VehicleInfo findDetailForAppraisal(String id);
}