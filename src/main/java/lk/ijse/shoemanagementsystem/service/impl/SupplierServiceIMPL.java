package lk.ijse.shoemanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.shoemanagementsystem.conversion.ConversionData;
import lk.ijse.shoemanagementsystem.dao.SupplierDAO;
import lk.ijse.shoemanagementsystem.dto.SupplierDTO;
import lk.ijse.shoemanagementsystem.entity.SupplierEntity;
import lk.ijse.shoemanagementsystem.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplierServiceIMPL implements SupplierService {
    private final SupplierDAO supplierDAO;
    private final ConversionData conversionData;

    @Override
    public void saveSupplier(SupplierDTO supplierDTO) {
        supplierDTO.setCode(getMaxId());
        conversionData.toSupplierDTO(supplierDAO.save(conversionData.toSupplierEntity(supplierDTO)));
    }

    @Override
    public void updateSupplier(SupplierDTO supplierDTO) {
        Optional<SupplierEntity> byId = supplierDAO.findById(supplierDTO.getCode());
        byId.get().setName(supplierDTO.getName());
        byId.get().setCategory(supplierDTO.getCategory());
        byId.get().setAddress1(supplierDTO.getAddress1());
        byId.get().setAddress2(supplierDTO.getAddress2());
        byId.get().setAddress3(supplierDTO.getAddress3());
        byId.get().setAddress4(supplierDTO.getAddress4());
        byId.get().setAddress5(supplierDTO.getAddress5());
        byId.get().setAddress6(supplierDTO.getAddress6());
        byId.get().setContact1(supplierDTO.getContact1());
        byId.get().setContact2(supplierDTO.getContact2());
        byId.get().setEmail(supplierDTO.getEmail());
    }

    @Override
    public void deleteSupplier(String code) {
        supplierDAO.deleteById(code);
    }

    @Override
    public List<SupplierDTO> getAllSupplier() {
        return conversionData.getAllSuppliers(supplierDAO.findAll());
    }

    private String getMaxId() {
        return generateNextOrderId(supplierDAO.findMaxId());
    }
    private static String generateNextOrderId(String lastOrderId) {
        String numericPart = lastOrderId.substring(1);
        int nextNumericValue = Integer.parseInt(numericPart) + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        return "S" + nextNumericPart;
    }
}
