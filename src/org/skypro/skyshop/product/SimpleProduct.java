package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    public int getNormalPrice() {
        return normalPrice;
    }

    private int normalPrice;

    public SimpleProduct(String name, int normalPrice) {
        super(name);
        this.normalPrice = normalPrice;
    }

    @Override
    public int getPrice() {
        return normalPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
