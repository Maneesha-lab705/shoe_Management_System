package lk.ijse.shoemanagementsystem.api;

import lk.ijse.shoemanagementsystem.dto.SupplierDTO;
import lk.ijse.shoemanagementsystem.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/supplier")
@CrossOrigin(origins = "http://localhost:63342")
@RequiredArgsConstructor
public class SupplierAPI {
    private final SupplierService supplierService;
    @PostMapping
    public void saveSupplier(@RequestBody SupplierDTO supplierDTO){
        System.out.println(supplierDTO.getName());
        supplierService.saveSupplier(supplierDTO);
    }
    @PutMapping
    public void updateSupplier(@RequestBody SupplierDTO supplierDTO) {
        supplierService.updateSupplier(supplierDTO);
    }
    @DeleteMapping("/{code}")
    public void deleteSupplier(@PathVariable("code")String code){
        supplierService.deleteSupplier(code);
    }
    @GetMapping
    public List<SupplierDTO> getAllSuppliers(){
        return supplierService.getAllSupplier();
    }
}
