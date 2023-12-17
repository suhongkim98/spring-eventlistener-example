package com.example.eventlistener.order;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderCustomRepository {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishEvent(OrderCreatedEvent orderCreatedEvent) {
        applicationEventPublisher.publishEvent(orderCreatedEvent);
    }
}
