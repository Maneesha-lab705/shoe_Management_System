package lk.ijse.shoemanagementsystem.dao;

import jakarta.transaction.Transactional;
import lk.ijse.shoemanagementsystem.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryDAO extends JpaRepository<InventoryEntity,String> {
    @Query("SELECT i FROM InventoryEntity i WHERE i.itemEntity.shoeCode = :shoeCode AND i.size = :size")
    InventoryEntity findByShoeCodeAndSize(@Param("shoeCode") String shoeCode, @Param("size") int size);

    @Modifying
    @Transactional
    @Query("UPDATE InventoryEntity i SET i.qty = :qty WHERE i.itemEntity.shoeCode = :shoeCode AND i.size = :size")
    void updateQtyByShoeCodeAndSize(String shoeCode, int size, int qty);
}
