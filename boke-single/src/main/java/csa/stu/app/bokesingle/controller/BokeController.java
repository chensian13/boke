package csa.stu.app.bokesingle.controller;

import csa.stu.app.common.cache.LoginCacher;
import csa.stu.app.common.entity.Boke;
import csa.stu.app.common.entity.User;
import csa.stu.app.single.controller.MyControllerPlus;
import csa.stu.app.single.service.BokeService;
import csa.stu.util.ap.mvc.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 博客信息控制层
 *
 */
@Controller
@RequestMapping("/boke")
public class BokeController extends MyControllerPlus<Boke> {
    @Autowired
    private BokeService bokeService;
    @Autowired
    private LoginCacher loginCacher;


    @Override
    public IService<Boke> getService() {
        return bokeService;
    }


    @Override
    public User getLoginUser(HttpServletRequest request) {
        return loginCacher.get(request);
    }
}