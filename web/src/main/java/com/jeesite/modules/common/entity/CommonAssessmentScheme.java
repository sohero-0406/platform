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
 * 考核方案表Entity
 * @author mayuhu
 * @version 2019-08-05
 */
@Table(name="common_assessment_scheme", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="scheme_name", attrName="schemeName", label="scheme_name", queryType=QueryType.LIKE),
		@Column(name="basic_scheme_id", attrName="basicSchemeId", label="basic_scheme_id"),
		@Column(name="scheme_details", attrName="schemeDetails", label="详细的配置内容"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CommonAssessmentScheme extends PreEntity<CommonAssessmentScheme> {
	
	private static final long serialVersionUID = 1L;
	private String schemeName;		// scheme_name
	private String basicSchemeId;		// basic_scheme_id
	private String schemeDetails;		// 详细的配置内容
	
	public CommonAssessmentScheme() {
		this(null);
	}

	public CommonAssessmentScheme(String id){
		super(id);
	}
	
	@Length(min=0, max=100, message="scheme_name长度不能超过 100 个字符")
	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	
	@Length(min=0, max=64, message="basic_scheme_id长度不能超过 64 个字符")
	public String getBasicSchemeId() {
		return basicSchemeId;
	}

	public void setBasicSchemeId(String basicSchemeId) {
		this.basicSchemeId = basicSchemeId;
	}
	
	public String getSchemeDetails() {
		return schemeDetails;
	}

	public void setSchemeDetails(String schemeDetails) {
		this.schemeDetails = schemeDetails;
	}
	
}