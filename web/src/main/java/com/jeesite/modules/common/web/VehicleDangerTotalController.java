/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.modules.common.entity.Maintenance;
import com.jeesite.modules.common.entity.VehicleDanger;
import com.jeesite.modules.common.entity.VehicleDangerDetail;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.jeesite.modules.common.entity.VehicleDangerTotal;
import com.jeesite.modules.common.service.VehicleDangerTotalService;

/**
 * 车辆出险总表Controller
 *
 * @author liangtao
 * @version 2019-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/common/vehicleDangerTotal")
public class VehicleDangerTotalController extends BaseController {

    @Autowired
    private VehicleDangerTotalService vehicleDangerTotalService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public VehicleDangerTotal get(String id, boolean isNewRecord) {
        return vehicleDangerTotalService.get(id, isNewRecord);
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = {"list", ""})
    public String list(VehicleDangerTotal vehicleDangerTotal, Model model) {
        model.addAttribute("vehicleDangerTotal", vehicleDangerTotal);
        return "modules/common/vehicleDangerTotalList";
    }

    /**
     * 查询列表数据
     */
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<VehicleDangerTotal> listData(VehicleDangerTotal vehicleDangerTotal, HttpServletRequest request, HttpServletResponse response) {
        vehicleDangerTotal.setPage(new Page<>(request, response));
        Page<VehicleDangerTotal> page = vehicleDangerTotalService.findPage(vehicleDangerTotal);
        return page;
    }

    /**
     * 查看编辑表单
     */
    @RequestMapping(value = "form")
    public String form(VehicleDangerTotal vehicleDangerTotal, Model model) {
        model.addAttribute("vehicleDangerTotal", vehicleDangerTotal);
        return "modules/common/vehicleDangerTotalForm";
    }

    /**
     * 保存车辆出险总表
     */
    @PostMapping(value = "save")
    @ResponseBody
    public String save(@Validated VehicleDangerTotal vehicleDangerTotal) {
        vehicleDangerTotalService.save(vehicleDangerTotal);
        return renderResult(Global.TRUE, text("保存车辆出险总表成功！"));
    }

    /**
     * 删除车辆出险总表
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(VehicleDangerTotal vehicleDangerTotal) {
        vehicleDangerTotalService.delete(vehicleDangerTotal);
        return renderResult(Global.TRUE, text("删除车辆出险总表成功！"));
    }

    /**
     * @param
     * @return
     */
    @RequestMapping(value = "total")
    @ResponseBody
    public String total(String aaa) {

        JSONObject obj = JSONObject.parseObject(aaa);
        JSONObject resultJson = obj.getJSONObject("result");
        JSONObject dataJson = resultJson.getJSONObject("data");
        JSONObject detailsJson = dataJson.getJSONObject("details");
        JSONArray recordsArray = detailsJson.getJSONArray("records");
        String vehicleDangerTotalString = detailsJson.toJSONString();
        //声明车辆出险总表实体类
        VehicleDangerTotal vehicleDangerTotal = JSONObject.parseObject(vehicleDangerTotalString, VehicleDangerTotal.class);
        int recordsArrayLen = recordsArray.size();
        if (recordsArrayLen > 0) {
            //获取车架号
            vehicleDangerTotal.setVinCode((String) ((JSONObject) recordsArray.get(0)).get("vin"));
            //获取车辆类型
            vehicleDangerTotal.setVehicleType((String) ((JSONObject) recordsArray.get(0)).get("vehicle_Type"));
        }
        //车辆出险总表保存
        vehicleDangerTotalService.save(vehicleDangerTotal);
        //保存 出险记录详情表与车辆出险记录表
        vehicleDangerTotalService.saveVehicleDangerAndDetail(recordsArray, vehicleDangerTotal);
        return "成功";
    }


}