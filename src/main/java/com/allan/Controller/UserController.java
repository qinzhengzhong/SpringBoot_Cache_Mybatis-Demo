package com.allan.Controller;

import com.allan.entity.User;
import com.allan.service.UserService;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *springdemo
 */
@RestController
public class UserController {

    private  final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;

    private  Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();


    @RequestMapping(value = "/findUser", method = RequestMethod.GET)
    @ResponseBody
    public String findUser(Long id) {
        User user = userService.getById(id);
        Preconditions.checkNotNull(user,"用户不存在");
        return gson.toJson(user);
    }


    @RequestMapping(value = "/queryUserList", method = RequestMethod.GET)
    @ResponseBody
    public String queryUserList(Integer pageNo) {
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("pageNo",pageNo);
        List<User> list=userService.queryUserList(map);
        PageInfo<User> pageInfo=new PageInfo<User>(list);
        return gson.toJson(pageInfo);
    }

}
