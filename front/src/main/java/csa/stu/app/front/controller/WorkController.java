package csa.stu.app.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author  csa
 */
@Controller
@RequestMapping("/work")
public class WorkController {

    @RequestMapping("/hello")
    public String goUserWork(){
        return "/work/index.html";
    }

    @RequestMapping("/signin")
    public String login(){
        return "/work/login.html";
    }

    @RequestMapping("/signup")
    public String register(){
        return "/work/register.html";
    }

}
