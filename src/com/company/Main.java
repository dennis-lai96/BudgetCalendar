package com.company;



public class Main {

    public static void main(String[] args) {
        Transaction utilityBill = new Transaction("Electricity Bill",5, "2021-08-14");
        utilityBill.setDate("2002-08-14");
        utilityBill.setIncome(-534);


        MonthlyIncome MOWING = new MonthlyIncome("lawnmover services",25,"2012-08-12");



        Client JOE = new Client("JOE GOLDBERG",0);

        JOE.addTransaction(utilityBill);
        JOE.addTransaction(MOWING);
        JOE.printTransactions();


    }
}
