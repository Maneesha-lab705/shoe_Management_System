package lk.ijse.shoemanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.shoemanagementsystem.conversion.ConversionData;
import lk.ijse.shoemanagementsystem.conversion.InventoryDAO;
import lk.ijse.shoemanagementsystem.dao.ItemDAO;
import lk.ijse.shoemanagementsystem.dao.SupplierDAO;
import lk.ijse.shoemanagementsystem.dto.InventoryDTO;
import lk.ijse.shoemanagementsystem.entity.InventoryEntity;
import lk.ijse.shoemanagementsystem.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional

public class InventoryServiceIMPL implements InventoryService {
    private final ConversionData conversionData;
    private final InventoryDAO inventoryDAO;
    private final SupplierDAO supplierDAO;
    private final ItemDAO itemDAO;


    @Override
    public void saveInventory(InventoryDTO inventoryDTO) {
        inventoryDTO.setCode(UUID.randomUUID().toString());
        InventoryEntity inventoryEntity = conversionData.toInventoryEntity(inventoryDTO);


    }
}
