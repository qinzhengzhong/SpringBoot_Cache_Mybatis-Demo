package com.allan.mapper;

import com.allan.base.BaseMapper;
import com.allan.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper {
    List<User> queryUserList(Map<String, Object> params);
}