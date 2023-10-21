package com.example.eventlistener.mailsender;

import com.example.eventlistener.order.OrderEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * 1. @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
 * default 값이며, 트랜잭션이 commit 되었을 때 이벤트를 실행합니다.
 *
 * 2. @TransactionalEventListener(phase = TransactionPhase.ROLLBACK)
 * 트랜잭션이 rollback 되었을 때 이벤트를 실행합니다.
 *
 * 3. @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
 * 트랜잭션이 completion(commit 또는 rollback) 되었을 때 이벤트 실행합니다.
 *
 * 4. @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
 * 트랜잭션이 commit 되기 전에 이벤트를 실행합니다.
 */

/**
 * mail sender event listener
 *
 */
@Component
public class MailSenderEventListener {

    @Async // 이벤트리스너 메서드를 비동기로 실행할 수 있다.
    @EventListener
    public void defaultEventListener(OrderEvent orderEvent) {
        System.out.println("MailSenderEventListener[default] 트랜잭션 성공 여부 상관 없이 메일을 보냅니다. : " + orderEvent);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void transactionalEventListenerBeforeCommit(OrderEvent event) {
        System.out.println("MailSenderEventListener TransactionPhase.BEFORE_COMMIT ---> " + event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void transactionalEventListenerAfterCommit(OrderEvent event) {
        System.out.println("MailSenderEventListener TransactionPhase.AFTER_COMMIT ---> " + event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void transactionalEventListenerAfterRollback(OrderEvent event) {
        System.out.println("MailSenderEventListener TransactionPhase.AFTER_ROLLBACK ---> " + event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void transactionalEventListenerAfterCompletion(OrderEvent event) {
        System.out.println("MailSenderEventListener TransactionPhase.AFTER_COMPLETION ---> " + event);
    }

    /**
     * 트랜잭션이 성공한 이후 이벤트 리스너에서 DB에 쓰기작업 등을 추가로 해야하는 경우
     * REQUIRES_NEW를 주어 새로운 트랜잭션에서 이벤트 리스너의 메서드가 실행되게 한다.
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void transactionalEventListenerAfterCommitRequiredNew(OrderEvent event) {
        System.out.println("MailSenderEventListener TransactionPhase.AFTER_COMMIT(REQUIRES_NEW) ---> " + event);
    }
}
