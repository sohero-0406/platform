/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.constant.CodeConstant;
import com.jeesite.modules.common.entity.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.entity.VehicleSeries;
import com.jeesite.modules.common.service.VehicleSeriesService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 车辆车系表Controller
 *
 * @author chenlitao
 * @version 2019-07-04
 */
@Controller
@RequestMapping(value = "${adminPath}/common/vehicleSeries")
public class VehicleSeriesController extends BaseController {

    @Autowired
    private VehicleSeriesService vehicleSeriesService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public VehicleSeries get(String id, boolean isNewRecord) {
        return vehicleSeriesService.get(id, isNewRecord);
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = {"list", ""})
    public String list(VehicleSeries vehicleSeries, Model model) {
        model.addAttribute("vehicleSeries", vehicleSeries);
        return "modules/common/vehicleSeriesList";
    }

    /**
     * 查询列表数据
     */
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<VehicleSeries> listData(VehicleSeries vehicleSeries, HttpServletRequest request, HttpServletResponse response) {
        vehicleSeries.setPage(new Page<>(request, response));
        Page<VehicleSeries> page = vehicleSeriesService.findPage(vehicleSeries);
        return page;
    }

    /**
     * 查看编辑表单
     */
    @RequestMapping(value = "form")
    public String form(VehicleSeries vehicleSeries, Model model) {
        model.addAttribute("vehicleSeries", vehicleSeries);
        return "modules/common/vehicleSeriesForm";
    }

    /**
     * 保存车辆车系表
     */
    @PostMapping(value = "save")
    @ResponseBody
    public String save(@Validated VehicleSeries vehicleSeries) {
        vehicleSeriesService.save(vehicleSeries);
        return renderResult(Global.TRUE, text("保存车辆车系表成功！"));
    }

    /**
     * 删除车辆车系表
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(VehicleSeries vehicleSeries) {
        vehicleSeriesService.delete(vehicleSeries);
        return renderResult(Global.TRUE, text("删除车辆车系表成功！"));
    }

    @PostMapping(value = "findList")
    @ResponseBody
    public CommonResult findList(String pinpaiId) {
        CommonResult comRes = new CommonResult();
        List<VehicleSeries> vehicleSeriesList = new ArrayList<>();
        VehicleSeries vehicleSeries = new VehicleSeries();
        if (pinpaiId == null || pinpaiId.trim().length() <= 0) {
            // 二手车鉴定评估项目中需要不限品牌加载车系数据，下面代码先注释
            // comRes.setCode("1010");
            // comRes.setMsg("未按照接口要求进行数据查询！");
            // 不限品牌的时候，固定加载10个车系数据：卡罗拉、轩逸、朗逸、速腾、思域、奥迪A4L、迈腾、宝马3系、雅阁、凯美瑞
            vehicleSeriesList = vehicleSeriesService.findListByChexiString();
        }else{
            vehicleSeries.setPinpaiId(pinpaiId);
            vehicleSeriesList = vehicleSeriesService.findList(vehicleSeries);
        }
        List<VehicleSeries> dataList = new ArrayList<>();
        for (VehicleSeries vs : vehicleSeriesList) {
            vehicleSeries = new VehicleSeries();
            vehicleSeries.setChexi(vs.getChexi());
            vehicleSeries.setChexiId(vs.getChexiId());
            vehicleSeries.setId(vs.getId());

            dataList.add(vehicleSeries);
        }
        comRes.setData(dataList);
        return comRes;
    }

    /**
     * 查询实体
     */
    @RequestMapping(value = "getByEntity")
    @ResponseBody
    public CommonResult getByEntity(VehicleSeries vehicleSeries) {
        vehicleSeries = vehicleSeriesService.getByEntity(vehicleSeries);
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, vehicleSeries);
    }

    @ApiOperation(value = "网约车项目查询车辆车系")
    @PostMapping(value = "findSeriesListForWyc")
    @ResponseBody
    public CommonResult<List> findSeriesListForWyc(String pinpaiId) {
        CommonResult comRes = new CommonResult();
        List<VehicleSeries> vehicleSeriesList = new ArrayList<>();
        VehicleSeries vehicleSeries = new VehicleSeries();
        if (StringUtils.isNotBlank(pinpaiId)) {
            vehicleSeries.setPinpaiId(pinpaiId);
            vehicleSeriesList = vehicleSeriesService.findList(vehicleSeries);
        }
        comRes.setData(vehicleSeriesList.stream().sorted(Comparator.comparing(VehicleSeries::getChexi)).collect(Collectors.toList()));
        return comRes;
    }
}