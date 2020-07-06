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
public class UserinfoRequestUtil extends  UserinfoUtil{
    @Value("${csa.redis:false}")
    private boolean open; //是否开启redis
    @Autowired(required = false)
    private RedisUtil redisUtil;
    @Autowired(required = false)
    @Qualifier("myRestTemplate")
    private RestTemplate restTemplate;


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
     * 获取用户cookie信息
     * @param response
     */
    public User getUserCookie(HttpServletRequest request){
        String token=getTokenCookie(request);
        if(EmptyUtil.isEmptys(token)) return null;
        if(open){
            return JSON.parseObject(redisUtil.get(token),User.class);
        }else{
            return restTemplate.postForObject("http://sso/cache/get",token, User.class);
        } //end else
    }




}
