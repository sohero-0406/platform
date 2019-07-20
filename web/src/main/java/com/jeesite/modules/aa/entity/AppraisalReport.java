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
 * 二手车鉴定评估报告Entity
 * @author lvchangwei
 * @version 2019-07-19
 */
@Table(name="aa_appraisal_report", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="exam_user_id", attrName="examUserId", label="外键ID"),
		@Column(name="paper_id", attrName="paperId", label="试卷ID"),
		@Column(name="appraisal_date", attrName="appraisalDate", label="评报字-时间"),
		@Column(name="appraisal_num", attrName="appraisalNum", label="评报字-数字（8位）"),
		@Column(name="check_name", attrName="checkName", label="复核人姓名", queryType=QueryType.LIKE),
		@Column(name="base_date_end", attrName="baseDateEnd", label="鉴定评估基准日结束日"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class AppraisalReport extends PreEntity<AppraisalReport> {
	
	private static final long serialVersionUID = 1L;
	private String examUserId;		// 外键ID
	private String paperId;		// 试卷ID
	private String appraisalDate;		// 评报字-时间
	private String appraisalNum;		// 评报字-时间
	private String checkName;		// 复核人姓名
	private String baseDateEnd;		//鉴定评估基准日结束日



	public AppraisalReport() {
		this(null);
	}

	public AppraisalReport(String id){
		super(id);
	}
	
	@Length(min=0, max=64, message="外键ID长度不能超过 64 个字符")
	public String getExamUserId() {
		return examUserId;
	}

	public void setExamUserId(String examUserId) {
		this.examUserId = examUserId;
	}

	@Length(min=0, max=64, message="试卷ID长度不能超过 64 个字符")
	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	@Length(min=0, max=16, message="评报字-时间长度不能超过 16 个字符")
	public String getAppraisalDate() {
		return appraisalDate;
	}

	public void setAppraisalDate(String appraisalDate) {
		this.appraisalDate = appraisalDate;
	}

	@Length(min=0, max=8, message="评报字-数字（8位）长度不能超过 8 个字符")
	public String getAppraisalNum() {
		return appraisalNum;
	}

	public void setAppraisalNum(String appraisalNum) {
		this.appraisalNum = appraisalNum;
	}

	@Length(min=0, max=32, message="复核人姓名长度不能超过 32 个字符")
	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	@Length(min=0, max=32, message="鉴定评估基准日结束日长度不能超过 2 个字符")
	public String getBaseDateEnd() {
		return baseDateEnd;
	}

	public void setBaseDateEnd(String baseDateEnd) {
		this.baseDateEnd = baseDateEnd;
	}
}