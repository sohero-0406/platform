package com.jeesite.modules.common.vo;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Jiangyf
 * @version 1.0.0
 * @ClassName DocumentUpdateVO.java
 * @Description 资料修改入参VO
 * @createTime 2020年06月18日 10:44:00
 */
@Data
@ApiModel(value = "资料修改入参VO")
public class DocumentUpdateVO {

	@ApiModelProperty(value = "资料记录标识")
	@NotBlank(message = "资料记录标识不能为空")
	private String id;

	@ApiModelProperty(value = "文件数据Json对象")
	@NotNull(message = "文件数据Json对象不能为空")
	private Object documentData;
}
