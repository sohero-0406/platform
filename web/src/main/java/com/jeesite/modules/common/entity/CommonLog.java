/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 大平台日志表Entity
 * @author mayuhu
 * @version 2019-08-10
 */
@Table(name="common_log", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="description", attrName="description", label="方法具体是什么操作"),
		@Column(name="method", attrName="method", label="请求的具体方法"),
		@Column(name="operation_type", attrName="operationType", label="操作类别"),
		@Column(name="request_ip", attrName="requestIp", label="请求发起的ip"),
		@Column(name="exception_code", attrName="exceptionCode", label="异常代号"),
		@Column(name="exception_detail", attrName="exceptionDetail", label="异常详情"),
		@Column(name="params", attrName="params", label="传入参数"),
		@Column(name="true_name", attrName="trueName", label="姓名"),
		@Column(name="user_name", attrName="userName", label="登录名"),
		@Column(name="school_name", attrName="schoolName", label="学校"),
		@Column(name="create_by", attrName="createBy", label="创建者", isUpdate=false, isQuery=false),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false, isQuery=false),
		@Column(name="update_by", attrName="updateBy", label="更新者", isQuery=false),
		@Column(name="update_time", attrName="updateTime", label="更新时间"),
		@Column(name="status", attrName="status", label="状态", isUpdate=false),
		@Column(name="remarks", attrName="remarks", label="备注信息", queryType=QueryType.LIKE),
	}, orderBy="a.id DESC"
)
public class CommonLog extends PreEntity<CommonLog> {
	
	private static final long serialVersionUID = 1L;
	private String description;		// 方法具体是什么操作
	private String method;		// 请求的具体方法
	private String operationType;		// 操作类别
	private String requestIp;		// 请求发起的ip
	private String exceptionCode;		// 异常代号
	private String exceptionDetail;		// 异常详情
	private String params;		// 传入参数
	private Date updateTime;		// 更新时间
	private String trueName;
	private String userName;
	private String schoolName;
	
	public CommonLog() {
		this(null);
	}

	public CommonLog(String id){
		super(id);
	}
	
	@Length(min=0, max=200, message="方法具体是什么操作长度不能超过 200 个字符")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Length(min=0, max=300, message="请求的具体方法长度不能超过 300 个字符")
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	@Length(min=0, max=100, message="操作类别长度不能超过 100 个字符")
	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
	@Length(min=0, max=30, message="请求发起的ip长度不能超过 30 个字符")
	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}
	
	@Length(min=0, max=100, message="异常代号长度不能超过 100 个字符")
	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	
	@Length(min=0, max=10000, message="异常详情长度不能超过 10000 个字符")
	public String getExceptionDetail() {
		return exceptionDetail;
	}

	public void setExceptionDetail(String exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}
	
	@Length(min=0, max=1000, message="传入参数长度不能超过 1000 个字符")
	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	@Length(min=0, max=100, message="姓名长度不能超过 1000 个字符")
	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	@Length(min=0, max=100, message="登录名长度不能超过 1000 个字符")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Length(min=0, max=100, message="学校长度不能超过 1000 个字符")
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}