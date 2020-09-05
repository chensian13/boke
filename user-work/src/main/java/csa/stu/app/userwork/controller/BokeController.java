package csa.stu.app.userwork.controller;

import csa.stu.app.common.entity.Boke;
import csa.stu.app.single.service.BokeService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 博客信息控制层
 *
 */
@Controller
@RequestMapping("/boke")
public class BokeController extends MyController<Boke> {
    @Autowired
    private BokeService bokeService;

    @Override
    public IService<Boke> getService() {
        return bokeService;
    }




}
