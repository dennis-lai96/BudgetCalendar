package com.company;

import javax.swing.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;


public class Client {
    public String name;
    public int balance;
    Map<LocalDate, List<Transaction>> monthlyTransactions = new HashMap<>();

    Client(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
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
}
