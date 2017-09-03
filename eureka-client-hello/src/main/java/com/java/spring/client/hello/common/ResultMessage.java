package com.java.spring.client.hello.common;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @author renqingwang on 2017/9/3.
 * @version 1.0
 */
public class ResultMessage<T> implements Serializable {
    private Integer status;
    private String message;
    private T data;
    private static ResultMessage resultMessage;

    public static final int SUCCESS = 200;
    public static final int FAIL_BAD_REQUEST = 400;
    public static final int FAIL_PARAM = 4001;
    public static final int FAIL_BUSINESS = 4002;
    public static final int FAIL_DATABASE = 4003;
    public static final int FAIL_SERVER_ERROR = 500;
    public static final int FAIL_REMOTE_SERVER_ERROR = 5010;

    public static final String MESSAGE_SUCCESS = "success";
    public static final String MESSAGE_FAIL_BAD_REQUEST = "bad request,请检查";
    public static final String MESSAGE_FAIL_PARAM = "参数错误，请检查";
    public static final String MESSAGE_FAIL_BUSINESS = "业务错误";
    public static final String MESSAGE_FAIL_DATABASE = "数据库错误";
    public static final String MESSAGE_FAIL_SERVER_ERROR = "服务器内部错误";
    public static final String MESSAGE_FAIL_REMOTE_SERVER_ERROR = "远端服务器异常";

    private ResultMessage() {
    }

    public static ResultMessage getInstance() {
        if (resultMessage != null) {
            return resultMessage;
        } else {
            resultMessage = new ResultMessage();
            return resultMessage;
        }
    }

    public ResultMessage<T> success() {
        this.status = SUCCESS;
        this.message = MESSAGE_SUCCESS;
        return this;
    }

    public ResultMessage<T> success(T data) {
        this.status = SUCCESS;
        this.message = MESSAGE_SUCCESS;
        this.data = data;
        return this;
    }

    public ResultMessage<T> success(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        return this;
    }

    public ResultMessage<T> fail() {
        this.status = FAIL_BUSINESS;
        this.message = MESSAGE_FAIL_BUSINESS;
        return this;
    }

    public ResultMessage<T> fail(Integer status) {
        this.status = status;
        switch (status) {
            case SUCCESS:
                this.message = MESSAGE_SUCCESS;
                break;
            case FAIL_BAD_REQUEST:
                this.message = MESSAGE_FAIL_BAD_REQUEST;
                break;
            case FAIL_PARAM:
                this.message = MESSAGE_FAIL_PARAM;
                break;
            case FAIL_BUSINESS:
                this.message = MESSAGE_FAIL_BUSINESS;
                break;
            case FAIL_DATABASE:
                this.message = MESSAGE_FAIL_DATABASE;
                break;
            case FAIL_SERVER_ERROR:
                this.message = MESSAGE_FAIL_SERVER_ERROR;
                break;
            case FAIL_REMOTE_SERVER_ERROR:
                this.message = MESSAGE_FAIL_REMOTE_SERVER_ERROR;
                break;
            default:
                this.message = "unknown";
        }
        this.status = FAIL_BUSINESS;
        this.message = MESSAGE_FAIL_BUSINESS;
        return this;
    }

    public ResultMessage<T> fail(Integer status, String message) {
        this.status = status;
        this.message = message;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
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
