package com.jeesite.modules.common.entity;

import com.jeesite.common.utils.excel.annotation.ExcelField;

public class UserCondition {

    private String userName;
    private String trueName;
    private String assessmentDate;
    private String assessmentTime;
    private String majorName;
    private String className;
    private String schoolName;
    private String gender;
    private String commonUserId;
    private String schoolId;



    @ExcelField(title = "身份证",align=ExcelField.Align.CENTER, sort=1)
    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ExcelField(title = "姓名",align=ExcelField.Align.CENTER, sort=2)
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    @ExcelField(title = "考核日期",align=ExcelField.Align.CENTER, sort=3)
    public String getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(String assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    @ExcelField(title = "考核时间",align=ExcelField.Align.CENTER, sort=4)
    public String getAssessmentTime() {
        return assessmentTime;
    }

    public void setAssessmentTime(String assessmentTime) {
        this.assessmentTime = assessmentTime;
    }

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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCommonUserId() {
        return commonUserId;
    }

    public void setCommonUserId(String commonUserId) {
        this.commonUserId = commonUserId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}
