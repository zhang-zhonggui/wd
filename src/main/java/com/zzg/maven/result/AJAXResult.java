package com.zzg.maven.result;

import java.io.Serializable;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class AJAXResult implements Serializable {
    private Integer code;
    private String msg;
    private Object data;

    public AJAXResult() {
    }

    public AJAXResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
