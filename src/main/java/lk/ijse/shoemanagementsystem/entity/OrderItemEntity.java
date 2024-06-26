package lk.ijse.shoemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderItem")
public class OrderItemEntity implements SuperEntity {
    @Id
    private String id;
    private String shoeCode;
    @ManyToOne
    @JoinColumn(name = "orderCode")
    private OrderEntity orderEntity;

    @ManyToOne
    private InventoryEntity inventoryEntity;

    private String description;
    private Integer size;
    private Double unitPrice;
    private Integer qty;
    private String pic;
}
