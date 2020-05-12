package csa.stu.app.sso.controller;

import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.app.sso.service.UserService;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 *  有登录就会有登出
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;



    /**
     * 网站用户登录
     * @param paramWrap
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultPojo<User> loginByUser(@RequestBody User user){
        return userService.login(user);
    }






}
