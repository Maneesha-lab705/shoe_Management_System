package lk.ijse.shoemanagementsystem.api;

import lk.ijse.shoemanagementsystem.dto.EmployeeDTO;
import lk.ijse.shoemanagementsystem.entity.Gender;
import lk.ijse.shoemanagementsystem.entity.Role;
import lk.ijse.shoemanagementsystem.service.EmployeeService;
import lk.ijse.shoemanagementsystem.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin(origins = "http://localhost:63342")
@RequiredArgsConstructor
public class EmployeeAPI {
    private final EmployeeService employeeService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveEmployee(@RequestPart("name") String name,
                                    @RequestPart("profilePic") String profilePic,
                                    @RequestPart("gender") String gender,
                                    @RequestPart("status") String status,
                                    @RequestPart("designation") String designation,
                                    @RequestPart("role") String role,
                                    @RequestPart("dob") String dob,
                                    @RequestPart("dateOfJoin") String dateOfJoin,
                                    @RequestPart("branchName") String branchName,
                                    @RequestPart("address") String address,
                                    @RequestPart("contact") String contact,
                                    @RequestPart("email") String email,
                                    @RequestPart("guardianName") String guardianName,
                                    @RequestPart("emergencyContact") String emergencyContact){

        System.out.println(contact);
                EmployeeDTO newEmployeeDTO =new EmployeeDTO();
        String base64ProPic = UtilMatters.convertBAse64(profilePic);


        System.out.println(name);
        newEmployeeDTO.setName(name);
        newEmployeeDTO.setProfilePic(base64ProPic);
        newEmployeeDTO.setGender(Gender.valueOf(gender));
        newEmployeeDTO.setStatus(status);
        newEmployeeDTO.setDesignation(designation);
        newEmployeeDTO.setRole(Role.valueOf(role));
        newEmployeeDTO.setDob(LocalDate.parse(dob));
        newEmployeeDTO.setDateOfJoin(LocalDate.parse(dateOfJoin));
        newEmployeeDTO.setBranchName(branchName);
        newEmployeeDTO.setAddress1(address);
        newEmployeeDTO.setContact(contact);
        newEmployeeDTO.setEmail(email);
        newEmployeeDTO.setGuardianName(guardianName);
        newEmployeeDTO.setEmContact(emergencyContact);

         employeeService.save(newEmployeeDTO);
    }
}
