package csa.stu.app.userwork.controller;

import csa.stu.app.common.entity.Boke;
import csa.stu.app.single.service.BokeService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
