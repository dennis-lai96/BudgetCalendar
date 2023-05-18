package com.company;
// Importing everything
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
  private JTextField transactionTextField;
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

        //Expense list to add expenses
        DefaultListModel<String> dlm = new DefaultListModel<String>();
        JList <String> expenseList = new JList<String>(dlm);

        //Allowing the user to scroll if they input enough expenses
        JScrollPane expenseScrollPane = new JScrollPane(expenseList);
        expensePanel.add(expenseScrollPane, BorderLayout.CENTER);

        //Action-listener for the calendar object
        calendar.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                Date selectedDate = calendar.getDate();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                formattedDate = dateFormat.format(selectedDate);
                if(client.findTransaction(formattedDate)==true){
                dlm.clear();
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
                }
            }
        });

        //main panel stuff
        this.setTitle(client.name + "\'s Budget Calendar");
        this.setLayout(new BorderLayout(50,50));
        this.setResizable(false); //NO RESIZING FOR YOU.

        //centering panels
        this.add(calendarPanel,BorderLayout.CENTER);
        this.add(expensePanel,BorderLayout.EAST);

        //Declaring buttons
        JPanel buttonPanel1 = new JPanel(new BorderLayout());
        buttonPanel1.setPreferredSize(new Dimension(200, 160));
        JPanel topButtonPanel = new JPanel(new FlowLayout());
        JPanel middlePanel = new JPanel(new FlowLayout());
        middlePanel.setPreferredSize(new Dimension(250,50));
        JPanel bottomButtonPanel = new JPanel(new FlowLayout());

        //Declaring TextFields
        JTextField transactionName = new JTextField();
        transactionName.setText("Transaction Name");
        JTextField transactionAmount = new JTextField();
        transactionAmount.setText("Transaction Amount");

        //Listener for "Add Transaction" button
        JButton addButton = new JButton( new AbstractAction("Add Transaction") {
                    @Override
                    public void actionPerformed( ActionEvent e ) {
                        // add Action
                        double newamount=  Double.valueOf(transactionAmount.getText());
                        String transname= transactionName.getText();
                        Transaction trans=new Transaction(transname,newamount, formattedDate);
                        if(client.findTransaction(formattedDate)==true){

                          client.getTransaction(client.getlocation()).addmoney(newamount);
                          client.getTransaction(client.getlocation()).addname(transname);
                          dlm.addElement(transname);
                          dlm.addElement("$"+String.valueOf(newamount));
                          client.addbalance(newamount);
                        }else{
                        
                        client.addTransaction(trans);
                        client.saveTransaction(trans);
                        dlm.addElement(transname);
                        dlm.addElement("$"+newamount);
                        }

                    }
                });

        //Listener for "Remove Transaction" button
        JButton subButton = new JButton( new AbstractAction("Remove Transaction") { 
                  @Override
                  public void actionPerformed( ActionEvent e ) {
                    double newamount=  Double.valueOf(transactionAmount.getText());
                    String transname= transactionName.getText();
                      if(client.getTransaction(client.getlocation()).findmoney(newamount)==true && client.getTransaction(client.getlocation()).findname(transname)==true){
                        int moneylocal=client.getTransaction(client.getlocation()).getmoneylocation();
                        int namelocal= client.getTransaction(client.getlocation()).getnamelocation();
                        client.getTransaction(client.getlocation()).removeMoney(moneylocal);
                        client.getTransaction(client.getlocation()).removeName(namelocal);
                      // substract Action
                      dlm.removeElement(transname);
                      dlm.removeElement("$"+String.valueOf(newamount));
                      dlm.addElement("Transaction Removed");
                      }
                  else{
                    dlm.addElement("Transaction not found");
                  }
                  }
        });

        //Listener for "Set Income" button
        JButton incomeButton = new JButton( new AbstractAction("Set Income") {
        @Override
          public void actionPerformed( ActionEvent e ) {
            /* 
            if(client.findTransaction(formattedDate)==true){
              client.findTransaction(formattedDate).setIncome(150);
            }
            */
            System.out.println("hi!");
        }
        });

        //Listener for "Get Balance" button
        JButton balanceButton = new JButton( new AbstractAction("Get Balance") {
          @Override
            public void actionPerformed( ActionEvent e ) {
              dlm.addElement("Your current balance is $" +client.getbalance());
          }
          });

        //Adding TextFields to sub panel
        transactionName.setPreferredSize(new Dimension(200, 30));
        transactionAmount.setPreferredSize(new Dimension(200, 30));
        middlePanel.add(transactionName);
        middlePanel.add(transactionAmount);

        //Adding buttons to sub panels
        incomeButton.setPreferredSize(new Dimension(250,50));
        topButtonPanel.add(incomeButton);
        balanceButton.setPreferredSize(new Dimension(250,50));
        topButtonPanel.add(balanceButton);
        addButton.setPreferredSize(new Dimension(250,50));
        bottomButtonPanel.add(addButton);
        subButton.setPreferredSize(new Dimension(250,50));
        bottomButtonPanel.add(subButton);

        //Adding sub panels to main panel
        buttonPanel1.add(topButtonPanel, BorderLayout.NORTH);
        buttonPanel1.add(middlePanel, BorderLayout.CENTER);
        buttonPanel1.add(bottomButtonPanel, BorderLayout.SOUTH);
        
        //Adding main panel to GUI
        this.add(buttonPanel1,BorderLayout.SOUTH);        
        this.pack();
        this.setVisible(true);//visibility
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creating login page
        LoginPage loginPage = new LoginPage();
        if (loginPage.authenticate()) {
            // Proceed with the main application
            initializeComponents();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Exiting the application.");
            System.exit(0);
        }
    }

    //Initializing login page GUI
    private void initializeComponents() {
      // Initialize the GUI 
      transactionTextField = new JTextField();
  }

  //Class for LoginPage
  private class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPage() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        //Adding Labels and TextFields to LoginPage panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    //Authenticating login information
    public boolean authenticate() {
        return true; 
    }
}
}