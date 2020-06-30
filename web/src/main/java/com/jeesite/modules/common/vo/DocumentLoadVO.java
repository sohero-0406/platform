package com.jeesite.modules.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Jiangyf
 * @version 1.0.0
 * @ClassName DocumentLoadVO.java
 * @Description 资料加载入参VO
 * @createTime 2020年06月18日 10:56:00
 */
@Data
@ApiModel(value = "资料加载入参VO")
public class DocumentLoadVO {

	@ApiModelProperty(value = "资料记录标识")
	@NotBlank(message = "资料记录标识不能为空")
	private String id;
}
