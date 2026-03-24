package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @PostMapping("/add")
    public String addWarehouse(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String postalCode,
            @RequestParam String city,
            @RequestParam String country,
            @RequestParam String timestamp
            ) {

        Warehouse w = new Warehouse();
        w.setWarehouse_id(id);
        w.setName(name);
        w.setAddress(address);
        w.setPostal_code(postalCode);
        w.setCountry(country);
        w.setCity(city);
        w.setTimestamp(timestamp);


        warehouseRepository.save(w);

        return "Warehouse saved";
    }

    @GetMapping("/all")
    public Iterable<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    @PutMapping("/update")
    public Iterable<Warehouse> updateWarehouse(@RequestParam String id) {
        Warehouse w = warehouseRepository
                .findById(id)
                .orElseThrow();

        w.setName("Updated Warehouse Name");
        warehouseRepository.save(w);

        return warehouseRepository.findAll();
    }

    @GetMapping("/{warehouseId}/data")
    public WarehouseData getWarehouseData(@PathVariable String warehouseId) {
        Warehouse w = warehouseRepository.findByWarehouseId(warehouseId).orElseThrow();
        List<Product> products = productRepository.findAllByWarehouseId(warehouseId);
        List<Purchase> purchases = purchaseRepository.findAllByWarehouseId(warehouseId);
        return new WarehouseData(w, products, purchases);
    }


    @GetMapping("/{warehouseId}/product/{productId}")
    public Product getProductInWarehouse(@PathVariable String warehouseId, @PathVariable String productId) {
        return productRepository.findByProductIdAndWarehouseId(productId, warehouseId).orElseThrow();
    }


    @PutMapping("/{warehouseId}")
    public Warehouse updateWarehouseById(@PathVariable String warehouseId, @RequestParam String name) {
        Warehouse w = warehouseRepository.findByWarehouseId(warehouseId).orElseThrow();
        w.setName(name);
        return warehouseRepository.save(w);
    }

}



