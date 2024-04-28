package lk.ijse.shoemanagementsystem.service;

import lk.ijse.shoemanagementsystem.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO save(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    void updatEmployee(EmployeeDTO employeeDTO);
}
