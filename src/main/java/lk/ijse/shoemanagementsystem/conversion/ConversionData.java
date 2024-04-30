package lk.ijse.shoemanagementsystem.conversion;

import lk.ijse.shoemanagementsystem.dto.CustomerDTO;
import lk.ijse.shoemanagementsystem.dto.EmployeeDTO;
import lk.ijse.shoemanagementsystem.dto.SupplierDTO;
import lk.ijse.shoemanagementsystem.entity.CustomerEntity;
import lk.ijse.shoemanagementsystem.entity.EmployeeEntity;
import lk.ijse.shoemanagementsystem.entity.SupplierEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ConversionData {
    private final ModelMapper mapper;

    public CustomerDTO toCustomerDTO(CustomerEntity customerEntity){
        return mapper.map(customerEntity, CustomerDTO.class);
    }

    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO) {
        return mapper.map(customerDTO,CustomerEntity.class);
    }

    public List<CustomerDTO> getAllCustomerList(List<CustomerEntity> all) {
        return mapper.map(all, List.class);
    }

    public EmployeeDTO toEmployeeDTO(EmployeeEntity employeeEntity){
        return mapper.map(employeeEntity, EmployeeDTO.class);
    }
    public EmployeeEntity toEmployeeEntity(EmployeeDTO employeeDTO){
        return mapper.map(employeeDTO, EmployeeEntity.class);
    }

    public List<EmployeeDTO> getALlEmployeeLIst(List<EmployeeEntity> all) {
        return mapper.map(all, List.class);
    }
    public SupplierDTO toSupplierDTO(SupplierEntity supplierEntity){
        return mapper.map(supplierEntity, SupplierDTO.class);
    }

    public SupplierEntity toSupplierEntity(SupplierDTO supplierDTO) {
        return mapper.map(supplierDTO,SupplierEntity.class);
    }

    public List<SupplierDTO> getAllSuppliers(List<SupplierEntity> all) {
        return mapper.map(all, List.class);
    }

}

