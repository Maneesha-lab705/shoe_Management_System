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
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional

public class InventoryServiceIMPL implements InventoryService {
    private final ConversionData conversionData;
    private final InventoryDAO inventoryDAO;
    private final SupplierDAO supplierDAO;
    private final ItemDAO itemDAO;


//    @Override
//    public void saveInventory(InventoryDTO inventoryDTO) {
//        inventoryDTO.setCode(UUID.randomUUID().toString());
//        InventoryEntity inventory = conversionData.toInventoryEntity(inventoryDTO);
//        inventory.setItemEntity(new ItemEntity(inventoryDTO.getShoeCode()));
//        inventory.setSupplierEntity(new SupplierEntity(inventoryDTO.getSupplierCode()));
//        System.out.println(inventory);
//        inventoryDAO.save(inventory);
//
//
//    }

    @Override
    public void saveInventory(InventoryDTO inventoryDTO) {

    }

    @Override
    public void saveList(List<InventoryDTO> inventoryDTOList) {
        List<InventoryEntity> inventoryEntityList = new ArrayList<>();

        for (InventoryDTO inventoryDTO : inventoryDTOList) {
            // Generate a unique code for the inventory item (if necessary)
            String inventoryCode = UUID.randomUUID().toString();
            InventoryEntity inventory = conversionData.toInventoryEntity(inventoryDTO);
            Optional<ItemEntity> byId = itemDAO.findById(inventoryDTO.getShoeCode());
            ItemEntity itemEntity = new ItemEntity(inventoryDTO.getShoeCode(), byId.get().getDescription(), byId.get().getItemGender(), byId.get().getOcation(), byId.get().getVerities());
            inventory.setItemEntity(itemEntity);
            Optional<SupplierEntity> byId1 = supplierDAO.findById(inventoryDTO.getSupplierCode());
            SupplierEntity supplierEntity = new SupplierEntity(inventoryDTO.getSupplierCode(), byId1.get().getName(), byId1.get().getCategory(), byId1.get().getAddress1(),byId1.get().getAddress2(),byId1.get().getAddress3(),byId1.get().getAddress4(),byId1.get().getAddress5(),byId1.get().getAddress6(),byId1.get().getContact1(), byId1.get().getContact2(), byId1.get().getEmail());
            inventory.setSupplierEntity(supplierEntity);
            saveInventory(inventory);
        }

    }

    private void saveInventory(InventoryEntity inventory) {
        InventoryEntity byShoeCodeAndSize = inventoryDAO.findByShoeCodeAndSize(inventory.getItemEntity().getShoeCode(), inventory.getSize());
        if (byShoeCodeAndSize != null){
            updateInventory(byShoeCodeAndSize.getCode(),inventory);
            return;
        }
        inventoryDAO.save(inventory);
    }

    private void updateInventory(String code, InventoryEntity inventory) {
        Optional<InventoryEntity> byId = inventoryDAO.findById(code);
        Integer qty = byId.get().getQty();
        Integer newQty = qty + inventory.getQty();
        byId.get().setQty(newQty);
    }
}
