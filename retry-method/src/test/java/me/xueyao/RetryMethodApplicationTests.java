package me.xueyao;

import me.xueyao.service.MyRetryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class RetryMethodApplicationTests {

    @Autowired
    private MyRetryService myRetryService;

    @Test
    public void testRetry() throws Exception {
        myRetryService.sendMessage();
    }

}
