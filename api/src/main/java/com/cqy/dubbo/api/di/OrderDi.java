package com.cqy.dubbo.api.di;

import com.cqy.dubbo.api.model.Order;

/**
 * @author caiqy
 * @date 2020/10/29 15:12
 */
public interface OrderDi  {
    Order randomSave() throws Exception;
}
