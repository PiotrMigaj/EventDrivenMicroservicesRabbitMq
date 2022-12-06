package pl.migibud.orderservice.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Order {
    private String orderId;
    private String orderName;
    private int qty;
    private double price;
}
