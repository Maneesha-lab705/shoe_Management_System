package lk.ijse.shoemanagementsystem.service;

import lk.ijse.shoemanagementsystem.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    void saveInventory(InventoryDTO inventoryDTO);

    void saveList(List<InventoryDTO> inventoryDTOList);
}
