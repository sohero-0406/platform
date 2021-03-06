package com.jeesite.modules.common.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.entity.Page;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.dao.CommonAccessoryCategoryDao;
import com.jeesite.modules.common.entity.*;
import com.jeesite.modules.common.util.CommonUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 配件分类表Service
 *
 * @author mayuhu
 * @version 2019-08-12
 */
@Service
@Transactional(readOnly = true)
public class CommonAccessoryCategoryService extends CrudService<CommonAccessoryCategoryDao, CommonAccessoryCategory> {

    @Autowired
    private CommonUserService commonUserService;
    @Autowired
    private CommonAccessoryService commonAccessoryService;

    /**
     * 获取单条数据
     *
     * @param commonAccessoryCategory 配件分类
     * @return CommonAccessoryCategory
     */
    @Override
    public CommonAccessoryCategory get(CommonAccessoryCategory commonAccessoryCategory) {
        return super.get(commonAccessoryCategory);
    }

    /**
     * 查询分页数据
     *
     * @param commonAccessoryCategory 查询条件 commonAccessoryCategory.page 分页对象
     * @return Page<CommonAccessoryCategory>
     */
    @Override
    public Page<CommonAccessoryCategory> findPage(CommonAccessoryCategory commonAccessoryCategory) {
        return super.findPage(commonAccessoryCategory);
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param commonAccessoryCategory 配件分类
     */
    @Override
    @Transactional
    public void save(CommonAccessoryCategory commonAccessoryCategory) {
        super.save(commonAccessoryCategory);
    }

    /**
     * 更新状态
     *
     * @param commonAccessoryCategory 配件分类
     */
    @Override
    @Transactional
    public void updateStatus(CommonAccessoryCategory commonAccessoryCategory) {
        super.updateStatus(commonAccessoryCategory);
    }

    /**
     * 删除数据
     *
     * @param commonAccessoryCategory 配件分类
     */
    @Override
    @Transactional
    public void delete(CommonAccessoryCategory commonAccessoryCategory) {
        super.delete(commonAccessoryCategory);
    }


    /**
     * 根据对象条件加载分页配件分类数据
     *
     * @param commonAccessoryCategory 查询条件
     * @return CommonResult
     */
    public CommonResult<Page<CommonAccessoryCategory>> findPageByCondition(CommonAccessoryCategory commonAccessoryCategory) {
        String loginUserId = PreEntity.getUserIdByToken();
        CommonUser loginUser = commonUserService.get(loginUserId);
        if ("1".equals(loginUser.getRoleId())) {
            return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, super.findPage(commonAccessoryCategory));
        }
        return new CommonResult<>(CodeConstant.NO_RIGHT, "您有权限进行该操作");
    }

    /**
     * 保存配件分类数据，并保存对应上传的配件数据
     *
     * @param commonAccessoryCategory 配件分类
     * @param commonAccessoryList   配件列表
     * @return CommonResult
     */
    @Transactional
    public CommonResult<JSONObject> saveCategoryAndCommonAccessory(CommonAccessoryCategory commonAccessoryCategory, List<CommonAccessory> commonAccessoryList) {
        if (StringUtils.isBlank(commonAccessoryCategory.getCategoryName())) {
            return new CommonResult<>(CodeConstant.ERROR_DATA, "您为传入车型名称");
        }
        if (StringUtils.isNotBlank(commonAccessoryCategory.getCategoryName()) && commonAccessoryCategory.getCategoryName().length() > 100) {
            return new CommonResult<>(CodeConstant.ERROR_DATA, "车型名称长度不得超过100");
        }
        String loginUserId = PreEntity.getUserIdByToken();
        CommonUser loginUser = commonUserService.get(loginUserId);
        if (!"1".equals(loginUser.getRoleId())) {
            return new CommonResult<>(CodeConstant.NO_RIGHT, "您有权限进行该操作");
        }
        if (ListUtils.isEmpty(commonAccessoryList)) {
            return new CommonResult<>(CodeConstant.EXCEL_NO_DATA, "您传入的EXCEL表格没有数据");
        }

        List<String> msgList = new ArrayList<>();
        List<CommonAccessory> okCommonAccessoryList = new ArrayList<>();
        StringBuilder msg = new StringBuilder();
        for (CommonAccessory commonAccessory : commonAccessoryList) {
            int sum = 0;
            String msgX = "编号为\"" + commonAccessory.getAccessoryIndex() + "\"的配件:";
            if (StringUtils.isBlank(commonAccessory.getAccessoryIndex())) {
                msgX += "编号不能为空;";
                sum++;
            } else {
                if (commonAccessory.getAccessoryIndex().length() > 50) {
                    msgX += "编号长度不能大于50;";
                    sum++;
                }
            }
            if (StringUtils.isBlank(commonAccessory.getAccessoryName())) {
                msgX += "配件品牌不能为空;";
                sum++;
            } else {
                if (commonAccessory.getAccessoryName().length() > 100) {
                    msgX += "配件品牌长度不能大于100;";
                    sum++;
                }
            }
            if (StringUtils.isBlank(commonAccessory.getAccessoryLevel())) {
                msgX += "配件等级不能为空;";
                sum++;
            } else {
                if (commonAccessory.getAccessoryLevel().length() > 45) {
                    msgX += "配件等级长度不能大于45;";
                    sum++;
                }
            }
//            if (StringUtils.isBlank(commonAccessory.getAccessorySpecifications())) {
//                msgX += "规格不能为空;";
//                sum++;
//            } else {
                if (commonAccessory.getAccessorySpecifications()!=null&&commonAccessory.getAccessorySpecifications().length() > 20) {
                    msgX += "规格长度不能大于20;";
                    sum++;
                }
//            }
            if (StringUtils.isBlank(commonAccessory.getAccessoryUnit())) {
                msgX += "单位不能为空;";
                sum++;
            } else {
                if (commonAccessory.getAccessoryUnit().length() > 10) {
                    msgX += "单位长度不能大于10;";
                    sum++;
                }
            }
            if (StringUtils.isBlank(commonAccessory.getAccessoryPrice())) {
                msgX += "指导价不能为空;";
                sum++;
            } else {
                if (commonAccessory.getAccessoryPrice().length() > 20) {
                    msgX += "指导价长度不能大于20;";
                    sum++;
                }
            }
            if (StringUtils.isBlank(commonAccessory.getAccessoryPlaceOfOrigin())) {
                msgX += "产地不能为空;";
                sum++;
            } else {
                if (commonAccessory.getAccessoryPlaceOfOrigin().length() > 100) {
                    msgX += "产地长度不能大于100;";
                    sum++;
                }
            }
            if (StringUtils.isBlank(commonAccessory.getAccessoryImport())) {
                msgX += "是否进口不能为空;";
                sum++;
            }
            if (sum > 0) {
                msgList.add(msgX);
                msg.append(msgX).append("<br/>");
            } else {
                okCommonAccessoryList.add(commonAccessory);
            }
        }
        if (okCommonAccessoryList.size() > 0) {
            super.save(commonAccessoryCategory);
            for (CommonAccessory commonAccessory : commonAccessoryList) {
                commonAccessory.setCategoryId(commonAccessoryCategory.getId());
            }
            commonAccessoryService.saveList(okCommonAccessoryList);
        } else {
            JSONObject jo = new JSONObject();
            jo.put("successNum", okCommonAccessoryList.size());
            jo.put("errorNum", commonAccessoryList.size() - okCommonAccessoryList.size());
            jo.put("msgList", msgList);
            return new CommonResult<>(CodeConstant.EXCEL_WRONG_DATA, "excel文件中没有一个数据能正常上传", jo);
        }
        JSONObject jo = new JSONObject();
        jo.put("successNum", okCommonAccessoryList.size());
        jo.put("errorNum", commonAccessoryList.size() - okCommonAccessoryList.size());
        jo.put("msgList", msgList);
        return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, msg.toString(), jo);
    }

    // 只是逻辑删除

    /**
     * 删除配件分类数据（逻辑删除）
     *
     * @param json 要删除的数据
     * @return CommonResult
     */
    @Transactional
    public CommonResult<JSONObject> deleteCommonAccessoryCategory(String json) {
        String loginUserId = PreEntity.getUserIdByToken();
        CommonUser loginUser = commonUserService.get(loginUserId);
        if (!"1".equals(loginUser.getRoleId())) {
            return new CommonResult<>(CodeConstant.NO_RIGHT, "您有权限进行该操作");
        }
        JSONObject jsonObject = JSONObject.parseObject(json);
        Integer length = jsonObject.getInteger("length");
        JSONArray ja = JSONArray.parseArray(jsonObject.getString("datas"));
        int deletedNum = 0;
        for (int i = 0; i < length; i++) {
            String id = ja.getString(i);
            CommonAccessoryCategory commonAccessoryCategory = this.get(id);
            if (CommonUserUtil.isSuperAdmin(loginUser) || CommonUserUtil.isSameCreator(loginUser, commonAccessoryCategory)) {
                super.delete(commonAccessoryCategory);
                deletedNum++;
            }
        }
        JSONObject object = new JSONObject();
        object.put("deletedNum", deletedNum);
        int x = length - deletedNum;
        object.put("notDeletedNum", x);
        if (x > 0) {
            return new CommonResult<>(CodeConstant.DATA_LOCK, "有" + x + "条件数据不符合删除条件，不能删除，符合的已删除", object);
        } else {
            return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, object);
        }
    }

    /**
     * 更新配件分类信息，其实只是更新了分类的名称
     *
     * @param commonAccessoryCategory 要更新的配件分类
     * @return CommonResult
     */
    @Transactional
    public CommonResult<Object> updateCommonAccessoryCategory(CommonAccessoryCategory commonAccessoryCategory) {
        if (commonAccessoryCategory.getId() == null) {
            return new CommonResult<>(CodeConstant.ERROR_DATA, "您传入的数据错误");
        }
        String loginUserId = PreEntity.getUserIdByToken();
        CommonUser loginUser = commonUserService.get(loginUserId);
        if (!"1".equals(loginUser.getRoleId())) {
            return new CommonResult<>(CodeConstant.NO_RIGHT, "您有权限进行该操作");
        }
        super.update(commonAccessoryCategory);
        return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL);
    }

    /**
     * 配件项目，调用车型查配件
     */
    public CommonResult<List<CommonAccessoryCategory>> findPartsForVehicleParts() {
        return new CommonResult<>(dao.findPartsForVehicleParts());
    }

    public CommonResult<List<String>> findNameByPartsCode(String code) {
        return new CommonResult<>(dao.findNameByPartsCode(code));
    }
}