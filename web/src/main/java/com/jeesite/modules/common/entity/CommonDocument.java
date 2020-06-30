/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;

/**
 * 资料表Entity
 * @author jiangyanfei
 * @version 2020-06-16
 */
@Table(name="common_document", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="need_save", attrName="needSave", label="是否需要保存"),
		@Column(name="accessory_name", attrName="accessoryName", label="考核项名称"),
		@Column(name="document_name", attrName="documentName", label="文件名称"),
		@Column(name="last_update_date", attrName="lastUpdateDate", label="最后修改时间"),
		@Column(name="document_data", attrName="documentData", label="文件数据"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CommonDocument extends DataEntity<CommonDocument> {
	
	private static final long serialVersionUID = 1L;
	private String needSave;		// 是否需要保存
	private String accessoryName;		// 考核项名称
	private String documentName;		// 文件名称
	private String lastUpdateDate;		// 最后修改时间
	private String documentData;		// 文件数据
	
	public CommonDocument() {
		this(null);
	}

	public CommonDocument(String id){
		super(id);
	}
	
	@Length(min=0, max=50, message="是否需要保存长度不能超过 50 个字符")
	public String getNeedSave() {
		return needSave;
	}

	public void setNeedSave(String needSave) {
		this.needSave = needSave;
	}
	
	@Length(min=0, max=100, message="考核项名称长度不能超过 100 个字符")
	public String getAccessoryName() {
		return accessoryName;
	}

	public void setAccessoryName(String accessoryName) {
		this.accessoryName = accessoryName;
	}
	
	@Length(min=0, max=100, message="文件名称长度不能超过 100 个字符")
	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	
	@Length(min=0, max=50, message="最后修改时间长度不能超过 50 个字符")
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public String getDocumentData() {
		return documentData;
	}

	public void setDocumentData(String documentData) {
		this.documentData = documentData;
	}
	
}