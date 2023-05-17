package com.company;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class removeTransaction {
    JFrame frame = new JFrame();
    JLabel removeLabel = new JLabel("<html>Please enter the name of the transaction<br>you would like to remove:</html>");
    JTextField removeField = new JTextField();
    removeTransaction(Client client)
    {
        removeLabel.setBounds(50, 70, 300, 50);
        removeLabel.setHorizontalAlignment(JLabel.CENTER);
        removeField.setBounds(50, 150, 300, 30);

        JButton doneButton = new JButton("Done");
        doneButton.setBounds(200, 200, 100, 30);
        doneButton.setHorizontalAlignment(JLabel.CENTER);

        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JPanel panel = new JPanel(new FlowLayout()); // create a new JPanel
        panel.setLayout(null); // set the layout to null
        panel.add(doneButton);
        panel.add(removeLabel);
        panel.add(removeField);
        panel.setSize(420, 420); // set the panel size to the same as the frame

        frame.add(panel); // add the panel to the frame

        frame.setTitle("Remove transaction");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}