package csa.stu.app.bokesingle.component;

import csa.stu.app.bokesingle.login_cache.LoginCache;
import csa.stu.app.common.entity.User;
import csa.stu.util.ap.web_helper.login.LoginInterceptor;
import csa.stu.util.ap.web_helper.token.TokenUtilDefault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录拦截器
 * @author  csa
 */
@Component
public class MyLoginInterceptor extends LoginInterceptor {
    @Autowired
    private LoginCache loginCache;
    @Autowired
    private TokenUtilDefault tokenUtilDefault;
    private Logger logger= LoggerFactory.getLogger(MyLoginInterceptor.class);

    @Override
    public User getLoginUser(HttpServletRequest request) {
        return loginCache.get(tokenUtilDefault.getTokenCookie(request));
    }

    @Override
    public String getLoginPath() {
        return "/web/login.html";
    }
}
