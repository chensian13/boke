package csa.stu.app.common.aop;

import csa.stu.app.common.annotation.RedisCache;
import csa.stu.app.common.annotation.Resubmit;
import csa.stu.app.common.util.RedisUtil;
import csa.stu.app.common.util.ResubmitLockUtil;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import csa.stu.util.myutils.utils.JSONUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
@Aspect
public class RedisCacheAspect {
    @Autowired(required = false)
    private RedisUtil redisUtil;
    @Value("${csa.redis:false}")
    private boolean open;

    @Around("@annotation(redisCache)")
    public Object handleResubmit(ProceedingJoinPoint joinPoint, RedisCache redisCache) throws Throwable {
        if(!open){
            //不开启redis
            return joinPoint.proceed();
        }
        String key=getKey(joinPoint,redisCache);
        String re = redisUtil.get(key);
        if(!EmptyUtil.isEmptys(re)){
            return JSONUtil.parseObj(re,ResultPojo.class);
        }
        Object da = joinPoint.proceed();
        redisUtil.set(getKey(joinPoint,redisCache),JSONUtil.formatJSON(da));
        return da;
    }

    /**
     * 1.判断用户key类型  auto empty
     * @param joinPoint
     * @param cache_find
     * @return
     */
    private String getKey(ProceedingJoinPoint joinPoint, RedisCache redisCache) {
        if(!redisCache.self()) {
            //表示使用用户自己的key
            return redisCache.key();
        }
        //表示用户的key需要拼接  key+第一个参数
        Object[] args=joinPoint.getArgs();
        if(args.length>0){
            return redisCache.key()+JSONUtil.formatJSON(args[0]);
        }
        throw new RuntimeException("redis cache没有定义key");
    }




}
