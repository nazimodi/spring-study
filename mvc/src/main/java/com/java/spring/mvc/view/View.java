package com.java.spring.mvc.view;

import com.java.spring.mvc.constant.DispatchActionConstant;

/**
 * @author renqingwang on 2018/4/1.
 * @version 1.0
 */
public class View {
    private String url;
    private String dispatchAction = DispatchActionConstant.FORWARD;

    public View(String url) {
        this.url = url;
    }

    public View(String url, String name, Object value) {
        this.url = url;
        ViewData viewData = new ViewData();
        viewData.put(name, value);
    }

    public View(String url, String dispatchAction, String name, Object value) {
        this.url = url;
        this.dispatchAction = dispatchAction;
        ViewData viewData = new ViewData();
        viewData.put(name, value);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDispatchAction() {
        return dispatchAction;
    }

    public void setDispatchAction(String dispatchAction) {
        this.dispatchAction = dispatchAction;
    }
}
