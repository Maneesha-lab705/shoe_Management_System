package lk.ijse.shoemanagementsystem.dto;

import jakarta.persistence.*;
import lk.ijse.shoemanagementsystem.entity.InventoryEntity;
import lk.ijse.shoemanagementsystem.entity.ItemGender;
import lk.ijse.shoemanagementsystem.entity.Ocation;
import lk.ijse.shoemanagementsystem.entity.Verities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ItemDTO {
    private String shoeCode;
    private String description;
    private ItemGender itemGender;
    private Ocation ocation;
    private Verities verities;

}
