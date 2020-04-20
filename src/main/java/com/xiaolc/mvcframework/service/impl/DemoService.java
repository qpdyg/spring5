package com.xiaolc.mvcframework.service.impl;

import com.xiaolc.mvcframework.annotation.GPSerrvice;
import com.xiaolc.mvcframework.service.IDemoService;

/**
 * @Author: lc
 * @Date: 2020/4/20 19:27
 */
@GPSerrvice
public class DemoService implements IDemoService {
    @Override
    public String get(String name) {
        return "My name is" + name;
    }
}
