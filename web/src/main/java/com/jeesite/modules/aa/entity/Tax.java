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
 * 税率表Entity
 * @author lvchangwei
 * @version 2019-07-18
 */
@Table(name="aa_tax", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="purchase", attrName="purchase", label="购置税税率"),
		@Column(name="vat", attrName="vat", label="增值税税率"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class Tax extends PreEntity<Tax> {
	
	private static final long serialVersionUID = 1L;
	private String purchase;		// 购置税税率
	private String vat;		// 增值税税率
	
	public Tax() {
		this(null);
	}

	public Tax(String id){
		super(id);
	}
	
	@Length(min=0, max=16, message="购置税税率长度不能超过 16 个字符")
	public String getPurchase() {
		return purchase;
	}

	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}
	
	@Length(min=0, max=16, message="增值税税率长度不能超过 16 个字符")
	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}
	
}