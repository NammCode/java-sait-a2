package sait.bms.problemdomain;

/**
 * Represent a cook book, is the Subclass of Super class Book
 * @author Nam Khanh Nguyen
 * @version 1.0
 * @since 2020-06-11
 */
public class CookBook extends Book {

	/**
	 * This is the publisher of book
	 */
	private String publisher;
	
	/**
	 * This is the diet of book
	 */
	private char diet;

	public CookBook() {
	}

	/**
	 * This is the children constructor which takes in all of the respective info
	 * @param isbn is the Movie's isbn
	 * @param callNumber is the Movie's callNumber
	 * @param available is the Movie's available
	 * @param total is the Movie's total
	 * @param title is the Movie's title
	 * @param publisher is the Movie's publisher
	 * @param diet is the Movie's diet
	 */
	public CookBook(long isbn, String callNumber, int available, int total, String title, String publisher, char diet) {
		super(isbn, callNumber, available, total, title);
		this.publisher = publisher;
		this.diet = diet;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the diet
	 */
	public char getDiet() {
		return diet;
	}

	/**
	 * @param diet the diet to set
	 */
	public void setDiet(char diet) {
		this.diet = diet;
	}

	/**
	 * The toString method return content of cook book to show for user 
	 * @return the formated String
	 */
	@Override
	public String toString() {
		String dietFull = null;
		if (diet == 'D') {
			dietFull = "Diabetic";
		} else if (diet == 'V') {
			dietFull = "Vegetarian";
		} else if (diet == 'G') {
			dietFull = "Gluten-free";
		} else if (diet == 'I') {
			dietFull = "International";
		} else if (diet == 'N') {
			dietFull = "None";
		}
		return String.format("%-17s%d\n%-17s%s\n%-17s%d\n%-17s%d\n%-17s%s\n%-17s%s\n%-17s%s\n", "ISBN:", getIsbn(),
				"Call Number:", getCallNumber(), "Available:", getAvailable(), "Total:", getTotal(), "Title:",
				getTitle(), "Publisher:", publisher, "Diet:", dietFull);
	}
	
	/**
	 * The toString method return content of book to upload back to file
	 * @return the formated String
	 */
	public String toFile()  {
		return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle() + ";"
				+ publisher + ";" + diet;
	}

}
