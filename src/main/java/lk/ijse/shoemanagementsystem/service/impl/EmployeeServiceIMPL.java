package lk.ijse.shoemanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.shoemanagementsystem.conversion.ConversionData;
import lk.ijse.shoemanagementsystem.dao.EmployeeDAO;
import lk.ijse.shoemanagementsystem.dto.EmployeeDTO;
import lk.ijse.shoemanagementsystem.service.EmployeeService;
import lk.ijse.shoemanagementsystem.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceIMPL implements EmployeeService {
    private final EmployeeDAO employeeDAO;
    private final ConversionData conversionData;
    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        employeeDTO.setEmployee_code(getMaxId());
        return conversionData.toEmployeeDTO(employeeDAO.save(conversionData.toEmployeeEntity(employeeDTO)));
    }
    private String getMaxId() {
        return generateNextOrderId(employeeDAO.findMaxId());
    }
    private static String generateNextOrderId(String lastOrderId) {
        String numericPart = lastOrderId.substring(1);
        int nextNumericValue = Integer.parseInt(numericPart) + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        return "E" + nextNumericPart;
    }
}
