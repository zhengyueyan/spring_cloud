package com.zyy.oauth2.server;

import com.zyy.oauth2.entity.User;

/**
 * description
 *
 * @author zhengyueyan
 * @date 15:34 2018/8/20
 */
public interface UserService {

    public User selectByPrimaryKey(int id);

}
