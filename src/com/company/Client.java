package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BudgetCalendar{
    private List<Transaction> transactions;

    public BudgetCalendar() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void removeTransactionByName(String name) {
        Transaction transactionToRemove = null;
        for (Transaction transaction : transactions) {
            if (transaction.getName().equals(name)) {
                transactionToRemove = transaction;
                break;
            }
        }
        if (transactionToRemove != null) {
            transactions.remove(transactionToRemove);
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}


public class Client {
    public static void main(String[] args) {
        BudgetCalendar budgetCalendar = new BudgetCalendar();
        Transaction transaction1 = new Transaction("Salary", 5000.0);
        Transaction transaction2 = new Transaction("Rent", -1200.0);
        Transaction transaction3 = new Transaction("Groceries", -300.0);
        budgetCalendar.addTransaction(transaction1);
        budgetCalendar.addTransaction(transaction2);
        budgetCalendar.addTransaction(transaction3);
        budgetCalendar.removeTransactionByName("Rent");
        List<List<Transaction>> transactionsByMonth = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            List<Transaction> transactionsInMonth = new ArrayList<>();
            for (Transaction transaction : budgetCalendar.getTransactions()) {
                if (transaction.getMonth() == i) {
                    transactionsInMonth.add(transaction);
                }
            }
            transactionsByMonth.add(transactionsInMonth);
        }
        System.out.println("Transactions by month:");
        for (int i = 0; i < transactionsByMonth.size(); i++) {
            System.out.println("Month " + (i+1) + ": " + transactionsByMonth.get(i));
        }
    }
    }

    class Transaction {
        private String name;
        private double amount;
        private int month;
    
        public Transaction(String name, double amount) {
            this.name = name;
            this.amount = amount;
            this.month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        }
    
        public String getName() {
            return name;
        }
    
        public double getAmount() {
            return amount;
        }
    
        public int getMonth() {
            return month;
        }


}
