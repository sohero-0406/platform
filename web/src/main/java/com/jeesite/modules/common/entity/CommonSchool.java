/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 院校表Entity
 * @author mayuhu
 * @version 2019-08-05
 */
@Table(name="common_school", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="school_name", attrName="schoolName", label="院校名称", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CommonSchool extends PreEntity<CommonSchool> {
	
	private static final long serialVersionUID = 1L;
	private String schoolName;		// 院校名称
	
	public CommonSchool() {
		this(null);
	}

	public CommonSchool(String id){
		super(id);
	}
	
	@NotBlank(message="院校名称不能为空")
	@Length(min=0, max=100, message="院校名称长度不能超过 100 个字符")
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
}