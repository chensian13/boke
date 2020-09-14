//package csa.stu.app.front.controller;
//
//import csa.stu.app.common.entity.Boke;
//import csa.stu.app.common.entity.User;
//import csa.stu.app.common.util.UserinfoRequestUtil;
//import csa.stu.app.front.feign.SsoService;
//import csa.stu.app.front.feign.UserWorkService;
//import csa.stu.util.ap.pojo.ParamPojo;
//import csa.stu.util.ap.pojo.ResultPojo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@RequestMapping("/nouser")
//@Controller
//public class NoUserController {
//    @Autowired
//    private SsoService ssoService;
//    @Autowired
//    private UserWorkService userWorkService;
//    @Autowired
//    private UserinfoRequestUtil userinfoUtil;
//
//
//    @RequestMapping("/login")
//    @ResponseBody
//    public ResultPojo<User> loginByUser(@RequestBody User user, HttpServletResponse response, HttpServletRequest request){
//        ResultPojo<User> rs= ssoService.loginByUser(user);
//        if(rs!=null
//                && ResultPojo.OK.equals(rs.getCode())){
//            //验证通过，设置cookie
//            userinfoUtil.setTokenCookie(response,rs.getModel().getToken());
//        }
//        return rs;
//    }
//
//    @RequestMapping("/logout")
//    @ResponseBody
//    public ResultPojo logout(HttpServletResponse response) throws IOException {
//        return ssoService.logout();
//    }
//
//    @PostMapping("/register")
//    @ResponseBody
//    public ResultPojo register(@RequestBody User user){
//        return userWorkService.register(user);
//    }
//
//    @RequestMapping("/signin")
//    public String login(){
//        return "redirect:/work/login.html";
//    }
//
//    @RequestMapping("/signup")
//    public String register(){
//        return "redirect:/work/register.html";
//    }
//
//    @RequestMapping("/goRead/{userId}")
//    public String goRead(@PathVariable("userId") String userId){
//        return "redirect:/work/boke_store.html?author="+userId;
//    }
//
//
//    @RequestMapping({"/queryData/{userId}"})
//    @ResponseBody
//    public ResultPojo<Boke> queryData(@RequestBody ParamPojo paramPojo, @PathVariable("userId") String userId) {
//        if(paramPojo.getMap()==null){
//            Map<String,Object> map=new HashMap<>();
//            paramPojo.setMap(map);
//        }
//        paramPojo.getMap().put("creater",userId);
//        return userWorkService.queryData(paramPojo);
//    }
//
//}
