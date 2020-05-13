package csa.stu.app.common.util;

import org.springframework.stereotype.Component;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 防止重复提交帮助类
 * 本地锁机制：由于用户线程不止一条，所以使用synchronized没有意义，我们针对每次提交数据作为每个请求的唯一标识
 * */
@Component
public class ResubmitLockUtil {
    private final static ConcurrentHashMap<String,Object> LOCK=new ConcurrentHashMap<>();
    private static final ScheduledThreadPoolExecutor EXECUTOR = new ScheduledThreadPoolExecutor(20, new ThreadPoolExecutor.DiscardPolicy());

    /**
     * 是否上锁
     * @param key
     * @param obj
     * @return
     */
    public boolean look(String key,Object obj){
        return Objects.isNull(LOCK.putIfAbsent(key,obj));
    }

    /**
     * 解锁
     * @param key
     * @param obj
     * @return
     */
    public void unlook(String key,int delayTime){
        EXECUTOR.schedule(()->{
            LOCK.remove(key);
        },delayTime, TimeUnit.SECONDS);
    }

}
