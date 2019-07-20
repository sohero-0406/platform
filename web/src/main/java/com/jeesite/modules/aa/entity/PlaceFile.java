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
 * 归档Entity
 * @author liangtao
 * @version 2019-07-20
 */
@Table(name="aa_place_file", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="exam_user_id", attrName="examUserId", label="外键id"),
		@Column(name="paper_id", attrName="paperId", label="试卷id"),
		@Column(name="picture_user_id", attrName="pictureUserId", label="外键id"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class PlaceFile extends PreEntity<PlaceFile> {
	
	private static final long serialVersionUID = 1L;
	private String examUserId;		// 外键id
	private String paperId;		// 试卷id
	private String pictureUserId;		// 外键id
	
	public PlaceFile() {
		this(null);
	}

	public PlaceFile(String id){
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
	
	@Length(min=0, max=64, message="外键id长度不能超过 64 个字符")
	public String getPictureUserId() {
		return pictureUserId;
	}

	public void setPictureUserId(String pictureUserId) {
		this.pictureUserId = pictureUserId;
	}
	
}