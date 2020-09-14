package csa.stu.app.front.controller;

import csa.stu.app.common.entity.User;
import csa.stu.app.common.token.UserInfoUtilBoth;
import csa.stu.app.front.feign.BokeKeeperService;
import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.ap.web_helper.token.TokenUtilDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/sso")
@Controller
public class SsoController {
    @Autowired
    private BokeKeeperService bokeKeeperService;
    @Autowired
    private TokenUtilDefault tokenUtilDefault;
    @Autowired
    private UserInfoUtilBoth userInfoUtilBoth;

    @RequestMapping("/login")
    @ResponseBody
    public ResultPojo<User> loginByUser(@RequestBody User user, HttpServletResponse response, HttpServletRequest request){
        ResultPojo<User> rs= bokeKeeperService.login(user);
        if(rs!=null
                && ResultPojo.OK.equals(rs.getCode())){
            //验证通过，设置cookie
            tokenUtilDefault.setTokenCookie(response,rs.getModel().getToken());
        }
        return rs;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public ResultPojo logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        userInfoUtilBoth.removeUser(tokenUtilDefault.getTokenCookie(request));
        tokenUtilDefault.removeTokenCookie(response);
        return ResultPojo.newInstance(ResultPojo.OK,null);
    }

}
