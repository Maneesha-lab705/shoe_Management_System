package lk.ijse.shoemanagementsystem.api;

import lk.ijse.shoemanagementsystem.dto.InventoryDTO;
import lk.ijse.shoemanagementsystem.entity.InventoryEntity;
import lk.ijse.shoemanagementsystem.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@CrossOrigin(origins = "http://localhost:63342")
@RequiredArgsConstructor
public class InventoryAPI {
    private final InventoryService inventoryService;
//    @PostMapping
//    public void saveInventory(@RequestBody InventoryDTO inventoryDTO){
//        inventoryService.saveInventory(inventoryDTO);
//    }

    @PostMapping
    public void saveInventoryList(@RequestBody List<InventoryDTO> inventoryDTOList){
        inventoryService.saveList(inventoryDTOList);
    }
}
