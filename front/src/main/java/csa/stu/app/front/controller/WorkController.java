package csa.stu.app.front.controller;

import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoRequestUtil;
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
    private UserinfoRequestUtil userinfoUtil;

    @RequestMapping("/hello")
    public String goUserWork(){
        return "redirect:/work/index.html";
    }

    @RequestMapping("/goReadInner")
    public String goReadInner(HttpServletRequest request){
        User user=userinfoUtil.getUserCookie(request);
        return "redirect:/work/boke_store.html?author="+user.getUserId();
    }


}
