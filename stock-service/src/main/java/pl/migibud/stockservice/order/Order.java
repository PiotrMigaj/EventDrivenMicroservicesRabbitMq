package pl.migibud.stockservice.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Order {
    private String id;
    private String name;
    private int qty;
    private double price;
}
