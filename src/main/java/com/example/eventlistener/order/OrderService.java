package com.example.eventlistener.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public void order(String name) {
        Order order = Order.builder()
                .username(name)
                .build();

        orderRepository.save(order);

        // publish event
        orderRepository.publishEvent(new OrderCreatedEvent(order.getUsername()));
        // throw new RuntimeException(); // 예외 던져보기, 트랜잭션 성공, 실패 시 이벤트 리스너 호출 순서 확인
    }
}
