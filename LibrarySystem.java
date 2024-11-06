
import com.example.presentation.LibraryUI;
import com.example.business.ReturnBookService;
import com.example.data.BookDAO;
import com.example.data.UserDAO;

import javax.swing.SwingUtilities;

public class LibrarySystem {
    public static void main(String[] args) {
        // Create concrete DAO implementations
        BookDAO bookDAO = new BookDAO();
        UserDAO userDAO = new UserDAO();

        // Create the service using composition with DAO implementations
        ReturnBookService returnBookService = new ReturnBookService(bookDAO, userDAO);

        // Run the UI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibraryUI(returnBookService).setVisible(true);
            }
        });
    }
}
