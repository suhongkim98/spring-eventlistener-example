package com.example.eventlistener.order;

public interface OrderCustomRepository {

    void saveAndPublishEvent(Order order);
}
