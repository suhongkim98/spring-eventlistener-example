# spring-eventlistener-example

## spring event 구성요소
* `event class`
  * event
* `event publisher`
  * 이벤트를 발생시켜주는 이벤트 퍼블리셔
* `event listener`
  * 이벤트를 처리해주는 이벤트 리스너
* `transaction event listener`
  * `Transaction`의 상태에 따라 발생하는 이벤트를 처리해 주는 이벤트 리스너

## flow
* 음식 주문 시 주문 이력을 데이터베이스에 저장하고 이벤트를 발행
* 주문 이벤트 발행 시 업주는 메일, 푸쉬 알림으로 주문 알림을 받음

