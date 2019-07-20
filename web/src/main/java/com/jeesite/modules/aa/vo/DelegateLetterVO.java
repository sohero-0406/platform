package com.jeesite.modules.aa.vo;

import com.jeesite.modules.aa.entity.CarInfo;
import com.jeesite.modules.aa.entity.DelegateLetter;
import com.jeesite.modules.aa.entity.DelegateUser;
import com.jeesite.modules.aa.entity.PictureUser;

public class DelegateLetterVO {

    private DelegateLetter delegateLetter;      //委托书
    private DelegateUser delegateUser;      //委托人
    private CarInfo carInfo;        //车辆信息
    private PictureUser pictureUser;        //用户图片

    public DelegateLetter getDelegateLetter() {
        return delegateLetter;
    }

    public void setDelegateLetter(DelegateLetter delegateLetter) {
        this.delegateLetter = delegateLetter;
    }

    public DelegateUser getDelegateUser() {
        return delegateUser;
    }

    public void setDelegateUser(DelegateUser delegateUser) {
        this.delegateUser = delegateUser;
    }

    public CarInfo getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(CarInfo carInfo) {
        this.carInfo = carInfo;
    }

    public PictureUser getPictureUser() {
        return pictureUser;
    }

    public void setPictureUser(PictureUser pictureUser) {
        this.pictureUser = pictureUser;
    }
}
