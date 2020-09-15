package csa.stu.app.userwork.controller;

import csa.stu.app.common.entity.Special;
import csa.stu.app.userwork.service.SpecialService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/special")
public class SpecialController extends MyController<Special> {
    @Autowired
    private SpecialService specialService;


    @Override
    public IService<Special> getService() {
        return specialService;
    }


}
