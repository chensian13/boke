package csa.stu.app.common.util;

import com.alibaba.fastjson.JSON;
import csa.stu.app.common.entity.User;
import csa.stu.util.components.UserinfoUtil;
import csa.stu.util.myutils.utils.EmptyUtil;
import csa.stu.util.myutils.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基于redis
 */
@Component
public class UserinfoRequestUtil extends UserinfoUtil {
    @Value("${csa.redis:false}")
    private boolean open; //是否开启redis
    @Autowired(required = false)
    private RedisUtil redisUtil;



    /**
     * 加入cookie
     * @param
     * @return
     */
    public String putUser(User login) {
        if(login==null) return null;
        String token=StrUtil.generateUUID32();
        login.setToken(token);
        if(open){
            //开启redis缓存功能
            redisUtil.set(token,JSON.toJSONString(login));
        }
        throw new RuntimeException("请开启redis缓存");
    }

    public void logout(HttpServletResponse response,HttpServletRequest request) {
        logout(response,getTokenCookie(request));
    }

    public void logout(HttpServletResponse response,String token) {
        super.logout(response);
        if(open){
            redisUtil.del(token);
        }
        throw new RuntimeException("请开启redis缓存");
    }

    /**
     * 获取用户cookie信息
     * @param request
     */
    public User getUser(HttpServletRequest request){
        String token=getTokenCookie(request);
        return getUser(token);
    }

    public User getUser(String token){
        if(EmptyUtil.isEmptys(token)) return null;
        User user=null;
        if(open){
            user = JSON.parseObject(redisUtil.get(token),User.class);
        }
        throw new RuntimeException("请开启redis缓存");
    }






}
