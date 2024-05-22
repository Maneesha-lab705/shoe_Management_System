package lk.ijse.shoemanagementsystem.service;

import lk.ijse.shoemanagementsystem.dto.InventoryDTO;
import lk.ijse.shoemanagementsystem.entity.InventoryEntity;

import java.util.List;

public interface InventoryService {
    void saveInventory(InventoryDTO inventoryDTO);

    void saveList(List<InventoryDTO> inventoryDTOList);

    List<InventoryDTO> getAll();

    InventoryDTO getAllSizeQty(String shoeCode, Integer size);
}

