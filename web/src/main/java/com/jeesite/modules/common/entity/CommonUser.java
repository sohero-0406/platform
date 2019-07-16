/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * common_userEntity
 * @author lvchangwei
 * @version 2019-07-16
 */
@Table(name="common_user", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="user_name", attrName="userName", label="用户名", queryType=QueryType.LIKE),
		@Column(name="password", attrName="password", label="密码"),
		@Column(name="true_name", attrName="trueName", label="真实姓名", queryType=QueryType.LIKE),
		@Column(name="type", attrName="type", label="用户类型", comment="用户类型（学员，教员）"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CommonUser extends PreEntity<CommonUser> {
	
	private static final long serialVersionUID = 1L;
	private String userName;		// 用户名
	private String password;		// 密码
	private String trueName;		// 真实姓名
	private String type;		// 用户类型（学员，教员）
	
	public CommonUser() {
		this(null);
	}

	public CommonUser(String id){
		super(id);
	}
	
	@Length(min=0, max=32, message="用户名长度不能超过 32 个字符")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=0, max=32, message="密码长度不能超过 32 个字符")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=0, max=32, message="真实姓名长度不能超过 32 个字符")
	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	@Length(min=0, max=10, message="用户类型长度不能超过 10 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}