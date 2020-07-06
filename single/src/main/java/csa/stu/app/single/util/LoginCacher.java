package csa.stu.app.single.util;
import csa.stu.app.common.cache.LoginCache;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import csa.stu.util.myutils.utils.StrUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 缓存
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

    public ResultPojo<User> put( User user){
        String token= StrUtil.generateUUID32();
        user.setToken(token);
        loginCache.put(user.getToken(),user);
        return ResultPojo.newInstance(ResultPojo.OK,null);
    }



    /**
     * 登出
     * @param response
     */
    public void logout(HttpServletResponse response){
        Cookie cookie=new Cookie("token",null);
        cookie.setMaxAge(0);
        cookie.setPath("/"); //必须要和登录设置cookie路径一致，否则无效
        response.addCookie(cookie);
    }


}
