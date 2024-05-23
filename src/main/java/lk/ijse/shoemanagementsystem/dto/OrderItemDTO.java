package lk.ijse.shoemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemDTO{
    private String id;
    private String orderCode;
    private String shoeCode;
    private String description;
    private Integer size;
    private Double unitPrice;
    private Integer qty;
    private String pic;
}
