package lk.ijse.shoemanagementsystem.dao;

import lk.ijse.shoemanagementsystem.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<CustomerEntity,String> {
//    String findMaxId();
}
