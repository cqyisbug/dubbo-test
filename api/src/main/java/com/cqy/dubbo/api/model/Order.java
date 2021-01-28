package com.cqy.dubbo.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author caiqy
 * @date 2020/10/29 15:06
 */

@Data
public class Order implements Serializable {
    private Integer id;

    private Integer orderNo;

    private Integer personId;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}