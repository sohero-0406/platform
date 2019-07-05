package com.jeesite.modules.aa.vo;

import com.jeesite.modules.aa.entity.*;

public class CalculateVO {
    private Calculate calculate;
    private CalculateCurrent calculateCurrent;
    private CalculateDepreciation calculateDepreciation;
    private CalculateKm calculateKm;
    private CalculateReplaceCost calculateReplaceCost;

    public Calculate getCalculate() {
        return calculate;
    }

    public void setCalculate(Calculate calculate) {
        this.calculate = calculate;
    }

    public CalculateCurrent getCalculateCurrent() {
        return calculateCurrent;
    }

    public void setCalculateCurrent(CalculateCurrent calculateCurrent) {
        this.calculateCurrent = calculateCurrent;
    }

    public CalculateDepreciation getCalculateDepreciation() {
        return calculateDepreciation;
    }

    public void setCalculateDepreciation(CalculateDepreciation calculateDepreciation) {
        this.calculateDepreciation = calculateDepreciation;
    }

    public CalculateKm getCalculateKm() {
        return calculateKm;
    }

    public void setCalculateKm(CalculateKm calculateKm) {
        this.calculateKm = calculateKm;
    }

    public CalculateReplaceCost getCalculateReplaceCost() {
        return calculateReplaceCost;
    }

    public void setCalculateReplaceCost(CalculateReplaceCost calculateReplaceCost) {
        this.calculateReplaceCost = calculateReplaceCost;
    }
}
