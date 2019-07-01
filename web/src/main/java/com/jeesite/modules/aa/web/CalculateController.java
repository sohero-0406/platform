/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.test.entity.TestData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.aa.entity.Calculate;
import com.jeesite.modules.aa.service.CalculateService;

/**
 * 计算车辆价值Controller
 *
 * @author lvchangwei
 * @version 2019-06-25
 */
@Controller
@RequestMapping(value = "${adminPath}/aa/calculate")
public class CalculateController extends BaseController {

    @Autowired
    private CalculateService calculateService;

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
    @GetMapping(value = "save")
    @ResponseBody
    public String save(@Validated Calculate calculate, HttpServletRequest request) {

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

}