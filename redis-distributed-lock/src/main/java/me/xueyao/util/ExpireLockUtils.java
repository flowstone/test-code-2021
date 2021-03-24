package me.xueyao.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Simon.Xue
 * @date 2021/3/19 12:45 下午
 **/
@Component
public class ExpireLockUtils {
    private static final Boolean SUCCESS = Boolean.TRUE;
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 加锁(带过期时间)
     * 可能出现业务功能未执行完，就释放锁
     * @param key
     * @param requestId
     * @return
     */
    public boolean tryLockExpireTime(String key, String requestId, int expireTime) {
        return SUCCESS.equals(redisTemplate.opsForValue().setIfAbsent(key, requestId, expireTime, TimeUnit.SECONDS));
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
