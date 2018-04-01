package com.java.spring.mvc.handler;

import com.java.spring.mvc.RequestMappingMap;
import com.java.spring.mvc.annotation.Controller;
import com.java.spring.mvc.annotation.RequestMapping;
import com.java.spring.mvc.constant.DispatchActionConstant;
import com.java.spring.mvc.context.WebContext;
import com.java.spring.mvc.utils.BeanUtil;
import com.java.spring.mvc.utils.ScanClassUtil;
import com.java.spring.mvc.view.View;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author renqingwang on 2018/4/1.
 * @version 1.0
 */
public class AnnotationHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.execute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.execute(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("----init start----");
        String basePackage = config.getInitParameter("basePackage");
        if (basePackage.indexOf(",") > 0) {
            String[] packageNameArr = basePackage.split(",");
            for (String packageName : packageNameArr) {
                initRequestMappingMap(packageName);
            }
        } else {
            initRequestMappingMap(basePackage);
        }
        System.out.println("----init end ----");
    }

    private String preRequestURI(HttpServletRequest request) {
        String path = request.getContextPath() + "/";
        String requestURI = request.getRequestURI();
        String midUrl = requestURI.replaceFirst(path, "");
        return midUrl.substring(0, midUrl.lastIndexOf("."));
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext.requestHolder.set(request);
        WebContext.responseHolder.set(response);

        String lastUrl = preRequestURI(request);
        Class<?> clazz = RequestMappingMap.getRequestMap().get(lastUrl);
        Object instanceClass = BeanUtil.instanceClass(clazz);
        Method[] methods = BeanUtil.findDeclareMethods(clazz);
        Method targetMethod = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(RequestMapping.class)) {
                String value = method.getAnnotation(RequestMapping.class).value();
                if (value != null && !"".equals(value.trim()) && lastUrl.equals(value.trim())) {
                    targetMethod = method;
                    break;
                }
            }
        }
        if (targetMethod != null) {
            try {
                Object retObject = targetMethod.invoke(instanceClass);
                if (retObject != null) {
                    View view = (View) retObject;
                    if (view.getDispatchAction().equals(DispatchActionConstant.FORWARD)) {
                        request.getRequestDispatcher(view.getUrl()).forward(request, response);
                    } else if (view.getDispatchAction().equals(DispatchActionConstant.REDIRECT)) {
                        response.sendRedirect(request.getContextPath() + view.getUrl());
                    } else {
                        request.getRequestDispatcher(view.getUrl()).forward(request, response);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private void initRequestMappingMap(String packageName) {
        Set<Class<?>> classes = ScanClassUtil.getClasses(packageName);
        for (Class<?> clazz : classes) {
            if (clazz.isAnnotationPresent(Controller.class)) {
                Method[] methods = BeanUtil.findDeclareMethods(clazz);
                for (Method method : methods) {
                    if (method.isAnnotationPresent(RequestMapping.class)) {
                        String value = method.getAnnotation(RequestMapping.class).value();
                        if (value != null && !"".equals(value.trim())) {
                            if (RequestMappingMap.getRequestMap().containsKey(value)) {
                                throw new RuntimeException("requestMappingMap can't be mapped ");
                            }
                            RequestMappingMap.put(value, clazz);
                        }
                    }
                }
            }
        }
    }
}
