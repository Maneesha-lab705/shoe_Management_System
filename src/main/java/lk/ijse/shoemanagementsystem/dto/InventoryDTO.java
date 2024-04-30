package lk.ijse.shoemanagementsystem.dto;

import jakarta.persistence.*;
import lk.ijse.shoemanagementsystem.entity.ItemEntity;
import lk.ijse.shoemanagementsystem.entity.SupplierEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryDTO {

    private String code;
    private String shoeCode;
    private String supplierCode;
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
    private String supplierName;
    private Integer qty;
    private LocalDate buyDate;





}
