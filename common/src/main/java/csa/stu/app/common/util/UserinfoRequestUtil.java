package csa.stu.app.common.util;

import com.alibaba.fastjson.JSON;
import csa.stu.app.common.entity.User;
import csa.stu.util.myutils.utils.EmptyUtil;
import csa.stu.util.myutils.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserinfoRequestUtil extends  UserinfoUtil{
    @Value("${csa.redis:false}")
    private boolean open; //是否开启redis
    @Autowired(required = false)
    private RedisUtil redisUtil;



    /**
     * 加入cookie
     * @param password
     * @return
     */
    public String putUser(User login,SelfCacheFn<Object> selfCache) {
        if(login==null) return null;
        String token=StrUtil.generateUUID32();
        login.setToken(token);
        if(open){
            //开启redis缓存功能
            redisUtil.set(token,JSON.toJSONString(login));
        }else if(selfCache!=null){
            //不使用redis缓存
            selfCache.accept();
        }
        return token;
    }

    public void logout(HttpServletResponse response,HttpServletRequest request,SelfCacheFn<User> selfCache) {
        logout(response,getTokenCookie(request),selfCache);
    }

    public void logout(HttpServletResponse response,String token,SelfCacheFn<User> selfCache) {
        super.logout(response);
        if(open){
            redisUtil.del(token);
        }else if(selfCache!=null){
            selfCache.accept();
        } //end else
    }

    /**
     * 获取用户cookie信息
     * @param request
     */
    public User getUser(HttpServletRequest request,SelfCacheFn<User> selfCache){
        String token=getTokenCookie(request);
        return getUser(token,selfCache);
    }

    public User getUser(String token,SelfCacheFn<User> selfCache){
        if(EmptyUtil.isEmptys(token)) return null;
        User user=null;
        if(open){
            user = JSON.parseObject(redisUtil.get(token),User.class);
        }else if(selfCache!=null){
            user = selfCache.accept();
        } //end else
        return user;
    }



    public interface SelfCacheFn<T>{
        public T accept();
    }


}
