package lk.ijse.shoemanagementsystem.service;


import lk.ijse.shoemanagementsystem.dto.OrderDTO;
import lk.ijse.shoemanagementsystem.dto.OrderItemDTO;

import java.util.List;

public interface OrderService {
    void purchaseOrder(OrderDTO orderDTO, List<OrderItemDTO> orderItemDTOS, String customerCode);

    String nextOrderId();

}
