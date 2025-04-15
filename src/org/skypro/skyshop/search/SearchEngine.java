package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFoundException;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    public Set<Searchable> elements;


    public SearchEngine() {
        this.elements = new HashSet<>(10);
    }

    public SearchEngine(int size) {
        this.elements = new HashSet<>(size);
    }


    public Set<Searchable> search(String s) {
        return elements.stream()
                .filter(item -> item.searchTerm().contains(s))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public void add(Searchable searchable) {
        elements.add(searchable);
    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "elements=" + elements +
                '}';
    }

    public Searchable findBestMatch(String search, Set<Searchable> searchableItems) throws BestResultNotFoundException {
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


    public Set<Searchable> findAllMatches(String search, Set<Searchable> searchableItems) {
        Set<Searchable> matches = new HashSet<>();
        for (Searchable item : searchableItems) {
            int count = countOccurrences(item.searchTerm(), search);
            if (count > 0) {
                matches.add(item);
            }
        }
        return matches;
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

    private static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            int lengthComparison = Integer.compare(o2.searchTerm().length(), o1.searchTerm().length());
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return o1.searchTerm().compareTo(o2.searchTerm());
        }
    }
}
