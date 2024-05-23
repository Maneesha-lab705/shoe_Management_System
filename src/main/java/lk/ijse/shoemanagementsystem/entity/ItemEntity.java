package lk.ijse.shoemanagementsystem.entity;

import jakarta.persistence.*;
import lk.ijse.shoemanagementsystem.enums.ItemGender;
import lk.ijse.shoemanagementsystem.enums.Ocation;
import lk.ijse.shoemanagementsystem.enums.Verities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    private String shoeCode;
    private String description;
    private ItemGender itemGender;
    private Ocation ocation;
    private Verities verities;

    @OneToMany(mappedBy = "itemEntity",cascade = CascadeType.ALL)
    private List<InventoryEntity> inventoryEntities;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<ReturnOrderEntity> returnOrders;


    public ItemEntity(String shoeCode) {
        this.setShoeCode(shoeCode);
    }

    public ItemEntity(String shoeCode, String description, ItemGender itemGender, Ocation ocation, Verities verities) {
        this.setShoeCode(shoeCode);
        this.setDescription(description);
        this.setItemGender(itemGender);
        this.setOcation(ocation);
        this.setVerities(verities);
    }
}
