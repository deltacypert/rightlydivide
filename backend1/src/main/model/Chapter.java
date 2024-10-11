package main.model;

public class Chapter {
    private String book;
    private int chapter;

    public Chapter(String book, int chapter) {
        this.book = book;
        this.chapter = chapter;
    }

    public String getBook() {
        return book;
    }

    public int getChapter() {
        return chapter;
    }

    public String toString() {
       return getBook() + " " + getChapter();
    }
}
