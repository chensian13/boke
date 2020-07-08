package csa.stu.app.sso.controller;

import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoRequestUtil;
import csa.stu.app.single.service.UserService;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

/**
 *  有登录就会有登出
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserinfoRequestUtil userinfoUtil;


    /**
     * 网站用户登录
     * @param paramWrap
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultPojo<User> loginByUser(@RequestBody User user,HttpServletResponse response){
        ResultPojo<User> rs=userService.login(user);
        if(rs!=null
                && ResultPojo.OK.equals(rs.getCode())){
            //验证通过，设置cookie
            userinfoUtil.setUserData(rs.getModel());
        }
        return rs;
    }







}
