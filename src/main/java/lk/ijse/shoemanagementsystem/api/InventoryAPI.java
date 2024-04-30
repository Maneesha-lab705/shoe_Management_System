package lk.ijse.shoemanagementsystem.api;

import lk.ijse.shoemanagementsystem.dto.InventoryDTO;
import lk.ijse.shoemanagementsystem.entity.InventoryEntity;
import lk.ijse.shoemanagementsystem.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventory")
@CrossOrigin(origins = "http://localhost:63342")
@RequiredArgsConstructor
public class InventoryAPI {
    private final InventoryService inventoryService;
    @PostMapping
    public void saveInventory(InventoryDTO inventoryDTO){
        inventoryService.saveInventory(inventoryDTO);
    }
}
