package me.xueyao.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Simon.Xue
 * @date 2021/3/19 12:49 下午
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpireLockUtilTest {

    @Autowired
    private ExpireLockUtils expireLockUtils;

    @Test
    public void testTryLockExpireTime() {
        String key = "key_0002";
        String requestId = "1";
        boolean b = expireLockUtils.tryLockExpireTime(key, requestId, 60);
        log.info("是否获得到锁 = {}", b);
    }

    @Test
    public void testUnLock() {
        String key = "key_0002";
        String requestId = "1";
        boolean b = expireLockUtils.unLock(key, requestId);
        log.info("是否释放锁{}", b);
    }
}
