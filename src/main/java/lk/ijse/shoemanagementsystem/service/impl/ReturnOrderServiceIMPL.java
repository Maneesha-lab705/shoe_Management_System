package lk.ijse.shoemanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.shoemanagementsystem.dao.InventoryDAO;
import lk.ijse.shoemanagementsystem.dao.ItemDAO;
import lk.ijse.shoemanagementsystem.dao.ReturnOrderDAO;
import lk.ijse.shoemanagementsystem.dao.SupplierDAO;
import lk.ijse.shoemanagementsystem.dto.ReturnOrderDTO;
import lk.ijse.shoemanagementsystem.entity.InventoryEntity;
import lk.ijse.shoemanagementsystem.entity.ItemEntity;
import lk.ijse.shoemanagementsystem.entity.ReturnOrderEntity;
import lk.ijse.shoemanagementsystem.service.ReturnOrderServic;
import lk.ijse.shoemanagementsystem.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ReturnOrderServiceIMPL implements ReturnOrderServic {

    @Autowired
    private final Mapping mapping;
    @Autowired
    private final ItemDAO itemDAO;
    @Autowired
    private final InventoryDAO inventoryDAO;
    @Autowired
    private final ReturnOrderDAO returnOrderDAO;
    @Override
    public void saveReturns(ReturnOrderDTO returnOrderDTO) {

        System.out.println("hello");
        returnOrderDTO.setId(Long.valueOf(UUID.randomUUID().toString()));
        InventoryEntity item =inventoryDAO.findById(returnOrderDTO.getItem().getShoeCode()).orElseThrow(() -> new RuntimeException("Item not found"));
       int updatedQuantity= item.getQty();
        System.out.println(item);

        int returnQuantity = returnOrderDTO.getReturnQuantity();

        if (returnQuantity > updatedQuantity) {
            System.out.println("Error: Return quantity exceeds available quantity.");
        } else {
            // Create return order entry
            ReturnOrderEntity returnOrder = new ReturnOrderEntity();
            returnOrder.setCustomerId(returnOrderDTO.getCustomerId());
            returnOrder.setItem(returnOrderDTO.getItem().getShoeCode());
            returnOrder.setReturnQuantity(returnQuantity);
            returnOrder.setReason(returnOrderDTO.getReason());
            returnOrderDAO.save(returnOrder);

            // Update item quantity in the database (optional)
            item.setQty(updatedQuantity - returnQuantity);
            inventoryDAO.save(item);
        }
    }
}
