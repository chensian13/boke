package csa.stu.app.single.util;
import csa.stu.app.common.cache.LoginCache;
import csa.stu.app.common.entity.User;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


/**
 * 缓存
 */
@Component
public class LoginCacher {
    @Autowired
    private LoginCache loginCache;

    public User get(@RequestBody String token){
        return loginCache.get(token);
    }

    public ResultPojo<User> put(@RequestBody User user){
        if(EmptyUtil.isEmptys(user.getToken())){
            return ResultPojo.newInstance(ResultPojo.NO,"token不存在");
        }
        loginCache.put(user.getToken(),user);
        return ResultPojo.newInstance(ResultPojo.OK,null);
    }


    /**
     * 盐值加密
     * @param password
     * @return
     */
    public String saltPassword(String password,String salt){
        if(EmptyUtil.isEmptys(password,salt)) return null;
        SimpleHash sh=new SimpleHash("MD5", password, salt, 13);
        //转换16进制
        return sh.toHex();
    }

    public void setUserCookie(HttpServletResponse response, String token){
        //存入token
        Cookie cookie=new Cookie("token",token);
        cookie.setMaxAge(60*60*24*7);
        cookie.setPath("/");
        response.addCookie(cookie);
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
