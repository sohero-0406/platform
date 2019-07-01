package com.jeesite.modules.common.entity;

/**
 * 公共返回结果
 * @author lvchangwei
 * @version 2019-06-27
 */
public class CommonResult {
    /**
     * 返回编码
     */
    private String code = "1000";

    /**
     * 返回信息
     */
    private String msg = "请求成功";

    /**
     * 返回数据
     */
    private Object data;

    public CommonResult() {

    }

    public CommonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
