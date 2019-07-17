/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.entity.ExamUser;
import com.jeesite.modules.common.utils.UserUtils;
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
import com.jeesite.modules.aa.entity.CalculateDepreciation;
import com.jeesite.modules.aa.service.CalculateDepreciationService;

/**
 * 折旧率估值法Controller
 *
 * @author chenlitao
 * @version 2019-07-05
 */
@Controller
@RequestMapping(value = "${adminPath}/aa/calculateDepreciation")
public class CalculateDepreciationController extends BaseController {

    @Autowired
    private CalculateDepreciationService calculateDepreciationService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public CalculateDepreciation get(String id, boolean isNewRecord) {
        return calculateDepreciationService.get(id, isNewRecord);
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = {"list", ""})
    public String list(CalculateDepreciation calculateDepreciation, Model model) {
        model.addAttribute("calculateDepreciation", calculateDepreciation);
        return "modules/aa/calculateDepreciationList";
    }

    /**
     * 查询列表数据
     */
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<CalculateDepreciation> listData(CalculateDepreciation calculateDepreciation, HttpServletRequest request, HttpServletResponse response) {
        calculateDepreciation.setPage(new Page<>(request, response));
        Page<CalculateDepreciation> page = calculateDepreciationService.findPage(calculateDepreciation);
        return page;
    }

    /**
     * 查看编辑表单
     */
    @RequestMapping(value = "form")
    public String form(CalculateDepreciation calculateDepreciation, Model model) {
        model.addAttribute("calculateDepreciation", calculateDepreciation);
        return "modules/aa/calculateDepreciationForm";
    }

    /**
     * 保存折旧率估值法
     */
    @PostMapping(value = "save")
    @ResponseBody
    public String save(@Validated CalculateDepreciation calculateDepreciation) {
        calculateDepreciationService.save(calculateDepreciation);
        return renderResult(Global.TRUE, text("保存折旧率估值法成功！"));
    }

    /**
     * 删除折旧率估值法
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(CalculateDepreciation calculateDepreciation) {
        calculateDepreciationService.delete(calculateDepreciation);
        return renderResult(Global.TRUE, text("删除折旧率估值法成功！"));
    }

    /**
     * 计算
     */
    @RequestMapping(value = "calculate")
    @ResponseBody
    public CommonResult calculate(CalculateDepreciation calculateDepreciation) {
        ExamUser examUser = UserUtils.getExamUser();
        calculateDepreciation = calculateDepreciationService.calculate(calculateDepreciation, examUser);
        CommonResult result = new CommonResult();
        result.setData(calculateDepreciation);
        return result;
    }
}