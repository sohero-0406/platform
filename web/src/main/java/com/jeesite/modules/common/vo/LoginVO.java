package com.jeesite.modules.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "登录模型")
public class LoginVO {

    //用户名
    private String userName;
    //密码
    private String password;
    //登录入口标识 1-学生端前台 2-教师端前台 3-教师端后台
    private int flag;

    @ApiModelProperty(value = "用户名", required = true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ApiModelProperty(value = "密码", required = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
