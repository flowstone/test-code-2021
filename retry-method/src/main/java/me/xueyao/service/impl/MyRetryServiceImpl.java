package me.xueyao.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.xueyao.service.MyRetryService;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author Simon.Xue
 * @date 2021/3/31 10:51 下午
 **/
@Slf4j
@Service
public class MyRetryServiceImpl implements MyRetryService {

    /**
     *
     * @Retryable
     * value 什么异常需要重试方法
     * maxAttempts 重试次数(包含第一次)
     * delay 时间间隔
     * multiplier 重试时间的倍数
     */
    @Override
    @Retryable(value= Exception.class, maxAttempts = 3, backoff =@Backoff(delay = 2000, multiplier = 1.5))
    public void sendMessage() throws Exception {
        log.info("准备开始发送消息,当前线程ID = {}", Thread.currentThread().getId());
        // 抛出异常
        int code = 0;

        //int code = 1;
        if (code == 0) {
            throw new Exception("发送消息失败，准备重试!");
        }
        log.info("发送消息成功，继续执行!");
    }

    @Recover
    public void recover(Exception e) {
        log.info("重试次数超过指定次数，还失败时，调用此方法,当前线程ID = {}", Thread.currentThread().getId());
    }
}
