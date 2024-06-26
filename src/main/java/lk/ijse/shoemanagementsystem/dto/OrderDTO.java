package lk.ijse.shoemanagementsystem.dto;

import lk.ijse.shoemanagementsystem.enums.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO{
    private String code;
    private String customerName;
    private Double amount;
    private Double profit;
    private Date date;
    private Payment payment;
    private Integer point;
    private String userName;
}
