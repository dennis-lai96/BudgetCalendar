package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    public double cash;
    public LocalDate date;
    public String ID = "monthlyTransaction";
    public String transactionName ="";

    public Transaction(String transactionName, double cash, String dateString) {
        this.cash = cash;
        this.date = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
        this.transactionName=transactionName;

    }
    void setIncome(double cash) {
        this.cash = cash;

    }

    void setDate(String dateString) {
        this.date = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);

    }

    void printIncome() {
        System.out.println(cash);
    }

    void printDate() {
        System.out.println(date);
    }

    void printNameType(){
        System.out.println(ID);
        System.out.println(transactionName);
    }
    public String toString(){//overriding the toString() method
        return "Transaction Name: "+transactionName+"\nID: "+ID+"\nDate: "+date+"\nCash: "+cash;
    }

}
class MonthlyIncome extends Transaction{


    public MonthlyIncome(String transactionName, double cash, String dateString) {
        super(transactionName, cash, dateString);
        super.ID = "income";

    }
}

class Windfall extends Transaction{


    public Windfall(String transactionName, double cash, String dateString) {
        super(transactionName, cash, dateString);
        super.ID = "windfall";

    }
}
class MonthlyBill extends Transaction{


    public MonthlyBill(String transactionName, double cash, String dateString) {
        super(transactionName, cash, dateString);
        super.ID = "MonthlyBill";

    }
}
class Expense extends Transaction{


    public Expense(String transactionName, double cash, String dateString) {
        super(transactionName, cash, dateString);
        super.ID = "Expense";

    }
}


