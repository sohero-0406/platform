/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import com.google.common.collect.Lists;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.config.Global;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.entity.Page;
import com.jeesite.common.utils.excel.ExcelExport;
import com.jeesite.common.utils.excel.ExcelImport;
import com.jeesite.common.utils.excel.annotation.ExcelField;
import com.jeesite.common.utils.test.Test;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.entity.CommonUser;
import com.jeesite.modules.common.entity.TestUser;
import com.jeesite.modules.common.entity.UserCondition;
import com.jeesite.modules.common.service.CommonUserService;
import com.jeesite.modules.common.vo.LoginVO;
import com.jeesite.modules.common.vo.StuSearchVO;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * common_userController
 *
 * @author lvchangwei
 * @version 2019-07-16
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonUser")
public class CommonUserController extends BaseController {

    @Autowired
    private CommonUserService commonUserService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public CommonUser get(String id, boolean isNewRecord) {
        return commonUserService.get(id, isNewRecord);
    }

    @RequestMapping(value = "hello")
    @ResponseBody
    public CommonResult hello() {
        return new CommonResult();
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = {"list", ""})
    public String list(CommonUser commonUser, Model model) {
        model.addAttribute("commonUser", commonUser);
        return "modules/common/commonUserList";
    }

    /**
     * 查询列表数据
     */
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<CommonUser> listData(CommonUser commonUser, HttpServletRequest request, HttpServletResponse response) {
        commonUser.setPage(new Page<>(request, response));
        Page<CommonUser> page = commonUserService.findPage(commonUser);
        return page;
    }

    /**
     * 查看编辑表单
     */
    @RequestMapping(value = "form")
    public String form(CommonUser commonUser, Model model) {

        model.addAttribute("commonUser", commonUser);
        return "modules/common/commonUserForm";
    }

    /**
     * 保存common_user
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public CommonResult save(CommonUser commonUser) {
        commonUserService.save(commonUser);
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
    }

    /**
     * 删除common_user
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(CommonUser commonUser) {


        commonUserService.delete(commonUser);
        return renderResult(Global.TRUE, text("删除common_user成功！"));
    }


    @RequestMapping(value = "loadCommonUser")
    @ResponseBody
    public CommonResult loadCommonUser(String id) {
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, commonUserService.get(id));
    }

    @RequestMapping(value = "addUser")
    @ResponseBody
    public CommonResult addUser(CommonUser commonUser) {
        //commonUser.setCreateBy("999");
        return commonUserService.addCommonUser(commonUser);
    }

    @RequestMapping(value = "deleteUser")
    @ResponseBody
    public CommonResult deleteUser(String json) {

        return commonUserService.deleteCommonUser(json);
    }


    @RequestMapping(value = "listCommonUser")
    @ResponseBody
    public CommonResult listCommonUser(CommonUser commonUser) {
        Page<CommonUser> page = commonUserService.findPage(commonUser);
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, page);
    }

    @RequestMapping(value = "resetPass")
    @ResponseBody
    public CommonResult resetPass(String id) {

        return  commonUserService.resetPass(id);
    }

    @RequestMapping(value = "changeRight")
    @ResponseBody
    public CommonResult changeRight(String id, Integer isExamRight) {

        return  commonUserService.changeRight(id, isExamRight);
    }





    /**
     * 用户登录功能
     */

    /**
     * 删除common_user
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public CommonResult login(LoginVO vo) {
        return commonUserService.login(vo);
    }




    @RequestMapping(value = "teacherSideLogin")
    @ResponseBody
    public CommonResult teacherSideLogin(LoginVO vo) {
        return commonUserService.teacherSideLogin(vo);
    }

    // @RequestMapping(value)

    @RequestMapping(value = "loadStuListInPlatform")
    @ResponseBody
    public CommonResult loadStuListInPlatform(StuSearchVO vo) {
        return commonUserService.loadStuListInPlatform(vo);
    }

    @RequestMapping(value = "loadStuListByIds")
    @ResponseBody
    public CommonResult loadStuListByIds(String ids){
        return commonUserService.loadStuListByIds(ids);
    }

    @RequestMapping(value = "loadStuListByIDstr")
    @ResponseBody
    public CommonResult loadStuListByIDstr(MultipartFile file) throws Exception {
        ExcelImport ei = new ExcelImport(file, 2, 0);
        List<UserCondition> userConditionList = ei.getDataList(UserCondition.class);

        ei.close();
        if(ListUtils.isEmpty(userConditionList)){
            return new CommonResult(CodeConstant.EXCEL_NO_DATA, "您上传的excel没有数据");
        }

        return commonUserService.fillUserConditionList(userConditionList);
    }


    @RequestMapping(value = "tokenExpired")
    @ResponseBody
    public CommonResult tokenExpired(){
        return new CommonResult(CodeConstant.TOKEN_EXPIRED, "登录过期");
    }


    @RequestMapping(value = "unLogin")
    @ResponseBody
    public CommonResult unLogin(){
        return new CommonResult(CodeConstant.NO_LOGIN, "您未登录!");
    }

    @RequestMapping(value = "commonUserDemoExport")
    public void commonUserDemoExport(HttpServletResponse response, RedirectAttributes redirectAttributes) {
        try {
            String fileName = "人员信息导入模板.xlsx";
            List<CommonUser> list = Lists.newArrayList();
            list.add(new CommonUser());
            new ExcelExport("人员信息", CommonUser.class, ExcelField.Type.EXPORT).setDataList(list).write(response, fileName).close();
        } catch (Exception e) {
            // addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
        }
    }

    @RequestMapping(value = "importUsers", method= RequestMethod.POST)
    @ResponseBody
    public CommonResult importUsers(MultipartFile file, String roleId){
        try {
            ExcelImport ei = new ExcelImport(file, 2, 0);
            List<CommonUser> userList = ei.getDataList(CommonUser.class);
            ei.close();
            System.out.println(userList.toString());
            return commonUserService.saveUserList(userList, roleId);
        } catch (Exception e) {

        }
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
    }


    @RequestMapping(value = "testExportExcel")
    public void importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
        try {
            String fileName = "人员信息导入模板.xlsx";

            List<TestUser> list = Lists.newArrayList();
            list.add(new TestUser());
            new ExcelExport("人员信息", TestUser.class, ExcelField.Type.EXPORT).setDataList(list).write(response, fileName).close();
            // new ExcelExport("人员信息", TestUser.class, 2).setDataList(list).write(response, fileName).dispose();
// null;
        } catch (Exception e) {
            // addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
        }
        //return "redirect:" + Global.getAdminPath() + "/basic/personInfo/?repage";
    }



}