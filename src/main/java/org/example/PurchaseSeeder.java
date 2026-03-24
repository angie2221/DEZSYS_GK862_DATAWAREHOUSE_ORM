package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class PurchaseSeeder {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    private Random random = new Random();

    @PostConstruct
    public void seedPurchases() {

        List<Product> products = (List<Product>) productRepository.findAll();
        List<Warehouse> warehouses = (List<Warehouse>) warehouseRepository.findAll();

        String[] customerNames = {"Max", "Ana", "Lukas", "Emma", "Julia", "Leo", "Mia"};

        for (int i = 0; i < 300; i++) {
            Purchase purchase = new Purchase();

            // zufälliges Produkt und Warehouse
            Product product = products.get(random.nextInt(products.size()));
            Warehouse warehouse = warehouses.get(random.nextInt(warehouses.size()));

            purchase.setProduct(product);
            purchase.setWarehouse(warehouse);

            // zufälliger Kunde + Menge
            purchase.setCustomerName(customerNames[random.nextInt(customerNames.length)]);
            purchase.setAmount(random.nextInt(10) + 1); // 1–10

            purchaseRepository.save(purchase);
        }

        System.out.println("✅ 300 Purchase Records wurden erstellt!");
    }
}