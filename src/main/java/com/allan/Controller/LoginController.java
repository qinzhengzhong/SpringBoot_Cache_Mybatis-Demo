package com.allan.Controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);


    /**
     * 系统登录
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public String index() {
        return "login";
    }

    /**
     *  登录校验
     * @param userName
     * @param possword
     * @param model
     * @return
     */
    @RequestMapping(value = "/allan/checkLogin")
    public String checkLogin(@RequestParam(value = "userName", required = false) String userName,
                                   @RequestParam(value = "possword", required = false) String possword, Model model) {
        logger.info("*************用户：" + userName + "即将登录系统******************");
        if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(possword)) {
            if (!StringUtils.equals(userName, "allan@qq.com") || !StringUtils.equals(possword, "123456")) {
                return "error";
            }
        } else {
            return "error";
        }
        logger.info("*************用户：" + userName +"密码："+possword+ ",验证通过");
        model.addAttribute("userName", userName);
        model.addAttribute("freeMarker", "使用FreeMarker 模板加载");
        return "success";
    }


}
