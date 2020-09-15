package csa.stu.app.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {

    @RequestMapping("/signin")
    public String login(){
        return "redirect:/web/login.html";
    }

    @RequestMapping("/signup")
    public String register(){
        return "redirect:/web/register.html";
    }

    @RequestMapping("/goRead/{userId}")
    public String goRead(@PathVariable("userId") String userId){
        return "redirect:/web/boke_store.html?author="+userId;
    }

}
