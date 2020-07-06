package csa.stu.app.single.controller;

import csa.stu.app.common.entity.User;
import csa.stu.app.single.service.UserService;
import csa.stu.app.single.util.LoginCacher;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.myutils.pojo.ResultPojo;
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
    private LoginCacher loginCacher;

    @Override
    public LoginCacher loginCacher() {
        return loginCacher;
    }

    @Override
    public IService<User> getService() {
        return userService;
    }


    @PostMapping("/modPass")
    @ResponseBody
    public ResultPojo modPass(@RequestBody User user){
        return userService.modPass(user);
    }

    @RequestMapping("/userinfo")
    @ResponseBody
    public ResultPojo<User> userinfo(HttpServletRequest request) {
        User user=loginCacher.get(request);
        if(user==null) return ResultPojo.newInstance(ResultPojo.NO,"用户信息获取失败");
        return ResultPojo.newInstance(user);
    }

}
