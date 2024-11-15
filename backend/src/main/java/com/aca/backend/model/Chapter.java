package com.aca.backend.model;

public class Chapter {
    private int chapterId;
    private String bookName;
    private int chapterNumber;

    public Chapter (int chapterId, String bookName, int chapterNumber) {
        this.chapterId = chapterId;
        this.bookName = bookName;
        this.chapterNumber = chapterNumber;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    @Override
    public String toString() {
        return getBookName() + " " + getChapterNumber();
    }
}
