package budgetCalendar;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class monthlyTransaction {
	private double cash; 
	private String dateString; //figuring it out
	private Date date;
	public monthlyTransaction(double cash, String dateString) {
		this.cash = cash;
		
		
	}
	void setIncome(double cash) {
		this.cash = cash;
		
	}

	void setDate(String date) {
		
	}
	
	void printIncome() {
		System.out.println(cash);
	}
	
	void printDate() {
		System.out.println(date);
	}

}
