package me.xueyao.publish;

import me.xueyao.event.SmsEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 事件发布
 * @author Simon.Xue
 * @date 2021/3/24 11:27 下午
 **/
@Component
public class SmsEventPublish {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 事件发布方法
     * @param message
     */
    public void publish(String message) {
        SmsEvent smsEvent = new SmsEvent(this, message);
        applicationEventPublisher.publishEvent(smsEvent);
    }
}
