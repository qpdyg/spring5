package com.xiaolc.mvcframework.controller;

import com.xiaolc.mvcframework.annotation.GPAutowired;
import com.xiaolc.mvcframework.annotation.GPController;
import com.xiaolc.mvcframework.annotation.GPRepuestMapping;
import com.xiaolc.mvcframework.annotation.GPRepuestParam;
import com.xiaolc.mvcframework.service.IDemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: lc
 * @Date: 2020/4/20 19:28
 */
@GPController
@GPRepuestMapping("demo")
public class DemoAction {

    @GPAutowired
    private IDemoService iDemoService;

    @GPRepuestMapping("query")
    public void query(HttpServletRequest request, HttpServletResponse response, @GPRepuestParam("name") String name) {
        String result = iDemoService.get(name);
        try {
            response.getWriter().write(result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
