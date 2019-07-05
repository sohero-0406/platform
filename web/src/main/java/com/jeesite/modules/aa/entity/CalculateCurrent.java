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
 * 现行市价法Entity
 * @author chenlitao
 * @version 2019-07-05
 */
@Table(name="aa_calculate_current", alias="a", columns={
		@Column(name="id", attrName="id", label="主键，现行市价法", isPK=true),
		@Column(name="is_compute_new_rate", attrName="isComputeNewRate", label="是否计算成新率，1", comment="是否计算成新率，1：是，0：否"),
		@Column(name="provide_use_year", attrName="provideUseYear", label="规定使用年限"),
		@Column(name="p1_type", attrName="p1Type", label="参照物1的价格更有益的车辆0", comment="参照物1的价格更有益的车辆0：参照车辆，1是评估车辆"),
		@Column(name="param1_id", attrName="param1Id", label="参照物1的id"),
		@Column(name="p1_excellent_price", attrName="p1ExcellentPrice", label="参照物1的优异价格"),
		@Column(name="p1_k1", attrName="p1K1", label="参照物1的k1"),
		@Column(name="p1_k2", attrName="p1K2", label="参照物1的k2"),
		@Column(name="p1_k3", attrName="p1K3", label="参照物1的k3"),
		@Column(name="p1_k4", attrName="p1K4", label="参照物1的k4"),
		@Column(name="p1_price", attrName="p1Price", label="参照物1的评估值"),
		@Column(name="param2_id", attrName="param2Id", label="参照物2的id"),
		@Column(name="p2_type", attrName="p2Type", label="参照物2的价格更有益的车辆0", comment="参照物2的价格更有益的车辆0：参照车辆，1是评估车辆"),
		@Column(name="p2_excellent_price", attrName="p2ExcellentPrice", label="参照物2的优异价格"),
		@Column(name="p2_k1", attrName="p2K1", label="参照物2的k1"),
		@Column(name="p2_k2", attrName="p2K2", label="参照物2的k2"),
		@Column(name="p2_k3", attrName="p2K3", label="参照物2的k3"),
		@Column(name="p2_k4", attrName="p2K4", label="参照物2的k4"),
		@Column(name="p2_price", attrName="p2Price", label="参照物2的评估值"),
		@Column(name="price", attrName="price", label="评估价格"),
		@Column(name="calculate_id", attrName="calculateId", label="外键id"),
	}, orderBy="a.id DESC"
)
public class CalculateCurrent extends PreEntity<CalculateCurrent> {
	
	private static final long serialVersionUID = 1L;
	private String isComputeNewRate;		// 是否计算成新率，1：是，0：否
	private String provideUseYear;		// 规定使用年限
	private String p1Type;		// 参照物1的价格更有益的车辆0：参照车辆，1是评估车辆
	private String param1Id;		// 参照物1的id
	private Double p1ExcellentPrice;		// 参照物1的优异价格
	private Double p1K1;		// 参照物1的k1
	private Double p1K2;		// 参照物1的k2
	private Double p1K3;		// 参照物1的k3
	private Double p1K4;		// 参照物1的k4
	private Double p1Price;		// 参照物1的评估值
	private String param2Id;		// 参照物2的id
	private String p2Type;		// 参照物2的价格更有益的车辆0：参照车辆，1是评估车辆
	private Double p2ExcellentPrice;		// 参照物2的优异价格
	private Double p2K1;		// 参照物2的k1
	private Double p2K2;		// 参照物2的k2
	private Double p2K3;		// 参照物2的k3
	private Double p2K4;		// 参照物2的k4
	private Double p2Price;		// 参照物2的评估值
	private Double price;		// 评估价格
	private String calculateId;		// 外键id
	
	public CalculateCurrent() {
		this(null);
	}

	public CalculateCurrent(String id){
		super(id);
	}
	
	@Length(min=0, max=1, message="是否计算成新率，1长度不能超过 1 个字符")
	public String getIsComputeNewRate() {
		return isComputeNewRate;
	}

	public void setIsComputeNewRate(String isComputeNewRate) {
		this.isComputeNewRate = isComputeNewRate;
	}
	
	@Length(min=0, max=2, message="规定使用年限长度不能超过 2 个字符")
	public String getProvideUseYear() {
		return provideUseYear;
	}

	public void setProvideUseYear(String provideUseYear) {
		this.provideUseYear = provideUseYear;
	}
	
	@Length(min=0, max=1, message="参照物1的价格更有益的车辆0长度不能超过 1 个字符")
	public String getP1Type() {
		return p1Type;
	}

	public void setP1Type(String p1Type) {
		this.p1Type = p1Type;
	}
	
	@Length(min=0, max=64, message="参照物1的id长度不能超过 64 个字符")
	public String getParam1Id() {
		return param1Id;
	}

	public void setParam1Id(String param1Id) {
		this.param1Id = param1Id;
	}
	
	public Double getP1ExcellentPrice() {
		return p1ExcellentPrice;
	}

	public void setP1ExcellentPrice(Double p1ExcellentPrice) {
		this.p1ExcellentPrice = p1ExcellentPrice;
	}
	
	public Double getP1K1() {
		return p1K1;
	}

	public void setP1K1(Double p1K1) {
		this.p1K1 = p1K1;
	}
	
	public Double getP1K2() {
		return p1K2;
	}

	public void setP1K2(Double p1K2) {
		this.p1K2 = p1K2;
	}
	
	public Double getP1K3() {
		return p1K3;
	}

	public void setP1K3(Double p1K3) {
		this.p1K3 = p1K3;
	}
	
	public Double getP1K4() {
		return p1K4;
	}

	public void setP1K4(Double p1K4) {
		this.p1K4 = p1K4;
	}
	
	public Double getP1Price() {
		return p1Price;
	}

	public void setP1Price(Double p1Price) {
		this.p1Price = p1Price;
	}
	
	@Length(min=0, max=64, message="参照物2的id长度不能超过 64 个字符")
	public String getParam2Id() {
		return param2Id;
	}

	public void setParam2Id(String param2Id) {
		this.param2Id = param2Id;
	}
	
	@Length(min=0, max=1, message="参照物2的价格更有益的车辆0长度不能超过 1 个字符")
	public String getP2Type() {
		return p2Type;
	}

	public void setP2Type(String p2Type) {
		this.p2Type = p2Type;
	}
	
	public Double getP2ExcellentPrice() {
		return p2ExcellentPrice;
	}

	public void setP2ExcellentPrice(Double p2ExcellentPrice) {
		this.p2ExcellentPrice = p2ExcellentPrice;
	}
	
	public Double getP2K1() {
		return p2K1;
	}

	public void setP2K1(Double p2K1) {
		this.p2K1 = p2K1;
	}
	
	public Double getP2K2() {
		return p2K2;
	}

	public void setP2K2(Double p2K2) {
		this.p2K2 = p2K2;
	}
	
	public Double getP2K3() {
		return p2K3;
	}

	public void setP2K3(Double p2K3) {
		this.p2K3 = p2K3;
	}
	
	public Double getP2K4() {
		return p2K4;
	}

	public void setP2K4(Double p2K4) {
		this.p2K4 = p2K4;
	}
	
	public Double getP2Price() {
		return p2Price;
	}

	public void setP2Price(Double p2Price) {
		this.p2Price = p2Price;
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