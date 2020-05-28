package csa.stu.app.common.cache;

import csa.stu.app.common.entity.User;
import org.springframework.stereotype.Component;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *  参考：https://blog.csdn.net/qq_35024198/article/details/91158502
 */
@Component
public class LoginCache {
    private final int initCacheSize=10;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    LinkedHashMap<String, User> cacheMap;

    /**
     * 缓存工具类构造方法
     * @param  cacheSize 缓存大小
     * @param  accessOrder 是否翻找访问顺序存放(false：按照插入顺序存放)
     * */
    public LoginCache() {
        cacheMap = new LinkedHashMap<String, User>(initCacheSize, DEFAULT_LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, User> eldest) {
                return size() > initCacheSize;
            }
        };
    }

    public synchronized void put(String key, User value) {
        cacheMap.put(key, value);
    }

    public synchronized User get(String key) {
        return cacheMap.get(key);
    }

    public synchronized void remove(String key) {
        cacheMap.remove(key);
    }

    public synchronized Set<Map.Entry<String, User>> getAll() {
        return cacheMap.entrySet();
    }



}
