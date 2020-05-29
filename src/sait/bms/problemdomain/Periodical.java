package sait.bms.problemdomain;

public class Periodical extends Book {

	private char frequency;

	public Periodical() {
	}

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

	public String toFile() {
		return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle() + ";"
				+ frequency;
	}

}
