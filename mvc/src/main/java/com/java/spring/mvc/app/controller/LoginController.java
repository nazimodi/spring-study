package com.java.spring.mvc.app.controller;

import com.java.spring.mvc.annotation.Controller;
import com.java.spring.mvc.annotation.RequestMapping;
import com.java.spring.mvc.context.WebContext;
import com.java.spring.mvc.view.View;
import com.java.spring.mvc.view.ViewData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author renqingwang on 2018/4/1.
 * @version 1.0
 */
@Controller
public class LoginController {

    @RequestMapping("login/handle")
    public View loginHandle() {
        ViewData viewData = new ViewData();
        HttpServletRequest request = WebContext.requestHolder.get();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (name.equals("ren") && password.equals("123")) {
            request.getSession().setAttribute("name", name);
            viewData.put("msg", "hello, " + name);
            return new View("/index.jsp");
        } else {
            viewData.put("msg", "name or passwd mismatch");
            return new View("/login.jsp");
        }
    }

    @RequestMapping("ajax/login/handle")
    public void ajaxLoginHandle() throws IOException {
        HttpServletRequest request = WebContext.requestHolder.get();
        HttpServletResponse response = WebContext.responseHolder.get();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if ("ren".equals(name) && "123".equals(password)) {
            request.getSession().setAttribute("name", name);
            response.getWriter().write("succ");
        } else {
            response.getWriter().write("fail");
        }
    }
}
