/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.CommonDocument;
import com.jeesite.modules.common.vo.DocumentRespVO;
import com.jeesite.modules.common.vo.DocumentSearchReqVO;

import java.util.List;

/**
 * 资料表DAO接口
 * @author jiangyanfei
 * @version 2020-06-16
 */
@MyBatisDao
public interface CommonDocumentDao extends CrudDao<CommonDocument> {

	List<DocumentRespVO> loadDocs(DocumentSearchReqVO documentSearchReqVO);
}