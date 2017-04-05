package by.epam.library.entity;

import by.epam.library.publicationtype.BookType;
import by.epam.library.publicationtype.PublicationType;

import java.math.BigDecimal;

public class Book extends Publication {
    private String author;
    private BookType bookType;

    public Book() {
    }

    public Book(String name, String publisher, BigDecimal price, int pages, String author, BookType bookType) {
        super(name, publisher, price, pages, PublicationType.BOOK);
        this.author = author;
        this.bookType = bookType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", authors = " + author +
                ", genre = " + bookType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        if (!super.equals(o)){
            return false;
        }

        Book book = (Book) o;

        if (getAuthor() != null ? !getAuthor().equals(book.getAuthor()) : book.getAuthor() != null){
            return false;
        }
        return getBookType() == book.getBookType();

    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = super.hashCode();
        result = prime * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = prime * result + (getBookType() != null ? getBookType().hashCode() : 0);
        return result;
    }
}
