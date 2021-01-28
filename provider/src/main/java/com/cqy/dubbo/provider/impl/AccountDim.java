package com.cqy.dubbo.provider.impl;

import cn.hutool.core.util.RandomUtil;
import com.cqy.dubbo.api.di.AccountDi;
import com.cqy.dubbo.api.model.Account;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author caiqy
 * @date 2020/10/29 15:14
 */
@DubboService
public class AccountDim implements AccountDi {
    @Override
    public Account randomSave() {
        Account account = new Account();
        account.setPersonId(RandomUtil.randomInt());
        account.setAccountCode(RandomUtil.randomString(6));
        return account;
    }
}
