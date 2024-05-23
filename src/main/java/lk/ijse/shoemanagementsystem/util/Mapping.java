package lk.ijse.shoemanagementsystem.util;

import lk.ijse.shoemanagementsystem.dto.*;
import lk.ijse.shoemanagementsystem.entity.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class Mapping {
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

    public List<InventoryDTO> getALlInventoryDetails(List<InventoryEntity> all) {
        return mapper.map(all, List.class);
    }


    public ItemDTO toItemDto(ItemEntity itemEntity){
        return mapper.map(itemEntity, ItemDTO.class);
    }

    public ItemEntity toItemEntity(ItemDTO itemDTO) {
        return mapper.map(itemDTO,ItemEntity.class);
    }

//    public List<ItemDTO> getAllItemList(List<ItemEntity> all) {
//        return mapper.map(all, List.class);
//    }
//OrderMapping

public OrderEntity toOrderEntity(OrderDTO orderDTO) {
    return mapper.map(orderDTO, OrderEntity.class);
}
    public OrderDTO toOrderDTO(OrderEntity orderEntity) {
        return  mapper.map(orderEntity, OrderDTO.class);
    }


    //OrderItemMapping
    public OrderDTO toOrderItemDTO(OrderEntity orderEntity) {
        return  mapper.map(orderEntity, OrderDTO.class);
    }
    public OrderItemEntity toOrderItem(OrderItemDTO orderItemDTO) {
        return  mapper.map(orderItemDTO, OrderItemEntity.class);
    }
    public List<OrderItemDTO> toOrderItemDTOList(List<OrderItemEntity> orderItemEntityList) {
        return mapper.map(orderItemEntityList, List.class);
    }

    //UserMapping
    public UserEntity toUserEntity(UserDTO userDTO) {
        return mapper.map(userDTO, UserEntity.class);
    }
    public UserDTO toUserDTO(UserEntity userEntity) {
        return  mapper.map(userEntity, UserDTO.class);
    }

//    public PlaceOrderEntity toPlaceorderEntity(PlaceOrderDTO placeOrderDTO) {
//        return mapper.map(placeOrderDTO,PlaceOrderEntity.class);
//    }
public List<UserDTO> toUserDTOList(List<UserEntity> userEntities) {
    return mapper.map(userEntities, List.class);
}

    public List<OrderItemDTO> getAllOrder(List<OrderItemEntity> all) {
        return mapper.map(all, List.class);
    }


}

