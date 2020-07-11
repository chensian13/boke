package csa.stu.app.bokesingle.component;

import csa.stu.app.common.cache.LoginCache;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoRequestUtil;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 缓存加强版，可以用于开发测试环境
 */
@Component
public class LoginCacher extends UserinfoUtil {
    @Autowired
    private LoginCache loginCache;
    @Autowired
    private UserinfoRequestUtil userinfoRequestUtil;

    public User get(String token){
        return userinfoRequestUtil.getUser(token,()->{
            return loginCache.get(token);
        });
    }

    public User get(HttpServletRequest request){
        return userinfoRequestUtil.getUser(request,()->{
            return loginCache.get(userinfoRequestUtil.getTokenCookie(request));
        });
    }

    public ResultPojo<User> put(User user){
        userinfoRequestUtil.putUser(user,()->{
            loginCache.put(user.getToken(),user);
            return null;
        });
        return ResultPojo.newInstance(ResultPojo.OK,null);
    }



    /**
     * 登出
     * @param response
     */
    public void logout(HttpServletResponse response,HttpServletRequest request){
       userinfoRequestUtil.logout(response,request,()->{
           loginCache.remove(getTokenCookie(request));
           return null;
       });
    }


}
