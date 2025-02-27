package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

public class SimpleProduct extends Product {
    public int getNormalPrice() {
        return normalPrice;
    }

    final private int normalPrice;

    public SimpleProduct(String name, int normalPrice) {
        super(name);
        if (normalPrice <= 0) {
            throw new IllegalArgumentException("Price cannot be less than or equal to zero");
        }
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

    @Override
    public String searchTerm() {
        return getName();
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }

    @Override
    public void getStringRepresentation(Searchable searchable) {
        super.getStringRepresentation(searchable);
    }

    @Override
    public String toString() {
        return "SimpleProduct{ name= " + getName() +
                " normalPrice=" + normalPrice +
                '}';
    }
}
