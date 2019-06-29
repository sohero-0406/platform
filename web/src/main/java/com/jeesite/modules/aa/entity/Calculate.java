/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.entity;

import com.jeesite.modules.common.entity.PreEntity;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 计算车辆价值Entity
 * @author lvchangwei
 * @version 2019-06-25
 */
@Table(name="aa_calculate", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="type", attrName="type", label="算法类型"),
		@Column(name="begin_price", attrName="beginPrice", label="得分价格开始值"),
		@Column(name="end_price", attrName="endPrice", label="得分价格结束值"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class Calculate extends PreEntity<Calculate> {
	
	private static final long serialVersionUID = 1L;
	private String type;		// 算法类型
	private Double beginPrice;		// 得分价格开始值
	private Double endPrice;		// 得分价格结束值
	
	public Calculate() {
		this(null);
	}

	public Calculate(String id){
		super(id);
	}
	
	@Length(min=0, max=10, message="算法类型长度不能超过 10 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Double getBeginPrice() {
		return beginPrice;
	}

	public void setBeginPrice(Double beginPrice) {
		this.beginPrice = beginPrice;
	}
	
	public Double getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(Double endPrice) {
		this.endPrice = endPrice;
	}
	
}