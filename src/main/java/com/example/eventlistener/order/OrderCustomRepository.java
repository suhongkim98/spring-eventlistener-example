package com.example.eventlistener.order;

public interface OrderCustomRepository {

    void publishEvent(OrderCreatedEvent orderCreatedEvent);
}
