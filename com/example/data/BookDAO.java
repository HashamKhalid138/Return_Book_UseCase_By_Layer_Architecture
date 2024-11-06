package com.example.data;

import java.util.ArrayList;
import java.util.List;
class Book {
    private String bookId;
    private boolean available;

    public Book(String bookId, boolean available) {
        this.bookId = bookId;
        this.available = available;
    }

    public String getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

public class BookDAO implements IBookDAO {
    private List<Book> books = new ArrayList<>();

    public BookDAO() {
        books.add(new Book("B001", false)); // Book currently borrowed
        books.add(new Book("B002", true));  // Book available
    }

    @Override
    public boolean isBookAvailable(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book.isAvailable();
            }
        }
        return true;
    }

    @Override
    public void updateBookStatus(String bookId, boolean available) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                book.setAvailable(available);
                return;
            }
        }
        books.add(new Book(bookId, available));
    }
}
