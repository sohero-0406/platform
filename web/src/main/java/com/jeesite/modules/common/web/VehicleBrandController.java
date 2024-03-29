/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import com.jeesite.common.config.Global;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.entity.VehicleBrand;
import com.jeesite.modules.common.service.VehicleBrandService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 车辆品牌表Controller
 *
 * @author chenlitao
 * @version 2019-07-04
 */
@Controller
@RequestMapping(value = "${adminPath}/common/vehicleBrand")
public class VehicleBrandController extends BaseController {

	@Autowired
	private VehicleBrandService vehicleBrandService;

	/**
	 * 获取数据
	 */
	@ModelAttribute
	public VehicleBrand get(String id, boolean isNewRecord) {
		return vehicleBrandService.get(id, isNewRecord);
	}

	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(VehicleBrand vehicleBrand, Model model) {
		model.addAttribute("vehicleBrand", vehicleBrand);
		return "modules/common/vehicleBrandList";
	}

	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<VehicleBrand> listData(VehicleBrand vehicleBrand, HttpServletRequest request, HttpServletResponse response) {
		vehicleBrand.setPage(new Page<>(request, response));
		Page<VehicleBrand> page = vehicleBrandService.findPage(vehicleBrand);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(VehicleBrand vehicleBrand, Model model) {
		model.addAttribute("vehicleBrand", vehicleBrand);
		return "modules/common/vehicleBrandForm";
	}

	/**
	 * 保存车辆品牌表
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated VehicleBrand vehicleBrand) {
		vehicleBrandService.save(vehicleBrand);
		return renderResult(Global.TRUE, text("保存车辆品牌表成功！"));
	}

	/**
	 * 删除车辆品牌表
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(VehicleBrand vehicleBrand) {
		vehicleBrandService.delete(vehicleBrand);
		return renderResult(Global.TRUE, text("删除车辆品牌表成功！"));
	}
	@PostMapping(value="findList")
    @ResponseBody
	public CommonResult findList(){
	    CommonResult comRes = new CommonResult();
	    VehicleBrand vehicleBrand = new VehicleBrand();
        List<VehicleBrand> vehicleBrandList = vehicleBrandService.findList(vehicleBrand);
        List<VehicleBrand> dataList = new ArrayList<>();

        for(VehicleBrand vb : vehicleBrandList){
			vehicleBrand = new VehicleBrand();
			vehicleBrand.setPinpaiId(vb.getPinpaiId());
			vehicleBrand.setShouzimu(vb.getShouzimu());
			vehicleBrand.setPinpai(vb.getPinpai());

			dataList.add(vehicleBrand);
		}
        comRes.setData(dataList);
	    return comRes;
    }

	@ApiOperation(value = "二手车项目查询车辆品牌")
	@RequestMapping(value = "findBrandList")
	@ResponseBody
	public CommonResult findBrandList(String brandString){
		CommonResult comRes = new CommonResult();
		VehicleBrand vehicleBrand = new VehicleBrand();
		List<VehicleBrand> vehicleBrandList = vehicleBrandService.findList(vehicleBrand);
		List<VehicleBrand> dataList1 = new ArrayList<>();
		List<VehicleBrand> dataList2 = new ArrayList<>();
		for (VehicleBrand vb : vehicleBrandList){
			vehicleBrand = new VehicleBrand();
			vehicleBrand.setPinpaiId(vb.getPinpaiId());
			vehicleBrand.setShouzimu(vb.getShouzimu());
			vehicleBrand.setPinpai(vb.getPinpai());
			// 修改为前端入参来控制，这样可以避免每次更新变动都需要更新大平台的问题
//			String brandString = "丰田，大众，别克，福特，日产，荣威，现代，雪佛兰，宝马，奔驰，广汽传祺，比亚迪";
			if (StringUtils.isNotBlank(brandString) && brandString.contains(vehicleBrand.getPinpai())){
				dataList1.add(vehicleBrand);
			}else{
				dataList2.add(vehicleBrand);
			}
		}
		dataList1.addAll(dataList2);
		comRes.setData(dataList1);
		return comRes;
	}


	@ApiOperation(value = "网约车项目查询车辆品牌")
	@RequestMapping(value = "findBrandListForWyc")
	@ResponseBody
	public CommonResult<List<VehicleBrand>> findBrandListForWyc(String shouzimu) {
		CommonResult<List<VehicleBrand>> comRes = new CommonResult<>();
		VehicleBrand vehicleBrand = new VehicleBrand();
		vehicleBrand.setShouzimu(shouzimu);
		List<VehicleBrand> vehicleBrandList = vehicleBrandService.findList(vehicleBrand);
		List<VehicleBrand> dataList1 = new ArrayList<>();
		List<VehicleBrand> dataList2 = new ArrayList<>();
		for (VehicleBrand vb : vehicleBrandList) {
			vehicleBrand = new VehicleBrand();
			vehicleBrand.setPinpaiId(vb.getPinpaiId());
			vehicleBrand.setShouzimu(vb.getShouzimu());
			vehicleBrand.setPinpai(vb.getPinpai());
			String brandString = "丰田，大众，别克，福特，吉利，荣威，现代，雪佛兰，宝马，奔驰，广汽传媒，比亚迪";
			if (brandString.contains(vehicleBrand.getPinpai())) {
				dataList1.add(vehicleBrand);
			} else {
				dataList2.add(vehicleBrand);
			}
		}
		dataList1.addAll(dataList2);
		comRes.setData(dataList1.stream().sorted(Comparator.comparing(VehicleBrand::getShouzimu)).collect(Collectors.toList()));
		return comRes;
	}


	/**
	 * 查询实体
	 */
	@RequestMapping(value = "getByEntity")
	@ResponseBody
	public CommonResult getByEntity(VehicleBrand vehicleBrand) {
		vehicleBrand = vehicleBrandService.getByEntity(vehicleBrand);
		return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, vehicleBrand);
	}
}