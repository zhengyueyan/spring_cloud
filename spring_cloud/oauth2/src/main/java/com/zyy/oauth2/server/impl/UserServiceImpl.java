package com.zyy.oauth2.server.impl;

import com.zyy.oauth2.entity.User;
import com.zyy.oauth2.server.UserService;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author zhengyueyan
 * @date 16:09 2018/8/20
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User selectByPrimaryKey(int id) {

        User user = User.builder()
                .userName("wxz")
                .id("2")
                .build();

        return user;
    }
}
