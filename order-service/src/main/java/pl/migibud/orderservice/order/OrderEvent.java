package pl.migibud.orderservice.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class OrderEvent {
    private String status;
    private String message;
    private Order order;
}
