package csa.stu.app.common.token;

import csa.stu.app.common.entity.User;
import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.ap.web_helper.token.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserInfoUtilBoth implements UserInfoUtil {
    @Value("${csa.redis:false}")
    private boolean open; //是否开启redis
    @Autowired(required = false)
    private UserInfoUtilRedis userInfoUtilRedis;
    @Autowired(required = false)
    private RestTemplate restTemplate;


    @Override
    public User getUser(String token) {
        if(open){
            return userInfoUtilRedis.getUser(token);
        }
        return restTemplate.postForObject("http://boke-keeper/sso/get/"+token,null, User.class);
    }

    @Override
    public void putUser(String token, Object user) {
        if(open){
            userInfoUtilRedis.putUser(token,user);
        }else{
            restTemplate.postForObject("http://boke-keeper/sso/put/"+token,user, ResultPojo.class);
        }
    }

    @Override
    public void removeUser(String token) {
        if(open){
            userInfoUtilRedis.removeUser(token);
        }else{
            restTemplate.postForObject("http://boke-keeper/sso/remove/"+token,null, ResultPojo.class);
        }
    }


}
