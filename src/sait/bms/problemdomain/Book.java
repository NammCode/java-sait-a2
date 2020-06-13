package sait.bms.problemdomain;

/**
 * Represent a book, which take from text file
 * @author Nam Khanh Nguyen
 * @version 1.0
 * @since 2020-06-11
 */
public class Book {

	/**
	 * This is the isbn of book
	 */
	private long isbn; 
	
	/**
	 * This is call Number of book
	 */
	private String callNumber;
	
	/**
	 * This is the number of book which is avaiable
	 */
	private int available;
	
	/**
	 * The total number of book
	 */
	private int total;
	
	/**
	 * The title of book
	 */
	private String title;
	
	public Book() {
	}

	/**
	 * This is the book's constructor which takes in all of the respective info
	 * @param isbn is the Movie's isbn
	 * @param callNumber is the Movie's callNumber
	 * @param available is the Movie's available
	 * @param total is the Movie's total
	 * @param title is the Movie's title
	 */
	public Book(long isbn, String callNumber, int available, int total, String title) {
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
	}

	/**
	 * @return the isbn
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the callNumber
	 */
	public String getCallNumber() {
		return callNumber;
	}

	/**
	 * @param callNumber the callNumber to set
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	/**
	 * @return the available
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * The toString method return content of book to show for user 
	 * @return the formated String
	 */
	@Override
	public String toString() {
		return String.format("%-17s%d\n%-17s%s\n%-17s%d\n%-17s%d\n%-17s%s\n", "ISBN:", getIsbn(),
				"Call Number:", getCallNumber(), "Available:", getAvailable(), "Total:", getTotal(), "Title:",
				getTitle());
	}

}
