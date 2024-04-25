package lk.ijse.shoemanagementsystem.api;

import lk.ijse.shoemanagementsystem.dto.CustomerDTO;
import lk.ijse.shoemanagementsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin(origins = "http://localhost:63342")
@RequiredArgsConstructor
public class CustomerAPI {
    private final CustomerService customerService;

    @PostMapping
    public CustomerDTO save(@RequestBody CustomerDTO customerDTO){
        return customerService.save(customerDTO);
    }
    @GetMapping
    List<CustomerDTO> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @PatchMapping
    public void updateCustomer(@RequestBody CustomerDTO customerDTO){
            customerService.updateCustomer(customerDTO);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable("id")String id){
        System.out.println(id);
        customerService.delate(id);
    }
}
