package csa.stu.app.sso.controller;

import csa.stu.app.common.cache.LoginCacher;
import csa.stu.app.common.entity.User;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 缓存-开发测试专用
 */
@Controller
@RequestMapping("/cache")
public class LoginCacherController{
    @Autowired
    private LoginCacher loginCacher;

    @RequestMapping("/get")
    @ResponseBody
    public User get(@RequestBody String token){
        User user=loginCacher.get(token);
        return user;
    }

    @RequestMapping("/put")
    @ResponseBody
    public ResultPojo<User> put(@RequestBody User user){
        return loginCacher.put(user);
    }

    @RequestMapping("/logout")
    public void logout(HttpServletResponse response, HttpServletRequest request) {
        loginCacher.logout(response,request);
    }
}
