package com.jeesite.modules.aa.vo;

import com.jeesite.modules.aa.entity.CheckBodySkeleton;

import java.util.List;

/**
 * 检查车体骨架VO
 * @author lvchangwei
 * @version 2019-07-02
 */
public class CheckBodySkeletonVO {

    private List<CheckBodySkeleton> skeletonList;
    private String isAccident;
    private String enableAccidentVehicle;

    public List<CheckBodySkeleton> getSkeletonList() {
        return skeletonList;
    }

    public void setSkeletonList(List<CheckBodySkeleton> skeletonList) {
        this.skeletonList = skeletonList;
    }

    public String getIsAccident() {
        return isAccident;
    }

    public void setIsAccident(String isAccident) {
        this.isAccident = isAccident;
    }

    public String getEnableAccidentVehicle() {
        return enableAccidentVehicle;
    }

    public void setEnableAccidentVehicle(String enableAccidentVehicle) {
        this.enableAccidentVehicle = enableAccidentVehicle;
    }
}
