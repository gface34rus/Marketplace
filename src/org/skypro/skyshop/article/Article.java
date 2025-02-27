package org.skypro.skyshop.article;

import org.skypro.skyshop.interfaces.Searchable;

public final class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(final String title, final String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return title + "\n" + content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public void getStringRepresentation(Searchable searchable) {
        Searchable.super.getStringRepresentation(searchable);
    }

}
