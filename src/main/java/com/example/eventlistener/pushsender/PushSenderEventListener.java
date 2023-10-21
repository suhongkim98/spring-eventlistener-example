package com.example.eventlistener.pushsender;

import com.example.eventlistener.order.OrderEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * push sender event listener
 */
@Component
public class PushSenderEventListener {

    @EventListener
    public void defaultEventListener(OrderEvent orderEvent) {
        System.out.println("PushSenderEventListener[default] 트랜잭션 성공 여부 상관 없이 푸쉬 알림을 보냅니다. : " + orderEvent);
    }
}
