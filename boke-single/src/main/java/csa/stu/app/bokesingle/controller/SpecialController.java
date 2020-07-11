package csa.stu.app.bokesingle.controller;

import csa.stu.app.bokesingle.component.LoginCacher;
import csa.stu.app.common.entity.Special;
import csa.stu.app.common.entity.User;
import csa.stu.app.single.controller.MyControllerPlus;
import csa.stu.app.single.service.SpecialService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/special")
public class SpecialController extends MyControllerPlus<Special> {
    @Autowired
    private SpecialService specialService;
    @Autowired
    private LoginCacher loginCacher;

    @Override
    public User getLoginUser(HttpServletRequest request) {
        return loginCacher.get(request);
    }

    @Override
    public IService<Special> getService() {
        return specialService;
    }


}
