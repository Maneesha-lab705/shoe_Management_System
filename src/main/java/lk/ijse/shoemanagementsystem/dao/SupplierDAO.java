package lk.ijse.shoemanagementsystem.dao;

import lk.ijse.shoemanagementsystem.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierDAO extends JpaRepository<SupplierEntity,String> {
    @Query("SELECT MAX(s.code) FROM SupplierEntity s")
    String findMaxId();
}
