package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private static final int FIX_PRICE = 1;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getName()+": Фиксированная цена - "+FIX_PRICE;
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
