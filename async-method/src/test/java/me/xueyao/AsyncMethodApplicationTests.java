package me.xueyao;

import lombok.extern.slf4j.Slf4j;
import me.xueyao.async.SimpleAsyncTask;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class AsyncMethodApplicationTests {

    @Autowired
    private SimpleAsyncTask simpleAsyncTask;
    @Test
    public void testAsyncSayHello() {
        log.info("测试方法开始执行...");
        simpleAsyncTask.sayHello();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("测试方法执行结束...");
    }

}
