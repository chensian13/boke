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
        return "redirect:/work/index.html";
    }



}
