package lk.ijse.shoemanagementsystem.dto;

import lk.ijse.shoemanagementsystem.entity.Gender;
import lk.ijse.shoemanagementsystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String employee_code;
    private String name;
    private String profilePic;
    private Gender gender;
    private String status;
    private String designation ;
    private Role role;
    private LocalDate dob;
    private LocalDate dateOfJoin;
    private String branchName;
    private String address1;
    //    private String address2;
//    private String address3;
//    private String address4;
//    private String address5;
    private String contact;
    private String email;
    private String guardianName;
    private String emContact;
}
