/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.io.FileUtils;
import com.jeesite.common.utils.excel.ExcelExport;
import com.jeesite.common.utils.excel.ExcelImport;
import com.jeesite.common.utils.excel.annotation.ExcelField;
import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.entity.CommonUser;
import com.jeesite.modules.common.util.FilePathUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.entity.VehicleInfo;
import com.jeesite.modules.common.service.VehicleInfoService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆配置全表Controller
 *
 * @author chenlitao
 * @version 2019-07-04
 */
@Controller
@RequestMapping(value = "${adminPath}/common/vehicleInfo")
public class VehicleInfoController extends BaseController {

    @Autowired
    private VehicleInfoService vehicleInfoService;

//    /**
//     * 获取数据
//     */
//    @ModelAttribute
//    public VehicleInfo get(String id, boolean isNewRecord) {
//        return vehicleInfoService.get(id, isNewRecord);
//    }

//    /**
//     * 查询列表
//     */
//    @RequestMapping(value = {"list", ""})
//    public String list(VehicleInfo vehicleInfo, Model model) {
//        model.addAttribute("vehicleInfo", vehicleInfo);
//        return "modules/common/vehicleInfoList";
//    }
//
//    /**
//     * 查询列表数据
//     */
//    @RequestMapping(value = "listData")
//    @ResponseBody
//    public Page<VehicleInfo> listData(VehicleInfo vehicleInfo, HttpServletRequest request, HttpServletResponse response) {
//        vehicleInfo.setPage(new Page<>(request, response));
//        Page<VehicleInfo> page = vehicleInfoService.findPage(vehicleInfo);
//        return page;
//    }
//
//    /**
//     * 查看编辑表单
//     */
//    @RequestMapping(value = "form")
//    public String form(VehicleInfo vehicleInfo, Model model) {
//        model.addAttribute("vehicleInfo", vehicleInfo);
//        return "modules/common/vehicleInfoForm";
//    }
//
//    /**
//     * 保存车辆配置全表
//     */
//    @PostMapping(value = "save")
//    @ResponseBody
//    public String save(@Validated VehicleInfo vehicleInfo) {
//        vehicleInfoService.save(vehicleInfo);
//        return renderResult(Global.TRUE, text("保存车辆配置全表成功！"));
//    }
//
//    /**
//     * 删除车辆配置全表
//     */
//    @RequestMapping(value = "delete")
//    @ResponseBody
//    public String delete(VehicleInfo vehicleInfo) {
//        vehicleInfoService.delete(vehicleInfo);
//        return renderResult(Global.TRUE, text("删除车辆配置全表成功！"));
//    }

    /**
     * 根据车系id加载区分年款的车辆信息
     * @param chexiId
     * @return
     */
    @ApiOperation(value = "根据车系id加载区分年款的车辆信息")
    @ApiImplicitParam(name = "chexiId", value = "车系id", required = true, dataType="String")
    @Log(operationName = "根据车系id加载区分年款的车辆信息")
    @PostMapping(value = "findList")
    @ResponseBody
    public CommonResult findList(String chexiId) {
        CommonResult comRes = new CommonResult();
        if (chexiId == null || chexiId.trim().length() <= 0) {
            comRes.setCode("1010");
            comRes.setMsg("未按照接口要求进行数据查询！");
            return comRes;
        }
        List<VehicleInfo> vehicleInfoList = vehicleInfoService.findVehicleName(chexiId);

        Map<String, List<VehicleInfo>> map = new HashMap<>();
        List<VehicleInfo> values = null;
        for (VehicleInfo vi : vehicleInfoList) {
            String key = vi.getNiankuan();
            if (map.containsKey(key)) {
                values = map.get(key);
            } else {
                values = new ArrayList<>();
            }
            values.add(vi);

            map.put(key, values);
        }
        comRes.setData(map);

        return comRes;
    }

    /**
     * 根据车型id查部分常用属性
     */
    @ApiOperation(value = "根据车型id查部分常用属性")
    @ApiImplicitParam(name = "chexingId", value = "车型id", required = true, dataType="String")
    @Log(operationName = "根据车型id查部分常用属性")
    @RequestMapping(value = "getCarModel")
    @ResponseBody
    public CommonResult getCarModel(String chexingId) {
        VehicleInfo vehicleInfo = vehicleInfoService.getCarModel(chexingId);
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, vehicleInfo);
    }

    /**
     * 根据车型id查部分常用属性
     */
    @ApiOperation(value = "根据车型id查部分常用属性")
    @ApiImplicitParam(name = "vehicleInfo", value = "车的条件对象", required = true, dataType="VehicleInfo")
    @Log(operationName = "根据车型id查部分常用属性")
    @RequestMapping(value = "getByEntity")
    @ResponseBody
    public CommonResult getByEntity(VehicleInfo vehicleInfo) {
        vehicleInfo = vehicleInfoService.getByEntity(vehicleInfo);
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, vehicleInfo);
    }



    // 下面是马玉虎写的代码

    /**
     * 加载车的分页数据
     * @param vehicleInfo
     * @return
     */
    @ApiOperation(value = "加载车的分页数据")
    @ApiImplicitParam(name = "vehicleInfo", value = "查询的条件对象", required = true, dataType="VehicleInfo")
    @Log(operationName = "加载车的分页数据")
    @RequestMapping(value = "listVehicleInfo")
    @ResponseBody
    public CommonResult listVehicleInfo(VehicleInfo vehicleInfo){
        return vehicleInfoService.findPageByCondition(vehicleInfo);
    }

    /**
     * 下载车型配置表模板
     * @param response
     */
    @ApiOperation(value = "下载车型配置表模板")
    @Log(operationName = "下载车型配置表模板", operationType = Log.OPERA_TYPE_OTHER)
    @RequestMapping(value = "downTemplate" , produces = "application/octet-stream")
    @ResponseBody
    public void downTemplate(HttpServletResponse response){
        try {
            String fileName = "车型配置表.xlsx";
            List<VehicleInfo> list = Lists.newArrayList();
            list.add(new VehicleInfo());
            new ExcelExport(null, VehicleInfo.class, ExcelField.Type.EXPORT).setDataList(list).write(response, fileName).close();
        } catch (Exception e) {
            // addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
        }
    }

    /**
     * 导入车的信息
     * @param file
     * @return
     */
    @ApiOperation(value = "加载车的分页数据")
    @ApiImplicitParam(name = "file", value = "车型的excel文件", required = true, dataType="MultipartFile")
    @Log(operationName = "导入车的信息", operationType = Log.OPERA_TYPE_ADD)
    @RequestMapping(value = "importVehicleInfos", method= RequestMethod.POST)
    @ResponseBody
    public CommonResult importVehicleInfos(MultipartFile file){
        try {
            ExcelImport ei = new ExcelImport(file, 2, 0);
            List<VehicleInfo> vehicleInfoList = ei.getDataList(VehicleInfo.class);
            ei.close();
            return vehicleInfoService.saveVehicleList(vehicleInfoList);
        } catch (Exception e) {

        }
        return new CommonResult(CodeConstant.ERROR_DATA, "服务器错误");
    }

    /**
     * 根据json删除车的信息
     * @param json
     * @return
     */
    @ApiOperation(value = "根据json删除车的信息")
    @ApiImplicitParam(name = "json", value = "要删除的车的json数据", required = true, dataType="String")
    @Log(operationName = "根据json删除车的信息", operationType = Log.OPERA_TYPE_DEL)
    @RequestMapping(value = "deleteVehicle")
    @ResponseBody
    public CommonResult deleteVehicle(String json){

        return vehicleInfoService.deleteVehicle(json);
    }

    /**
     * 上传车的图片
     * @param image
     * @param vehicleInfoId
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "上传车的图片")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "image", value = "要上传的图片文件", required = true, dataType="MultipartFile"),
        @ApiImplicitParam(name = "vehicleInfoId", value = "车的id", required = true, dataType="String")
    })
    @Log(operationName = "上传车的图片", operationType = Log.OPERA_TYPE_ADD)
    @RequestMapping(value = "importVehicleImage", method= RequestMethod.POST)
    @ResponseBody
    public CommonResult importVehicleImage(MultipartFile image, String vehicleInfoId) throws IOException {
        return vehicleInfoService.saveVehicleImage(image, vehicleInfoId);
    }

    /**
     * 加载车的所有图片信息
     * @param vehicleInfo
     * @return
     */
    @ApiOperation(value = "加载车的所有图片信息")
    @ApiImplicitParam(name = "vehicleInfo", value = "车的条件对象", required = true, dataType="VehicleInfo")
    @Log(operationName = "加载车的所有图片信息")
    @RequestMapping(value = "loadVehicleImages")
    @ResponseBody
    public CommonResult loadVehicleImages(VehicleInfo vehicleInfo){
        return vehicleInfoService.findImageList(vehicleInfo);
    }

}