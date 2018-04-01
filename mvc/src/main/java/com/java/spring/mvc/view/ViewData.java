package com.java.spring.mvc.view;

import com.java.spring.mvc.context.WebContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author renqingwang on 2018/4/1.
 * @version 1.0
 */
public class ViewData {
    private HttpServletRequest request;

    public ViewData() {
        initRequest();
    }

    private void initRequest() {
        this.request = WebContext.requestHolder.get();
    }

    public void put(String name, Object value) {
        this.request.setAttribute(name, value);
    }
}
