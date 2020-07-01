package csa.stu.app.front.controller;

import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author  csa
 */
@Controller
@RequestMapping("/work")
public class WorkController {
    @Autowired
    private UserinfoUtil userinfoUtil;

    @RequestMapping("/hello")
    public String goUserWork(){
        return "/work/index.html";
    }




}
