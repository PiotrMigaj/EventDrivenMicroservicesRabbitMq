package pl.migibud.orderservice.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping
    ResponseEntity<String> placeOrder(@RequestBody Order order){

        order.setId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent(
                "PENDING",
                "Order is in pending status",
                order
        );
        orderProducer.sendMessage(orderEvent);
        return ResponseEntity.ok("Order sent to the RabbitMq...");
    }
}
