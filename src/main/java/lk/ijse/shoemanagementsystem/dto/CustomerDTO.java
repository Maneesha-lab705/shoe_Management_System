package lk.ijse.shoemanagementsystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.shoemanagementsystem.entity.Gender;
import lk.ijse.shoemanagementsystem.entity.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private String customer_code;
    private String customer_name;
    private Gender gender;
    private Date date;
    private Level level;
    private Integer total_points;
    private Date dob;
    private String address;
    private String contact;
    private String email;
    private Timestamp r_p_date;

}
