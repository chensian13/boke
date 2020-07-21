package csa.stu.app.bokesingle.controller;

import csa.stu.app.bokesingle.component.LoginCacher;
import csa.stu.app.common.controller.MyControllerPlus;
import csa.stu.app.common.entity.Boke;
import csa.stu.app.common.entity.User;
import csa.stu.app.single.service.BokeService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
