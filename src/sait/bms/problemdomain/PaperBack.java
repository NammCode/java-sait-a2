package sait.bms.problemdomain;

/**
 * Represent a paperback book, is the Subclass of Super class Book
 * @author Nam Khanh Nguyen
 * @version 1.0
 * @since 2020-06-11
 */
public class PaperBack extends Book {

	/**
	 * This is the authors of book
	 */
	private String authors;
	
	/**
	 * This is the year of book
	 */
	private int year;
	
	/**
	 * This is the genre of book
	 */
	private char genre;

	public PaperBack() {
	}
	
	/**
	 * This is the children constructor which takes in all of the respective info
	 * @param isbn is the Movie's isbn
	 * @param callNumber is the Movie's callNumber
	 * @param available is the Movie's available
	 * @param total is the Movie's total
	 * @param title is the Movie's title
	 * @param authors is the Movie's authors
	 * @param years is the Movie's years
	 * @param genre is the Movie's genre
	 */
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
	
	/**
	 * The toString method return content of paperback book to show for user 
	 * @return the formated String
	 */
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

	/**
	 * The toString method return content of book to upload back to file
	 * @return the formated String
	 */
	public String toFile() {
		return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle() + ";"
				+ authors + ";" + year + ";" + genre;
	}

}
