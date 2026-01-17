package org.example.p10;

public class Book extends Medium {
    private String author;
    private String isbn;
    private int pages;

    public Book(String mediumID, String title, String author, String isbn, int pages) {
        super(mediumID, title);
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

    //Getter
    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPages() {
        return pages;
    }
}
