/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.entity;


import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 车辆品牌表Entity
 * @author chenlitao
 * @version 2019-07-04
 */
@Table(name="common_vehicle_brand", alias="a", columns={
		@Column(name="id", attrName="id", label="主键，车辆品牌表", isPK=true),
		@Column(name="shouzimu", attrName="shouzimu", label="首字母"),
		@Column(name="pinpai", attrName="pinpai", label="品牌名称"),
		@Column(name="pinpai_id", attrName="pinpaiId", label="pinpai_id"),
		@Column(name="pinpai_logo", attrName="pinpaiLogo", label="品牌logo路径"),
		@Column(name="gengxinshijian", attrName="gengxinshijian", label="更新时间"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class VehicleBrand extends PreEntity<VehicleBrand> {
	
	private static final long serialVersionUID = 1L;
	private String shouzimu;		// 首字母
	private String pinpai;		// 品牌名称
	private String pinpaiId;		// pinpai_id
	private String pinpaiLogo;		// 品牌logo路径
	private String gengxinshijian;		// 更新时间
	
	public VehicleBrand() {
		this(null);
	}

	public VehicleBrand(String id){
		super(id);
	}
	
	public String getShouzimu() {
		return shouzimu;
	}

	public void setShouzimu(String shouzimu) {
		this.shouzimu = shouzimu;
	}
	
	public String getPinpai() {
		return pinpai;
	}

	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	
	public String getPinpaiId() {
		return pinpaiId;
	}

	public void setPinpaiId(String pinpaiId) {
		this.pinpaiId = pinpaiId;
	}
	
	public String getPinpaiLogo() {
		return pinpaiLogo;
	}

	public void setPinpaiLogo(String pinpaiLogo) {
		this.pinpaiLogo = pinpaiLogo;
	}
	
	public String getGengxinshijian() {
		return gengxinshijian;
	}

	public void setGengxinshijian(String gengxinshijian) {
		this.gengxinshijian = gengxinshijian;
	}
	
}