package me.xueyao;

import lombok.extern.slf4j.Slf4j;
import me.xueyao.publish.SmsEventPublish;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringEventNoticeApplicationTests {

    @Autowired
    private SmsEventPublish smsEventPublish;

    @Test
    public void testSmsEvent() throws InterruptedException {
        smsEventPublish.publish("今天天气真好");
        log.info("这应该是先输出的记录，{}", System.currentTimeMillis());
        Thread.sleep(5000);
    }

}
