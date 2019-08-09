/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.entity.Page;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.service.CrudService;
import com.jeesite.common.utils.jwt.JwtUtils;
import com.jeesite.modules.common.dao.CommonRoleDao;
import com.jeesite.modules.common.dao.CommonUserDao;
import com.jeesite.modules.common.entity.*;
import com.jeesite.modules.common.vo.LoginVO;
import com.jeesite.modules.common.vo.StuSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * common_userService
 *
 * @author lvchangwei
 * @version 2019-07-16
 */
@Service
@Transactional(readOnly = true)
public class CommonUserService extends CrudService<CommonUserDao, CommonUser> {

    @Autowired
    private CommonUserDao commonUserDao;
    @Autowired
    private CommonRoleDao commonRoleDao;

    /**
     * 获取单条数据
     *
     * @param commonUser
     * @return
     */
    @Override
    public CommonUser get(CommonUser commonUser) {
        return super.get(commonUser);
    }

    /**
     * 查询分页数据
     *
     * @param commonUser      查询条件

     * @return
     */
    @Override
    public Page<CommonUser> findPage(CommonUser commonUser) {
        return super.findPage(commonUser);
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param commonUser
     */
    @Override
    @Transactional(readOnly = false)
    public void save(CommonUser commonUser) {
        super.save(commonUser);
    }

    /**
     * 更新状态
     *
     * @param commonUser
     */
    @Override
    @Transactional(readOnly = false)
    public void updateStatus(CommonUser commonUser) {
        super.updateStatus(commonUser);
    }

    /**
     * 删除数据
     *
     * @param commonUser
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(CommonUser commonUser) {
        super.delete(commonUser);
    }

    /**
     * 依据用户名查找用户信息 getByEntity
     */
    @Transactional(readOnly = false)
    public CommonUser getByEntity(CommonUser user) {
        return dao.getByEntity(user);
    }


    /**
     * 保存数据（插入或更新）
     *
     * @param commonUser
     */

    @Transactional(readOnly = false)
    public CommonResult addCommonUser(CommonUser commonUser) {
        if(StringUtils.isBlank(commonUser.getId())){
            commonUser.setPassword("123456");
            CommonUser con = new CommonUser();
            con.setUserName(commonUser.getUserName());
            List<CommonUser> exist = super.findList(con);
            if(exist!=null&&exist.size()>0){
                return new CommonResult(CodeConstant.USER_EXIST, commonUser.getUserName()+"已存在！");
            }
        }
        super.save(commonUser);
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
    }

    @Transactional
    public CommonResult saveUserList(List<CommonUser> userList, String roleId){
        if(ListUtils.isEmpty(userList)){
            return new CommonResult(CodeConstant.EXCEL_NO_DATA, "您上传的excel没有数据，请检查");
        }
        int okNum = 0;
        int errorNum = 0;
        String msg = "";
        for (CommonUser user: userList) {
            user.setPassword("123456");
            CommonUser con = new CommonUser();
            con.setUserName(user.getUserName());
            List<CommonUser> exist = super.findList(con);
            if(exist!=null&&exist.size()>0){
                msg += user.getUserName()+"已存在！<br/>";
                errorNum++;
            }else{
                if(user.getUserName().trim().length()!=18){
                    msg += user.getUserName()+"长度不是18！<br/>";
                    errorNum++;
                }else{
                    user.setRoleId(roleId);
                    super.save(user);
                    okNum++;
                }
            }
        }
        JSONObject jo = new JSONObject();
        jo.put("successNum", okNum);
        jo.put("errorNum", errorNum);
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, msg, jo);
    }

    @Transactional(readOnly = false)
    public CommonResult resetPass(String id) {
        String loginUserId = PreEntity.getUserIdByToken();
        CommonUser loginUser = super.get(loginUserId);
        if(loginUser.getRoleId().equals("1")&&id.equals(loginUserId)){ // 管理员不能给自己重置密码
            return new CommonResult(CodeConstant.ERROR_DATA, "您无权执行该操作！");
        }
        CommonUser commonUser = super.get(id);
        if(loginUser.getRoleId().equals("1")){ // 管理员可以重置所有密码
            commonUser.setPassword("123456");
            super.update(commonUser);
            return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
        }else if(loginUser.getRoleId().equals("2")){ // 教师可以重置密码
            if(loginUser.getSchoolId().equals(commonUser.getSchoolId())){ // 教师该校的教师才能重置该校的密码
                commonUser.setPassword("123456");
                super.update(commonUser);
                return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
            }else{
                return new CommonResult(CodeConstant.ERROR_DATA, "您无权执行该操作！");
            }
        }else{ // 学生不能执行重置密码的操作
            return new CommonResult(CodeConstant.ERROR_DATA, "您无权执行该操作！");
        }


    }

    @Transactional(readOnly = false)
    public CommonResult changeRight(String id, Integer isExamRight){
        CommonUser commonUser = super.get(id);
        String loginUserId = PreEntity.getUserIdByToken();
        CommonUser loginUser = super.get(loginUserId);
        if(loginUser.getRoleId().equals("1")&&commonUser.getRoleId().equals("2")){ // 只有超管才能给教师开启考试权限
            commonUser.setIsExamRight(isExamRight);
            super.update(commonUser);
            return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
        }else{
            return new CommonResult(CodeConstant.ERROR_DATA, "您无权修改该数据！");
        }

    }

    @Transactional(readOnly = false)
    public CommonResult deleteCommonUser(String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        Integer length =jsonObject.getInteger("length");
        JSONArray ja = JSONArray.parseArray(jsonObject.getString("datas"));
        for (int i = 0; i < length; i++) {
            String id = ja.getString(i);
            super.delete(this.get(id));
        }
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
    }


    public CommonResult teacherSideLogin(LoginVO vo){
        CommonResult result = new CommonResult();
        String userName = vo.getUserName();
        String password = vo.getPassword();
        CommonUser user = commonUserDao.findByUserName(userName);
        if(user==null){
            return new CommonResult(CodeConstant.INCORRECT_USER_NAME_OR_PASSWORD, "用户名或密码不正确");
        }else{
            if(user.getRoleId().equals("1")){
                result.setCode(CodeConstant.INCORRECT_USER_NAME_OR_PASSWORD);
                result.setMsg("用户名或密码不正确");
                return result;
            }
            if (null == user || !password.equals(user.getPassword())) {
                result.setCode(CodeConstant.INCORRECT_USER_NAME_OR_PASSWORD);
                result.setMsg("用户名或密码不正确");
                return result;
            }
            user.setToken(JwtUtils.generateToken(user.getId()));
            result.setData(user);

            result.setCode(CodeConstant.REQUEST_SUCCESSFUL);
            return result;
        }
    }



    /**
     * 登录
     *
     * @param vo
     * @return
     */
    public CommonResult login(LoginVO vo) {
        CommonResult result = new CommonResult();
        String userName = vo.getUserName();
        String password = vo.getPassword();
        //登录入口标识
        //int flag = vo.getFlag();

//        CommonUser user = new CommonUser();
//
//        user.setUserName(userName);

        CommonUser user = commonUserDao.findByUserName(userName);

        if (null == user || !password.equals(user.getPassword())) {
            result.setCode(CodeConstant.INCORRECT_USER_NAME_OR_PASSWORD);
            result.setMsg("用户名或密码不正确");
            return result;
        }

        //HttpSession session = ServletUtils.getRequest().getSession();
       // session.setAttribute("flag", flag);
        result.setCode(CodeConstant.REQUEST_SUCCESSFUL);

        CommonRole crCon = new CommonRole();
        crCon.setId(user.getRoleId());;
        CommonRole cr = commonRoleDao.getByEntity(crCon);

        user.setRoleArray(cr.getRightArray());
        user.setToken(JwtUtils.generateToken(user.getId()));
        user.setPassword(null);
        result.setData(user);
        return result;
    }

    public CommonResult loadStuListInPlatform(StuSearchVO vo){
        CommonResult result = new CommonResult();
        if(vo.getCommonUserId()!=null&&vo.getExamOrPractice()!=null){
            CommonUser commonUser = super.get(vo.getCommonUserId());
            if(vo.getExamOrPractice().equals("exam")){
                List<CommonUser> commonUserList = commonUserDao.findAssessmentStu(commonUser.getSchoolId(),
                        vo.getAssessmentId(), vo.getAssessmentDate(), vo.getAssessmentTime());
                result.setCode(CodeConstant.REQUEST_SUCCESSFUL);
                result.setData(commonUserList);
            }else{
                List<CommonUser> commonUserList = commonUserDao.findNormalStu(commonUser.getSchoolId());
                result.setCode(CodeConstant.REQUEST_SUCCESSFUL);
                result.setData(commonUserList);
            }
        }else{
            result.setCode(CodeConstant.PARA_MUST_NEED);
            result.setMsg("commonUserId或者examOrPractice");
        }
        return result;
    }

    public CommonResult loadStuListByIds(String ids){
        String[] isArray = ids.split(",");
        List<String> idList = Arrays.asList(isArray);
//        CommonUser con = new CommonUser();
//        con.setId_in(isArray);
        List<CommonUser> list = this.commonUserDao.findStuByIdsWithSchoolName(idList);

        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, list);
    }

    public CommonResult fillUserConditionList(List<UserCondition> userConditionList){
        List<String> userNameList = new ArrayList<>();
        for (UserCondition userCondition:userConditionList ) {
            userNameList.add(userCondition.getUserName());
        }
        List<CommonUser> userList = this.commonUserDao.findStuByUserNamesWithSchoolName(userNameList);
        if(ListUtils.isEmpty(userList)){
            return new CommonResult(CodeConstant.EXCEL_NO_DATA, "没有查询到任何数据");
        }
        for (UserCondition userCondition:userConditionList ) {
            for (CommonUser commonUser:userList) {
                if(userCondition.getUserName().equals(commonUser.getUserName())){
                    userCondition.setClassName(commonUser.getClassName());
                    userCondition.setMajorName(commonUser.getMajorName());
                    userCondition.setSchoolName(commonUser.getSchoolName());
                    userCondition.setGender(commonUser.getGender());
                    userCondition.setCommonUserId(commonUser.getId());
                    userCondition.setSchoolId(commonUser.getSchoolId());
                    break;
                }
            }
        }
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, userConditionList);
    }
}