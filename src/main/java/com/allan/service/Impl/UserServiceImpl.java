package com.allan.service.Impl;

import com.allan.base.mapper.BaseMapper;
import com.allan.base.mapper.BaseServiceImpl;
import com.allan.base.mapper.PageConstant;
import com.allan.entity.User;
import com.allan.mapper.UserMapper;
import com.allan.service.UserService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService{
    private final Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    UserMapper userMapper;


    @Override
    public BaseMapper getMapper() {
        return userMapper;
    }

    @Override
    @Cacheable(value = "GetUserByID",key = "'userId_'+#id")
    public User getById(Long id) {
        User user=userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    @Cacheable(value = "FindUserListCache")
    public List<User> queryUserList(Map<Object, Object> params) {
        List<User> userList=new ArrayList<User>();
        if(params.get("pageNo")!=null){
            PageHelper page=new PageHelper();
            page.startPage((Integer)params.get("pageNo"), PageConstant.pageSize, true);
        }
        userList=userMapper.queryUserList(params);
        return userList;
    }
}
