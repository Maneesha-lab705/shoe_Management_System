package lk.ijse.shoemanagementsystem.reqAndresp.secure;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SignUp {
    private String employeeId;
    private String name;
    private String email;
    private String password;
    private String role;
}
