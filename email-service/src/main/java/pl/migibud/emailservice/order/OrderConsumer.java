package pl.migibud.emailservice.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class OrderConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.email.name}")
    void consume(OrderEvent event){
        log.info("Order event received => {}",event);
    }

}
