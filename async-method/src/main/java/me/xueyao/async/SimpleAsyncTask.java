package me.xueyao.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Simon.Xue
 * @date 2021/3/24 10:39 下午
 **/
@Component
@Slf4j
public class SimpleAsyncTask {

    /**
     * 异步方法
     */
    @Async
    public void sayHello() {
        try {
            // 休眠三秒
            log.info("进入异步方法中...");
            Thread.sleep(3000);
            log.info("Hello, World! Thread = {}", Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("异步方法执行结束...");
    }
}
