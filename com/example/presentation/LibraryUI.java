// src/com/example/presentation/LibraryUI.java
package com.example.presentation;

import com.example.business.ReturnBookService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryUI extends JFrame {
    private ReturnBookService returnBookService;

    // Constructor that accepts a ReturnBookService instance
    public LibraryUI(ReturnBookService returnBookService) {
        this.returnBookService = returnBookService;

        // Set up the JFrame
        setTitle("Library Return Book System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create UI components
        JLabel bookIdLabel = new JLabel("Enter Book ID:");
        JTextField bookIdField = new JTextField(15);

        JLabel userIdLabel = new JLabel("Enter User ID:");
        JTextField userIdField = new JTextField(15);

        JLabel lateLabel = new JLabel("Is the book returned late?");
        JCheckBox lateCheckBox = new JCheckBox("Yes");

        JButton returnButton = new JButton("Return Book");
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);

        // Set up the panel and layout
        JPanel panel = new JPanel();
        panel.add(bookIdLabel);
        panel.add(bookIdField);
        panel.add(userIdLabel);
        panel.add(userIdField);
        panel.add(lateLabel);
        panel.add(lateCheckBox);
        panel.add(returnButton);
        panel.add(new JScrollPane(resultArea));

        add(panel);

        // Add action listener for the button
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookId = bookIdField.getText();
                String userId = userIdField.getText();
                boolean isLate = lateCheckBox.isSelected();

                // Call the return book service and display the result
                String result = returnBookService.returnBook(bookId, userId, isLate);
                resultArea.setText(result);
            }
        });
    }
}
