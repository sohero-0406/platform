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
 * 配件分类表Entity
 * @author mayuhu
 * @version 2019-08-12
 */
@Table(name="common_accessory_category", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="category_name", attrName="categoryName", label="分类名称", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CommonAccessoryCategory extends PreEntity<CommonAccessoryCategory> {
	
	private static final long serialVersionUID = 1L;
	private String categoryName;		// 分类名称
	
	public CommonAccessoryCategory() {
		this(null);
	}

	public CommonAccessoryCategory(String id){
		super(id);
	}
	
	@Length(min=0, max=100, message="分类名称长度不能超过 100 个字符")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}