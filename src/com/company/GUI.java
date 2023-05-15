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

        //Empty PAnel
        JPanel emptyPanel = new JPanel(new BorderLayout());
        emptyPanel.setPreferredSize(new Dimension(50,50));

        //main panel shit
        this.setTitle("Budget Calendar");
        this.setLayout(new BorderLayout(50,50));
        this.setResizable(false); //NO RESIZING FOR YOU.
        //centering
        this.add(calendarPanel,BorderLayout.CENTER);
        this.add(expensePanel,BorderLayout.EAST);


        this.pack();
        this.setVisible(true);//visibility
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}
