package csa.stu.app.front.component;

import csa.stu.app.common.entity.User;
import csa.stu.app.common.interceptor.LoginInterceptor;
import csa.stu.app.common.util.UserinfoRequestUtil;
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
    private UserinfoRequestUtil userinfoUtil;
    private Logger logger= LoggerFactory.getLogger(MyLoginInterceptor.class);

    @Override
    public User getLoginUser(HttpServletRequest request) {
        return userinfoUtil.getUser(request);
    }

}
