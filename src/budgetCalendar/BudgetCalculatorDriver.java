package budgetCalendar;
import java.io.*;
import java.text.ParseException;
import java.util.*;

public class BudgetCalculatorDriver {
	public static void main(String[] args) throws ParseException {
		monthlyTransaction utilityBill = new monthlyTransaction(5,"13/31/31");
		utilityBill.printDate();
		utilityBill.printIncome();
		
		utilityBill.setDate("31/12/19");
		utilityBill.setIncome(534);
		
		utilityBill.printDate();
		utilityBill.printIncome();
		
		
		
		
	}

}
