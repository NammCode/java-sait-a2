package sait.bms.problemdomain;

public class PaperBack extends Book {

	private String authors;
	private int year;
	private char genre;

	public PaperBack() {
	}

	public PaperBack(long isbn, String callNumber, int available, int total, String title, String authors, int year,
			char genre) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.year = year;
		this.genre = genre;
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
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the genre
	 */
	public char getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(char genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		String genreFull = null;
		if (genre == 'A') {
			genreFull = "Adventure";
		} else if (genre == 'D') {
			genreFull = "Drama";
		} else if (genre == 'E') {
			genreFull = "Education";
		} else if (genre == 'C') {
			genreFull = "Classic";
		} else if (genre == 'F') {
			genreFull = "Fantasy";
		} else if (genre == 'S') {
			genreFull = "Science";
		}
		return String.format("%-17s%d\n%-17s%s\n%-17s%d\n%-17s%d\n%-17s%s\n%-17s%s\n%-17s%d\n%-17s%s\n", "ISBN:",
				getIsbn(), "Call Number:", getCallNumber(), "Available:", getAvailable(), "Total:", getTotal(),
				"Title:", getTitle(), "Authors:", authors, "Year:", year, "Genre:", genreFull);
	}

	public String toFile() {
		return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle() + ";"
				+ authors + ";" + year + ";" + genre;
	}

}
