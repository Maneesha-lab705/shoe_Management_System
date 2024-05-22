package lk.ijse.shoemanagementsystem.dao;

import lk.ijse.shoemanagementsystem.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemDao extends JpaRepository<OrderItemEntity,String> {

    @Query("SELECT MAX(oi.id) FROM OrderItemEntity oi")
    String findMaxId();
}
