/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.common.web.http.ServletUtils;
import com.jeesite.modules.common.dao.CommonUserDao;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.entity.CommonUser;
import com.jeesite.modules.common.vo.LoginVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * common_userService
 *
 * @author lvchangwei
 * @version 2019-07-16
 */
@Service
@Transactional(readOnly = true)
public class CommonUserService extends CrudService<CommonUserDao, CommonUser> {

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
     * @param commonUser.page 分页对象
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
        int flag = vo.getFlag();

        CommonUser user = new CommonUser();
        //教师端前后端登录
        if (flag == 2 || flag == 3) {
            user.setUserName(userName);
            user = this.getByEntity(user);
            if (null == user || !password.equals(user.getPassword())) {
                result.setCode(CodeConstant.INCORRECT_USER_NAME_OR_PASSWORD);
                result.setMsg("用户名或密码不正确");
                return result;
            }
        }
        HttpSession session = ServletUtils.getRequest().getSession();
        session.setAttribute("flag", flag);
        //教师端前台
        if (flag == 2) {

        }
        //教师端后台
        if (flag == 3) {

        }
        return result;
    }
}