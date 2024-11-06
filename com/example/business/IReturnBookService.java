package com.example.business;

public interface IReturnBookService {
    String returnBook(String bookId, String userId, boolean isLate);
}
