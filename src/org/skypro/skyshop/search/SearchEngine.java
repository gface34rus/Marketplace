package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFoundException;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.Arrays;
import java.util.List;

public class SearchEngine {
    public Searchable[] elements;


    public SearchEngine() {
    }

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

    public Searchable findBestMatch(String search, List<Searchable> searchableItems) throws BestResultNotFoundException {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : searchableItems) {
            int count = countOccurrences(item.searchTerm(), search);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFoundException("Не найдено подходящее совпадение для запроса: " + search);
        }

        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }
}
