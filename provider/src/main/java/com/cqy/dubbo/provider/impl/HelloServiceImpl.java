package com.cqy.dubbo.provider.impl;

import com.cqy.dubbo.api.HelloService;
import com.cqy.exp.Ce;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author caiqy
 * @date 2020/7/14 5:16 下午
 */
@DubboService(cache = "lru")
public class HelloServiceImpl implements HelloService {

    public String hello(String name) throws Ce, InterruptedException {
        if ("cqy".equals(name)) {
            throw new Ce("he");
        }
        Thread.sleep(2 * 1000);
        return "hello " + name;
    }
}