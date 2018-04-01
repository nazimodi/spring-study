package com.java.spring.mvc.context;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author renqingwang on 2018/4/1.
 * @version 1.0
 */
public class WebContext {
    public static ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();
    public static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<>();

    public HttpServletRequest getRequest() {
        return requestHolder.get();
    }

    public HttpServletResponse getResponse() {
        return responseHolder.get();
    }

    public HttpSession getSession() {
        return requestHolder.get().getSession();
    }

    public ServletContext getServletContext() {
        return requestHolder.get().getSession().getServletContext();
    }

}
