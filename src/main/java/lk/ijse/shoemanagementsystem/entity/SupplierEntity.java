package lk.ijse.shoemanagementsystem.entity;

import jakarta.persistence.*;
import lk.ijse.shoemanagementsystem.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier")
public class SupplierEntity {
    @Id
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

    @OneToMany(mappedBy = "supplierEntity",cascade = CascadeType.ALL)
    private List<InventoryEntity> inventoryEntities;

    public SupplierEntity(String supplierCode) {
        this.setCode(supplierCode);
    }

    public SupplierEntity(String supplierCode, String name, Category category, String address1, String address2, String address3, String address4, String address5, String address6, String contact1, String contact2, String email) {
        this.setCode(supplierCode);
        this.setName(name);
        this.setCategory(category);
        this.setAddress1(address1);
        this.setAddress2(address2);
        this.setAddress3(address3);
        this.setAddress4(address4);
        this.setAddress5(address5);
        this.setAddress6(address6);
        this.setContact1(contact1);
        this.setContact2(contact2);
        this.setEmail(email);
    }
}
