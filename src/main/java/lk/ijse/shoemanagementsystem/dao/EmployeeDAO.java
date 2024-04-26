package lk.ijse.shoemanagementsystem.dao;

import lk.ijse.shoemanagementsystem.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeDAO extends JpaRepository<EmployeeEntity,String> {
    @Query("SELECT MAX(e.employee_code) FROM EmployeeEntity e")
    String findMaxId();

}
