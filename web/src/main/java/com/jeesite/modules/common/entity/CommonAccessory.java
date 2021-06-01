
package com.jeesite.modules.common.entity;

import com.jeesite.common.utils.excel.annotation.ExcelField;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 汽车配件表Entity
 * @author mayuhu
 * @version 2019-08-12
 */
@Table(name="common_accessory", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="accessory_index", attrName="accessoryIndex", label="配件编号"),
		@Column(name="accessory_name", attrName="accessoryName", label="配件名称", queryType=QueryType.LIKE),
		@Column(name="accessory_brand", attrName="accessoryBrand", label="配件品牌"),
		@Column(name="accessory_level", attrName="accessoryLevel", label="accessory_level"),
		@Column(name="accessory_specifications", attrName="accessorySpecifications", label="规格"),
		@Column(name="accessory_unit", attrName="accessoryUnit", label="单位"),
		@Column(name="accessory_price", attrName="accessoryPrice", label="指导价"),
		@Column(name="accessory_place_of_origin", attrName="accessoryPlaceOfOrigin", label="产地"),
		@Column(name="accessory_import", attrName="accessoryImport", label="是否 进口 取值 “是”或者“否”"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="category_id", attrName="categoryId", label="配件分类id"),
	}, orderBy="a.update_date DESC"
)
public class CommonAccessory extends PreEntity<CommonAccessory> {
	
	private static final long serialVersionUID = 1L;
	private String accessoryIndex;		// 配件编号
	private String accessoryName;		// 配件名称
	private String accessoryBrand;		// 配件品牌
	private String accessoryLevel;		// 配件等级
	private String accessorySpecifications;		// 规格
	private String accessoryUnit;		// 单位
	private String accessoryPrice;		// 指导价
	private String accessoryPlaceOfOrigin;		// 产地
	private String accessoryImport;		// 是否 进口 取值 “是”或者“否”
	private String categoryId;		// 配件分类id
	
	public CommonAccessory() {
		this(null);
	}

	public CommonAccessory(String id){
		super(id);
	}
	
	@Length(max=50, message="配件编号长度不能超过 50 个字符")
	@ExcelField(title="配件编号", align = ExcelField.Align.CENTER, sort = 1)
	public String getAccessoryIndex() {
		return accessoryIndex;
	}

	public void setAccessoryIndex(String accessoryIndex) {
		this.accessoryIndex = accessoryIndex;
	}
	
	@Length(max=100, message="配件名称长度不能超过 100 个字符")
	@ExcelField(title="配件名称", align = ExcelField.Align.CENTER, sort = 2)
	public String getAccessoryName() {
		return accessoryName;
	}

	public void setAccessoryName(String accessoryName) {
		this.accessoryName = accessoryName;
	}
	
	@Length(max=100, message="配件品牌长度不能超过 100 个字符")
	@ExcelField(title="配件品牌", align = ExcelField.Align.CENTER, sort = 3)
	public String getAccessoryBrand() {
		return accessoryBrand;
	}

	public void setAccessoryBrand(String accessoryBrand) {
		this.accessoryBrand = accessoryBrand;
	}
	
	@Length(max=45, message="配件等级长度不能超过 45 个字符")
	@ExcelField(title="配件等级", align = ExcelField.Align.CENTER, sort = 4)
	public String getAccessoryLevel() {
		return accessoryLevel;
	}

	public void setAccessoryLevel(String accessoryLevel) {
		this.accessoryLevel = accessoryLevel;
	}
	
	@Length(max=20, message="规格长度不能超过 20 个字符")
	@ExcelField(title="规格", align = ExcelField.Align.CENTER, sort = 5)
	public String getAccessorySpecifications() {
		return accessorySpecifications;
	}

	public void setAccessorySpecifications(String accessorySpecifications) {
		this.accessorySpecifications = accessorySpecifications;
	}
	
	@Length(max=10, message="单位长度不能超过 10 个字符")
	@ExcelField(title="单位", align = ExcelField.Align.CENTER, sort = 6)
	public String getAccessoryUnit() {
		return accessoryUnit;
	}

	public void setAccessoryUnit(String accessoryUnit) {
		this.accessoryUnit = accessoryUnit;
	}
	
	@Length(max=20, message="指导价长度不能超过 20 个字符")
	@ExcelField(title="指导价", align = ExcelField.Align.CENTER, sort = 7)
	public String getAccessoryPrice() {
		return accessoryPrice;
	}

	public void setAccessoryPrice(String accessoryPrice) {
		this.accessoryPrice = accessoryPrice;
	}
	
	@Length(max=100, message="产地长度不能超过 100 个字符")
	@ExcelField(title="产地", align = ExcelField.Align.CENTER, sort = 8)
	public String getAccessoryPlaceOfOrigin() {
		return accessoryPlaceOfOrigin;
	}

	public void setAccessoryPlaceOfOrigin(String accessoryPlaceOfOrigin) {
		this.accessoryPlaceOfOrigin = accessoryPlaceOfOrigin;
	}
	
	@Length(max=10, message="是否 进口 取值 “是”或者“否”长度不能超过 10 个字符")
	@ExcelField(title="是否进口", align = ExcelField.Align.CENTER, sort = 9)
	public String getAccessoryImport() {
		return accessoryImport;
	}

	public void setAccessoryImport(String accessoryImport) {
		this.accessoryImport = accessoryImport;
	}
	
	@Length(max=64, message="配件分类id长度不能超过 64 个字符")
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
}