package com.jeesite.modules.aa.vo;

import com.jeesite.modules.aa.entity.Reference;
import com.jeesite.modules.sys.entity.DictData;

import java.util.List;

public class ReferenceVO {

    //车辆配置类型
    private List<DictData> vehicleConfigurationTypeList;
    //发动机类型
    private List<DictData> engineTypeList;
    //变速箱类型
    private List<DictData> gearboxTypeList;
    //尾气排放标准
    private List<DictData> environmentalStandardList;
    //付款方式
    private List<DictData> paymentMethodList;
    //参照物
    private Reference reference;

    public List<DictData> getVehicleConfigurationTypeList() {
        return vehicleConfigurationTypeList;
    }

    public void setVehicleConfigurationTypeList(List<DictData> vehicleConfigurationTypeList) {
        this.vehicleConfigurationTypeList = vehicleConfigurationTypeList;
    }

    public List<DictData> getEngineTypeList() {
        return engineTypeList;
    }

    public void setEngineTypeList(List<DictData> engineTypeList) {
        this.engineTypeList = engineTypeList;
    }

    public List<DictData> getGearboxTypeList() {
        return gearboxTypeList;
    }

    public void setGearboxTypeList(List<DictData> gearboxTypeList) {
        this.gearboxTypeList = gearboxTypeList;
    }

    public List<DictData> getEnvironmentalStandardList() {
        return environmentalStandardList;
    }

    public void setEnvironmentalStandardList(List<DictData> environmentalStandardList) {
        this.environmentalStandardList = environmentalStandardList;
    }

    public List<DictData> getPaymentMethodList() {
        return paymentMethodList;
    }

    public void setPaymentMethodList(List<DictData> paymentMethodList) {
        this.paymentMethodList = paymentMethodList;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }
}
