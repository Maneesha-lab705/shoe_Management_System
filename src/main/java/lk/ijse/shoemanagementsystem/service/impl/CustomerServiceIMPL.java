package lk.ijse.shoemanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.shoemanagementsystem.util.Mapping;
import lk.ijse.shoemanagementsystem.dao.CustomerDAO;
import lk.ijse.shoemanagementsystem.dto.CustomerDTO;
import lk.ijse.shoemanagementsystem.entity.CustomerEntity;
import lk.ijse.shoemanagementsystem.exectiopn.NotFoundException;
import lk.ijse.shoemanagementsystem.service.CustomerService;
import lk.ijse.shoemanagementsystem.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceIMPL implements CustomerService {
    private  final Mapping conversionData;
    private final CustomerDAO customerDAO;
    private final UtilMatters utilMatters;
    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        customerDTO.setCustomer_code(getMaxId());
        System.out.println(getMaxId());
        return conversionData.toCustomerDTO(customerDAO.save(conversionData.toCustomerEntity(customerDTO)));
    }
    private String getMaxId() {
        return generateNextOrderId(customerDAO.findMaxId());
    }
    private static String generateNextOrderId(String lastOrderId) {
        String numericPart = lastOrderId.substring(1);
        int nextNumericValue = Integer.parseInt(numericPart) + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        return "C" + nextNumericPart;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return conversionData.getAllCustomerList(customerDAO.findAll());
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmpCustomer = customerDAO.findById(customerDTO.getCustomer_code());
        if (!tmpCustomer.isPresent())throw new NotFoundException("CUSTOMER NOT FOUND");
        tmpCustomer.get().setCustomer_name(customerDTO.getCustomer_name());
        tmpCustomer.get().setGender(customerDTO.getGender());
        tmpCustomer.get().setDate(customerDTO.getDate());
        tmpCustomer.get().setLevel(customerDTO.getLevel());
        tmpCustomer.get().setTotal_points(customerDTO.getTotal_points());
        tmpCustomer.get().setDob(customerDTO.getDob());
        tmpCustomer.get().setAddress(customerDTO.getAddress());
        tmpCustomer.get().setContact(customerDTO.getContact());
        tmpCustomer.get().setEmail(customerDTO.getEmail());
        tmpCustomer.get().setR_p_date(customerDTO.getR_p_date());

    }

    @Override
    public void delate(String id) {
        customerDAO.deleteById(id);
    }

}
