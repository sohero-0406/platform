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
 * 车辆加装信息Entity
 * @author chenlitao
 * @version 2019-07-03
 */
@Table(name="aa_vehicle_install_info", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="exam_user_id", attrName="examUserId", label="外键Id"),
		@Column(name="paper_id", attrName="paperId", label="试卷id"),
		@Column(name="project", attrName="project", label="加装项目"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class VehicleInstallInfo extends PreEntity<VehicleInstallInfo> {
	
	private static final long serialVersionUID = 1L;
	private String examUserId;		// 外键Id
	private String paperId;		// 试卷id
	private String project;		// 加装项目
	
	public VehicleInstallInfo() {
		this(null);
	}

	public VehicleInstallInfo(String id){
		super(id);
	}
	
	@Length(min=0, max=64, message="外键Id长度不能超过 64 个字符")
	public String getExamUserId() {
		return examUserId;
	}

	public void setExamUserId(String examUserId) {
		this.examUserId = examUserId;
	}
	
	@Length(min=0, max=64, message="试卷id长度不能超过 64 个字符")
	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
	
	@Length(min=0, max=10, message="加装项目长度不能超过 10 个字符")
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
}