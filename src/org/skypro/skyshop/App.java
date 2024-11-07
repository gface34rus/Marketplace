package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct p1 = new SimpleProduct("laptop", 1000);
        SimpleProduct p2 = new SimpleProduct("tv", 800);
        SimpleProduct p3 = new SimpleProduct("PC", 1500);
        SimpleProduct p4 = new SimpleProduct("PS", 2000);
        SimpleProduct p5 = new SimpleProduct("xbox", 2000);
        SimpleProduct p6 = new SimpleProduct("car", 20000);
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