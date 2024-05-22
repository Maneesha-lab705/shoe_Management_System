package lk.ijse.shoemanagementsystem.dao;

import lk.ijse.shoemanagementsystem.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDao extends JpaRepository<OrderEntity,String> {

    @Query("SELECT MAX(o.code) FROM OrderEntity o")
    String findMaxId();
}
