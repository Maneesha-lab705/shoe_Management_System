package lk.ijse.shoemanagementsystem.conversion;

import lk.ijse.shoemanagementsystem.dto.CustomerDTO;
import lk.ijse.shoemanagementsystem.entity.CustomerEntity;
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
}

