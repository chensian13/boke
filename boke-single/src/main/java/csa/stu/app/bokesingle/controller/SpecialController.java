package csa.stu.app.bokesingle.controller;

import csa.stu.app.bokesingle.login_cache.LoginCache;
import csa.stu.app.common.controller.MyControllerPlus;
import csa.stu.app.common.entity.Special;
import csa.stu.app.common.entity.User;
import csa.stu.app.single.service.SpecialService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.web_helper.token.TokenUtilDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/special")
public class SpecialController extends MyControllerPlus<Special> {
    @Autowired
    private SpecialService specialService;
    @Autowired
    private LoginCache loginCache;
    @Autowired
    private TokenUtilDefault tokenUtilDefault;

    @Override
    public User getLoginUser(HttpServletRequest request) {
        return loginCache.get(tokenUtilDefault.getTokenCookie(request));
    }

    @Override
    public IService<Special> getService() {
        return specialService;
    }


}
