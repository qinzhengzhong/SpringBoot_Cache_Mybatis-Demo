package com.allan.Controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@Controller
@RestController
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);


    /**
     * 系统登录
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView index() {
        return new ModelAndView("login");
    }

    @PostMapping(value = "/allan/checkLogin")
    public ModelAndView checkLogin(@RequestParam(value = "userName", required = false) String userName,
                             @RequestParam(value = "pwd", required = false) String pwd, Model model) {
        logger.info("*************用户：" + userName + "即将登录系统******************");
        if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(pwd)) {
            if (!StringUtils.equals(userName, "allan@qq.com") || !StringUtils.equals(pwd, "123456")) {
                return new ModelAndView("error");
            }
        } else {
            return new ModelAndView("error");
        }
        logger.info("*************用户：" + userName +"密码："+pwd+ ",验证通过");
        model.addAttribute("userName", userName);
        return new ModelAndView("success");
    }
}
