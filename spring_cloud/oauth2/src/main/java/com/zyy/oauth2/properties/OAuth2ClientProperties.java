package com.zyy.oauth2.properties;

import lombok.Data;

/**
 * description
 *
 * @author zhengyueyan
 * @date 14:20 2018/8/21
 */
@Data
public class OAuth2ClientProperties {

    private String clientId;

    private String clientSecret;

    private Integer accessTokenValiditySeconds = 7200;
}
