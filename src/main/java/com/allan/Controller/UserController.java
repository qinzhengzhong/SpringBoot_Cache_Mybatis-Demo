package com.allan.Controller;

import com.allan.Util.PDFUtil.ExportPDFUtil;
import com.allan.base.BaseController;
import com.allan.entity.User;
import com.allan.query.UserQuery;
import com.allan.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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


    /**
     * 用户列表查询
     *
     * @param pageNum   页码
     * @param pageSize  每页数量
     * @param userQuery 查询条件
     * @return
     */
    @GetMapping(value = "/queryUserList")
    public String queryUserList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                UserQuery userQuery) {
        userQuery.setPageNum(pageNum);
        userQuery.setPageSize(pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.queryUserList(userQuery);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        return getSuccessResult(pageInfo);
    }

    /**
     * 导出demo
     *  localhost:8081/download/exportPDF
     * @param response
     */
    @GetMapping(value = "/download/exportPDF")
    public void exportPDF(HttpServletResponse response,
                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                          UserQuery userQuery) {
        try {
            userQuery.setPageNum(pageNum);
            userQuery.setPageSize(pageSize);
            PageHelper.startPage(pageNum, pageSize);
            List<User> list = userService.queryUserList(userQuery);
           //组装数据 to do something

            String pdfName = "导出PDF测试";
            ExportPDFUtil.exportPDF(response, pdfName,null,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
