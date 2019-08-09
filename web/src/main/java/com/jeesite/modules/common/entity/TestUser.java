package com.jeesite.modules.common.entity;

import com.jeesite.common.utils.excel.annotation.ExcelField;

public class TestUser {

    private String name;
    private String card;  //身份证号码
    private String address;  //家庭住址

    @ExcelField(title = "姓名",align=ExcelField.Align.CENTER, sort=100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ExcelField(title = "身份证号码",align=ExcelField.Align.CENTER, sort=30)
    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @ExcelField(title = "家庭住址",align= ExcelField.Align.CENTER, sort=40)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
