package com.allan.service.Impl;

import com.allan.base.BaseMapper;
import com.allan.base.BaseServiceImpl;
import com.allan.base.PageConstant;
import com.allan.entity.User;
import com.allan.mapper.UserMapper;
import com.allan.query.UserQuery;
import com.allan.service.UserService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    UserMapper userMapper;


    @Override
    public BaseMapper getMapper() {
        return userMapper;
    }


    @Override
    @Cacheable(value = "GetUserByID", key = "'userId_'+#id")
//    @CacheEvict(value = "GetUserByID", allEntries = true)
    public User getById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
//    @Cacheable(value = "FindUserListCache")
    public List<User> queryUserList(UserQuery user) {
        Map<String, Object> params = new HashMap<>();
        params.put("condition", user);
        List<User> userList = userMapper.queryUserList(params);
        return userList;
    }
}
