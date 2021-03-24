package me.xueyao;

import lombok.extern.slf4j.Slf4j;
import me.xueyao.async.FutureAsyncTask;
import me.xueyao.async.SimpleAsyncTask;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class AsyncMethodApplicationTests {

    @Autowired
    private SimpleAsyncTask simpleAsyncTask;
    @Autowired
    private FutureAsyncTask futureAsyncTask;

    /**
     * 调用异步方法 无返回值
     */
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

    /**
     * 调用异步方法 有返回值
     */
    @Test
    public void testAsyncResultSayHello() throws Exception {
        log.info("测试方法开始执行...");
        Future<String> future = futureAsyncTask.sayHello();
        log.info("调用异步方法后...");
        while (true) {
            if (future.isCancelled()) {
                log.info("异步方法已取消");
                break;
            }

            if (future.isDone()) {
                log.info("异步方法调用结束...");
                log.info("异步方法返回值是 {}", future.get());
                break;
            }

            log.info("等待异步方法执行结束...");
            Thread.sleep(3000);
        }

    }

}
