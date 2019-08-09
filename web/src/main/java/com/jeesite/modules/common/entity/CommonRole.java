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
 * common_roleEntity
 * @author mayuhu
 * @version 2019-08-05
 */
@Table(name="common_role", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="role_name", attrName="roleName", label="角色名称", queryType=QueryType.LIKE),
		@Column(name="right_array", attrName="rightArray", label="权限数据字符串", comment = "权限数据字符串"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CommonRole extends PreEntity<CommonRole> {
	
	private static final long serialVersionUID = 1L;
	private String roleName;		// 角色名称
	private String rightArray;
	
	public CommonRole() {
		this(null);
	}

	public CommonRole(String id){
		super(id);
	}
	
	@Length(min=0, max=50, message="角色名称长度不能超过 50 个字符")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Length(min=0, max=100, message="权限数据字符串长度不能超过 100 个字符")
	public String getRightArray() {
		return rightArray;
	}

	public void setRightArray(String rightArray) {
		this.rightArray = rightArray;
	}
}