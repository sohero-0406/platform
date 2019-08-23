package com.jeesite.modules.common.entity;

import com.jeesite.common.utils.excel.annotation.ExcelField;

public class UploadStu {


    private String userName;

    private String trueName;

    private String assessmentDate;

    private String assessmentTime;

    @ExcelField(title="身份证号", align = ExcelField.Align.CENTER, sort = 1)
    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ExcelField(title="姓名", align = ExcelField.Align.CENTER, sort = 2)
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    @ExcelField(title="考核日期", align = ExcelField.Align.CENTER, sort = 3)
    public String getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(String assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    @ExcelField(title="考核时间", align = ExcelField.Align.CENTER, sort = 4)
    public String getAssessmentTime() {
        return assessmentTime;
    }

    public void setAssessmentTime(String assessmentTime) {
        this.assessmentTime = assessmentTime;
    }
}
