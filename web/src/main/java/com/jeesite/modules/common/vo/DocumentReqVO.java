package com.jeesite.modules.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Jiangyf
 * @version 1.0.0
 * @ClassName DocumentReqVO.java
 * @Description 考核项入参VO
 * @createTime 2020年06月18日 09:19:00
 */
@Data
@ApiModel(value = "考核项入参VO")
public class DocumentReqVO {

	@NotBlank(message = "考核项下拉入参不能为空")
	@ApiModelProperty(value = "考核Map的key；'1'：初级；'2'：中级；", example = "1")
	private String assessKey;

}
