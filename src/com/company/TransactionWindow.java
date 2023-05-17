package com.company;
import java.awt.Font;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TransactionWindow {
    JFrame frame = new JFrame();
    JLabel transactionNameLabel = new JLabel("Transaction Name:");
    JLabel dateLabel = new JLabel("Date:");
    JLabel amountLabel = new JLabel("Amount (Pos or Neg):");
    JTextField transactionNameField = new JTextField();
    JTextField dateField = new JTextField();
    JTextField amountField = new JTextField();
    JTextField textField = new JTextField();

    TransactionWindow()
    {
        // Creating 
        transactionNameLabel.setBounds(50, 70, 150, 30);
        transactionNameField.setBounds(200, 70, 150, 30);
        dateLabel.setBounds(50, 110, 150, 30);
        dateField.setBounds(200, 110, 150, 30);
        amountLabel.setBounds(50, 150, 150, 30);
        amountField.setBounds(200, 150, 150, 30);
        textField.setHorizontalAlignment(JTextField.CENTER);

        JPanel panel = new JPanel(); // create a new JPanel
        panel.setLayout(null); // set the layout to null
        panel.add(transactionNameLabel);
        panel.add(transactionNameField);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(amountLabel);
        panel.add(amountField);
        panel.setSize(420, 420); // set the panel size to the same as the frame

        frame.add(panel); // add the panel to the frame

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}