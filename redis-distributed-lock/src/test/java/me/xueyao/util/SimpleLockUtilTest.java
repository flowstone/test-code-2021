package me.xueyao.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Simon.Xue
 * @date 2021/3/15 11:43 下午
 **/
@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleLockUtilTest {
    @Autowired
    private SimpleLockUtils simpleLockUtils;

    @Test
    public void testTryLock() {
        String key = "key_0001";
        String requestId = "1";
        boolean b = simpleLockUtils.tryLock(key, requestId);
        log.info("是否获得到锁{}", b);
    }

    @Test
    public void testUnLock() {
        String key = "key_0001";
        String requestId = "1";
        boolean b = simpleLockUtils.unLock(key, requestId);
        log.info("是否释放锁{}", b);
    }


}
