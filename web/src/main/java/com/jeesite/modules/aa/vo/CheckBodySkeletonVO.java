package com.jeesite.modules.aa.vo;

import com.jeesite.modules.aa.entity.CheckBodySkeleton;
import com.jeesite.modules.aa.entity.CheckTradableVehicles;
import com.jeesite.modules.aa.entity.ExamDetail;

import java.util.List;

/**
 * 检查车体骨架VO
 *
 * @author lvchangwei
 * @version 2019-07-02
 */
public class CheckBodySkeletonVO {

    private List<CheckBodySkeleton> skeletonList;
    private CheckTradableVehicles checkTradableVehicles;
    private ExamDetail examDetail;

    public List<CheckBodySkeleton> getSkeletonList() {
        return skeletonList;
    }

    public void setSkeletonList(List<CheckBodySkeleton> skeletonList) {
        this.skeletonList = skeletonList;
    }

    public CheckTradableVehicles getCheckTradableVehicles() {
        return checkTradableVehicles;
    }

    public void setCheckTradableVehicles(CheckTradableVehicles checkTradableVehicles) {
        this.checkTradableVehicles = checkTradableVehicles;
    }

    public ExamDetail getExamDetail() {
        return examDetail;
    }

    public void setExamDetail(ExamDetail examDetail) {
        this.examDetail = examDetail;
    }
}
