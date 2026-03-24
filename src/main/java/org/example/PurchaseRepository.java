package org.example;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseRepository extends org.springframework.data.repository.CrudRepository<Purchase, String> {

    @Query("select p from Purchase p where p.warehouse.warehouse_id = :warehouseId")
    List<Purchase> findAllByWarehouseId(@Param("warehouseId") String warehouseId);

}

