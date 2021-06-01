package com.jeesite.modules.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class DownLoadFinalZipReqVO {

    @ApiModelProperty("需要下载的软件列表")
    private List<SoftInVO> softInVOList;

    @ApiModelProperty("考核id")
    private String assessmentId;

}
