package csa.stu.app.bokesingle.component;

import csa.stu.app.common.cache.LoginCacher;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.interceptor.LoginInterceptor;
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
    private LoginCacher userinfoUtil;
    private Logger logger= LoggerFactory.getLogger(MyLoginInterceptor.class);

    @Override
    public User getLoginUser(HttpServletRequest request) {
        return userinfoUtil.get( request);
    }
}
