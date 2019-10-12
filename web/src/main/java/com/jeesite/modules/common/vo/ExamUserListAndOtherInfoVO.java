package com.jeesite.modules.common.vo;

import com.jeesite.modules.common.entity.CommonUser;

import java.util.List;

public class ExamUserListAndOtherInfoVO {
    private List<CommonUser> list;
    private String assessmentName;
    private String assessmentDate;
    private String assessmentTime;
    private List<String> assessmentNameList;
    private List<String> assessmentDateList;
    private List<String> assessmentTimeList;
    private String majorName;
    private String clsName;
    private List<String> majorNameList;
    private List<String> clsNameList;

    public List<CommonUser> getList() {
        return list;
    }

    public void setList(List<CommonUser> list) {
        this.list = list;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public String getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(String assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public String getAssessmentTime() {
        return assessmentTime;
    }

    public void setAssessmentTime(String assessmentTime) {
        this.assessmentTime = assessmentTime;
    }

    public List<String> getAssessmentNameList() {
        return assessmentNameList;
    }

    public void setAssessmentNameList(List<String> assessmentNameList) {
        this.assessmentNameList = assessmentNameList;
    }

    public List<String> getAssessmentDateList() {
        return assessmentDateList;
    }

    public void setAssessmentDateList(List<String> assessmentDateList) {
        this.assessmentDateList = assessmentDateList;
    }

    public List<String> getAssessmentTimeList() {
        return assessmentTimeList;
    }

    public void setAssessmentTimeList(List<String> assessmentTimeList) {
        this.assessmentTimeList = assessmentTimeList;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public List<String> getMajorNameList() {
        return majorNameList;
    }

    public void setMajorNameList(List<String> majorNameList) {
        this.majorNameList = majorNameList;
    }

    public List<String> getClsNameList() {
        return clsNameList;
    }

    public void setClsNameList(List<String> clsNameList) {
        this.clsNameList = clsNameList;
    }
}
