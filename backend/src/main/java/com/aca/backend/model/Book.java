package com.aca.backend.model;

public class Book {
    private int bookId;
    private String bookName;
    private int chapterCount;
    private ReadingList readingList;
    private int bookOrder;

    public Book(int bookId, String bookName, int chapterCount, ReadingList readingList, int bookOrder) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.chapterCount = chapterCount;
        this.readingList = readingList;
        this.bookOrder = bookOrder;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(int chapterCount) {
        this.chapterCount = chapterCount;
    }

    public ReadingList getReadingList() {
        return readingList;
    }

    public void setReadingList(ReadingList readingList) {
        this.readingList = readingList;
    }

    public int getBookOrder() {
        return bookOrder;
    }

    public void setBookOrder(int bookOrder) {
        this.bookOrder = bookOrder;
    }
}
