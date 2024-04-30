package lk.ijse.shoemanagementsystem.service;

import lk.ijse.shoemanagementsystem.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    void saveSupplier(SupplierDTO supplierDTO);

    void updateSupplier(SupplierDTO supplierDTO);

    void deleteSupplier(String code);

    List<SupplierDTO> getAllSupplier();

}
