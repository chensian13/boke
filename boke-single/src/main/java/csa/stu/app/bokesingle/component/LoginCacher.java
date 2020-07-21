package csa.stu.app.bokesingle.component;

import csa.stu.app.common.cache.LoginCache;
import csa.stu.app.common.entity.User;
import csa.stu.util.components.UserinfoUtil;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 缓存加强版，可以用于开发测试环境
 */
@Component()
public class LoginCacher  extends UserinfoUtil {
    @Autowired
    private LoginCache loginCache;

    public User get(String token){
            return loginCache.get(token);
    }

    public User get(HttpServletRequest request){
            return loginCache.get(super.getTokenCookie(request));
    }

    public ResultPojo<User> put(User user){
        loginCache.put(user.getToken(),user);
        return ResultPojo.newInstance(ResultPojo.OK,null);
    }



    /**
     * 登出
     * @param response
     */
    public void logout(HttpServletResponse response,HttpServletRequest request){
        loginCache.remove(super.getTokenCookie(request));
    }


}
