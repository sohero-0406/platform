package com.jeesite.modules.common.entity;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.utils.jwt.JwtUtils;
import com.jeesite.common.web.http.ServletUtils;
import io.jsonwebtoken.Claims;

import javax.servlet.http.HttpServletRequest;

public class PreEntity<T extends DataEntity<?>> extends DataEntity<T> {

    @Override
    public void preInsert() {
        super.preInsert();
        String commonUserId = getUserIdByToken();
        this.createBy = commonUserId;
        this.updateBy = commonUserId;
    }

    public static String getUserIdByToken() {
        HttpServletRequest request = ServletUtils.getRequest();
        String token = request.getHeader(JwtUtils.getHeader());
        // 如果header中不存在token，则从参数中获取token
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(JwtUtils.getHeader());
        }
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        Claims claims = JwtUtils.getClaimByToken(token);
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        return claims.getSubject();
    }

    @Override
    public void preUpdate() {
        super.preUpdate();
        String commonUserId = getUserIdByToken();
        this.updateBy = commonUserId;
    }

    public PreEntity(String id) {
        super(id);
    }
}
