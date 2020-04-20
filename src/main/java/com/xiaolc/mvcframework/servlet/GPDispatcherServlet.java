package com.xiaolc.mvcframework.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author: lc
 * @Date: 2020/4/20 19:36
 */
public class GPDispatcherServlet extends HttpServlet {
    private Map<String, Object> mapping = new HashMap<String, Object>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("500 Exception" + Arrays.toString(e.getStackTrace()));
        }

    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url.replace(contextPath, "").replaceAll("/+", "/");
        if (!this.mapping.containsKey(url)) {
            resp.getWriter().write("404 NotFound!!");
            return;
        }
        Method method = (Method) this.mapping.get("url");

        Map<String, String[]> parames = req.getParameterMap();
        method.invoke(this.mapping.get(method.getDeclaringClass().getName()), new Object[]{req, resp, parames.get("name")[0]});
    }

    @Override
    public void init() throws ServletException {
        InputStream is = null;
        try {
            Properties properties = new Properties();
            //is= this.getClass().getClassLoader().getResourceAsStream(config.getInitParameter("contextConfigLocation"));


        } catch (Exception e) {
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
