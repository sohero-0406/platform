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
 * 检查车体骨架Entity
 * @author lvchangwei
 * @version 2019-07-02
 */
@Table(name="aa_check_body_skeleton", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="exam_user_id", attrName="examUserId", label="外键id"),
		@Column(name="paper_id", attrName="paperId", label="试卷id"),
		@Column(name="technology_info_id", attrName="technologyInfoId", label="鉴定项id"),
		@Column(name="state", attrName="state", label="状态"),
		@Column(name="description", attrName="description", label="缺陷描述"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CheckBodySkeleton extends PreEntity<CheckBodySkeleton> {
	
	private static final long serialVersionUID = 1L;
	private String examUserId;		// 外键id
	private String paperId;		// 试卷id
	private String technologyInfoId;		// 鉴定项id
	private String state;		// 状态
	private String description;		// 缺陷描述

	//非数据库字段
	private String project;
	private String projectName;
	
	public CheckBodySkeleton() {
		this(null);
	}

	public CheckBodySkeleton(String id){
		super(id);
	}
	
	@Length(min=0, max=64, message="外键id长度不能超过 64 个字符")
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

	@Length(min=0, max=64, message="鉴定项id长度不能超过 64 个字符")
	public String getTechnologyInfoId() {
		return technologyInfoId;
	}

	public void setTechnologyInfoId(String technologyInfoId) {
		this.technologyInfoId = technologyInfoId;
	}

	@Length(min=0, max=10, message="状态长度不能超过 10 个字符")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Length(min=0, max=512, message="缺陷描述长度不能超过 512 个字符")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}