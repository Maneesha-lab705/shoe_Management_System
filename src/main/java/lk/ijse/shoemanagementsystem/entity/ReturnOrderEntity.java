package lk.ijse.shoemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "returns")
public class ReturnOrderEntity {
    @Id
    private Long id;

    private String customerId;
    private int returnQuantity;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    public void setItem(String shoeCode) {
       item.setShoeCode(shoeCode);
    }
}
