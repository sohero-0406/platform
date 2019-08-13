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
 * 车辆图片表Entity
 * @author mayuhu
 * @version 2019-08-13
 */
@Table(name="common_vehicle_image", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="image_name", attrName="imageName", label="图片名称", comment="图片名称（可能会带有相对路径）", queryType=QueryType.LIKE),
		@Column(name="vehicle_id", attrName="vehicleId", label="车的id"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CommonVehicleImage extends PreEntity<CommonVehicleImage> {
	
	private static final long serialVersionUID = 1L;
	private String imageName;		// 图片名称（可能会带有相对路径）
	private String vehicleId;		// 车的id
	
	public CommonVehicleImage() {
		this(null);
	}

	public CommonVehicleImage(String id){
		super(id);
	}
	
	@Length(min=0, max=100, message="图片名称长度不能超过 100 个字符")
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	@Length(min=0, max=64, message="车的id长度不能超过 64 个字符")
	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	
}