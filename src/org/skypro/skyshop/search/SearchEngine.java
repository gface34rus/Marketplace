package org.skypro.skyshop.search;

import org.skypro.skyshop.interfaces.Searchable;

import java.util.Arrays;

public class SearchEngine {
    public Searchable[] elements;

    public SearchEngine(int size) {
        elements = new Searchable[size];
    }

    public Searchable[] search(String s) {
        Searchable[] result = new Searchable[elements.length];
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].searchTerm().contains(s)) {
                result[i] = elements[i];
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public void add(Searchable searchable, int index) {
        elements[index] = searchable;
    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
