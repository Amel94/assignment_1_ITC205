import java.io.Serializable;


@SuppressWarnings("serial")
public class Book implements Serializable { // changed book to Book - Amel
	
	private String title;  //changed TITLE to title - Amel
	private String author; //changed AUTHOR to author - Amel
	private String callNo; //changed CALLNO to callNo - Amel
	private int id; //changed ID to id - Amel
	
	private enum STATE { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };
	private STATE State;
	
	
	public book(String author, String title, String callNo, int id) {
		this.author = author; //changed AUTHOR to author - Amel
		this.title = title; //changed TITLE to title - Amel
		this.callNo = callNo; //changed CALLNO to callNo - Amel
		this.id = id; //changed ID to id - Amel
		this.State = STATE.AVAILABLE;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book: ").append(ID).append("\n")
		  .append("  Title:  ").append(TITLE).append("\n")
		  .append("  Author: ").append(AUTHOR).append("\n")
		  .append("  CallNo: ").append(CALLNO).append("\n")
		  .append("  State:  ").append(State);
		
		return sb.toString();
	}

	public Integer id() { //changed ID to id - Amel
		return id;
	}

	public String title() { //changed TITLE to title - Amel
		return title;
	}


	
	public boolean available() { //changed AVAILABLE to available - Amel
		return State == STATE.AVAILABLE;
	}

	
	public boolean onLoan() { //changed On_Loan to onLoan - Amel
		return State == STATE.ON_LOAN;
	}

	
	public boolean isDamaged() { //changed IS_Damaged to isDamaged - Amel
		return State == STATE.DAMAGED;
	}

	
	public void borrow() { //changed Borrow to borrow - Amel
		if (State.equals(STATE.AVAILABLE)) {
			State = STATE.ON_LOAN;
		}
		else {
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", State));
		}
		
	}


	public void Return(boolean DAMAGED) { //changed Return to return - Amel
		if (State.equals(STATE.ON_LOAN)) {
			if (DAMAGED) {
				State = STATE.DAMAGED;
			}
			else {
				State = STATE.AVAILABLE;
			}
		}
		else {
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", State));
		}		
	}

	
	public void Repair() { //changed Repair to repair - Amel
		if (State.equals(STATE.DAMAGED)) {
			State = STATE.AVAILABLE;
		}
		else {
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", State));
		}
	}


}
