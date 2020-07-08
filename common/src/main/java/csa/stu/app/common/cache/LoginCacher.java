package csa.stu.app.common.cache;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import csa.stu.util.myutils.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 缓存加强版，可以用于开发测试环境
 */
@Component
public class LoginCacher extends UserinfoUtil {
    @Autowired
    private LoginCache loginCache;

    public User get(String token){
        return loginCache.get(token);
    }

    public User get(HttpServletRequest request){
        return loginCache.get(getTokenCookie(request));
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
       super.logout(response);
       loginCache.remove(getTokenCookie(request));
    }


}
