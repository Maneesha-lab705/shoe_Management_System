package lk.ijse.shoemanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.shoemanagementsystem.conversion.ConversionData;
import lk.ijse.shoemanagementsystem.dao.EmployeeDAO;
import lk.ijse.shoemanagementsystem.dto.EmployeeDTO;
import lk.ijse.shoemanagementsystem.entity.EmployeeEntity;
import lk.ijse.shoemanagementsystem.service.EmployeeService;
import lk.ijse.shoemanagementsystem.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return conversionData.getALlEmployeeLIst(employeeDAO.findAll());
    }

    @Override
    public void updatEmployee(EmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> byId = employeeDAO.findById(employeeDTO.getEmployee_code());
        byId.get().setName(employeeDTO.getName());
        byId.get().setProfilePic(employeeDTO.getProfilePic());
        byId.get().setGender(employeeDTO.getGender());
        byId.get().setStatus(employeeDTO.getName());
        byId.get().setDesignation(employeeDTO.getDesignation());
        byId.get().setRole(employeeDTO.getRole());
        byId.get().setDob(employeeDTO.getDob());
        byId.get().setDateOfJoin(employeeDTO.getDateOfJoin());
        byId.get().setBranchName(employeeDTO.getBranchName());
        byId.get().setAddress1(employeeDTO.getAddress1());
        byId.get().setContact(employeeDTO.getContact());
        byId.get().setEmail(employeeDTO.getEmail());
        byId.get().setGuardianName(employeeDTO.getGuardianName());
        byId.get().setEmContact(employeeDTO.getEmContact());
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
