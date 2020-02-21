package com.jeesite.modules.common.web;

import com.jeesite.common.utils.excel.ExcelImport;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.CommonAccessory;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.service.CommonAccessoryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 汽车配件表Controller
 * @author mayuhu
 * @version 2019-08-12
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonAccessory")
public class CommonAccessoryController extends BaseController {

	@Autowired
	private CommonAccessoryService commonAccessoryService;

	/**
	 * 加载配件分页数据
	 * @param commonAccessory
	 * @return
	 */
	@ApiOperation(value = "加载配件分页数据")
	@ApiImplicitParam(name = "commonAccessory", value = "查询的配件条件对象", required = true, dataType="CommonAccessory")
	@Log(operationName = "加载配件分页数据")
	@RequestMapping(value = "listCommonAccessory")
	@ResponseBody
	public CommonResult listCommonAccessory(CommonAccessory commonAccessory){
		return commonAccessoryService.findPageByCondition(commonAccessory);
	}

	/**
	 * 删除配件信息
	 * @param json
	 * @return
	 */
	@ApiOperation(value = "删除配件信息")
	@ApiImplicitParam(name = "json", value = "删除的json信息", required = true, dataType="String")
	@Log(operationName = "删除配件信息", operationType = Log.OPERA_TYPE_DEL)
	@RequestMapping(value = "deleteCommonAccessory")
	@ResponseBody
	public CommonResult deleteCommonAccessory(String json) {

		return commonAccessoryService.deleteCommonCommonAccessory(json);
	}

	@ApiOperation(value = "上传配件信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "categoryId", value = "车型分类的id", required = true, dataType="String"),
			@ApiImplicitParam(name = "file", value = "上传的数据文件", required = true, dataType="MultipartFile")
	})
	@Log(operationName = "上传配件信息", operationType = Log.OPERA_TYPE_ADD)
	@RequestMapping(value = "uploadCommonAccessoryByCategoryId")
	@ResponseBody
	public CommonResult uploadCommonAccessoryByCategoryId(String categoryId, MultipartFile file) throws Exception {
		ExcelImport ei = new ExcelImport(file, 2, 0);
		List<CommonAccessory> commonAccessoryList = ei.getDataList(CommonAccessory.class);
		return commonAccessoryService.saveByCategoryId(commonAccessoryList, categoryId);
	}

	
}