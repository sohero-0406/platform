/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.entity;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import com.jeesite.common.utils.excel.annotation.ExcelField;
import org.hibernate.validator.constraints.Length;

/**
 * common_userEntity
 * @author lvchangwei
 * @version 2019-07-16
 */
public class CommonUserTeacher extends PreEntity<CommonUserTeacher> {

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

	public CommonUserTeacher() {
		this(null);
	}

	public CommonUserTeacher(String id){
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
	@ExcelField(title="手机号", align = ExcelField.Align.CENTER, sort = 7)
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	@ExcelField(title="专业", align = ExcelField.Align.CENTER, sort = 5)
	public String getMajorName() {
		return majorName;
	}


	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@ExcelField(title="学校", align = ExcelField.Align.CENTER, sort = 4)
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

    @ExcelField(title="性别", align = ExcelField.Align.CENTER, sort = 3)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}