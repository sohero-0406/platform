package com.jeesite.modules.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SoftwareName {

    @ApiModelProperty("项目名称")
    private String projectName;
    @ApiModelProperty("软件id")
    private String softId;
    @ApiModelProperty("软件名称")
    private String softName;


}
