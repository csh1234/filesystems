package com.example.demo.response;

public class Response<T> {

    private String code = "0";

    private String msg = "成功";

    private T data;

    public Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response() {
    }


    public void setFail(String msg, T data) {
        this.code = "-1";
        this.msg = msg;
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + ((data == null) ? "" : data.toString()) +
                '}';
    }
}
