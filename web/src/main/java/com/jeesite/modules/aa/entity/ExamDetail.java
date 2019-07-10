/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 考试详情表Entity
 * @author lvchangwei
 * @version 2019-07-09
 */
@Table(name="aa_exam_detail", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="exam_id", attrName="examId", label="考试id"),
		@Column(name="enable_check_body_skeleton", attrName="enableCheckBodySkeleton", label="启用检查车体骨架"),
		@Column(name="enable_accident_vehicle", attrName="enableAccidentVehicle", label="启用判定事故车"),
		@Column(name="enable_road_test", attrName="enableRoadTest", label="启用路试项"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ExamDetail extends DataEntity<ExamDetail> {
	
	private static final long serialVersionUID = 1L;
	private String examId;		// 考试id
	private String enableCheckBodySkeleton;		// 启用检查车体骨架
	private String enableAccidentVehicle;		// 启用判定事故车
	private String enableRoadTest;		// 启用路试项
	
	public ExamDetail() {
		this(null);
	}

	public ExamDetail(String id){
		super(id);
	}
	
	@Length(min=0, max=64, message="考试id长度不能超过 64 个字符")
	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}
	
	@Length(min=0, max=10, message="启用检查车体骨架长度不能超过 10 个字符")
	public String getEnableCheckBodySkeleton() {
		return enableCheckBodySkeleton;
	}

	public void setEnableCheckBodySkeleton(String enableCheckBodySkeleton) {
		this.enableCheckBodySkeleton = enableCheckBodySkeleton;
	}
	
	@Length(min=0, max=10, message="启用判定事故车长度不能超过 10 个字符")
	public String getEnableAccidentVehicle() {
		return enableAccidentVehicle;
	}

	public void setEnableAccidentVehicle(String enableAccidentVehicle) {
		this.enableAccidentVehicle = enableAccidentVehicle;
	}
	
	@Length(min=0, max=10, message="启用路试项长度不能超过 10 个字符")
	public String getEnableRoadTest() {
		return enableRoadTest;
	}

	public void setEnableRoadTest(String enableRoadTest) {
		this.enableRoadTest = enableRoadTest;
	}
	
}