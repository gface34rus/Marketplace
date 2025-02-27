package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

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
        return "SimpleProduct{ name= " +getName()+
                " normalPrice=" + normalPrice +
                '}';
    }
}
