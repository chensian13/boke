package csa.stu.app.front.controller;

import csa.stu.app.common.entity.User;
import csa.stu.app.common.token.UserInfoUtilBoth;
import csa.stu.app.front.feign.BokeKeeperService;
import csa.stu.util.ap.mvc.plus.CheckLoginController;
import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.ap.web_helper.token.TokenUtilDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @author csa
 */
@RequestMapping("/user")
@Controller
public class UserController implements CheckLoginController {
    @Autowired
    private BokeKeeperService bokeKeeperService;
    @Autowired
    private TokenUtilDefault tokenUtilDefault;
    @Autowired
    private UserInfoUtilBoth userInfoUtilBoth;

    @PostMapping("/register")
    @ResponseBody
    public ResultPojo register(@RequestBody User user){
        return bokeKeeperService.register(user);
    }

    @RequestMapping("/userinfo")
    @ResponseBody
    public ResultPojo<User> userinfo(HttpServletRequest request) {
        return ResultPojo.newInstance(userInfoUtilBoth.getUser(tokenUtilDefault.getTokenCookie(request)));
    }

    @RequestMapping("/data/{oper}")
    @ResponseBody
    public ResultPojo<User> operData(@RequestBody User user,@PathVariable("oper") String oper,HttpServletRequest request) {
        return mustWrapUser(request,data->{
            user.setToken(tokenUtilDefault.getTokenCookie(request));
            return bokeKeeperService.operUserData(user, oper);
        });
    }

    @PostMapping("/modPass")
    @ResponseBody
    public ResultPojo modPass(@RequestBody User user,HttpServletRequest request){
        return mustWrapUser(request,user2->{
            user.setUserId(((User)user2).getUserId());
            return bokeKeeperService.modPass(user);
        });
    }

    @Override
    public Object getLoginUser(HttpServletRequest request) {
        return userInfoUtilBoth.getUser(tokenUtilDefault.getTokenCookie(request));
    }

    @Override
    public String[] getWhiteMethod() {
        return null ;
    }
}
