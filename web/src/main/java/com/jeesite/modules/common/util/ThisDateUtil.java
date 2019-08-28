package com.jeesite.modules.common.util;

import com.jeesite.common.lang.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class ThisDateUtil {
    public static boolean checkDateIn(String startDate, String endDate, String checkDate){
        String[] parsePatterns = {"yyyyMMdd"};
        try {
            Date start = DateUtils.parseDate(startDate, parsePatterns);
            Date end = DateUtils.parseDate(endDate, parsePatterns);
            Date check = DateUtils.parseDate(checkDate, parsePatterns);
            return (start.before(check)&&check.before(end))||startDate.equals(checkDate)||endDate.equals(checkDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
