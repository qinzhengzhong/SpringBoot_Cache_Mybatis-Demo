package com.allan.service;

import com.allan.base.BaseService;
import com.allan.entity.User;
import com.allan.query.UserQuery;

import java.util.List;
import java.util.Map;

public interface UserService extends BaseService{
    /**
     * 通过id获取用户
     * @param id 用户ID
     * @return
     */
    User getById(Integer id);

    /**
     * 获取所有用户
     * @param user  查询map 条件
     * @return 所有用户
     */
    List<User> queryUserList(UserQuery user);
}
