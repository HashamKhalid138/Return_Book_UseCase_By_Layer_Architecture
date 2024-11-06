// src/com/example/business/ReturnBookService.java
package com.example.business;

import com.example.data.BookDAO;
import com.example.data.UserDAO;
import com.example.data.IBookDAO;
import com.example.data.IUserDAO;

public class ReturnBookService implements IReturnBookService {
    private IBookDAO bookDAO;
    private IUserDAO userDAO;

    // Constructor to accept dependencies
    public ReturnBookService(IBookDAO bookDAO, IUserDAO userDAO) {
        this.bookDAO = bookDAO;
        this.userDAO = userDAO;
    }

    public String returnBook(String bookId, String userId, boolean isLate) {
        if (bookDAO.isBookAvailable(bookId)) {
            return "This book is already available in the library.";
        }

        bookDAO.updateBookStatus(bookId, true);

        if (isLate) {
            int fine = 50;
            int currentFine = userDAO.getUserFine(userId);
            userDAO.updateUserFine(userId, currentFine + fine);
            return "Book returned successfully with a late fine of $" + fine;
        }

        return "Book returned successfully without any fine.";
    }
}
