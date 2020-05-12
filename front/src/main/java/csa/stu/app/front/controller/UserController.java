package csa.stu.app.front.controller;

import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.app.front.feign.SsoService;
import csa.stu.app.front.feign.UserWorkService;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author csa
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private SsoService ssoService;
    @Autowired
    private UserWorkService userWorkService;
    @Autowired
    private UserinfoUtil userinfoUtil;

    @RequestMapping("/login")
    @ResponseBody
    public ResultPojo<User> loginByUser(@RequestBody User user, HttpServletResponse response){
        ResultPojo<User> rs= ssoService.loginByUser(user);
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
        return userWorkService.register(user);
    }


    @RequestMapping("/userinfo")
    @ResponseBody
    public ResultPojo<User> userinfo(HttpServletRequest request) {
        User user=userinfoUtil.getUserCookie(request);
        if(user==null) return ResultPojo.newInstance(ResultPojo.NO,"用户信息获取失败");
        return userWorkService.queryUserById(user.getUserId());
    }

    @RequestMapping("/data/upd")
    @ResponseBody
    public ResultPojo<User> userinfo(@RequestBody User user) {
        return userWorkService.updUserById(user);
    }

    @PostMapping("/modPass")
    @ResponseBody
    public ResultPojo modPass(@RequestBody User user,HttpServletRequest request){
        User user2=userinfoUtil.getUserCookie(request);
        user.setUserId(user2.getUserId());
        return userWorkService.modPass(user);
    }

}
