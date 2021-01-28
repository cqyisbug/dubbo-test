package com.cqy.dubbo.api.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author caiqy
 * @date 2020/10/29 15:06
 */

@Data
public class Person implements Serializable {
    private Integer id;

    private String lastName;

    private String firstName;

    private String address;

    private String city;

    private static final long serialVersionUID = 1L;
}