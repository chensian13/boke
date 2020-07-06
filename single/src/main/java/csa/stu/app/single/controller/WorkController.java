package csa.stu.app.single.controller;

import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.app.single.util.LoginCacher;
import org.springframework.beans.factory.annotation.Autowired;
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
    private LoginCacher userinfoUtil;

    @RequestMapping("/hello")
    public String goUserWork(){
        return "redirect:/work/index.html";
    }

    @RequestMapping("/goReadInner")
    public String goReadInner(HttpServletRequest request){
        User user=userinfoUtil.get(request);
        return "redirect:/work/boke_store.html?author="+user.getUserId();
    }


}
