package com.springdemo.meetingreserve.common;

public class CommonResult {
    private String code;
    private String message;
    private Object content;
    private String ok;

    public CommonResult(Object content){
        this.code= "000000";
        this.message = "success";
        this.content = content;
    }

    public static CommonResult ok(Object content){
        return new CommonResult(content);
    }

    public String getCode() {
        return code;
    }

    public void setCode(Integer status) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}
