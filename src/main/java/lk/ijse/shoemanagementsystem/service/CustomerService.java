package lk.ijse.shoemanagementsystem.service;

import lk.ijse.shoemanagementsystem.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO save(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomer();

    void updateCustomer(CustomerDTO customerDTO);

    void delate(String id);
}
