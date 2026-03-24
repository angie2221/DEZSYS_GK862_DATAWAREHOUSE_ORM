package org.example;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WarehouseRepository extends org.springframework.data.repository.CrudRepository<Warehouse, String> {

    @Query("select w from Warehouse w where w.warehouse_id = :warehouseId")
    Optional<Warehouse> findByWarehouseId(@Param("warehouseId") String warehouseId);

}
