package lk.ijse.shoemanagementsystem.dto;

import lk.ijse.shoemanagementsystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private String id;
    private String employeeId;
    private String name;
    private String email;
    private String password;
    private Role role;
}