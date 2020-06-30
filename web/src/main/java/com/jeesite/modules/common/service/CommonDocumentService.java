/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.*;
import java.util.stream.Collectors;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.lang.DateUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.mapper.JsonMapper;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.vo.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.CommonDocument;
import com.jeesite.modules.common.dao.CommonDocumentDao;

import javax.validation.constraints.NotNull;

/**
 * 资料表Service
 * @author jiangyanfei
 * @version 2020-06-16
 */
@Service
@Transactional(readOnly=true)
public class CommonDocumentService extends CrudService<CommonDocumentDao, CommonDocument> {
	
	/**
	 * 获取单条数据
	 * @param commonDocument
	 * @return
	 */
	@Override
	public CommonDocument get(CommonDocument commonDocument) {
		return super.get(commonDocument);
	}
	
	/**
	 * 查询分页数据
	 * @param commonDocument 查询条件
	 * @return
	 */
	@Override
	public Page<CommonDocument> findPage(CommonDocument commonDocument) {
		return super.findPage(commonDocument);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonDocument
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonDocument commonDocument) {
		super.save(commonDocument);
	}
	
	/**
	 * 更新状态
	 * @param commonDocument
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonDocument commonDocument) {
		super.updateStatus(commonDocument);
	}
	
	/**
	 * 删除数据
	 * @param commonDocument
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonDocument commonDocument) {
		super.delete(commonDocument);
	}


	/**
	 * @Author Jiangyf
	 * @Description 加载考核或考核项
	 * @Date 2020/6/18
	 * @Param [documentReqVO]
	 * @return com.jeesite.modules.common.entity.CommonResult<java.util.List<java.lang.String>>
	 **/
	public CommonResult<List<ItemVO>> loadAssessItemList(String assessKey) {
		List<ItemVO> respVO = new ArrayList<>();
		if (StringUtils.isBlank(assessKey)) {
			// 选择考核
			ItemVO item1 = new ItemVO();
			item1.setKey("1");
			item1.setName("汽车营销评估与金融保险服务技术【初级】");
			ItemVO item2 = new ItemVO();
			item2.setKey("2");
			item2.setName("汽车营销评估与金融保险服务技术【中级】");
			respVO.add(item1);
			respVO.add(item2);
			return new CommonResult<>(respVO);
		}
		// 选择考核项
		Map<String, String> map = loadAssessAndItemsMap().get(assessKey);
		map.forEach((key, value) -> {
			ItemVO item = new ItemVO();
			item.setKey(key);
			item.setName(value);
			respVO.add(item);
		});
		return new CommonResult<>(respVO);
	}

	private static Map<String, Map<String, String>> loadAssessAndItemsMap() {
		Map<String, Map<String, String>> assessItemsMap = new HashMap<>();
		assessItemsMap.put("1", new HashMap<String, String>(){{
			put("1", "汽车销售与三包作业流程");
			put("2", "汽车保险与按揭作业流程");
			put("3", "汽车配件进销存作业流程");
			put("4", "客户关系管理与网络营销");
		}});
		assessItemsMap.put("2", new HashMap<String, String>(){{
			put("5", "二手车评估作业鉴定技术");
			put("6", "保险理赔与三包作业技术");
			put("7", "电子定损计算机应用技术");
			put("8", "客户信息管理与数据应用");
		}});
		return assessItemsMap;
	}

	/**
	 * @Author Jiangyf
	 * @Description 资料筛选
	 * @Date 2020/6/18
	 * @Param [documentSearchReqVO]
	 * @return com.jeesite.modules.common.entity.CommonResult<java.util.List<com.jeesite.modules.common.vo.DocumentRespVO>>
	 **/
	public CommonResult<Page<DocumentRespVO>> loadDocs(DocumentSearchReqVO documentSearchReqVO) {
		Page<DocumentRespVO> page = documentSearchReqVO.getPage();
		return new CommonResult<>(page.setList(dao.loadDocs(documentSearchReqVO)));
	}

	/**
	 * @Author Jiangyf
	 * @Description 资料编辑
	 * @Date 2020/6/18
	 * @Param [documentUpdateVO]
	 * @return com.jeesite.modules.common.entity.CommonResult<org.apache.poi.ss.formula.functions.T>
	 **/
	@Transactional(readOnly = false)
	public CommonResult<T> updateDoc(DocumentUpdateVO documentUpdateVO) {
		CommonDocument doc = this.get(documentUpdateVO.getId());
		if (Objects.isNull(doc)) {
			return new CommonResult<>(CodeConstant.NO_DATA, "无法查询到相关资料数据");
		}
		doc.setDocumentData(documentUpdateVO.getDocumentData().toString());
		doc.setLastUpdateDate(DateUtils.formatDate(new Date(), "yyyyMMdd HH:mm:ss"));
		this.update(doc);
		return new CommonResult<>();
	}

	/**
	 * @Author Jiangyf
	 * @Description 资料加载
	 * @Date 2020/6/18
	 * @Param [documentLoadVO]
	 * @return com.jeesite.modules.common.entity.CommonResult<com.jeesite.modules.common.vo.DocumentRespVO>
	 **/
	@Transactional(readOnly = false)
	public CommonResult<DocumentRespVO> loadDoc(String id) {
		CommonDocument doc = this.get(id);
		if (Objects.isNull(doc)) {
			return new CommonResult<>(CodeConstant.NO_DATA, "无法查询到相关资料数据");
		}
		DocumentRespVO result = new DocumentRespVO();
		result.setId(doc.getId());
		result.setDocumentName(doc.getDocumentName());
		result.setDocumentData(JSONObject.parseObject(doc.getDocumentData()));
		result.setLastUpdateDate(doc.getLastUpdateDate());
		return new CommonResult<>(result);
	}
}

