package com.company;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;


public class Client {
    public String name;
    public int balance;
    public int count=0;
    public int location=0;
    public Transaction[] calender= new Transaction[365];;
    Map<LocalDate, List<Transaction>> monthlyTransactions = new HashMap<>();

    Client(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
        transaction.addmoney(transaction.cash);
        transaction.addname(transaction.transactionName);
        LocalDate date = transaction.date;
        List<Transaction> transactions = monthlyTransactions.get(date);
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);
        monthlyTransactions.put(date, transactions);
        balance += transaction.cash;
    }
    public void printTransactions() {
        System.out.println(name + "'s Monthly transactions: \n");
        monthlyTransactions.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
            System.out.println(entry.getKey().toString());
            entry.getValue().forEach(System.out::println);
        });
        System.out.println("The user's balance" + balance);
    }
    public String getbalance(){
        return String.valueOf(balance);
    }
    public Transaction getTransaction(int i){
        return this.calender[i];
    }
    public void saveTransaction(Transaction trans){
  
        this.calender[count]= trans;
        count++;
    }
    public boolean findTransaction(String date){

        for(int i=0;i<365;i++){
            if(this.calender[i]!=null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedString = this.calender[i].getDate().format(formatter);
            if(formattedString.equals(date)){

                location=i;
                return true;
               
            }
        }
        }
        return false;

    }
    public int getlocation(){
        return this.location;
    }
    public void addbalance(double cash){
        this.balance+=cash;
    }

}
