/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.aa.entity.CheckBodySkeleton;
import com.jeesite.modules.aa.entity.IdentifyTec;
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
import com.jeesite.modules.aa.entity.IdentifyTecDetail;
import com.jeesite.modules.aa.service.IdentifyTecDetailService;

import java.util.List;

/**
 * 鉴定技术状况详情Controller
 *
 * @author lvchangwei
 * @version 2019-07-04
 */
@Controller
@RequestMapping(value = "${adminPath}/aa/identifyTecDetail")
public class IdentifyTecDetailController extends BaseController {

    @Autowired
    private IdentifyTecDetailService identifyTecDetailService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public IdentifyTecDetail get(String id, boolean isNewRecord) {
        return identifyTecDetailService.get(id, isNewRecord);
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = {"list", ""})
    public String list(IdentifyTecDetail identifyTecDetail, Model model) {
        model.addAttribute("identifyTecDetail", identifyTecDetail);
        return "modules/aa/identifyTecDetailList";
    }

    /**
     * 查询列表数据
     */
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<IdentifyTecDetail> listData(IdentifyTecDetail identifyTecDetail, HttpServletRequest request, HttpServletResponse response) {
        identifyTecDetail.setPage(new Page<>(request, response));
        Page<IdentifyTecDetail> page = identifyTecDetailService.findPage(identifyTecDetail);
        return page;
    }

    /**
     * 查看编辑表单
     */
    @RequestMapping(value = "form")
    public String form(IdentifyTecDetail identifyTecDetail, Model model) {
        model.addAttribute("identifyTecDetail", identifyTecDetail);
        return "modules/aa/identifyTecDetailForm";
    }

    /**
     * 保存鉴定技术状况详情
     */
    @PostMapping(value = "save")
    @ResponseBody
    public String save(@Validated IdentifyTecDetail identifyTecDetail) {
        identifyTecDetailService.save(identifyTecDetail);
        return renderResult(Global.TRUE, text("保存鉴定技术状况详情成功！"));
    }

    /**
     * 删除鉴定技术状况详情
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(IdentifyTecDetail identifyTecDetail) {
        identifyTecDetailService.delete(identifyTecDetail);
        return renderResult(Global.TRUE, text("删除鉴定技术状况详情成功！"));
    }

    /**
     * 加载鉴定技术状况检查项数据
     */
    @RequestMapping(value = "findData")
    @ResponseBody
    public CommonResult findList(IdentifyTec identifyTec) {
        ExamUser examUser = UserUtils.getExamUser();
        identifyTec = identifyTecDetailService.findData(identifyTec, examUser);
        CommonResult result = new CommonResult();
        result.setData(identifyTec);
        return result;
    }
}