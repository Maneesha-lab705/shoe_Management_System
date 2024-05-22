package lk.ijse.shoemanagementsystem.dto;

import lk.ijse.shoemanagementsystem.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SupplierDTO {
    private String code;
    private String name;
    private Category category;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    private String address6;
    private String contact1;
    private String contact2;
    private String email;
}
