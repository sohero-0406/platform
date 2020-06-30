package com.jeesite.modules.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jiangyf
 * @version 1.0.0
 * @ClassName ItemVO.java
 * @Description 考核项VO
 * @createTime 2020年06月19日 15:21:00
 */
@Data
@ApiModel(value = "考核项VO")
public class ItemVO {

	@ApiModelProperty(value = "标识")
	private String key;
	@ApiModelProperty(value = "名称")
	private String name;

}
