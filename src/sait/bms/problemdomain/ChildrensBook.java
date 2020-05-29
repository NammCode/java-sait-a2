package sait.bms.problemdomain;

public class ChildrensBook extends Book {

	private String authors;
	private char format;

	public ChildrensBook() {
	}

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

	public String toFile() {
		return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle() + ";"
				+ authors + ";" + format;
	}
}
