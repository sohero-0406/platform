/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.entity;


import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 车辆车系表Entity
 * @author chenlitao
 * @version 2019-07-04
 */
@Table(name="common_vehicle_series", alias="a", columns={
		@Column(name="id", attrName="id", label="主键，车辆车系表", isPK=true),
		@Column(name="chexi_id", attrName="chexiId", label="chexi_id"),
		@Column(name="shouzimu", attrName="shouzimu", label="首字母"),
		@Column(name="pinpai_id", attrName="pinpaiId", label="pinpai_id"),
		@Column(name="chexi", attrName="chexi", label="车系名称"),
		@Column(name="changshang", attrName="changshang", label="厂商"),
		@Column(name="changshang_id", attrName="changshangId", label="changshang_id"),
		@Column(name="zuidizhidaojia_wan", attrName="zuidizhidaojiaWan", label="最低指导价"),
		@Column(name="zuigaozhidaojia_wan", attrName="zuigaozhidaojiaWan", label="最高指导价"),
		@Column(name="chexizhanshitu", attrName="chexizhanshitu", label="车系展示图路径"),
		@Column(name="gengxinshijian", attrName="gengxinshijian", label="更新时间"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class VehicleSeries extends PreEntity<VehicleSeries> {
	
	private static final long serialVersionUID = 1L;
	private String chexiId;		// chexi_id
	private String shouzimu;		// 首字母
	private String pinpaiId;		// pinpai_id
	private String chexi;		// 车系名称
	private String changshang;		// 厂商
	private String changshangId;		// changshang_id
	private String zuidizhidaojiaWan;		// 最低指导价
	private String zuigaozhidaojiaWan;		// 最高指导价
	private String chexizhanshitu;		// 车系展示图路径
	private String gengxinshijian;		// 更新时间
	
	public VehicleSeries() {
		this(null);
	}

	public VehicleSeries(String id){
		super(id);
	}
	
	public String getChexiId() {
		return chexiId;
	}

	public void setChexiId(String chexiId) {
		this.chexiId = chexiId;
	}
	
	public String getShouzimu() {
		return shouzimu;
	}

	public void setShouzimu(String shouzimu) {
		this.shouzimu = shouzimu;
	}
	
	public String getPinpaiId() {
		return pinpaiId;
	}

	public void setPinpaiId(String pinpaiId) {
		this.pinpaiId = pinpaiId;
	}
	
	public String getChexi() {
		return chexi;
	}

	public void setChexi(String chexi) {
		this.chexi = chexi;
	}
	
	public String getChangshang() {
		return changshang;
	}

	public void setChangshang(String changshang) {
		this.changshang = changshang;
	}
	
	public String getChangshangId() {
		return changshangId;
	}

	public void setChangshangId(String changshangId) {
		this.changshangId = changshangId;
	}
	
	public String getZuidizhidaojiaWan() {
		return zuidizhidaojiaWan;
	}

	public void setZuidizhidaojiaWan(String zuidizhidaojiaWan) {
		this.zuidizhidaojiaWan = zuidizhidaojiaWan;
	}
	
	public String getZuigaozhidaojiaWan() {
		return zuigaozhidaojiaWan;
	}

	public void setZuigaozhidaojiaWan(String zuigaozhidaojiaWan) {
		this.zuigaozhidaojiaWan = zuigaozhidaojiaWan;
	}
	
	public String getChexizhanshitu() {
		return chexizhanshitu;
	}

	public void setChexizhanshitu(String chexizhanshitu) {
		this.chexizhanshitu = chexizhanshitu;
	}
	
	public String getGengxinshijian() {
		return gengxinshijian;
	}

	public void setGengxinshijian(String gengxinshijian) {
		this.gengxinshijian = gengxinshijian;
	}
	
}