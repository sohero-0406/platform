package com.jeesite.modules.common.web;

import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.codec.EncodeUtils;
import com.jeesite.common.entity.Page;
import com.jeesite.common.utils.excel.ExcelImport;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.common.aop.Log;
import com.jeesite.modules.common.entity.CommonAccessory;
import com.jeesite.modules.common.entity.CommonAccessoryCategory;
import com.jeesite.modules.common.entity.CommonResult;
import com.jeesite.modules.common.service.CommonAccessoryCategoryService;
import com.jeesite.modules.common.util.FilePathUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * 配件分类表Controller
 * @author mayuhu
 * @version 2019-08-12
 */
@Controller
@RequestMapping(value = "/common/commonAccessoryCategory")
public class CommonAccessoryCategoryController extends BaseController {

	@Autowired
	private CommonAccessoryCategoryService commonAccessoryCategoryService;

	/**
	 * 加载分页配件分类数据
	 * @param commonAccessoryCategory 配件分类对象
	 * @return CommonResult
	 */
	@ApiOperation(value = "加载分页配件分类数据")
	@ApiImplicitParam(name = "commonAccessoryCategory", value = "查询的数据对象", required = true, dataType="CommonAccessoryCategory")
	@Log(operationName = "加载分页配件分类数据")
	@RequestMapping(value = "listCommonAccessoryCategory")
	@ResponseBody
	public CommonResult<Page<CommonAccessoryCategory>> listCommonAccessoryCategory(CommonAccessoryCategory commonAccessoryCategory){
		return commonAccessoryCategoryService.findPageByCondition(commonAccessoryCategory);
	}

	/**
	 * 保存配件分类并上传对应的配件数据
	 * @param file 文件
	 * @param commonAccessoryCategory 配件分类对象
	 * @return CommonResult
	 * @throws Exception 1
	 */
	@ApiOperation(value = "保存配件分类并上传对应的配件数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "file", value = "查询的数据对象", required = true, dataType="MultipartFile"),
			@ApiImplicitParam(name = "commonAccessoryCategory", value = "保存的配件分类对象", required = true, dataType="CommonAccessoryCategory")
	})
	@Log(operationName = "保存配件分类并上传对应的配件数据", operationType = Log.OPERA_TYPE_ADD)
	@RequestMapping(value = "uploadCommonAccessoryAndCategory")
	@ResponseBody
	public CommonResult<JSONObject> uploadCommonAccessoryAndCategory(MultipartFile file, CommonAccessoryCategory commonAccessoryCategory) throws Exception {
		ExcelImport ei = new ExcelImport(file, 2, 0);
		List<CommonAccessory> commonAccessoryList = ei.getDataList(CommonAccessory.class);
		return commonAccessoryCategoryService.saveCategoryAndCommonAccessory(commonAccessoryCategory, commonAccessoryList);
	}

	/**
	 * 删除配件分类信息
	 * @param json 删除的json字符串
	 * @return  CommonResult
	 */
	@ApiOperation(value = "删除配件分类信息")
	@ApiImplicitParam(name = "json", value = "删除用的json数据", required = true, dataType="String")
	@Log(operationName = "删除配件分类信息", operationType = Log.OPERA_TYPE_DEL)
	@RequestMapping(value = "deleteCommonAccessoryAndCategory")
	@ResponseBody
	public CommonResult<JSONObject> deleteCommonAccessoryAndCategory(String json) {

		return commonAccessoryCategoryService.deleteCommonAccessoryCategory(json);
	}

	/**
	 * 更新配件分类信息
	 * @param commonAccessoryCategory 更新的配件分类对象
	 * @return CommonResult
	 */
	@ApiOperation(value = "更新配件分类信息")
	@ApiImplicitParam(name = "commonAccessoryCategory", value = "要更新的配件分类对象", required = true, dataType="CommonAccessoryCategory")
	@Log(operationName = "更新配件分类信息", operationType = Log.OPERA_TYPE_ADD_OR_UPD)
	@RequestMapping(value = "saveCommonAccessoryAndCategory")
	@ResponseBody
	public CommonResult<Object> saveCommonAccessoryAndCategory(CommonAccessoryCategory commonAccessoryCategory) {

		return commonAccessoryCategoryService.updateCommonAccessoryCategory(commonAccessoryCategory);
	}

	/**
	 * 下载配件信息表
	 * @param response 1
	 */
	@ApiOperation(value = "下载配件信息表")
	@Log(operationName = "下载配件信息表", operationType = Log.OPERA_TYPE_OTHER)
	@RequestMapping(value = "downTemplate", produces = "application/octet-stream")
	//@RequestMapping(value = "downTemplate")
    @ResponseBody
	public void downTemplate(HttpServletResponse response){
		File file = new File(FilePathUtil.getFileSavePath("template")+"配件基础信息表.xlsx");

		try {
			FileInputStream fileIn = new FileInputStream(file);
			BufferedInputStream is = new BufferedInputStream(fileIn);
			byte[] fileBytes = new byte[1024];
			response.reset();
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename="+ EncodeUtils.encodeUrl("配件基础信息表.xlsx"));
			// 输出文件流
			ServletOutputStream out = response.getOutputStream();
			int len;
			while ((len = is.read(fileBytes, 0, 1024)) != -1) {
				out.write(fileBytes, 0, len);
			}
			is.close();
			out.close();

			fileIn.close();
		} catch (IOException ex) {
			//log.error(ex.getMessage(), ex);
		}
	}

	/**
	 * 配件项目，调用车型查配件
	 */
	@Log(operationName = "配件项目，调用车型查配件")
	@RequestMapping(value = "findPartsForVehicleParts")
	@ResponseBody
	public CommonResult<List<CommonAccessoryCategory>> findPartsForVehicleParts(){
		return commonAccessoryCategoryService.findPartsForVehicleParts();
	}

	/**
	 * 配件项目，根据配件编码查适用车型
	 */
	@Log(operationName = "配件项目，根据配件编码查适用车型")
	@RequestMapping(value = "findNameByPartsCode")
	@ResponseBody
	public CommonResult<List<String>> findNameByPartsCode(String code){
		return commonAccessoryCategoryService.findNameByPartsCode(code);
	}
}