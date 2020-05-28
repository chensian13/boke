package csa.stu.app.common.util;

import com.alibaba.fastjson.JSON;
import csa.stu.app.common.entity.User;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import csa.stu.util.myutils.utils.StrUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserinfoUtil {
    @Value("${csa.redis:false}")
    private boolean open; //是否开启redis
    @Autowired(required = false)
    private RedisUtil redisUtil;
    @Autowired
    @Qualifier("myRestTemplate")
    private RestTemplate restTemplate;

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

    public void setUserCookie(HttpServletResponse response,String token){
        //存入token
        Cookie cookie=new Cookie("token",token);
        cookie.setMaxAge(60*60*24*7);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 加入cookie
     * @param password
     * @return
     */
    public String setUserData(User login) {
        if(login==null) return null;
        String token=StrUtil.generateUUID32();
        login.setToken(token);
        if(open){
            //开启redis缓存功能
            redisUtil.set(token,JSON.toJSONString(login));
        }else{
            //不使用redis缓存
            restTemplate.postForObject("http://sso/cache/put",login, ResultPojo.class);
        }
        return token;
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
        String token=null;
        for(Cookie cookie:cookies){
            if("token".equals(cookie.getName())
                    && !EmptyUtil.isEmpty(cookie.getValue())){
                token= cookie.getValue();
                break;
            }
        } //end for
        if(EmptyUtil.isEmptys(token)) return null;
        if(open){
            return JSON.parseObject(redisUtil.get(token),User.class);
        }else{
            return restTemplate.postForObject("http://sso/cache/get",token, User.class);
        } //end else
    }

}
