package lk.ijse.shoemanagementsystem.entity;

import jakarta.persistence.*;
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

    public ItemEntity(String shoeCode) {
        this.setShoeCode(shoeCode);
    }
}
