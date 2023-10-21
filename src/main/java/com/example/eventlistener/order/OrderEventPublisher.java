package com.example.eventlistener.order;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Order 이벤트 퍼블리셔
 */
@Component
@RequiredArgsConstructor
public class OrderEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher; // event publisher

    /**
     * 주문 이벤트를 방출한다.
     */
    public void publishOrder(String username) {
        OrderEvent orderEvent = new OrderEvent(username);
        applicationEventPublisher.publishEvent(orderEvent);
    }
}
