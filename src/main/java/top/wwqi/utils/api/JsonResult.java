package top.wwqi.utils.api;


import java.io.Serializable;

public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = 3914321599786836702L;  // 序列化对象
    private T data;     // 结果集
    private int code;    // 状态码
    private String msg;     // 接口描述

    /**
     * 若没有数据返回，默认状态码为 0，提示信息为“操作成功！”
     */
    public JsonResult() {
        this.code = 0;
        this.msg = "操作成功！";
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @param code
     * @param msg
     */
    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }



    /**
     * 有数据返回，状态码为 200，人为指定提示信息
     * @param data
     * @param msg
     */
    public JsonResult(T data, String msg) {
        this.data = data;
        this.code = 200;
        this.msg = msg;
    }

    /**
     * 有数据返回，状态码为 200，人为指定提示信息
     * @param data
     * @param msg
     */
    public JsonResult(int code, T data, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    /**
     * get、set方法
     * @return
     */
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

