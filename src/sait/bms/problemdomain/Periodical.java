package sait.bms.problemdomain;

/**
 * Represent a periodical book, is the Subclass of Super class Book
 * @author Nam Khanh Nguyen
 * @version 1.0
 * @since 2020-06-11
 */
public class Periodical extends Book {

	/**
	 * This is the frequency of book
	 */
	private char frequency;

	public Periodical() {
	}
	
	/**
	 * This is the children constructor which takes in all of the respective info
	 * @param isbn is the Movie's isbn
	 * @param callNumber is the Movie's callNumber
	 * @param available is the Movie's available
	 * @param total is the Movie's total
	 * @param title is the Movie's title
	 * @param frequency is the Movie's frequency
	 */
	public Periodical(long isbn, String callNumber, int available, int total, String title, char frequency) {
		super(isbn, callNumber, available, total, title);
		this.frequency = frequency;
	}

	/**
	 * @return the frequency
	 */
	public char getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}

	/**
	 * The toString method return content of periodical book to show for user 
	 * @return the formated String
	 */
	@Override
	public String toString() {
		String frequencyFull = null;
		if (frequency == 'D') {
			frequencyFull = "Daily";
		} else if (frequency == 'W') {
			frequencyFull = "Weekly";
		} else if (frequency == 'M') {
			frequencyFull = "Monthly";
		} else if (frequency == 'B') {
			frequencyFull = "Bimonthly";
		} else if (frequency == 'Q') {
			frequencyFull = "Quarterly";
		}
		return String.format("%-17s%d\n%-17s%s\n%-17s%d\n%-17s%d\n%-17s%s\n%-17s%s\n", "ISBN:", getIsbn(),
				"Call Number:", getCallNumber(), "Available:", getAvailable(), "Total:", getTotal(), "Title:",
				getTitle(), "Frequency:", frequencyFull);
	}

	/**
	 * The toString method return content of book to upload back to file
	 * @return the formated String
	 */
	public String toFile() {
		return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle() + ";"
				+ frequency;
	}

}
