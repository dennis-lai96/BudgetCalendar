package com.company;

import com.toedter.calendar.JCalendar;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class GUI extends JFrame {
    private JTextField transactionTextField;
    //private TransactionWindow transactionWindow;
    GUI(Client client){
        // Calendar Panel
        JPanel calendarPanel = new JPanel(new BorderLayout());
        JCalendar calendar = new JCalendar();
        calendarPanel.add(calendar);
        calendarPanel.setPreferredSize((new Dimension(300,300)));

        // Expense Panel
        JPanel expensePanel = new JPanel(new BorderLayout());
        JLabel expenseLabel = new JLabel("Expenses");
        expensePanel.add(expenseLabel,BorderLayout.NORTH);
        expensePanel.setPreferredSize(new Dimension(200,50));
        // Expense list
        DefaultListModel<String> expenseListModel = new DefaultListModel<>();
        JList<String> expenseList = new JList<>(expenseListModel);//stick the list of things in the jlist somehow...
        // Scrolling for expense box
        JScrollPane expenseScrollPane = new JScrollPane(expenseList);
        expensePanel.add(expenseScrollPane, BorderLayout.CENTER);

        // Listener to display the date depending on which date is chosen on the calendar
        PropertyChangeListener listener = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                Date selectedDate = calendar.getDate();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                String formattedDate = dateFormat.format(selectedDate);
                expenseListModel.clear();
                expenseListModel.addElement(formattedDate);
            }
        };
        // Action listener for calendar
        calendar.getDayChooser().addPropertyChangeListener("day", listener);

        //Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setPreferredSize(new Dimension(50,50));
        //Creating button
        JButton button = new JButton("New Transaction");
        button.setPreferredSize(new Dimension(250,50));
        buttonPanel.add(button);
        //Creating button2
        JButton button2 = new JButton("Remove Transaction from this month");
        button2.setPreferredSize(new Dimension(250,50));
        buttonPanel.add(button2);

        // Action listener for button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opening \"Add Transaction\" window...");
                TransactionWindow window = new TransactionWindow();
            }
        });
        // Action listener for button2
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opening \"Remove Transaction\" window...");
                removeTransaction window = new removeTransaction();
            }
        });
        //------------------------------------------------------------------
        /* 
        transactionTextField = new JTextField();
        transactionTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String transactionText = transactionTextField.getText(); 
            }
        });
        expensePanel.add(transactionTextField, BorderLayout.NORTH);
        */
        //------------------------------------------------------------------
        //main panel stuff
        this.setTitle(client.name + "'s Budget Calendar");
        this.setLayout(new BorderLayout(50,10));
        this.setResizable(false); //NO RESIZING FOR YOU.
        //centering
        this.add(calendarPanel,BorderLayout.CENTER);
        this.add(expensePanel,BorderLayout.EAST);
        this.add(buttonPanel,BorderLayout.SOUTH);


        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);//visibility
        calendar.getDayChooser().removePropertyChangeListener(listener);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        loginPage.toFront();
    }

    private void initializeComponents() {
        // Initialize the GUI 
        transactionTextField = new JTextField();
    }

    class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPage() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check credentials
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    public boolean authenticate() {
        return true; 
    }
}
}

