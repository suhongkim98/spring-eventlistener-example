package com.example.eventlistener.order;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderCustomRepository {

    private final OrderEventPublisher orderEventPublisher;
    private final EntityManager entityManager;

    @Override
    public void saveAndPublishEvent(Order order) {
        entityManager.persist(order);
        orderEventPublisher.publishOrder(order.getUsername()); // 이벤트 발행
    }
}
