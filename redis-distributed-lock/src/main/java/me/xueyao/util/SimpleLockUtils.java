package me.xueyao.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 简单的Redis锁
 * @author Simon.Xue
 * @date 2021/3/15 11:13 下午
 **/
@Component
public class SimpleLockUtils {
    private static final Boolean SUCCESS = Boolean.TRUE;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 加锁
     * @param key
     * @param requestId
     * @return
     */
    public boolean tryLock(String key, String requestId) {
        return SUCCESS.equals(redisTemplate.opsForValue().setIfAbsent(key, requestId));
    }

    /**
     * 解锁
     * @param key
     * @param requestId
     * @return
     */
    public boolean unLock(String key, String requestId) {
        if (requestId.equals(redisTemplate.opsForValue().get(key))) {
            return redisTemplate.delete(key);
        }
        return false;
    }

}
