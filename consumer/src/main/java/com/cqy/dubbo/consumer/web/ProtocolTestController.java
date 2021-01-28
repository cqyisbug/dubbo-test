package com.cqy.dubbo.consumer.web;

import com.cqy.dubbo.api.di.AccountDi;
import com.cqy.dubbo.api.di.OrderDi;
import com.cqy.dubbo.api.model.Account;
import com.cqy.dubbo.api.model.Order;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Global transactional test controller.
 *
 * @author caiqy
 * @date 2020 /10/29 15:16
 */
@RestController
@RequestMapping("/protocol")
public class ProtocolTestController {


    @DubboReference
    private AccountDi accountDi;

    @DubboReference
    private OrderDi orderDi;

    /**
     * 有分布式事务插入
     *
     * @return map
     * @throws Exception the exception
     */
    @GetMapping("/spring-cloud")
    public Map<String, Object> withTransaction() throws Exception {
        Account account = accountDi.randomSave();
        Order order = orderDi.randomSave();
        return new HashMap<String, Object>() {{
            this.put("account", account);
            this.put("order", order);
        }};
    }
}
