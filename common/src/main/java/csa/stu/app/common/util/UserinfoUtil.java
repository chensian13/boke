package csa.stu.app.common.util;

import com.alibaba.fastjson.JSON;
import csa.stu.app.common.entity.User;
import csa.stu.util.myutils.utils.EmptyUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

@Component
public class UserinfoUtil {
    @Value("${csa.redis:false}")
    private boolean open; //是否开启redis

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

    /**
     * 加入cookie
     * @param password
     * @return
     */
    public void setUserCookie(User user, HttpServletResponse response) {
        if(user==null) return ;
        try{
            String json= JSON.toJSONString(user);
            json= URLEncoder.encode(json,"UTF-8");
            Cookie cookie=new Cookie("token",json);
            cookie.setMaxAge(60*60*24*7);
            cookie.setPath("/");
            response.addCookie(cookie);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
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

    /**
     * 获取用户cookie信息
     * @param response
     */
    public User getUserCookie(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if(cookies==null) return null;
        for(Cookie cookie:cookies){
            if("token".equals(cookie.getName())
                    && !EmptyUtil.isEmpty(cookie.getValue())){
                try{
                    String json= URLDecoder.decode(cookie.getValue(),"UTF-8");
                    return JSON.parseObject(json,User.class);
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        } //end for
        return null;
    }

}
