package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @PostMapping("/add")
    public String addPurchase(
            @RequestParam String productId,
            @RequestParam String warehouseId,
            @RequestParam String customerName,
            @RequestParam int amount) {

        Product product = productRepository
                .findById(productId)
                .orElseThrow();

        Warehouse warehouse = warehouseRepository
                .findById(warehouseId)
                .orElseThrow();

        Purchase purchase = new Purchase();
        purchase.setProduct(product);
        purchase.setWarehouse(warehouse);
        purchase.setCustomerName(customerName);
        purchase.setAmount(amount);

        purchaseRepository.save(purchase);

        return "Purchase recorded";
    }

    @GetMapping("/all")
    public Iterable<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }
}