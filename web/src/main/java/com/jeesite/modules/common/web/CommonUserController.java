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
import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.entity.CommonUser;
import com.jeesite.modules.common.entity.TestUser;
import com.jeesite.modules.common.entity.UserCondition;
import com.jeesite.modules.common.service.CommonUserService;
import com.jeesite.modules.common.vo.DeleteVO;
import com.jeesite.modules.common.vo.LoginVO;
import com.jeesite.modules.common.vo.StuSearchVO;
import com.jeesite.modules.job.p.C;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
//    @ModelAttribute
//    public CommonUser get(String id, boolean isNewRecord) {
//        return commonUserService.get(id, isNewRecord);
//    }

    /**
     * 检测方法
     * @return
     */
    @Log(operationName = "检测方法", operationType = Log.OPERA_TYPE_OTHER)
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
     * 保存common_user 此方法不用
     */
    @Log(operationName = "保存common_user", operationType = Log.OPERA_TYPE_ADD_OR_UPD)
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

    /**
     * 根据id加载用户
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id加载用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataTypeClass = String.class)
    @Log(operationName = "根据id加载用户")
    @RequestMapping(value = "loadCommonUser")
    @ResponseBody
    public CommonResult loadCommonUser(String id) {
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, commonUserService.get(id));
    }

    /**
     * 保存common_user
     * @param commonUser
     * @return
     */
    @ApiOperation(value = "保存用户信息")
    @ApiImplicitParam(name = "commonUser", value = "用户的对象", required = true, dataType = "CommonUser")
    @Log(operationName = "保存common_user", operationType = Log.OPERA_TYPE_ADD_OR_UPD)
    @RequestMapping(value = "addUser")
    @ResponseBody
    public CommonResult addUser(CommonUser commonUser) {

        return commonUserService.addCommonUser(commonUser);
    }

    /**
     * 根据json删除用户
     * @param json
     * @return
     */
    @ApiOperation(value = "根据json删除用户")
    @ApiImplicitParam(name = "json", value = "删除信息的json数据", required = true, dataType = "String")
    @Log(operationName = "根据json删除用户", operationType = Log.OPERA_TYPE_DEL)
    @RequestMapping(value = "deleteUser")
    @ResponseBody
    public CommonResult deleteUser(String json) {

        return commonUserService.deleteCommonUser(json);
    }

//    @RequestMapping(value = "deleteUserByVO")
//    @ResponseBody
//    public CommonResult deleteUserByVO(DeleteVO deleteVO) {
//
//        System.out.println("1111");
//
//
//        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
//    }

    /**
     * 加载分页用户信息
     * @param commonUser
     * @return
     */
    @Log(operationName = "加载分页用户信息")
    @RequestMapping(value = "listCommonUser")
    @ResponseBody
    public CommonResult listCommonUser(CommonUser commonUser) {
        Page<CommonUser> page = commonUserService.findPage(commonUser);
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, page);
    }

    /**
     * 根据id重置密码
     * @param id
     * @return
     */
    @Log(operationName = "根据id重置密码", operationType = Log.OPERA_TYPE_UPD)
    @RequestMapping(value = "resetPass")
    @ResponseBody
    public CommonResult resetPass(String id) {
        return  commonUserService.resetPass(id);
    }

    /**
     * 更改考试权限
     * @param id
     * @param isExamRight
     * @return
     */
    @Log(operationName = "更改考试权限", operationType = Log.OPERA_TYPE_UPD)
    @RequestMapping(value = "changeRight")
    @ResponseBody
    public CommonResult changeRight(String id, String isExamRight) {
        return  commonUserService.changeRight(id, isExamRight);
    }

    /**
     * 用户登录功能
     */
    @ApiOperation(value = "大后台前端登录", notes = "根据用户名和密码来判断是否登录")
    @ApiImplicitParam(name = "vo", value = "登录模型", required = true, dataTypeClass = LoginVO.class)
    @Log(operationName = "登录")
    @RequestMapping(value = "login")
    @ResponseBody
    public CommonResult login(LoginVO vo) {
        return commonUserService.login(vo);
    }

    /**
     * 用户注销
     */
    @ApiOperation(value = "大后台前端注销")
    @Log(operationName = "注销", operationType = Log.OPERA_TYPE_OTHER)
    @RequestMapping(value = "logout")
    @ResponseBody
    public CommonResult logout() {
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
    }

    /**
     * 根据token加载用户信息
     * @return
     */
    @ApiOperation(value = "根据token加载用户信息", notes = "在token解析出用户id，再记载数据后返回")
    @Log(operationName = "根据token加载用户信息")
    @RequestMapping(value = "loadUserByToken")
    @ResponseBody
    public CommonResult loadUserByToken() {
        return commonUserService.loadUserByToken();
    }

    /**
     * 教师端登录
     * @param vo
     * @return
     */
    @ApiOperation(value = "教师端登录", notes = "根据用户名和密码来判断是否登录")
    @ApiImplicitParam(name = "vo", value = "登录模型", required = true, dataType = "LoginVO")
    @Log(operationName = "教师端登录")
    @RequestMapping(value = "teacherSideLogin")
    @ResponseBody
    public CommonResult teacherSideLogin(LoginVO vo) {
        return commonUserService.teacherSideLogin(vo);
    }

    /**
     * 加载平台中的学生
     * @param vo
     * @return
     */
    @ApiOperation(value = "加载平台中的学生", notes = "根据查询对象里的数据进行加载")
    @ApiImplicitParam(name = "vo", value = "学生查询模型", required = true, dataType = "StuSearchVO")
    @Log(operationName = "加载平台中的学生")
    @RequestMapping(value = "loadStuListInPlatform")
    @ResponseBody
    public CommonResult loadStuListInPlatform(StuSearchVO vo) {
        return commonUserService.loadStuListInPlatform(vo);
    }

    /**
     * 加载专业列表
     * @param commonUserId
     * @return
     */
    @ApiOperation(value = "加载专业列表", notes = "根据登录的id夹杂对应学校的专业列表")
    @ApiImplicitParam(name = "commonUserId", value = "登录的用户id", required = true, dataTypeClass = String.class)
    @Log(operationName = "加载专业列表")
    @RequestMapping(value = "loadMajorList")
    @ResponseBody
    public CommonResult loadMajorList(String commonUserId){ return commonUserService.loadMajorList(commonUserId); }

    /**
     * 加载班级列表
     * @param commonUserId
     * @param majorName
     * @return
     */
    @ApiOperation(value = "加载班级列表", notes = "根据登录的id夹杂对应学校的专业列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "commonUserId", value = "登录的用户id", required = true, dataTypeClass = String.class),
        @ApiImplicitParam(name = "majorName", value = "专业个名称", dataTypeClass = String.class)
    })
    @Log(operationName = "加载班级列表")
    @RequestMapping(value = "loadClassList")
    @ResponseBody
    public CommonResult loadClassList(String commonUserId, String majorName){ return commonUserService.loadClassList(commonUserId, majorName); }

    /**
     * 根据多个id加载学生信息
     * @param ids
     * @return
     */
    @Log(operationName = "根据多个id加载学生信息")
    @RequestMapping(value = "loadStuListByIds")
    @ResponseBody
    public CommonResult loadStuListByIds(String ids){
        return commonUserService.loadStuListByIds(ids);
    }

    /**
     * 根据上传的excel中的身份证数据加载学生信息
     * @param file
     * @return
     * @throws Exception
     */
    @Log(operationName = "根据上传的excel中的身份证数据加载学生信息")
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

    /**
     * 根据服务器考生信息加载学生信息
     * @param examUserIds
     * @return
     */
    @Log(operationName = "根据服务器考生信息加载学生信息")
    @RequestMapping(value = "loadStuListByExamUserIds")
    @ResponseBody
    public CommonResult loadStuListByExamUserIds(String examUserIds) {
        return commonUserService.loadStuListByExamUserIds(examUserIds);
    }

    /**
     * token过期的跳转接口
     * @return
     */
    @Log(operationName = "token过期的跳转接口", operationType = Log.OPERA_TYPE_OTHER)
    @RequestMapping(value = "tokenExpired")
    @ResponseBody
    public CommonResult tokenExpired(){
        return new CommonResult(CodeConstant.TOKEN_EXPIRED, "登录过期");
    }

    /**
     * 未登录的跳转接口
     * @return
     */
    @Log(operationName = "未登录的跳转接口", operationType = Log.OPERA_TYPE_OTHER)
    @RequestMapping(value = "unLogin")
    @ResponseBody
    public CommonResult unLogin(){
        return new CommonResult(CodeConstant.NO_LOGIN, "您未登录!");
    }

    /**
     * 导出用户模板
     * @param response
     */
    @Log(operationName = "导出用户模板", operationType = Log.OPERA_TYPE_OTHER)
    @RequestMapping(value = "commonUserDemoExport")
    public void commonUserDemoExport(HttpServletResponse response) {
        try {
            String fileName = "人员信息导入模板.xlsx";
            List<CommonUser> list = Lists.newArrayList();
            list.add(new CommonUser());
            new ExcelExport("人员信息", CommonUser.class, ExcelField.Type.EXPORT).setDataList(list).write(response, fileName).close();
        } catch (Exception e) {
            // addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
        }
    }

    /**
     * 导入用户
     * @param file
     * @param roleId
     * @return
     */
    @Log(operationName = "导入用户", operationType = Log.OPERA_TYPE_ADD)
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