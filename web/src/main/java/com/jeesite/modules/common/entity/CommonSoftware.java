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
 * 软件表Entity
 * @author mayuhu
 * @version 2019-08-08
 */
@Table(name="common_software", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="software_name", attrName="softwareName", label="软件名称", queryType=QueryType.LIKE),
		@Column(name="software_type_id", attrName="softwareTypeId", label="软件种类id"),
		@Column(name="software_desc", attrName="softwareDesc", label="software_desc"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CommonSoftware extends DataEntity<CommonSoftware> {
	
	private static final long serialVersionUID = 1L;
	private String softwareName;		// 软件名称
	private String softwareTypeId;		// 软件种类id
	private String softwareDesc;		// software_desc


	public CommonSoftware() {
		this(null);
	}

	public CommonSoftware(String id){
		super(id);
	}
	
	@Length(min=0, max=30, message="软件名称长度不能超过 30 个字符")
	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	
	@Length(min=0, max=64, message="软件种类id长度不能超过 64 个字符")
	public String getSoftwareTypeId() {
		return softwareTypeId;
	}

	public void setSoftwareTypeId(String softwareTypeId) {
		this.softwareTypeId = softwareTypeId;
	}
	
	@Length(min=0, max=200, message="software_desc长度不能超过 200 个字符")
	public String getSoftwareDesc() {
		return softwareDesc;
	}

	public void setSoftwareDesc(String softwareDesc) {
		this.softwareDesc = softwareDesc;
	}
	
}