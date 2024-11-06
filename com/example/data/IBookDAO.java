package com.example.data;

public interface IBookDAO {
    boolean isBookAvailable(String bookId);
    void updateBookStatus(String bookId, boolean available);
}
