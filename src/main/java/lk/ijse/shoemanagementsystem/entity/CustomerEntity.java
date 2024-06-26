package lk.ijse.shoemanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.shoemanagementsystem.enums.Gender;
import lk.ijse.shoemanagementsystem.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customer")
public class CustomerEntity {
    @Id
    private String customer_code;
    private String customer_name;
    private Gender gender;
    private LocalDate date;
    private Level level;
    private Integer total_points;
    private LocalDate dob;
    private String address;
    private String contact;
    private String email;
    private Timestamp r_p_date;

}
