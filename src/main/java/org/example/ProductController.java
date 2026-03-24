package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @PostMapping("/add")
    public String addProduct(
            @RequestParam String productID,
            @RequestParam String name,
            @RequestParam String category,
            @RequestParam int quantity,
            @RequestParam String unit,
            @RequestParam String warehouseID) {

        Warehouse warehouse = warehouseRepository
                .findById(warehouseID)
                .orElseThrow();

        Product p = new Product();
        p.setProduct_id(productID);
        p.setName(name);
        p.setProductCategory(category);
        p.setProductQuantity(quantity);
        p.setProductUnit(unit);
        p.setWarehouse(warehouse);

        productRepository.save(p);

        return "Product saved";
    }

    @GetMapping("/all")
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}