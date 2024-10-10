package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product p1 = new Product("laptop", 1000);
        Product p2 = new Product("tv", 800);
        Product p3 = new Product("PC", 1500);
        Product p4 = new Product("PS", 2000);
        Product p5 = new Product("xbox", 2000);
        Product p6 = new Product("car", 20000);
        ProductBasket pb = new ProductBasket();
        pb.addProduct(p1);
        pb.addProduct(p2);
        pb.addProduct(p3);
        pb.addProduct(p4);
        pb.addProduct(p5);
        pb.addProduct(p6);
        pb.printContents();
        pb.getTotalPrice();
        pb.containsProduct("tv");
        pb.containsProduct("beer");
        pb.clearBasket();
        pb.printContents();

    }
}