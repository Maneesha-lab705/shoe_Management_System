package lk.ijse.shoemanagementsystem.conversion;

import lk.ijse.shoemanagementsystem.dto.*;
import lk.ijse.shoemanagementsystem.entity.*;
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


    public InventoryDTO toInventoryDto(InventoryEntity inventoryEntity){
        return mapper.map(inventoryEntity,InventoryDTO.class);
    }
    public InventoryEntity toInventoryEntity(InventoryDTO inventoryDTO){
        return mapper.map(inventoryDTO, InventoryEntity.class);
    }

    public ItemDTO toItemDto(ItemEntity itemEntity){
        return mapper.map(itemEntity, ItemDTO.class);
    }

    public ItemEntity toItemEntity(ItemDTO itemDTO) {
        return mapper.map(itemDTO,ItemEntity.class);
    }

    public List<ItemDTO> getAllItemList(List<ItemEntity> all) {
        return mapper.map(all, List.class);
    }


    //UserMapping
    public UserEntity toUserEntity(UserDTO userDTO) {
        return mapper.map(userDTO, UserEntity.class);
    }
    public UserDTO toUserDTO(UserEntity userEntity) {
        return  mapper.map(userEntity, UserDTO.class);
    }
}

