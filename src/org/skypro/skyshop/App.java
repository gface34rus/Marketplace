package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFoundException;
import org.skypro.skyshop.interfaces.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.List;

public class App {
    public static void main(String[] args) {
        SimpleProduct p1 = new SimpleProduct("laptop", 1000);
        DiscountedProduct p2 = new DiscountedProduct("tv", 800, 10);
        FixPriceProduct p3 = new FixPriceProduct("PC");
        SimpleProduct p4 = new SimpleProduct("PS", 2000);
        SimpleProduct p5 = new SimpleProduct("xbox", 2000);
        SimpleProduct p6 = new SimpleProduct("car", 20000);
        ProductBasket pb = new ProductBasket();
        pb.addProduct(p1);
        pb.addProduct(p2);
        pb.addProduct(p3);
        pb.addProduct(p4);
        pb.addProduct(p5);
        pb.addProduct(p6);
        pb.printContents();
        pb.getTotalPrice();
        pb.containsProduct("tv");
        pb.containsProduct("beer");
        //  pb.clearBasket();
        pb.printContents();
        SearchEngine searchEngine = new SearchEngine(10);
        Article article1 = new Article("one", "content");
        Article article2 = new Article("two", "content_2");
        Article article3 = new Article("three", "content_3");
        searchEngine.add(p1, 0);
        searchEngine.add(p2, 1);
        searchEngine.add(p3, 2);
        searchEngine.add(p4, 3);
        searchEngine.add(p5, 4);
        searchEngine.add(article1, 5);
        searchEngine.add(article2, 6);
        searchEngine.add(article3, 7);
        System.out.println("asdasd" + searchEngine);

        List<Searchable> articles = List.of(
                new Article("Hello world", "Hello world"),
                new Article("Hello hello world", "Hello hello world"),
                new Article("Goodbye world", "Goodbye world")
        );

        SearchEngine searchEngine2 = new SearchEngine();


        // Сценарий 1: Нужный объект существует
        try {
            Searchable bestMatch = searchEngine2.findBestMatch("hello", articles);
            System.out.println("Лучшее совпадение: " + bestMatch.searchTerm());
        } catch (BestResultNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Сценарий 2: Нужный объект не существует
        try {
            Searchable bestMatch = searchEngine2.findBestMatch("nonexistent", articles);
            System.out.println("Лучшее совпадение: " + bestMatch.searchTerm());
        } catch (BestResultNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


    }
}