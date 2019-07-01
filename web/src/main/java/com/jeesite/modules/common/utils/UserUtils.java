package com.jeesite.modules.common.utils;

import com.jeesite.common.web.http.ServletUtils;
import com.jeesite.modules.common.entity.ExamUser;

import javax.servlet.http.HttpServletRequest;

/**
 * 获得前台、后台登录用户对象工具类
 *
 * @author lvchangwei
 * @version 2019-07-01
 */
public class UserUtils {
    public static ExamUser getExamUser() {
        HttpServletRequest request = ServletUtils.getRequest();
        ExamUser examUser = (ExamUser) request.getSession().getAttribute("examUser");
        if (null == examUser) {
            examUser = new ExamUser();
            examUser.setId("1");
            examUser.setUserId("1");
            examUser.setPaperId("1");
        }
        return examUser;
    }
}