package com.zyy.oauth2.entity;

import lombok.Builder;
import lombok.Data;

/**
 * description
 *
 * @author zhengyueyan
 * @date 15:31 2018/8/20
 */
@Data
@Builder
public class User {

    private String id;

    private String userName;

}
