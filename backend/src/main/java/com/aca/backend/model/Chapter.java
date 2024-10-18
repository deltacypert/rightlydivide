package com.aca.backend.model;

public class Chapter {
    private String book;
    private int chapterNumber;

    public Chapter(String book, int chapterNumber) {
        this.book = book;
        this.chapterNumber = chapterNumber;
    }

    public String getBook() {
        return book;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    @Override
    public String toString() {
        return getBook() + " " + getChapterNumber();
    }
}
