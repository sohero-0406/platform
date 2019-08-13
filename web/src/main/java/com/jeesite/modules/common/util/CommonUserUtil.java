package com.jeesite.modules.common.util;

import com.jeesite.modules.common.entity.CommonUser;

public class CommonUserUtil {

    public static boolean isHaveExamRight(CommonUser loginUser){
        return loginUser.getRoleId().equals("1")||(loginUser.getRoleId().equals("2")&&loginUser.getIsExamRight()==1);
    }

    public static boolean isHaveExamRight(CommonUser loginUser, CommonUser creator){
        return loginUser.getRoleId().equals("1")||(loginUser.getRoleId().equals("2")&&loginUser.getIsExamRight()==1&&loginUser.getSchoolId().equals(creator.getSchoolId()));
    }

    public static boolean isSameSchool(CommonUser loginUser, CommonUser otherUser){
        return loginUser.getRoleId().equals("2")&&loginUser.getIsExamRight()==1&&loginUser.getSchoolId().equals(otherUser.getSchoolId());
    }

    public static boolean isSuperAdmin(CommonUser loginUser){
        return "1".equals(loginUser.getRoleId());
    }

}
