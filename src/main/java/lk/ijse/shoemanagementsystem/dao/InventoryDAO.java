package lk.ijse.shoemanagementsystem.dao;

import lk.ijse.shoemanagementsystem.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryDAO extends JpaRepository<InventoryEntity,String> {
}
