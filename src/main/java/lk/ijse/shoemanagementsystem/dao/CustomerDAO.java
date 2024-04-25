package lk.ijse.shoemanagementsystem.dao;

import lk.ijse.shoemanagementsystem.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDAO extends JpaRepository<CustomerEntity,String> {
    @Query("SELECT MAX(c.customer_code) FROM CustomerEntity c")
    String findMaxId();

//    String findMaxId();
}
