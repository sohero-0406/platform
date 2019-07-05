/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.aa.entity.*;
import com.jeesite.modules.aa.service.*;
import com.jeesite.modules.aa.vo.CalculateVO;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.entity.Exam;
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

import java.util.List;

/**
 * 计算车辆价值Controller
 * @author chenlitao
 * @version 2019-07-04
 */
@Controller
@RequestMapping(value = "${adminPath}/aa/calculate")
public class CalculateController extends BaseController {
	//?todo 暂时写死
	private final static  String EXAM_USER_ID = "11";
	@Autowired
	private CalculateService calculateService;
	@Autowired
	private CalculateDepreciationService calculateDepreciationService;
	@Autowired
	private CalculateReplaceCostService calculateReplaceCostService;
	@Autowired
	private CalculateKmService calculateKmService;
	@Autowired
	private CalculateCurrentService calculateCurrentService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Calculate get(String id, boolean isNewRecord) {
		return calculateService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(Calculate calculate, Model model) {
		model.addAttribute("calculate", calculate);
		return "modules/aa/calculateList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Calculate> listData(Calculate calculate, HttpServletRequest request, HttpServletResponse response) {
		calculate.setPage(new Page<>(request, response));
		Page<Calculate> page = calculateService.findPage(calculate);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(Calculate calculate, Model model) {
		model.addAttribute("calculate", calculate);
		return "modules/aa/calculateForm";
	}

	/**
	 * 保存计算车辆价值
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Calculate calculate) {
		calculateService.save(calculate);
		return renderResult(Global.TRUE, text("保存计算车辆价值成功！"));
	}
	
	/**
	 * 删除计算车辆价值
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Calculate calculate) {
		calculateService.delete(calculate);
		return renderResult(Global.TRUE, text("删除计算车辆价值成功！"));
	}

	/**
	 * 获取车辆评估价值算法
	 * @return
	 */
	@PostMapping(value = "get")
	@ResponseBody
	public CommonResult get(String id){
		CommonResult comRes = new CommonResult();
		CalculateVO calculateVO = new CalculateVO();
		Calculate calculate = null;
		if(id != null && id.trim().length() > 0){
			calculate = calculateService.get(id);

			switch (calculate.getType()){
				case "1"://折旧率估值法
					CalculateDepreciation cd = new CalculateDepreciation();
					cd.setCalculateId(id);
					calculateVO.setCalculateDepreciation(calculateDepreciationService.get(cd));
					break;
				case "2"://公里数估值法
					CalculateKm calculateKm = new CalculateKm();
					calculateKm.setCalculateId(id);
					calculateVO.setCalculateKm(calculateKmService.get(calculateKm));
					break;
				case "3"://重置成本法
					CalculateReplaceCost crc = new CalculateReplaceCost();
					crc.setCalculateId(id);
					calculateVO.setCalculateReplaceCost(calculateReplaceCostService.get(crc));
					break;
				case "4"://现行市价法
					CalculateCurrent cc = new CalculateCurrent();
					cc.setCalculateId(id);
					calculateVO.setCalculateCurrent(calculateCurrentService.get(cc));
					break;
			}
		}
		calculateVO.setCalculate(calculate);
		comRes.setData(calculateVO);
		return comRes;
	}
}