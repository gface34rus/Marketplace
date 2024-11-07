package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct p1 = new SimpleProduct("laptop", 1000);
        DiscountedProduct p2 = new DiscountedProduct("tv", 800,10);
        FixPriceProduct p3 = new FixPriceProduct("PC");
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
       // pb.clearBasket();
        pb.printContents();

    }
}