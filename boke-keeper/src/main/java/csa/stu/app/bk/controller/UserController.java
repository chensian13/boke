package csa.stu.app.bk.controller;

import csa.stu.app.bk.service.UserService;
import csa.stu.app.common.entity.User;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import csa.stu.util.ap.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 *  有登录就会有登出
 */
@Controller
@RequestMapping("/user")
public class UserController extends MyController<User> {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    @ResponseBody
    public ResultPojo register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/modPass")
    @ResponseBody
    public ResultPojo modPass(@RequestBody User user, HttpServletRequest request){
        return userService.modPass(user);
    }


    @Override
    public IService<User> getService() {
        return userService;
    }
}
