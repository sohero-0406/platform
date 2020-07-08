package com.jeesite.modules.common.vo.vehicleInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VehicleInfoVO {

    @ApiModelProperty("车型id")
    private String chexingId;
    @ApiModelProperty("名称")
    private String name;
}
