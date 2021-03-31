package me.xueyao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;


@EnableRetry
@SpringBootApplication
public class RetryMethodApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetryMethodApplication.class, args);
    }

}
