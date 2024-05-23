package lk.ijse.shoemanagementsystem.api;

import lk.ijse.shoemanagementsystem.dto.InventoryDTO;
import lk.ijse.shoemanagementsystem.dto.OrderDTO;
import lk.ijse.shoemanagementsystem.dto.OrderItemDTO;
import lk.ijse.shoemanagementsystem.dto.OrderRequestDTO;
import lk.ijse.shoemanagementsystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class OrderApi {
    @Autowired
    private final OrderService orderService;

    @PostMapping
    public void purchaseOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        orderRequestDTO.getOrderDTO().setCode(orderService.nextOrderId());
        orderService.purchaseOrder(orderRequestDTO.getOrderDTO(),orderRequestDTO.getOrderItemDTOS(),orderRequestDTO.getCustomerCode());
    }



}
