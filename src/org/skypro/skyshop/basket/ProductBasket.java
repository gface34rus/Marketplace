package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> products = new ArrayList<>();
    private int productCount = 0;

    public void addProduct(Product product) {
        products.add(product);
        productCount++;
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products.get(i).getPrice();
        }
        return total;
    }

    public void printContents() {
        int isSpecialCount = 0;
        if (productCount == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < productCount; i++) {
            System.out.println(products.get(i).getName() + ": " + products.get(i).getPrice());
        }
        for (Product product : products) {
            if (product.isSpecial()) {
                isSpecialCount++;
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + isSpecialCount);
    }

    public boolean containsProduct(String name) {
        for (int i = 0; i < productCount; i++) {
            if (products.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
        productCount = 0;
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }
}
