package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

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
