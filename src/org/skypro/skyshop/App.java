package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFoundException;
import org.skypro.skyshop.interfaces.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        SimpleProduct p1 = new SimpleProduct("laptop", 1000);
        DiscountedProduct p2 = new DiscountedProduct("tv", 800, 10);
        FixPriceProduct p3 = new FixPriceProduct("PC");
        SimpleProduct p4 = new SimpleProduct("PS", 2000);
        SimpleProduct p5 = new SimpleProduct("xbox", 2000);
        SimpleProduct p6 = new SimpleProduct("car", 20000);
        ProductBasket pb = new ProductBasket();

        // Изменяем вызов метода addProduct, добавляя категорию
        pb.addProduct("Electronics", p1);
        pb.addProduct("Electronics", p2);
        pb.addProduct("Computers", p3);
        pb.addProduct("Gaming", p4);
        pb.addProduct("Gaming", p5);
        pb.addProduct("Vehicles", p6);

        pb.printBasket(); // Изменяем на printBasket
        System.out.println("Total Price: " + pb.getTotalPrice()); // Выводим общую стоимость
        // Убедитесь, что метод containsProduct существует
        pb.containsProduct("tv");
        pb.containsProduct("beer");
        pb.clearBasket(); // Если метод clearBasket существует
        pb.printBasket(); // Изменяем на printBasket

        SearchEngine searchEngine = new SearchEngine();
        Article article1 = new Article("one", "content");
        Article article2 = new Article("two", "content_2");
        Article article3 = new Article("three", "content_3");
        searchEngine.add(p1);
        searchEngine.add(p2);
        searchEngine.add(p3);
        searchEngine.add(p4);
        searchEngine.add(p5);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        System.out.println("Search Engine: " + searchEngine);

        Set<Searchable> articles = Set.of(
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

        // Убедитесь, что метод removeProductsByName существует
        List<Product> removed = pb.removeProductsByName("");
        System.out.println(removed);
    }
}