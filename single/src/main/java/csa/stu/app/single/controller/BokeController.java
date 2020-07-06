package csa.stu.app.single.controller;

import csa.stu.app.common.entity.Boke;
import csa.stu.app.single.service.BokeService;
import csa.stu.app.single.util.LoginCacher;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public LoginCacher loginCacher() {
        return loginCacher;
    }
}
