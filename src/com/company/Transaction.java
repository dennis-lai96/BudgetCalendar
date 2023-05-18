package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    public double cash;
    public LocalDate date;
    public String ID = "monthlyTransaction";
    public String transactionName ="";
    public double[] money= new double[20];
    public int count=0;
    public int moneylocation=0;
    public String[] name=new String[20];
    public int namecount=0;
    public int namelocation=0;


    public Transaction(String transactionName, double cash, String dateString) {
        this.cash = cash;
        this.date = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
        this.transactionName=transactionName;

    }
    void setIncome(double cash) {
        this.cash = cash;

    }
    String getcash(int i){
        return String.valueOf(this.money[i]);
    }
    void addmoney(double cash){
        this.money[count]=cash;
        count++;
    }
    void addname(String name){
        this.name[namecount]=name;
        namecount++;
    }
    String getname(int i){
        return String.valueOf(this.name[i]);
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

    public String getcash(){
        return String.valueOf(cash);
    }
    public LocalDate getDate(){
        return date;
    }
    public boolean findmoney(double money){
    
        for(int i=0;i<20;i++){
            if(this.money[i]!=0.0){

            if(this.money[i]==money){

                moneylocation=i;

                return true;
               
            }
        }
      }
        return false;

    }
    public void removeMoney( int index)
    {


        double[] anotherArray = new double[this.money.length - 1];
  
        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < this.money.length; i++) {
  
            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }
            // if the index is not
            // the removal element index
            anotherArray[k++] = this.money[i];
        }
  
        // return the resultant array
        this.money=anotherArray;
    }

    public int getmoneylocation(){
        return this.moneylocation;
    }
    public boolean findname(String name){

        for(int i=0;i<20;i++){
            if(this.name[i]!=null){

            if(this.name[i].equals(name)){

                namelocation=i;

                return true;
               
            }
        }
    }
        return false;

    }
    public int getnamelocation(){
        return this.namelocation;
    }
    public void removeName( int index)
    {


        String[] anotherArray = new String[this.name.length - 1];
  
        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < this.name.length; i++) {
  
            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }
            // if the index is not
            // the removal element index
            anotherArray[k++] = this.name[i];
        }
  
        // return the resultant array
        this.name=anotherArray;
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



