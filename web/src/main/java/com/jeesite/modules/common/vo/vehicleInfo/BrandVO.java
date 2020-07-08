package com.jeesite.modules.common.vo.vehicleInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class BrandVO {

    @ApiModelProperty("品牌")
    private String brand;
    @ApiModelProperty("车型")
    private List<VehicleInfoVO> infoList;
}
