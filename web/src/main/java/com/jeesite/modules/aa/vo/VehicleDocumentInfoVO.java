/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.modules.common.entity.PreEntity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public class VehicleDocumentInfoVO {

    private String[] project;        // 单证项目
    private String[] state;        // 状态
    private Date[] validity;        // 有效期

    public String[] getProject() {
        return project;
    }

    public void setProject(String[] project) {
        this.project = project;
    }

    public String[] getState() {
        return state;
    }

    public void setState(String[] state) {
        this.state = state;
    }

    public Date[] getValidity() {
        return validity;
    }

    public void setValidity(Date[] validity) {
        this.validity = validity;
    }
}