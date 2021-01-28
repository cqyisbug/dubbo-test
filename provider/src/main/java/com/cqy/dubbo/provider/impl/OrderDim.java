package com.cqy.dubbo.provider.impl;

import cn.hutool.core.util.RandomUtil;
import com.cqy.dubbo.api.di.OrderDi;
import com.cqy.dubbo.api.model.Order;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Date;

/**
 * @author caiqy
 * @date 2020/10/29 15:14
 */
@DubboService
public class OrderDim implements OrderDi {


    @Override
    public Order randomSave() throws Exception {
        Order order = new Order();
        order.setOrderNo(RandomUtil.randomInt());
        order.setPersonId(RandomUtil.randomInt());
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        return order;
    }
}
