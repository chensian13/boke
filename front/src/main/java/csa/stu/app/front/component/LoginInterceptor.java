package csa.stu.app.front.component;

import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @author  csa
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserinfoUtil userinfoUtil;
    private Logger logger= LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            User user=userinfoUtil.getUserCookie(request);
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
