package org.example;

public class WarehouseData {
    private Warehouse warehouse;
    private Iterable<Product> products;
    private Iterable<Purchase> purchases;

    public WarehouseData(Warehouse warehouse, Iterable<Product> products, Iterable<Purchase> purchases) {
        this.warehouse = warehouse;
        this.products = products;
        this.purchases = purchases;
    }
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Iterable<Product> getProducts() {
        return products;
    }

    public void setProducts(Iterable<Product> products) {
        this.products = products;
    }

    public Iterable<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Iterable<Purchase> purchases) {
        this.purchases = purchases;
    }
}
