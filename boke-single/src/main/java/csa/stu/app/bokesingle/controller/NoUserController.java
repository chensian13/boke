package csa.stu.app.bokesingle.controller;

import csa.stu.app.common.cache.LoginCacher;
import csa.stu.app.common.entity.Boke;
import csa.stu.app.common.entity.User;
import csa.stu.app.single.service.BokeService;
import csa.stu.app.single.service.UserService;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/nouser")
@Controller
public class NoUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BokeService bokeService;
    @Autowired
    private LoginCacher loginCacher;

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
            loginCacher.put(rs.getModel());
            loginCacher.setUserCookie(response,rs.getModel().getToken());
        }
        return rs;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public ResultPojo logout(HttpServletResponse response, HttpServletRequest request) throws IOException {
        loginCacher.logout(response,request);
        return ResultPojo.newInstance(ResultPojo.OK,null);
    }

    @PostMapping("/register")
    @ResponseBody
    public ResultPojo register(@RequestBody User user){
        return userService.register(user);
    }

    @RequestMapping("/signin")
    public String login(){
        return "redirect:/work/login.html";
    }

    @RequestMapping("/signup")
    public String register(){
        return "redirect:/work/register.html";
    }

    @RequestMapping("/goRead/{userId}")
    public String goRead(@PathVariable("userId") String userId){
        return "redirect:/work/boke_store.html?author="+userId;
    }


    @RequestMapping({"/queryData/{userId}"})
    @ResponseBody
    public ResultPojo<Boke> queryData(@RequestBody ParamPojo paramPojo, @PathVariable("userId") String userId) {
        if(paramPojo.getMap()==null){
            Map<String,Object> map=new HashMap<>();
            paramPojo.setMap(map);
        }
        paramPojo.getMap().put("creater",userId);
        return bokeService.selectData(paramPojo);
    }

}
