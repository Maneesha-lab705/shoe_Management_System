package lk.ijse.shoemanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.shoemanagementsystem.enums.Gender;
import lk.ijse.shoemanagementsystem.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
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
