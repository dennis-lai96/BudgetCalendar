package com.company;

import com.toedter.calendar.JCalendar;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class GUI extends JFrame {
    GUI(Client client){

        //Calendar Panel
        JPanel calendarPanel = new JPanel(new BorderLayout());
        JCalendar calendar = new JCalendar();
        calendarPanel.add(calendar);
        calendarPanel.setPreferredSize((new Dimension(300,300)));

        //Expense Panel
        JPanel expensePanel = new JPanel(new BorderLayout());
        JLabel expenseLabel = new JLabel("Expenses");
        expensePanel.add(expenseLabel,BorderLayout.NORTH);
        expensePanel.setPreferredSize(new Dimension(200,50));

        DefaultListModel<String> expenseListModel = new DefaultListModel<>();
        JList<String> expenseList = new JList<>(expenseListModel);//stick the list of things in the jlist somehow...
        JScrollPane expenseScrollPane = new JScrollPane(expenseList);
        expensePanel.add(expenseScrollPane, BorderLayout.CENTER);

        // Listener to display the date depending on which date is chosen on the calendar
        calendar.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                Date selectedDate = calendar.getDate();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                String formattedDate = dateFormat.format(selectedDate);
                expenseListModel.addElement(formattedDate);
            }
        });

        //Button panel 1
        JPanel buttonPanel1 = new JPanel(new FlowLayout());
        buttonPanel1.setPreferredSize(new Dimension(50,50));

        Button button = new Button("New Transaction");
        button.setPreferredSize(new Dimension(250,50));
        buttonPanel1.add(button);

        Button button2 = new Button("Remove Transaction from this month");
        button2.setPreferredSize(new Dimension(250,50));
        buttonPanel1.add(button2);

        //main panel shit
        this.setTitle("Budget Calendar");
        this.setLayout(new BorderLayout(50,10));
        this.setResizable(false); //NO RESIZING FOR YOU.
        //centering
        this.add(calendarPanel,BorderLayout.CENTER);
        this.add(expensePanel,BorderLayout.EAST);
        this.add(buttonPanel1,BorderLayout.SOUTH);


        this.pack();
        this.setVisible(true);//visibility
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}
