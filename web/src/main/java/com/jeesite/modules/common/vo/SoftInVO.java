package com.jeesite.modules.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SoftInVO {
    @ApiModelProperty("软件id")
    private String softwareId;
    @ApiModelProperty("是否下载答题详情 0 不下 1下")
    private String isDownAnswerDetail;
    @ApiModelProperty("是否下载工单 0 不下 1下")
    private String isDownWorkOrder;
    @ApiModelProperty("项目名称")
    private String projectName;

}
