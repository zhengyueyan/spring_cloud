package com.zyy.oauth2.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * description
 *
 * @author zhengyueyan
 * @date 14:19 2018/8/21
 */
@Data
@ConfigurationProperties(prefix = "zyy.security.oauth2")
public class OAuth2Properties {

    private String jwtSigningKey = "zyy";

    private OAuth2ClientProperties[] clients = {};
}