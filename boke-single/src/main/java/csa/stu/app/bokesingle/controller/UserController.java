package csa.stu.app.bokesingle.controller;

import csa.stu.app.bokesingle.login_cache.LoginCache;
import csa.stu.app.common.controller.MyControllerPlus;
import csa.stu.app.common.entity.User;
import csa.stu.app.single.service.UserService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.ap.web_helper.token.TokenUtilDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户信息控制层
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends MyControllerPlus<User> {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginCache loginCache;
    @Autowired
    private TokenUtilDefault tokenUtilDefault;

    @Override
    public IService<User> getService() {
        return userService;
    }


    @PostMapping("/modPass")
    @ResponseBody
    public ResultPojo modPass(@RequestBody User user, HttpServletRequest request){
        return mustWrapUser(request,user2->{
            user.setUserId(((User)user2).getUserId());
            return userService.modPass(user);
        });
    }

    @RequestMapping("/userinfo")
    @ResponseBody
    public ResultPojo<User> userinfo(HttpServletRequest request) {
        return mustWrapUser(request,user->{
            return userService.selectById(((User)user).getUserId());
        });
    }

    /**
     * 不必登录
     * @param request
     * @return
     */
    @RequestMapping("/userinfoQuery")
    @ResponseBody
    public ResultPojo<User> userinfoQuery(HttpServletRequest request) {
        return wrapUser(request,user->{
            return userService.selectById(((User)user).getUserId());
        });
    }

    @Override
    public User getLoginUser(HttpServletRequest request) {
        return loginCache.get(tokenUtilDefault.getTokenCookie(request));
    }
}
