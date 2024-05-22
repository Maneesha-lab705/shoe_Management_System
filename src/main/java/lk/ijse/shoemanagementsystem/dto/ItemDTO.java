package lk.ijse.shoemanagementsystem.dto;

import lk.ijse.shoemanagementsystem.enums.ItemGender;
import lk.ijse.shoemanagementsystem.enums.Ocation;
import lk.ijse.shoemanagementsystem.enums.Verities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
