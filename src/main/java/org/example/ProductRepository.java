package org.example;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends org.springframework.data.repository.CrudRepository<Product, String> {

    // Find all products that belong to a warehouse with the given warehouse_id
    @Query("select p from Product p where p.warehouse.warehouse_id = :warehouseId")
    List<Product> findAllByWarehouseId(@Param("warehouseId") String warehouseId);

    // Find a single product by product id and its warehouse id
    @Query("select p from Product p where p.product_id = :productId and p.warehouse.warehouse_id = :warehouseId")
    Optional<Product> findByProductIdAndWarehouseId(@Param("productId") String productId, @Param("warehouseId") String warehouseId);

}