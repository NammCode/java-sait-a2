package sait.bms.problemdomain;

/**
 * Represent a children book, is the Subclass of Super class Book
 * @author Nam Khanh Nguyen
 * @version 1.0
 * @since 2020-06-11
 */
public class ChildrensBook extends Book {

	/**
	 * This is the authors of book
	 */
	private String authors;
	
	/**
	 * This is the format of book
	 */
	private char format;

	public ChildrensBook() {
	}

	/**
	 * This is the children constructor which takes in all of the respective info
	 * @param isbn is the Movie's isbn
	 * @param callNumber is the Movie's callNumber
	 * @param available is the Movie's available
	 * @param total is the Movie's total
	 * @param title is the Movie's title
	 * @param authors is the Movie's authors
	 */
	public ChildrensBook(long isbn, String callNumber, int available, int total, String title, String authors,
			char format) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.format = format;
	}

	/**
	 * @return the authors
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * @return the format
	 */
	public char getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(char format) {
		this.format = format;
	}

	/**
	 * The toString method return content of children book to show for user 
	 * @return the formated String
	 */
	@Override
	public String toString() {
		String formatFull = null;
		if (format == 'P') {
			formatFull = "Picture book";
		} else if (format == 'E') {
			formatFull = "Early Readers";
		} else if (format == 'C') {
			formatFull = "Chapter book";
		}
		return String.format("%-17s%d\n%-17s%s\n%-17s%d\n%-17s%d\n%-17s%s\n%-17s%s\n%-17s%s\n", "ISBN:", getIsbn(),
				"Call Number:", getCallNumber(), "Available:", getAvailable(), "Total:", getTotal(), "Title:",
				getTitle(), "Authors:", authors, "Format:", formatFull);
	}

	/**
	 * The toString method return content of book to upload back to file
	 * @return the formated String
	 */
	public String toFile() {
		return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle() + ";"
				+ authors + ";" + format;
	}
}
