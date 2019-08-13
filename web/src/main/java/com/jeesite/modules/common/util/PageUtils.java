package com.jeesite.modules.common.util;

import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.entity.DataEntity;
import com.jeesite.modules.common.entity.CommonResult;

public class PageUtils {

    public static boolean checkPageParams(DataEntity<?> entity){
        if(entity.getPage()==null){
            return false;
        }
        if(entity.getPage().getPageNo()==0||entity.getPage().getPageSize()==0){
            return false;
        }
        return true;
    }

}
