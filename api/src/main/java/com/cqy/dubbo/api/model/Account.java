package com.cqy.dubbo.api.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author caiqy
 * @date 2020/10/29 15:06
 */

@Data
public class Account implements Serializable {
    private Integer id;

    private Integer personId;

    private String accountCode;

    private static final long serialVersionUID = 1L;
}