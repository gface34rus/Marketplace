package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();
    private int productCount = 0;


    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
        productCount++;
    }

    public int getTotalPrice() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printContents() {
        int isSpecialCount = 0;
        if (productCount == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                System.out.println(product.getName() + ": " + product.getPrice());
                if (product.isSpecial()) {
                    isSpecialCount++;
                }
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + isSpecialCount);
    }

    public boolean containsProduct(String name) {
        return products.containsKey(name);
    }

    public void clearBasket() {
        products.clear();
        productCount = 0;
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = products.remove(name);
        if (removedProducts != null) {
            productCount -= removedProducts.size();
        }
        return removedProducts != null ? removedProducts : new ArrayList<>();
    }
}
