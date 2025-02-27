package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFoundException;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchEngine {
    public List<Searchable> elements;


    public SearchEngine() {
    }

    public SearchEngine(int size) {
        elements = List.of(new Searchable[size]);
    }

    public List<Searchable> search(String s) {
        List<Searchable> result = new ArrayList<>(elements.size());
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).searchTerm().contains(s)) {
                result.set(i, elements.get(i));
            }
        }
        System.out.println(result);
        return result;
    }

    public void add(Searchable searchable, int index) {
        elements.set(index, searchable);
    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "elements=" + Arrays.toString(new List[]{elements}) +
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


    public List<Searchable> findAllMatches(String search, List<Searchable> searchableItems) {
        List<Searchable> matches = new ArrayList<>();
        for (Searchable item : searchableItems) {
            int count = countOccurrences(item.searchTerm(), search);
            if (count > 0) {
                matches.add(item); // Добавляем все подходящие элементы
            }
        }

        return matches; // Возвращаем список всех подходящих результатов
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
