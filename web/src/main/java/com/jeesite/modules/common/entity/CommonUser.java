/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.entity;

import com.jeesite.common.entity.Page;
import com.jeesite.common.utils.excel.annotation.ExcelField;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * common_userEntity
 * @author lvchangwei
 * @version 2019-07-16
 */
@Table(name="common_user", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="user_name", attrName="userName", label="用户名", queryType=QueryType.LIKE),
		@Column(name="password", attrName="password", label="密码"),
		@Column(name="true_name", attrName="trueName", label="真实姓名", queryType=QueryType.LIKE),
		@Column(name="type", attrName="type", label="用户类型", comment="用户类型（学员，教员）"),
		@Column(name="school_id", attrName="schoolId", label="学校id", comment="学校id"),
		@Column(name="role_id", attrName="roleId", label="角色id", comment="角色id"),
		@Column(name="is_exam_right", attrName="isExamRight", label="是否有创建考试的权限", comment="0是没有 1是有"),
		@Column(name="phone_num", attrName="phoneNum", label="手机号", comment="手机号"),
		@Column(name="major_name", attrName="majorName", label="专业", comment="专业"),
		@Column(name="class_name", attrName="className", label="班级", comment="班级"),
		@Column(name="gender", attrName="gender", label="性别", comment="性别"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CommonUser extends PreEntity<CommonUser> {
	
	private static final long serialVersionUID = 1L;
	private String userName;		// 用户名
	private String password;		// 密码
	private String trueName;		// 真实姓名
	private String type;		// 用户类型（学员，教员）
	private String schoolId;   // 学校id
	private String roleId;    // 角色id
	private String isExamRight; // 是否有考试权限
	private String phoneNum;
	private String majorName;
	private String className;
	private String schoolName;
	private String gender;


	// 非数据库字段
	private String token;
	private String commonAssessmentStuId;
	private String roleArray;
	
	public CommonUser() {
		this(null);
	}

	public CommonUser(String id){
		super(id);
	}
	
	@Length(min=0, max=32, message="用户名长度不能超过 32 个字符")
	@ExcelField(title="身份证号", align = ExcelField.Align.CENTER, sort = 1)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=0, max=32, message="密码长度不能超过 32 个字符")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=0, max=32, message="真实姓名长度不能超过 32 个字符")
	@ExcelField(title="姓名", align = ExcelField.Align.CENTER, sort = 2)
	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	@Length(min=0, max=10, message="用户类型长度不能超过 10 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getIsExamRight() {
		return isExamRight;
	}

	public void setIsExamRight(String isExamRight) {
		this.isExamRight = isExamRight;
	}

	@Length(min=0, max=20, message="手机号长度不能超过 20 个字符")
	@ExcelField(title="手机号", align = ExcelField.Align.CENTER, sort = 3)
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@ExcelField(title="专业", align = ExcelField.Align.CENTER, sort = 6)
	public String getMajorName() {
		return majorName;
	}


	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@ExcelField(title="班级", align = ExcelField.Align.CENTER, sort = 7)
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@ExcelField(title="学校", align = ExcelField.Align.CENTER, sort = 5)
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

    @ExcelField(title="性别", align = ExcelField.Align.CENTER, sort = 4)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

	public String getCommonAssessmentStuId() {
		return commonAssessmentStuId;
	}

	public void setCommonAssessmentStuId(String commonAssessmentStuId) {
		this.commonAssessmentStuId = commonAssessmentStuId;
	}

	public String getRoleArray() {
		return roleArray;
	}

	public void setRoleArray(String roleArray) {
		this.roleArray = roleArray;
	}
}