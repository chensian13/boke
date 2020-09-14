package csa.stu.app.common.token;

import com.alibaba.fastjson.JSON;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.redis.RedisUtil;
import csa.stu.util.ap.web_helper.token.TokenUtilDefault;
import csa.stu.util.ap.web_helper.token.UserInfoUtil;
import csa.stu.util.myutils.direct.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Component
public class UserInfoUtilRedis implements UserInfoUtil {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private TokenUtilDefault tokenUtilDefault;

    /**
     * 获取用户cookie信息
     * @param request
     */
    public User getUser(HttpServletRequest request){
        String token=tokenUtilDefault.getTokenCookie(request);
        return getUser(token);
    }

    @Override
    public User getUser(String token){
        if(EmptyUtil.isEmptys(token)) return null;
        return JSON.parseObject(redisUtil.get(token),User.class);
    }

    @Override
    public void putUser(String token, Object user) {
        // 开启redis缓存功能
        redisUtil.set(token, JSON.toJSONString(user));
    }

    @Override
    public void removeUser(String token) {
        redisUtil.del(token);
    }

}
