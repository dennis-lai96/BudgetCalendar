package com.company;


//Driver class
public class Main {

    public static void main(String[] args) {
        Transaction utilityBill = new Transaction("Electricity Bill",5, "2021-08-14");
        utilityBill.setDate("2002-08-14");
        utilityBill.setIncome(-534);


        MonthlyIncome MOWING = new MonthlyIncome("lawnmover services",25,"2021-08-12");



        Client JOE = new Client("JOE GOLDBERG",0);

        JOE.addTransaction(utilityBill);
        JOE.addTransaction(MOWING);
        JOE.printTransactions();



        new GUI(JOE);
        //implement
        //a way to list expenses based on the JCALENDAR month using the hashmap, and list that
        // under the "Expenses" section of the GUI
        //meaning you would need an action-listener on the JCALENDAR component to change the expense JLIST.
        // past that, we would need to implement add buttons on the GUI to add/remove a new/old transaction based on the
        // DATE selected on the calendar
    }
}