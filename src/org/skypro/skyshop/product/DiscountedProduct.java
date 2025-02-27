package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

public class DiscountedProduct extends Product {
    int basicPrice;
    int percentDiscount;

    public DiscountedProduct(String name, int basicPrice, int percentDiscount) {
        super(name);
        if (basicPrice <= 0) throw new IllegalArgumentException("Price cannot be less than or equal to zero");
        if (percentDiscount < 0 || percentDiscount > 100)
            throw new IllegalArgumentException("Discount percentage cannot be less than zero or more than 100");
        this.basicPrice = basicPrice;
        this.percentDiscount = percentDiscount;

    }

    @Override
    public String toString() {
        return getName() + ": " + basicPrice + "%" + percentDiscount;
    }

    @Override
    public int getPrice() {
        return basicPrice - ((basicPrice / 100) * percentDiscount);
    }

    @Override
    public boolean isSpecial() {
        return true;
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
}
