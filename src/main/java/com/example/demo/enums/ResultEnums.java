package com.example.demo.enums;

public enum ResultEnums {

    FAIL("1", "上传失败"),

    SUCCESS("2", "上传成功"),

    EMPTY("3", "上传文件为空");

    private String code;
    private String msg;

    ResultEnums(String code, String msg) {
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
}
