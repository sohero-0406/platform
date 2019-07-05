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
 * 折旧率估值法Entity
 * @author chenlitao
 * @version 2019-07-05
 */
@Table(name="aa_calculate_depreciation", alias="a", columns={
		@Column(name="id", attrName="id", label="主键，折旧率估值法", isPK=true),
		@Column(name="sale_price", attrName="salePrice", label="车辆销售价格"),
		@Column(name="use_year", attrName="useYear", label="车辆已使用年限"),
		@Column(name="depreciation_rate", attrName="depreciationRate", label="年限折旧率之和"),
		@Column(name="price", attrName="price", label="评估价格"),
		@Column(name="calculate_id", attrName="calculateId", label="外键id"),
	}, orderBy="a.id DESC"
)
public class CalculateDepreciation extends PreEntity<CalculateDepreciation> {
	
	private static final long serialVersionUID = 1L;
	private Double salePrice;		// 车辆销售价格
	private String useYear;		// 车辆已使用年限
	private String depreciationRate;		// 年限折旧率之和
	private Double price;		// 评估价格
	private String calculateId;		// 外键id
	
	public CalculateDepreciation() {
		this(null);
	}

	public CalculateDepreciation(String id){
		super(id);
	}
	
	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	
	@Length(min=0, max=2, message="车辆已使用年限长度不能超过 2 个字符")
	public String getUseYear() {
		return useYear;
	}

	public void setUseYear(String useYear) {
		this.useYear = useYear;
	}
	
	@Length(min=0, max=10, message="年限折旧率之和长度不能超过 10 个字符")
	public String getDepreciationRate() {
		return depreciationRate;
	}

	public void setDepreciationRate(String depreciationRate) {
		this.depreciationRate = depreciationRate;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Length(min=0, max=64, message="外键id长度不能超过 64 个字符")
	public String getCalculateId() {
		return calculateId;
	}

	public void setCalculateId(String calculateId) {
		this.calculateId = calculateId;
	}
	
}