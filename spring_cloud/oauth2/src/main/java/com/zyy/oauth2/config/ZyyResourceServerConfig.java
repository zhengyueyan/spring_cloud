package com.zyy.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * description
 *
 * @author zhengyueyan
 * @date 16:04 2018/8/21
 */
@Configuration
@EnableResourceServer
public class ZyyResourceServerConfig extends ResourceServerConfigurerAdapter {
    /**
     * 自定义登录成功处理器
     */
    @Autowired
    private AuthenticationSuccessHandler appLoginInSuccessHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .successHandler(appLoginInSuccessHandler)//登录成功处理器
                .and()
                .authorizeRequests().anyRequest().authenticated().and()
                .csrf().disable();
    }
}
