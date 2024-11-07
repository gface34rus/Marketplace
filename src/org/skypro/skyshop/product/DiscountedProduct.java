package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    int basicPrice;
    int percentDiscount;

    public DiscountedProduct(String name, int basicPrice, int percentDiscount) {
        super(name);
        this.basicPrice = basicPrice;
        this.percentDiscount = percentDiscount;

    }

    @Override
    public String toString() {
        return getName()+": "+basicPrice+"%"+percentDiscount;
    }

    @Override
    public int getPrice() {
        return basicPrice-((basicPrice/100)*percentDiscount);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
