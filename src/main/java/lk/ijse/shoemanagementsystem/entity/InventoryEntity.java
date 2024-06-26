package lk.ijse.shoemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    private String code;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shoeCode",nullable = false)
    private ItemEntity itemEntity;
    private String description;
    @Column(columnDefinition = "LONGTEXT")
    private String pic;
    private String category;
    private int size;
    private double unitPriceSale;
    private double unitPriceBuy;
    private double expectedProfit;
    private double profitMargin;
    private String status;
    private Integer qty;
    private LocalDate buyDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplierCode",nullable = false)
    private SupplierEntity supplierEntity;
    private String supplierName;



}
