package com.cqy.dubbo.api;

import com.cqy.exp.Ce;

import javax.validation.constraints.NotEmpty;

/**
 * @author caiqy
 * @date 2020/7/14 4:41 下午
 */
public interface HelloService {

    //    @Cacheable(key = "#name", value = "wuha")
    String hello(@NotEmpty(message = "哈哈") String name) throws Ce, InterruptedException;
}
