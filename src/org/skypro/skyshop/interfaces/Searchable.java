package org.skypro.skyshop.interfaces;

public interface Searchable {
    String searchTerm();

    String getType();

    default void getStringRepresentation(Searchable searchable) {
        System.out.println("Имя- " + searchable.searchTerm() + " Тип- " + searchable.getType());
    }
}
