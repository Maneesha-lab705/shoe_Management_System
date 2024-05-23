package lk.ijse.shoemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminPanelDTO{
    private Double totalSales;
    private Double totalProfit;
    private String mostSaleItem;
    private String itemPic;
    private int saleItemQty;
}
