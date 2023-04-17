package com.company;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public String name;
    public int balance;
    List<Transaction> MonthlyTransactionals = new ArrayList<>();

    Client(String name, int balance) {
        this.name = name;
        this.balance = balance;

    }

    public void addTransaction(Transaction transaction){

        MonthlyTransactionals.add(transaction);
        balance = (int) (balance + transaction.cash);
    }

    public void printTransactions(){
        System.out.println(name+"'s Monthly transactions: \n");
        MonthlyTransactionals.forEach(System.out::println);
        System.out.println("The user's balance"+ balance);
    }


    //NEED TO IMPLEMENT A METHOD TO REMOVE A TRANSACTION BASED ON THE TRANSACTION NAME
    //NEED TO IMPLEMENT A WAY IN CLIENT CLASS FOR A LIST OF LISTS. Ex. Each list should present a month, and that list
    //should reflect THAT month's transactions.




}
