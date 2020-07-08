package csa.stu.app.userwork.controller;

import csa.stu.app.common.entity.User;
import csa.stu.app.single.service.UserService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户信息控制层
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends MyController<User> {
    @Autowired
    private UserService userService;

    @Override
    public IService<User> getService() {
        return userService;
    }


    @PostMapping("/register")
    @ResponseBody
    public ResultPojo register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/modPass")
    @ResponseBody
    public ResultPojo modPass(@RequestBody User user){
        return userService.modPass(user);
    }


}
