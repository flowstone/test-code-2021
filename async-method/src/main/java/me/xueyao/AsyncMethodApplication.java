package me.xueyao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 启动类
 * @author Simon.Xue
 */
@EnableAsync
@SpringBootApplication
public class AsyncMethodApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncMethodApplication.class, args);
    }

}
