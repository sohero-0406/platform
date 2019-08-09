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
 * 方案基本表，目前不做管理使用，只作为基础数据调用，后期能会做出管理界面Entity
 * @author mayuhu
 * @version 2019-08-05
 */
@Table(name="common_basic_scheme", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="basic_name", attrName="basicName", label="基本方案名称", queryType=QueryType.LIKE),
		@Column(name="basic_detail", attrName="basicDetail", label="basic_detail"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CommonBasicScheme extends PreEntity<CommonBasicScheme> {
	
	private static final long serialVersionUID = 1L;
	private String basicName;		// 基本方案名称
	private String basicDetail;		// basic_detail
	
	public CommonBasicScheme() {
		this(null);
	}

	public CommonBasicScheme(String id){
		super(id);
	}
	
	@Length(min=0, max=100, message="基本方案名称长度不能超过 100 个字符")
	public String getBasicName() {
		return basicName;
	}

	public void setBasicName(String basicName) {
		this.basicName = basicName;
	}
	
	public String getBasicDetail() {
		return basicDetail;
	}

	public void setBasicDetail(String basicDetail) {
		this.basicDetail = basicDetail;
	}
	
}