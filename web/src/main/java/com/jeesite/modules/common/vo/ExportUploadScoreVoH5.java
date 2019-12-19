package com.jeesite.modules.common.vo;

import com.jeesite.common.utils.excel.annotation.ExcelField;

public class ExportUploadScoreVoH5 {
    private String userName;
    private String trueName;
    private String schoolName;
    private String softwareName;


    @ExcelField(title="登录名（身份证号）", align = ExcelField.Align.CENTER, sort = 1)
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

    @ExcelField(title="学校", align = ExcelField.Align.CENTER, sort = 3)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @ExcelField(title="车技通汽车网络营销H5制作教学平台", align = ExcelField.Align.CENTER, sort = 4)
    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }
}
