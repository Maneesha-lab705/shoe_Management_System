package lk.ijse.shoemanagementsystem.entity;

import jakarta.persistence.*;
import lk.ijse.shoemanagementsystem.enums.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity{
    @Id
    private String code;
    private String customerName;
    private Double amount;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Payment payment;
    private Integer point;
    private String userName;

    @ManyToOne
    private CustomerEntity customerEntity;
    @ManyToOne
    private UserEntity userEntity;
    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItemEntityList;
}
