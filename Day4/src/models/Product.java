package models;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Product {
    int id;
    String name;
    double price;
    String category;
    boolean inStock;

    Product(int id, String name, double price, String category, boolean inStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.inStock = inStock;
    }

    static Product[] getInStockProducts(Product[] products) {
        return Arrays.stream(products).filter(product -> product.inStock).toArray(Product[]::new);
    }

    static String[] getProductNames(Product[] products) {
        return Arrays.stream(products).map(product -> product.name).toArray(String[]::new);
    }

    static Product findProductsById(Product[] products, int id) {
        return Arrays.stream(products).filter(product -> product.id == id).findFirst().orElse(null);
    }

    static double getTotalCatalogValue(Product[] products) {
        return Arrays.stream(products).map(product -> product.price).reduce(0.0, (acc, price) -> acc + price);
    }

    static Map<String, List<Product>> groupByCategory(Product[] products) {
        return Arrays.stream(products).collect((Collectors.groupingBy(product -> product.category)));
    }

    static String formatProduct(String name, double price, boolean inStock) {
        String inStockMessage = inStock ? "In Stock" : "Not In Stock";
        return String.format("%s - NGN %.2f (%s)", name, price, inStockMessage);
    }

    @Override
    public String toString() {
        return name;
    }
}
