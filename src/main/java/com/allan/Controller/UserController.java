package com.allan.Controller;

import com.allan.base.BaseController;
import com.allan.entity.User;
import com.allan.query.UserQuery;
import com.allan.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * springdemo
 */
//@Controller
@RestController
public class UserController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;


    @GetMapping(value = "/findUser")
    public String findUser(Integer id) {
        User user = userService.getById(id);
        Preconditions.checkNotNull(user, "用户不存在");
        return getSuccessResult(user);
    }


    @GetMapping(value = "/queryUserList")
    public String queryUserList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, UserQuery userQuery) {
        userQuery.setPageNum(pageNum);
        userQuery.setPageSize(pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.queryUserList(userQuery);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        return getSuccessResult(pageInfo);
    }

}
