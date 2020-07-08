package csa.stu.app.common.interceptor;

import csa.stu.app.common.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @author  csa
 */
public abstract class LoginInterceptor implements HandlerInterceptor {
    private Logger logger= LoggerFactory.getLogger(LoginInterceptor.class);

    public abstract User getLoginUser(HttpServletRequest request);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            User user=getLoginUser(request);
            logger.info("已拦截："+request.getRequestURI());
            if(user!=null){
                logger.info("请求放行："+user);
                return true;
            }
            response.sendRedirect("/nouser/signin");
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
