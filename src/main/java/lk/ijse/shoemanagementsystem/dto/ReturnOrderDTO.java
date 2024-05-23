package lk.ijse.shoemanagementsystem.dto;

import jakarta.persistence.*;
import lk.ijse.shoemanagementsystem.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReturnOrderDTO {
    private Long id;
    private String customerId;
    private int returnQuantity;
    private String reason;
    private ItemEntity item;
}
