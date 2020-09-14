package csa.stu.app.front.component;

import csa.stu.app.common.entity.User;
import csa.stu.app.common.token.UserInfoUtilBoth;
import csa.stu.util.ap.web_helper.login.LoginInterceptor;
import csa.stu.util.ap.web_helper.token.TokenUtilDefault;
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
    private UserInfoUtilBoth userInfoUtilBoth;
    @Autowired
    private TokenUtilDefault tokenUtilDefault;

    @Override
    public User getLoginUser(HttpServletRequest request) {
        return userInfoUtilBoth.getUser(tokenUtilDefault.getTokenCookie(request));
    }

    @Override
    public String getLoginPath() {
        return "/web/login.html";
    }

}
