package me.xueyao.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 定义短信事件
 * @author Simon.Xue
 * @date 2021/3/24 11:23 下午
 **/
@Getter
public class SmsEvent extends ApplicationEvent {
    private String message;

    public SmsEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

}
