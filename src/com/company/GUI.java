package com.company;

import com.toedter.calendar.JCalendar;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;
import javax.swing.DefaultListModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;



public class GUI extends JFrame {
    String formattedDate;
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

        DefaultListModel<String> dlm = new DefaultListModel<String>();
        JList <String> expenseList = new JList<String>(dlm);

        JScrollPane expenseScrollPane = new JScrollPane(expenseList);
        expensePanel.add(expenseScrollPane, BorderLayout.CENTER);
        calendar.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                Date selectedDate = calendar.getDate();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                formattedDate = dateFormat.format(selectedDate);
                if(client.findTransaction(formattedDate)==true){
                    dlm.clear();
                    //dlm.addElement(formattedDate);
                    for(int i=0;i<20;i++){
                        if(client.getTransaction(client.getlocation()).getname(i)==null){
                            break;
                        }
                        if(client.getTransaction(client.getlocation()).getcash(i).equals("0.0")){
                            break;
                        }
                        dlm.addElement(client.getTransaction(client.getlocation()).getname(i));
                        dlm.addElement(client.getTransaction(client.getlocation()).getcash(i));
                    }

                }
                else{
                    dlm.clear();
                    //dlm.addElement(formattedDate);
                }
            }
        });

        //Empty PAnel
        JPanel emptyPanel = new JPanel(new BorderLayout());
        emptyPanel.setPreferredSize(new Dimension(50,50));

        //main panel shit
        this.setTitle(client.name + "'s Budget Calendar");
        this.setLayout(new BorderLayout(50,50));
        this.setResizable(false); //NO RESIZING FOR YOU.
        //centering
        this.add(calendarPanel,BorderLayout.CENTER);
        this.add(expensePanel,BorderLayout.EAST);
        //button to add elements to jlist
        JPanel buttonPanel1 = new JPanel(new BorderLayout());
        buttonPanel1.setPreferredSize(new Dimension(200, 160));
        JPanel topButtonPanel = new JPanel(new FlowLayout());
        JPanel middlePanel = new JPanel(new FlowLayout());
        middlePanel.setPreferredSize(new Dimension(250,50));
        JPanel bottomButtonPanel = new JPanel(new FlowLayout());
        JTextField transactionName = new JTextField();
        JTextField transactionAmount = new JTextField();
        JButton addButton = new JButton( new AbstractAction("Add") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                // add Action
                Transaction trans=new Transaction("Electricity Bill",5, formattedDate);
                if(client.findTransaction(formattedDate)==true){
                    double newamount= 15;
                    String transname= "school";
                    client.getTransaction(client.getlocation()).addmoney(newamount);
                    client.getTransaction(client.getlocation()).addname(transname);
                    dlm.addElement(transname);
                    dlm.addElement(String.valueOf(newamount));
                    client.addbalance(newamount);
                    dlm.addElement(client.getbalance());
                }else{
                    client.addTransaction(trans);
                    client.saveTransaction(trans);
                    dlm.addElement(client.getTransaction(0).getcash());
                    dlm.addElement(client.getbalance());
                }

            }
        });
        JButton subButton = new JButton( new AbstractAction("substract") {
            @Override
            public void actionPerformed( ActionEvent e ) {

                if(client.getTransaction(client.getlocation()).findmoney(15)==true && client.getTransaction(client.getlocation()).findname("school")==true){
                    int moneylocal=client.getTransaction(client.getlocation()).getmoneylocation();
                    int namelocal= client.getTransaction(client.getlocation()).getnamelocation();
                    client.getTransaction(client.getlocation()).removeMoney(moneylocal);
                    client.getTransaction(client.getlocation()).removeName(namelocal);
                    // substract Action
                    dlm.removeElement("school");
                    dlm.removeElement("15.0");
                    dlm.addElement("Transaction Removed");
                }
                else{
                    dlm.addElement("Transaction not found");
                }
            }
        });
        JButton incomeButton = new JButton( new AbstractAction("Set Income") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                //client.setIncome(trans, 150);
                System.out.println("Income has been set!");
            }
        });
        JButton balanceButton = new JButton( new AbstractAction("Get Balance") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println(client.getbalance());
                System.out.println("Retrieved Balance!");
            }
        });
        //Adding panels and buttons
        transactionName.setPreferredSize(new Dimension(200, 30));
        transactionAmount.setPreferredSize(new Dimension(200, 30));
        middlePanel.add(transactionName);
        middlePanel.add(transactionAmount);
        incomeButton.setPreferredSize(new Dimension(250,50));
        topButtonPanel.add(incomeButton);
        balanceButton.setPreferredSize(new Dimension(250,50));
        topButtonPanel.add(balanceButton);
        addButton.setPreferredSize(new Dimension(250,50));
        bottomButtonPanel.add(addButton);
        subButton.setPreferredSize(new Dimension(250,50));
        bottomButtonPanel.add(subButton);
        buttonPanel1.add(topButtonPanel, BorderLayout.NORTH);
        buttonPanel1.add(middlePanel, BorderLayout.CENTER);
        buttonPanel1.add(bottomButtonPanel, BorderLayout.SOUTH);
        this.add(buttonPanel1,BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);//visibility
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}