package com.java.spring.client.hello.common;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @author renqingwang on 2017/9/3.
 * @version 1.0
 */
public class ResultMessage<T> implements Serializable{
    private  Integer code;
    private  String message;
    private  T data;
    private static ResultMessage resultMessage;

    public static final Integer SUCCESS = 200;
    public static final Integer FAIL_BAD_REQUEST = 400;
    public static final Integer FAIL_PARAM = 4001;
    public static final Integer FAIL_BUSINESS = 4002;
    public static final Integer FAIL_DATABASE = 4003;
    public static final Integer FAIL_SERVER_ERROR = 500;
    public static final Integer FAIL_REMOTE_SERVER_ERROR = 5010;

    public static final String MESSAGE_SUCCESS = "success";
    public static final String MESSAGE_FAIL_BAD_REQUEST = "bad request,请检查";
    public static final String MESSAGE_FAIL_PARAM = "参数错误，请检查";
    public static final String MESSAGE_FAIL_BUSINESS = "业务错误";
    public static final String MESSAGE_FAIL_DATABASE = "数据库错误";
    public static final String MESSAGE_FAIL_SERVER_ERROR = "服务器内部错误";
    public static final String MESSAGE_FAIL_REMOTE_SERVER_ERROR = "远端服务器异常";

    private ResultMessage() {}

    public static ResultMessage getInstance() {
        if (resultMessage != null) {
            return resultMessage;
        } else {
            resultMessage = new ResultMessage();
            return resultMessage;
        }
    }

    public  ResultMessage<T> success() {
        this.code = SUCCESS;
        this.message = MESSAGE_SUCCESS;
        return this;
    }

    public ResultMessage<T> success(T data) {
        this.code = SUCCESS;
        this.message = MESSAGE_SUCCESS;
        this.data = data;
        return this;
    }

    public ResultMessage<T> success(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    public ResultMessage<T> fail() {
        this.code = FAIL_BUSINESS;
        this.message = MESSAGE_FAIL_BUSINESS;
        return this;
    }

    public ResultMessage<T> fail(Integer code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public void setStatus(Integer status) {
        this.code = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
