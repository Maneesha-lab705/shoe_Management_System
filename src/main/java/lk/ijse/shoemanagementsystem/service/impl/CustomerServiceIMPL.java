package lk.ijse.shoemanagementsystem.service.impl;

import lk.ijse.shoemanagementsystem.conversion.ConversionData;
import lk.ijse.shoemanagementsystem.dao.CustomerDAO;
import lk.ijse.shoemanagementsystem.dto.CustomerDTO;
import lk.ijse.shoemanagementsystem.service.CustomerService;
import lk.ijse.shoemanagementsystem.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService {
    private  final ConversionData conversionData;
    private final CustomerDAO customerDAO;
    private final UtilMatters utilMatters;
    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        customerDTO.setCustomer_code(UUID.randomUUID().toString());
        return conversionData.toCustomerDTO(customerDAO.save(conversionData.toCustomerEntity(customerDTO)));
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return conversionData.getAllCustomerList(customerDAO.findAll());
    }
}
