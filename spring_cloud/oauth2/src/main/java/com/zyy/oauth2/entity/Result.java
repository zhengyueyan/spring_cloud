package com.zyy.oauth2.entity;

import lombok.Data;

/**
 * description
 *
 * @author zhengyueyan
 * @date 13:46 2018/8/21
 */
@Data
public class Result<T> {
    private Integer code;
    private String msg;

    private T data;
}
