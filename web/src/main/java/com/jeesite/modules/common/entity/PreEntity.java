package com.jeesite.modules.common.entity;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.web.http.ServletUtils;

import javax.servlet.http.HttpServletRequest;

public class PreEntity<T extends DataEntity<?>> extends DataEntity<T> {

    @Override
    public void preInsert() {
        super.preInsert();
        HttpServletRequest request = ServletUtils.getRequest();
        ExamUser examUser = (ExamUser) request.getSession().getAttribute("examUser");
        if (null != examUser) {
            this.createBy = examUser.getUserId();
            this.updateBy = examUser.getUserId();
        }
    }

    @Override
    public void preUpdate() {
        super.preUpdate();
        HttpServletRequest request = ServletUtils.getRequest();
        ExamUser examUser = (ExamUser) request.getSession().getAttribute("examUser");
        if (null != examUser) {
            this.updateBy = examUser.getUserId();
        }
    }

    public PreEntity(String id) {
        super(id);
    }
}
