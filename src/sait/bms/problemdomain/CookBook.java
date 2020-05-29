package sait.bms.problemdomain;

public class CookBook extends Book {

	private String publisher;
	private char diet;

	public CookBook() {
	}

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
	
	public String toFile()  {
		return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle() + ";"
				+ publisher + ";" + diet;
	}

}
