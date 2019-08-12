package com.jeesite.modules.common.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {


    String OPERA_TYPE_DEL = "删除操作";

    String OPERA_TYPE_ADD = "保存操作";

    String OPERA_TYPE_ADD_OR_UPD = "保存或者更新操作";

    String OPERA_TYPE_UPD = "更新操作";

    String OPERA_TYPE_SEL = "查询操作";

    String OPERA_TYPE_OTHER = "其他操作";

    String OPERA_DEFAULT_NAME = "加载数据";

    /** 要执行的操作类型比如：add操作 **/
    public String operationType() default Log.OPERA_TYPE_SEL;

    /** 要执行的具体操作比如：添加用户 **/
    public String operationName() default Log.OPERA_DEFAULT_NAME;

}