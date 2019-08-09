package com.jeesite.modules.common.util;

import com.jeesite.modules.common.entity.CommonUser;

public class CommonUserUtil {

    public static boolean isHaveExamRight(CommonUser loginUser){
        return loginUser.getRoleId().equals("1")||(loginUser.getRoleId().equals("2")&&loginUser.getIsExamRight()==1);
    }

}
