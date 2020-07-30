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
 * 考核学生表Entity
 * @author mayuhu
 * @version 2019-08-05
 */
@Table(name="common_assessment_stu", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="common_user_id", attrName="commonUserId", label="用户id"),
		@Column(name="assessment_id", attrName="assessmentId", label="考试id"),
		@Column(name="login_name", attrName="loginName", label="登录名", queryType=QueryType.LIKE),
		@Column(name="true_name", attrName="trueName", label="姓名/真名", queryType=QueryType.LIKE),
		@Column(name="school_name", attrName="schoolName", label="学校名称", queryType=QueryType.LIKE),
		@Column(name="school_id", attrName="schoolId", label="学校id"),
		@Column(name="major_name", attrName="majorName", label="专业", queryType=QueryType.LIKE),
		@Column(name="class_name", attrName="className", label="班级", queryType=QueryType.LIKE),
		@Column(name="assessment_date", attrName="assessmentDate", label="考核日期"),
		@Column(name="assessment_time", attrName="assessmentTime", label="考核时间"),
		@Column(name="soft_uploaded_marks", attrName="softUploadedMarks", label="软件分数上传标识"),
		@Column(name="total_score", attrName="totalScore", label="总分"),
		@Column(name="score_details", attrName="scoreDetails", label="得分详情"),
        @Column(name="data_status", attrName="dataStatus", label="通过状态"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CommonAssessmentStu extends PreEntity<CommonAssessmentStu> {
	
	private static final long serialVersionUID = 1L;
	private String commonUserId;		// 用户id
	private String assessmentId;
	private String loginName;		// 登录名
	private String trueName;		// 姓名/真名
	private String schoolName;		// 学校名称
	private String schoolId;		// 学校id
	private String majorName;		// 专业
	private String className;		// 班级
	private String assessmentDate;		// 考核日期
	private String assessmentTime;		// 考核时间
	private String softUploadedMarks; // 软件分数上传标识
	private String totalScore;		// 总分
	private String scoreDetails; // 得分详情
    private String dataStatus; // 通过状态

	//非数据库字段
	private String assessmentName;
	private String searchDate;

	
	public CommonAssessmentStu() {
		this(null);
	}

	public CommonAssessmentStu(String id){
		super(id);
	}
	
	@Length(min=0, max=64, message="用户id长度不能超过 64 个字符")
	public String getCommonUserId() {
		return commonUserId;
	}

	public void setCommonUserId(String commonUserId) {
		this.commonUserId = commonUserId;
	}

	@Length(min=0, max=64, message="考试id长度不能超过 64 个字符")
	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	@Length(min=0, max=32, message="登录名长度不能超过 32 个字符")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@Length(min=0, max=32, message="姓名/真名长度不能超过 32 个字符")
	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	@Length(min=0, max=100, message="学校名称长度不能超过 100 个字符")
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	@Length(min=0, max=64, message="学校id长度不能超过 64 个字符")
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	
	@Length(min=0, max=100, message="专业长度不能超过 100 个字符")
	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
	@Length(min=0, max=100, message="班级长度不能超过 100 个字符")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	@Length(min=0, max=20, message="考核日期长度不能超过 20 个字符")
	public String getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(String assessmentDate) {
		this.assessmentDate = assessmentDate;
	}
	
	@Length(min=0, max=20, message="考核时间长度不能超过 20 个字符")
	public String getAssessmentTime() {
		return assessmentTime;
	}

	public void setAssessmentTime(String assessmentTime) {
		this.assessmentTime = assessmentTime;
	}

	@Length(min=0, max=300, message="软件分数上传标识长度不能超过 1000 个字符")
	public String getSoftUploadedMarks() {
		return softUploadedMarks;
	}

	public void setSoftUploadedMarks(String softUploadedMarks) {
		this.softUploadedMarks = softUploadedMarks;
	}

	@Length(min=0, max=20, message="总分长度不能超过 20 个字符")
	public String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public String getScoreDetails() {
		return scoreDetails;
	}

	public void setScoreDetails(String scoreDetails) {
		this.scoreDetails = scoreDetails;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

    @Length(min=0, max=100, message="通过状态长度不能超过 100 个字符")
    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
}