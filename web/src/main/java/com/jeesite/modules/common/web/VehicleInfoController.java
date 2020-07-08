package com.jeesite.modules.common.web;

import com.google.common.collect.Lists;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.utils.excel.ExcelExport;
import com.jeesite.common.utils.excel.ExcelImport;
import com.jeesite.common.utils.excel.annotation.ExcelField;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.entity.VehicleInfo;
import com.jeesite.modules.common.service.VehicleInfoService;
import com.jeesite.modules.common.vo.SelectVO;
import com.jeesite.modules.common.vo.vehicleInfo.FindDetailForAppraisalRespVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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
@RequestMapping(value = "/common/vehicleInfo")
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
     * @param chexiId 车系id
     * @return CommonResult
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
     * @param vehicleInfo 查询的条件对象
     * @return CommonResult
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
     * @param response response
     */
    @ApiOperation(value = "下载车型配置表模板")
    @Log(operationName = "下载车型配置表模板", operationType = Log.OPERA_TYPE_OTHER)
    @RequestMapping(value = "downTemplate" , produces = "application/octet-stream")
    @ResponseBody
    public void downTemplate(HttpServletResponse response){
        try {
            String fileName = "车型配置表.xlsx";
            List<VehicleInfo> list = Lists.newArrayList();
            list.add(vehicleInfoService.get("1"));
            new ExcelExport(null, VehicleInfo.class, ExcelField.Type.EXPORT).setDataList(list).write(response, fileName).close();
        } catch (Exception e) {
            // addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
        }
    }

    /**
     * 导入车的信息
     * @param file 车型的excel文件
     * @return CommonResult
     */
    @ApiOperation(value = "导入车的信息")
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
            e.printStackTrace();
        }
        return new CommonResult(CodeConstant.ERROR_DATA, "服务器错误");
    }

    /**
     * 根据json删除车的信息
     * @param json 要删除的车的json数据
     * @return CommonResult
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
     * @param image 图片
     * @param vehicleInfoId 车的id
     * @return CommonResult
     * @throws IOException 1
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
     * 上传车的图片
     * @param image 图片数组
     * @param vehicleInfoId 车的id
     * @return CommonResult
     * @throws IOException 1
     */
    @ApiOperation(value = "上传车的多个图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "image", value = "要上传的图片文件数组", required = true, dataType="MultipartFile[]"),
            @ApiImplicitParam(name = "vehicleInfoId", value = "车的id", required = true, dataType="String")
    })
    @Log(operationName = "上传车的多个图片", operationType = Log.OPERA_TYPE_ADD)
    @RequestMapping(value = "importVehicleImages", method= RequestMethod.POST)
    @ResponseBody
    public CommonResult importVehicleImages(MultipartFile[] image, String vehicleInfoId) throws IOException {
        return vehicleInfoService.saveVehicleImages(image, vehicleInfoId);
    }

    /**
     * 加载车的所有图片信息
     * @param id  车的id
     * @return CommonResult
     */
    @ApiOperation(value = "加载车的所有图片信息")
    @ApiImplicitParam(name = "id", value = "车的id", required = true, dataType="String")
    @Log(operationName = "加载车的所有图片信息")
    @RequestMapping(value = "loadVehicleImages")
    @ResponseBody
    public CommonResult loadVehicleImages(String id){
        return vehicleInfoService.findImageList(id);
    }


    @ApiOperation(value = "根据品牌id，车系id，年款，加载一些特定的属性")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pinpaiId", value = "品牌id", required = true, dataType="String"),
            @ApiImplicitParam(name = "chexiId", value = "车系id", required = true, dataType="String"),
            @ApiImplicitParam(name = "year", value = "年款", required = true, dataType="String")
    })
    @Log(operationName = "根据品牌id，车系id，年款，加载一些特定的属性")
    @RequestMapping(value = "loadCarList")
    @ResponseBody
    public CommonResult loadCarList(String pinpaiId,String chexiId,String year){
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setPinpaiId(pinpaiId);
        vehicleInfo.setChexiId(chexiId);
        vehicleInfo.setNiankuan(year);
        List<SelectVO> fieldList = new ArrayList<>();
        SelectVO selectVO = new SelectVO();
        selectVO.setFieldName("pinpai");
        selectVO.setEntityAttrName("pinpai");
        fieldList.add(selectVO);
        SelectVO selectVO1 = new SelectVO();
        selectVO1.setFieldName("chexi");
        selectVO1.setEntityAttrName("chexi");
        fieldList.add(selectVO1);
        SelectVO selectVO2 = new SelectVO();
        selectVO2.setFieldName("chexi_id");
        selectVO2.setEntityAttrName("chexiId");
        fieldList.add(selectVO2);
        SelectVO selectVO3 = new SelectVO();
        selectVO3.setFieldName("niankuan");
        selectVO3.setEntityAttrName("niankuan");
        fieldList.add(selectVO3);
        SelectVO selectVO4 = new SelectVO();
        selectVO4.setFieldName("chexing");
        selectVO4.setEntityAttrName("chexing");
        fieldList.add(selectVO4);
        SelectVO selectVO5 = new SelectVO();
        selectVO5.setFieldName("chexing_id");
        selectVO5.setEntityAttrName("chexingId");
        fieldList.add(selectVO5);
        List<VehicleInfo> vehicleInfoList = vehicleInfoService.findListWithField(vehicleInfo, fieldList);
        if(ListUtils.isEmpty(vehicleInfoList)){
            return new CommonResult(CodeConstant.ERROR_DATA, "未查询出任何数据");
        }
        return new CommonResult(vehicleInfoList);
    }

    @ApiOperation(value = "根据车型id加载一些相关属性")
    @ApiImplicitParam(name = "chexingId", value = "车型id", required = true, dataType="String")
    @Log(operationName = "根据车型id加载一些相关属性")
    @RequestMapping(value = "loadCarDetail")
    @ResponseBody
    public CommonResult loadCarDetail(String chexingId){
        VehicleInfo vehicleInfoCon = new VehicleInfo();
        vehicleInfoCon.setChexingId(chexingId);

        List<SelectVO> fieldList = new ArrayList<>();
        SelectVO selectVO = new SelectVO();
        selectVO.setFieldName("chexingmingcheng");
        selectVO.setEntityAttrName("chexingmingcheng");
        fieldList.add(selectVO);
        SelectVO selectVO1 = new SelectVO();
        selectVO1.setFieldName("chexi");
        selectVO1.setEntityAttrName("chexi");
        fieldList.add(selectVO1);
        SelectVO selectVO2 = new SelectVO();
        selectVO2.setFieldName("chexi_id");
        selectVO2.setEntityAttrName("chexiId");
        fieldList.add(selectVO2);
        SelectVO selectVO3 = new SelectVO();
        selectVO3.setFieldName("changshangzhidaojia");
        selectVO3.setEntityAttrName("changshangzhidaojia");
        fieldList.add(selectVO3);
        SelectVO selectVO4 = new SelectVO();
        selectVO4.setFieldName("fadongji");
        selectVO4.setEntityAttrName("fadongji");
        fieldList.add(selectVO4);
        SelectVO selectVO5 = new SelectVO();
        selectVO5.setFieldName("biansuxiang");
        selectVO5.setEntityAttrName("biansuxiang");
        fieldList.add(selectVO5);

        SelectVO selectVO6 = new SelectVO();
        selectVO6.setFieldName("pailiang_l");
        selectVO6.setEntityAttrName("pailiangL");
        fieldList.add(selectVO6);

        SelectVO selectVO7 = new SelectVO();
        selectVO7.setFieldName("nengyuanleixing");
        selectVO7.setEntityAttrName("nengyuanleixing");
        fieldList.add(selectVO7);

        SelectVO selectVO8 = new SelectVO();
        selectVO8.setFieldName("zuidagonglv_kw");
        selectVO8.setEntityAttrName("zuidagonglvKw");
        fieldList.add(selectVO8);

        SelectVO selectVO9 = new SelectVO();
        selectVO9.setFieldName("zuidaniuju_n_m");
        selectVO9.setEntityAttrName("zuidaniujuNM");
        fieldList.add(selectVO9);

        SelectVO selectV10 = new SelectVO();
        selectV10.setFieldName("changdu_mm");
        selectV10.setEntityAttrName("changduMm");
        fieldList.add(selectV10);

        SelectVO selectV11 = new SelectVO();
        selectV11.setFieldName("kuandu_mm");
        selectV11.setEntityAttrName("kuanduMm");
        fieldList.add(selectV11);

        SelectVO selectV12 = new SelectVO();
        selectV12.setFieldName("gaodu_mm");
        selectV12.setEntityAttrName("gaoduMm");
        fieldList.add(selectV12);

        SelectVO selectV13 = new SelectVO();
        selectV13.setFieldName("zuoweishu_ge");
        selectV13.setEntityAttrName("zuoweishuGe");
        fieldList.add(selectV13);

        SelectVO selectV14 = new SelectVO();
        selectV14.setFieldName("waiguanyanse");
        selectV14.setEntityAttrName("waiguanyanse");
        fieldList.add(selectV14);

        SelectVO selectV15 = new SelectVO();
        selectV15.setFieldName("neishiyanse");
        selectV15.setEntityAttrName("neishiyanse");
        fieldList.add(selectV15);

        VehicleInfo vehicleInfo = vehicleInfoService.selectOneWithField(vehicleInfoCon, fieldList);
        if(vehicleInfo==null){
            return new CommonResult(CodeConstant.ERROR_DATA, "未查询出任何数据");
        }
        return new CommonResult(vehicleInfo);
    }


    @ApiOperation(value = "根据车系id加载对应的车型id集合")
    @ApiImplicitParam(name = "chexiId", value = "车系id", required = true, dataType="String")
    @Log(operationName = "根据车系id加载对应的车型id集合")
    @RequestMapping(value = "loadCarModelList")
    @ResponseBody
    public CommonResult loadCarModelList(String chexiId){
        List<String> chexingIdList = vehicleInfoService.loadCheXingIds(chexiId);
        if(ListUtils.isEmpty(chexingIdList)){
            return new CommonResult(CodeConstant.ERROR_DATA, "未查询出任何数据");
        }
        return new CommonResult(chexingIdList);
    }

    @ApiOperation(value = "根据车系id加载对应的车型数据集合")
    @ApiImplicitParam(name = "chexiId", value = "车系id", required = true, dataType="String")
    @Log(operationName = "根据车系id加载对应的车型数据集合")
    @RequestMapping(value = "loadCheXingList")
    @ResponseBody
    public CommonResult loadCheXingList(String chexiId){
        List<VehicleInfo> chexingIdList = vehicleInfoService.loadCheXingList(chexiId);
        if(ListUtils.isEmpty(chexingIdList)){
            return new CommonResult(CodeConstant.ERROR_DATA, "未查询出任何数据");
        }
        return new CommonResult(chexingIdList);
    }

    @ApiOperation(value = "根据车系id加载对应的级别数据集合")
    @ApiImplicitParam(name = "chexiId", value = "车系id", required = true, dataType="String")
    @Log(operationName = "根据车系id加载对应的级别数据集合")
    @RequestMapping(value = "loadJibieList")
    @ResponseBody
    public CommonResult loadJibieList(String chexiId){
        List<String> jibieList = vehicleInfoService.loadJibieList(chexiId);
        if(ListUtils.isEmpty(jibieList)){
            return new CommonResult(CodeConstant.ERROR_DATA, "未查询出任何数据");
        }
        return new CommonResult(jibieList);
    }

    @ApiOperation(value = "二手车项目查询车型数据")
    @Log(operationName = "二手车项目查询车型数据")
    @RequestMapping(value = "findAllForAppraisal")
    @ResponseBody
    public CommonResult<Map<String, Map<String, List<VehicleInfo>>>> findAllForAppraisal(String chexi){
        Map<String, Map<String, List<VehicleInfo>>> map = vehicleInfoService.findAllForAppraisal(chexi);
        return new CommonResult<>(map);
    }

    @ApiOperation(value = "二手车项目查询车详情")
    @Log(operationName = "二手车项目查询车详情")
    @RequestMapping(value = "findDetailForAppraisal")
    @ResponseBody
    public CommonResult<FindDetailForAppraisalRespVO> findDetailForAppraisal(String id){
        FindDetailForAppraisalRespVO respVO = vehicleInfoService.findDetailForAppraisal(id);
        return new CommonResult<>(respVO);
    }
}