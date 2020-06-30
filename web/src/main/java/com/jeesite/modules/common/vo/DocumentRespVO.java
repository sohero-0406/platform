package com.jeesite.modules.common.vo;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jiangyf
 * @version 1.0.0
 * @ClassName DocumentRespVO.java
 * @Description 资料返参VO
 * @createTime 2020年06月18日 10:05:00
 */
@Data
@ApiModel(value = "资料返参VO")
public class DocumentRespVO {

	@ApiModelProperty(value = "数据记录标识")
	private String id;
	@ApiModelProperty(value = "是否需要保存")
	private String needSave;
	@ApiModelProperty(value = "文件名称")
	private String documentName;
	@ApiModelProperty(value = "最后修改时间")
	private String lastUpdateDate;
	@ApiModelProperty(value = "文件数据Json对象")
	private Object documentData;

}
