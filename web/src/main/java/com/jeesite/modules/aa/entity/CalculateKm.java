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
 * 公里数估值法Entity
 * @author chenlitao
 * @version 2019-07-05
 */
@Table(name="aa_calculate_km", alias="a", columns={
		@Column(name="id", attrName="id", label="主键，公里数估值法", isPK=true),
		@Column(name="sale_price", attrName="salePrice", label="车辆销售价格"),
		@Column(name="calculate_id", attrName="calculateId", label="外键id"),
		@Column(name="price", attrName="price", label="评估价格"),
	}, orderBy="a.id DESC"
)
public class CalculateKm extends PreEntity<CalculateKm> {
	
	private static final long serialVersionUID = 1L;
	private Double salePrice;		// 车辆销售价格
	private String calculateId;		// 外键id
	private Double price;		// 评估价格
	
	public CalculateKm() {
		this(null);
	}

	public CalculateKm(String id){
		super(id);
	}
	
	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	
	@Length(min=0, max=64, message="外键id长度不能超过 64 个字符")
	public String getCalculateId() {
		return calculateId;
	}

	public void setCalculateId(String calculateId) {
		this.calculateId = calculateId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}