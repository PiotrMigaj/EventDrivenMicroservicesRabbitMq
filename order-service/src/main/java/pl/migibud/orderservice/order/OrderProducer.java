package pl.migibud.orderservice.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class OrderProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.binding.routing.key}")
    private String orderRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    void sendMessage(OrderEvent orderEvent){
        log.info(String.format("Order event sent to RabbitMq => %s",orderEvent));
        rabbitTemplate.convertAndSend(exchange,orderRoutingKey,orderEvent);
    }

}
