package com.jeesite.modules.common.vo.vehicleInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class FindDetailForAppraisalRespVO {

    @ApiModelProperty("车型名称")
    private String chexingmingcheng;
    @ApiModelProperty("厂商指导价（元）")
    private String changshangzhidaojiaYuan;
    @ApiModelProperty("车型级别")
    private String jibie;
    @ApiModelProperty("车身尺寸")
    private String changkuangaoMm;
    @ApiModelProperty("发动机")
    private String fadongji;
    @ApiModelProperty("最大功率(KW)")
    private String zuidagonglvKW;
    @ApiModelProperty("最大扭矩(NM)")
    private String zuidaniujuNM;
    @ApiModelProperty("驱动")
    private String qudongfangshi;
    @ApiModelProperty("变速箱")
    private String biansuxiang;
    @ApiModelProperty("环保标准")
    private String huanbaobiaozhun;
    @ApiModelProperty("综合油耗")
    private String gongxinbuzongheyouhaoL100km;
    @ApiModelProperty("车门数")
    private String chemenshuGe;
    @ApiModelProperty("座位数")
    private String zuoweishuGe;
    @ApiModelProperty("图片列表")
    private List<String> imageList;
}
