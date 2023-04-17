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
    }



}
