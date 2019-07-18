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
 * common_exam_userEntity
 * @author lvchangwei
 * @version 2019-06-27
 */
@Table(name="common_exam_user", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="user_id", attrName="userId", label="用户id"),
		@Column(name="exam_id", attrName="examId", label="考试id"),
		@Column(name="user_num", attrName="userNum", label="用户名"),
		@Column(name="password", attrName="password", label="密码"),
		@Column(name="score", attrName="score", label="分数"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ExamUser extends PreEntity<ExamUser> {
	
	private static final long serialVersionUID = 1L;
	private String userId;		// 用户id
	private String examId;		// 考试id
	private String userNum;		// 用户名
	private String password;		// 密码

	private String paperId;		//试卷id
	private String score;		// 密码

	public ExamUser() {
		this(null);
	}

	public ExamUser(String id){
		super(id);
	}
	
	@Length(min=0, max=64, message="用户id长度不能超过 64 个字符")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Length(min=0, max=64, message="考试id长度不能超过 64 个字符")
	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}
	
	@Length(min=0, max=32, message="用户名长度不能超过 32 个字符")
	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	
	@Length(min=0, max=32, message="密码长度不能超过 32 个字符")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Length(min=0, max=10, message="分数长度不能超过 10 个字符")
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
}