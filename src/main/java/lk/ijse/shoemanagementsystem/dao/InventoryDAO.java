package lk.ijse.shoemanagementsystem.dao;

import lk.ijse.shoemanagementsystem.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryDAO extends JpaRepository<InventoryEntity,String> {
    @Query("SELECT i FROM InventoryEntity i WHERE i.itemEntity.shoeCode = :shoeCode AND i.size = :size")
    InventoryEntity findByShoeCodeAndSize(@Param("shoeCode") String shoeCode, @Param("size") int size);
}
