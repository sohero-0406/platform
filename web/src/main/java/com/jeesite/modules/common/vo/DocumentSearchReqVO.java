package com.jeesite.modules.common.vo;

import com.jeesite.common.entity.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Jiangyf
 * @version 1.0.0
 * @ClassName DocumentSearchReqVO.java
 * @Description 资料搜索入参VO
 * @createTime 2020年06月18日 10:10:00
 */
@Data
@ApiModel(value = "资料搜索入参VO")
public class DocumentSearchReqVO {


	@ApiModelProperty(value = "搜索时这里为考核项返回Map的key；'2'：汽车保险与按揭作业流程", example = "2")
	@NotBlank(message = "考核项返回Map的key不能为空")
	private String assessItemKey;

	@ApiModelProperty(value = "分页对象")
	@NotNull(message = "分页对象不能为空")
	Page<DocumentRespVO> page;
}
