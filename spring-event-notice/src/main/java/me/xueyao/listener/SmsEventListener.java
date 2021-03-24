package me.xueyao.listener;

import lombok.extern.slf4j.Slf4j;
import me.xueyao.event.SmsEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 注册一个事件监听器
 * @author Simon.Xue
 * @date 2021/3/24 11:22 下午
 **/
@Slf4j
@Component
public class SmsEventListener implements ApplicationListener<SmsEvent> {
    @Override
    public void onApplicationEvent(SmsEvent smsEvent) {
        log.info("发送短信的内容是 = {}", smsEvent.getMessage());
    }
}
