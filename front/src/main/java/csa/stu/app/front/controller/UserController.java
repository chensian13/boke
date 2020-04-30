package csa.stu.app.front.controller;

import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.app.front.feign.UserService;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author csa
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserinfoUtil userinfoUtil;

    @RequestMapping("/login")
    @ResponseBody
    public ResultPojo<User> loginByUser(@RequestBody User user, HttpServletResponse response){
        ResultPojo<User> rs=userService.loginByUser(user);
        if(rs!=null
                && ResultPojo.OK.equals(rs.getCode())){
            //验证通过，设置cookie
            userinfoUtil.setUserCookie(rs.getModel(),response);
        }
        return rs;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public ResultPojo logout(HttpServletResponse response) throws IOException {
        userinfoUtil.logout(response);
        return ResultPojo.newInstance(ResultPojo.OK,"");
    }

    @PostMapping("/register")
    @ResponseBody
    public ResultPojo register(@RequestBody User user){
        return userService.register(user);
    }

}
