/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.service;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.aa.dao.AppraisalReportDao;
import com.jeesite.modules.aa.entity.*;
import com.jeesite.modules.aa.vo.AppraisalReportVO;
import com.jeesite.modules.common.entity.ExamUser;
import com.jeesite.modules.common.entity.VehicleInfo;
import com.jeesite.modules.common.service.VehicleInfoService;
import com.jeesite.modules.common.utils.MoneyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 二手车鉴定评估报告Service
 *
 * @author lvchangwei
 * @version 2019-07-19
 */
@Service
@Transactional(readOnly = true)
public class AppraisalReportService extends CrudService<AppraisalReportDao, AppraisalReport> {

    @Autowired
    private DelegateUserService delegateUserService;
    @Autowired
    private CarInfoService carInforService;
    @Autowired
    private VehicleDocumentInfoService vehicleDocumentInfoService;
    @Autowired
    private CheckTradableVehiclesService checkTradableVehiclesService;
    @Autowired
    private IdentifyTecService identifyTecService;
    @Autowired
    private VehicleGradeAssessService vehicleGradeAssessService;
    @Autowired
    private CalculateService calculateService;
    @Autowired
    private DelegateLetterService delegateLetterService;
    @Autowired
    private VehicleInfoService vehicleInfoService;
    @Autowired
    private CalculateDepreciationService calculateDepreciationService;
    @Autowired
    private CalculateKmService calculateKmService;
    @Autowired
    private CalculateReplaceCostService calculateReplaceCostService;
    @Autowired
    private CalculateCurrentService calculateCurrentService;


    /**
     * 获取单条数据
     *
     * @param appraisalReport
     * @return
     */
    @Override
    public AppraisalReport get(AppraisalReport appraisalReport) {
        return super.get(appraisalReport);
    }

    /**
     * 查询分页数据
     *
     * @param appraisalReport 查询条件
     * @return
     */
    @Override
    public Page<AppraisalReport> findPage(AppraisalReport appraisalReport) {
        return super.findPage(appraisalReport);
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param appraisalReport
     */
    @Override
    @Transactional(readOnly = false)
    public void save(AppraisalReport appraisalReport) {
        super.save(appraisalReport);
    }

    /**
     * 更新状态
     *
     * @param appraisalReport
     */
    @Override
    @Transactional(readOnly = false)
    public void updateStatus(AppraisalReport appraisalReport) {
        super.updateStatus(appraisalReport);
    }

    /**
     * 删除数据
     *
     * @param appraisalReport
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(AppraisalReport appraisalReport) {
        super.delete(appraisalReport);
    }

    public AppraisalReport getByEntity(AppraisalReport appraisalReport) {
        return dao.getByEntity(appraisalReport);
    }

    public AppraisalReportVO findAppraisalReport(ExamUser examUser) {

        AppraisalReportVO appraisalReportVO = new AppraisalReportVO();

        //缺陷描述
        StringBuilder defectDescription = new StringBuilder();
        //大写金额
        String priceCapital = null;

        //鉴定报告
        AppraisalReport appraisalReport = new AppraisalReport();
        appraisalReport.setExamUserId(examUser.getExamId());
        appraisalReport.setPaperId(examUser.getPaperId());
        appraisalReport = this.getByEntity(appraisalReport);
        if (StringUtils.isNotBlank(appraisalReport.getBaseDateEnd())) {
            String[] baseDateEndArr = appraisalReport.getBaseDateEnd().substring(0, 10).split("-");
            appraisalReport.setBaseDateEnd(baseDateEndArr[0] + "年" + baseDateEndArr[1] + "月" + baseDateEndArr[2] + "日");
        }
        appraisalReportVO.setAppraisalReport(appraisalReport);

        //委托人
        DelegateUser delegateUser = new DelegateUser();
        delegateUser.setExamUserId(examUser.getExamId());
        delegateUser.setPaperId(examUser.getPaperId());
        delegateUser = delegateUserService.getByEntity(delegateUser);
        appraisalReportVO.setDelegateUser(delegateUser);
        appraisalReportVO.setCarOwner(delegateUser.getName());

        //车辆信息
        CarInfo carInfo = new CarInfo();
        carInfo.setExamUserId(examUser.getExamId());
        carInfo.setPaperId(examUser.getPaperId());
        carInfo = carInforService.getByEntity(carInfo);
        if (StringUtils.isNotBlank(carInfo.getRegisterDate())) {
            String[] registerDateArr = carInfo.getRegisterDate().substring(0, 10).split("-");
            carInfo.setRegisterDate(registerDateArr[0] + "年" + registerDateArr[1] + "月" + registerDateArr[2] + "日");
        }
        if (StringUtils.isNotBlank(carInfo.getYearCheckDue())) {
            String[] yearCheckDueArr = carInfo.getYearCheckDue().substring(0, 10).split("-");
            carInfo.setYearCheckDue(yearCheckDueArr[0] + "年" + yearCheckDueArr[1] + "月");
        }
        appraisalReportVO.setCarInfo(carInfo);

        //车辆单证信息
        List<VehicleDocumentInfo> vehicleDocumentInfoList = new ArrayList<VehicleDocumentInfo>();
        VehicleDocumentInfo vehicleDocumentInfo = new VehicleDocumentInfo();
        vehicleDocumentInfo.setExamUserId(examUser.getExamId());
        vehicleDocumentInfo.setPaperId(examUser.getPaperId());
        vehicleDocumentInfoList = vehicleDocumentInfoService.findList(vehicleDocumentInfo);
        for (VehicleDocumentInfo temp : vehicleDocumentInfoList) {
            if ("1".equals(temp.getState())) {
                temp.setState("是");
            } else {
                temp.setState("否");
            }
            String[] projectArr = temp.getValidity().substring(0, 10).split("-");
            if ("3".equals(temp.getProject()) && StringUtils.isNotBlank(temp.getValidity())) {
                //车船税截止日期
                temp.setValidity(projectArr[0] + "年" + projectArr[1] + "月");
            } else {
                temp.setValidity(projectArr[0] + "年" + projectArr[1] + "月" + projectArr[2] + "日");
            }
        }
        appraisalReportVO.setVehicleDocumentInfolist(vehicleDocumentInfoList);

        //检查可交易车辆
        CheckTradableVehicles checkTradableVehicles = new CheckTradableVehicles();
        checkTradableVehicles.setExamUserId(examUser.getExamId());
        checkTradableVehicles.setPaperId(examUser.getPaperId());
        checkTradableVehicles = checkTradableVehiclesService.getByEntity(checkTradableVehicles);
        if ("1".equals(checkTradableVehicles.getCheck3())) {
            checkTradableVehicles.setCheck3("是");
        } else {
            checkTradableVehicles.setCheck3("否");
        }
        if ("1".equals(checkTradableVehicles.getTrafficIllegalRecord())) {
            checkTradableVehicles.setCheck3("有");
        } else {
            checkTradableVehicles.setCheck3("无");
        }
        appraisalReportVO.setCheckTradableVehicles(checkTradableVehicles);

        //鉴定技术状况
        List<IdentifyTec> identifyTecList = new ArrayList<IdentifyTec>();
        IdentifyTec identifyTec = new IdentifyTec();
        identifyTec.setExamUserId(examUser.getExamId());
        identifyTec.setPaperId(examUser.getPaperId());
        identifyTecList = identifyTecService.findList(identifyTec);
        for (IdentifyTec temp : identifyTecList) {
            defectDescription.append(temp.getDescription());
        }

        //车辆等级评定
        VehicleGradeAssess vehicleGradeAssess = new VehicleGradeAssess();
        vehicleGradeAssess.setExamUserId(examUser.getExamId());
        vehicleGradeAssess.setPaperId(examUser.getPaperId());
        vehicleGradeAssess = vehicleGradeAssessService.getByEntity(vehicleGradeAssess);
        if ("1".equals(vehicleGradeAssess.getTechnicalStatus())) {
            vehicleGradeAssess.setTechnicalStatus("一级");
        } else if ("2".equals(vehicleGradeAssess.getTechnicalStatus())) {
            vehicleGradeAssess.setTechnicalStatus("二级");
        } else if ("3".equals(vehicleGradeAssess.getTechnicalStatus())) {
            vehicleGradeAssess.setTechnicalStatus("三级");
        } else if ("4".equals(vehicleGradeAssess.getTechnicalStatus())) {
            vehicleGradeAssess.setTechnicalStatus("四级");
        } else if ("5".equals(vehicleGradeAssess.getTechnicalStatus())) {
            vehicleGradeAssess.setTechnicalStatus("五级");
        }

        if (StringUtils.isNotBlank(vehicleGradeAssess.getIdentifyDate())) {
            String[] identifyDateArr = vehicleGradeAssess.getIdentifyDate().substring(0, 10).split("-");
            vehicleGradeAssess.setIdentifyDate(identifyDateArr[0] + "年" + identifyDateArr[1] + "月" + identifyDateArr[2] + "日");
        }
        appraisalReportVO.setVehicleGradeAssess(vehicleGradeAssess);
        defectDescription.append(vehicleGradeAssess.getDescription());
        //填入缺陷描述
        appraisalReportVO.setDefectDescription(defectDescription.toString());

        //计算车辆价值
        Calculate calculate = new Calculate();
        calculate.setExamUserId(examUser.getExamId());
        calculate.setPaperId(examUser.getPaperId());
        calculate = calculateService.getByEntity(calculate);
        if ("1".equals(calculate.getType())) {
            CalculateDepreciation calculateDepreciation = new CalculateDepreciation();
            calculateDepreciation.setCalculateId(calculate.getId());
            calculateDepreciation = calculateDepreciationService.getByEntity(calculateDepreciation);
            priceCapital = MoneyUtils.change(calculateDepreciation.getPrice());
            calculate.setType("折旧率估值法");
        } else if ("2".equals(calculate.getType())) {
            CalculateKm calculateKm = new CalculateKm();
            calculateKm.setCalculateId(calculate.getId());
            calculateKm = calculateKmService.getByEntity(calculateKm);
            priceCapital = MoneyUtils.change(calculateKm.getPrice());
            calculate.setType("公里数估值法");
        } else if ("3".equals(calculate.getType())) {
            CalculateReplaceCost calculateReplaceCost = new CalculateReplaceCost();
            calculateReplaceCost.setCalculateId(calculate.getId());
            calculateReplaceCost = calculateReplaceCostService.getByEntity(calculateReplaceCost);
            priceCapital = MoneyUtils.change(calculateReplaceCost.getPrice());
            calculate.setType("重置成本法");
        } else if ("4".equals(calculate.getType())) {
            CalculateCurrent calculateCurrent = new CalculateCurrent();
            calculateCurrent.setCalculateId(calculate.getId());
            calculateCurrent = calculateCurrentService.getByEntity(calculateCurrent);
            priceCapital = MoneyUtils.change(calculateCurrent.getPrice());
            calculate.setType("现行市价法");
        }
        appraisalReportVO.setCalculate(calculate);
        appraisalReportVO.setPriceCapital(priceCapital);

        //委托书信息
        DelegateLetter delegateLetter = new DelegateLetter();
        delegateLetter.setExamUserId(examUser.getExamId());
        delegateLetter.setPaperId(examUser.getPaperId());
        delegateLetter = delegateLetterService.getByEntity(delegateLetter);
        appraisalReportVO.setDelegateLetter(delegateLetter);

        //车辆配置全表
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setChexingId(carInfo.getModel());
        vehicleInfo = vehicleInfoService.getCarModel(vehicleInfo);
        appraisalReportVO.setVehicleInfo(vehicleInfo);

        return appraisalReportVO;
    }

}