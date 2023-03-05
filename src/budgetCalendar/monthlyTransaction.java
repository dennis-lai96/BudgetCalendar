package budgetCalendar;
import java.util.Date;


public class monthlyTransaction {
	double cash; 
	Long date; //we might have to convert date into calendar format later
	public monthlyTransaction(double cash, Long date) {
		this.cash = cash;
		this.date = date;
		
	}
	void setIncome(double cash) {
		this.cash = cash;
		
	}

	void setDate(Long date) {
		this.date = date;
	}
	
	void printIncome() {
		System.out.println(cash);
	}
	
	void printDate() {
		System.out.println(date);
	}

}
