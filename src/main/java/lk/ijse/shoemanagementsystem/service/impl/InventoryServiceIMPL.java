package lk.ijse.shoemanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.shoemanagementsystem.conversion.ConversionData;
import lk.ijse.shoemanagementsystem.dao.InventoryDAO;
import lk.ijse.shoemanagementsystem.dao.ItemDAO;
import lk.ijse.shoemanagementsystem.dao.SupplierDAO;
import lk.ijse.shoemanagementsystem.dto.InventoryDTO;
import lk.ijse.shoemanagementsystem.dto.ItemDTO;
import lk.ijse.shoemanagementsystem.entity.InventoryEntity;
import lk.ijse.shoemanagementsystem.entity.ItemEntity;
import lk.ijse.shoemanagementsystem.entity.SupplierEntity;
import lk.ijse.shoemanagementsystem.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        InventoryEntity inventory = conversionData.toInventoryEntity(inventoryDTO);
        inventory.setItemEntity(new ItemEntity(inventoryDTO.getShoeCode()));
        inventory.setSupplierEntity(new SupplierEntity(inventoryDTO.getSupplierCode()));
        System.out.println(inventory);
        inventoryDAO.save(inventory);


    }

    @Override
    public void saveList(List<InventoryDTO> inventoryDTOList) {
        List<InventoryEntity> inventoryEntityList = new ArrayList<>();

        for (InventoryDTO inventoryDTO : inventoryDTOList) {
            // Generate a unique code for the inventory item (if necessary)
            String inventoryCode = UUID.randomUUID().toString();

            // Create an instance of InventoryEntity and set its properties

            InventoryEntity inventoryEntity = conversionData.toInventoryEntity(inventoryDTO);
            inventoryEntity.setCode(inventoryCode);
            inventoryEntity.setBuyDate(LocalDate.now());

            // Create an instance of ItemEntity and set its properties
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setShoeCode(inventoryDTO.getShoeCode());

            // Create an instance of SupplierEntity and set its properties
            SupplierEntity supplierEntity = new SupplierEntity();
            supplierEntity.setCode(inventoryDTO.getSupplierCode());

            // Set the relationships between entities
            inventoryEntity.setItemEntity(itemEntity);
            inventoryEntity.setSupplierEntity(supplierEntity);

            // Add the inventory entity to the list
            inventoryEntityList.add(inventoryEntity);
        }

        // Save the list of inventory entities
        inventoryDAO.saveAll(inventoryEntityList);
    }
}
