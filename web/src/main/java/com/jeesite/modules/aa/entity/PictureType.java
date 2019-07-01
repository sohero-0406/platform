/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.aa.entity;

import com.jeesite.modules.common.entity.PreEntity;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 图片类型表Entity
 * @author chenlitao
 * @version 2019-07-01
 */
@Table(name="aa_picture_type", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="parent_id", attrName="parentId", label="父级id"),
		@Column(name="parent_ids", attrName="parentIds", label="所有父级id"),
		@Column(name="sort", attrName="sort", label="本级排序号", comment="本级排序号（升序）"),
		@Column(name="is_leaf", attrName="isLeaf", label="是否最末级"),
		@Column(name="level", attrName="level", label="层次级别"),
		@Column(name="name", attrName="name", label="全节点名", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class PictureType extends PreEntity<PictureType> {
	
	private static final long serialVersionUID = 1L;
	private String parentId;		// 父级id
	private String parentIds;		// 所有父级id
	private Integer sort;		// 本级排序号（升序）
	private String isLeaf;		// 是否最末级
	private Integer level;		// 层次级别
	private String name;		// 全节点名
	
	public PictureType() {
		this(null);
	}

	public PictureType(String id){
		super(id);
	}
	
	@Length(min=0, max=64, message="父级id长度不能超过 64 个字符")
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	@Length(min=0, max=1000, message="所有父级id长度不能超过 1000 个字符")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	@Length(min=0, max=1, message="是否最末级长度不能超过 1 个字符")
	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
	@Length(min=0, max=1000, message="全节点名长度不能超过 1000 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}