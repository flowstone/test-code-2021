package me.xueyao.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 异步调用返回数据
 * @author Simon.Xue
 * @date 2021/3/24 10:55 下午
 **/
@Slf4j
@Component
public class FutureAsyncTask {

    /**
     * 异步方法 带返回值
     * @return
     */
    @Async
    public Future<String> sayHello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(String.valueOf(System.currentTimeMillis()));
    }
}
