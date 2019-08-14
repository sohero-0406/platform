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
 * 考核表Entity
 * @author mayuhu
 * @version 2019-08-05
 */
@Table(name="common_assessment", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="assessment_name", attrName="assessmentName", label="assessment_name", queryType=QueryType.LIKE),
		@Column(name="assessment_scheme_id", attrName="assessmentSchemeId", label="assessment_scheme_id"),
		@Column(name="start_date", attrName="startDate", label="start_date"),
		@Column(name="end_date", attrName="endDate", label="end_date"),
		@Column(name="school_id", attrName="schoolId", label="school_id"),
		@Column(name="school_name", attrName="schoolName", label="school_name", queryType=QueryType.LIKE),
		@Column(name="data_status", attrName="dataStatus", label="自定义状态"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CommonAssessment extends PreEntity<CommonAssessment> {
	
	private static final long serialVersionUID = 1L;
	private String assessmentName;		// assessment_name
	private String assessmentSchemeId;		// assessment_scheme_id
	private String startDate;		// start_date
	private String endDate;		// end_date
	private String schoolId;		// school_id
	private String schoolName;		// school_name
	private String dataStatus;

	// dataStatus 0 初始状态可以修改和删除，1 是逻辑删除状态  2 是 考核处于开始状态   3是 考核处于结束状态 4 是 评分表上传后并解析成功状态 5 是统分成功状态
	
	public CommonAssessment() {
		this(null);
	}

	public CommonAssessment(String id){
		super(id);
	}
	
	@Length(min=0, max=100, message="assessment_name长度不能超过 100 个字符")
	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}
	
	@Length(min=0, max=64, message="assessment_scheme_id长度不能超过 64 个字符")
	public String getAssessmentSchemeId() {
		return assessmentSchemeId;
	}

	public void setAssessmentSchemeId(String assessmentSchemeId) {
		this.assessmentSchemeId = assessmentSchemeId;
	}
	
	@Length(min=0, max=20, message="start_date长度不能超过 20 个字符")
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	@Length(min=0, max=20, message="end_date长度不能超过 20 个字符")
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@Length(min=0, max=64, message="school_id长度不能超过 64 个字符")
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	
	@Length(min=0, max=100, message="school_name长度不能超过 100 个字符")
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Length(min=0, max=100, message="自定义状态长度不能超过 100 个字符")
	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}
}