package csa.stu.app.bk.controller;

import csa.stu.app.bk.component.TokenCache;
import csa.stu.app.bk.service.UserService;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.token.UserInfoUtilBoth;
import csa.stu.util.ap.mvc.helper.ServiceHelper;
import csa.stu.util.ap.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;

/**
 *  有登录就会有登出
 */
@Controller
@RequestMapping("/sso")
public class SsoController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoUtilBoth userInfoUtilBoth;
    @Autowired
    private TokenCache tokenCache;

    @RequestMapping("/get/{token}")
    @ResponseBody
    public User getUser(@PathVariable("token") String token) {
        return tokenCache.get(token);
    }

    @RequestMapping("/put/{token}")
    @ResponseBody
    public ResultPojo putUser(@PathVariable("token") String token,@RequestBody User user) {
        tokenCache.put(token,user);
        return ResultPojo.newInstance(ResultPojo.OK,null);
    }

    @RequestMapping("/remove/{token}")
    @ResponseBody
    public ResultPojo removeUser(@PathVariable("token") String token) {
        tokenCache.remove(token);
        return ResultPojo.newInstance(ResultPojo.OK,null);
    }

    /**
     * 网站用户登录
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultPojo<User> login(@RequestBody User user, HttpServletResponse response){
        return userService.login(user);
    }







}
