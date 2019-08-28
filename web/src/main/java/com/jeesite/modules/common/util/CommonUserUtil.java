package com.jeesite.modules.common.util;

import com.jeesite.modules.common.entity.CommonAccessoryCategory;
import com.jeesite.modules.common.entity.CommonUser;
import com.jeesite.modules.common.entity.PreEntity;

public class CommonUserUtil {

    public static boolean isHaveExamRight(CommonUser loginUser){
        return loginUser.getRoleId().equals("1")||(loginUser.getRoleId().equals("2")&&"1".equals(loginUser.getIsExamRight()));
    }

    public static boolean isHaveExamRight(CommonUser loginUser, CommonUser creator){
        return loginUser.getRoleId().equals("1")||(loginUser.getRoleId().equals("2")&&"1".equals(loginUser.getIsExamRight())&&loginUser.getSchoolId().equals(creator.getSchoolId()));
    }

    public static boolean isSameSchool(CommonUser loginUser, CommonUser otherUser){
        return loginUser.getRoleId().equals("2")&&"1".equals(loginUser.getIsExamRight())&&loginUser.getSchoolId().equals(otherUser.getSchoolId());
    }

    public static boolean isSuperAdmin(CommonUser loginUser){
        return "1".equals(loginUser.getRoleId());
    }

    public static boolean isSameCreator(CommonUser loginUser, PreEntity preEntity) {
        return loginUser.getId().equals(preEntity.getCreateBy());
    }
}
