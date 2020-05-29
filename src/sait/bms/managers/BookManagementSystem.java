package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildrensBook;
import sait.bms.problemdomain.CookBook;
import sait.bms.problemdomain.PaperBack;
import sait.bms.problemdomain.Periodical;

public class BookManagementSystem {

	public static final String FILE_PATH = "res\\books.txt";

	Scanner keyboard;

	private ArrayList<Book> books;

	public BookManagementSystem() throws FileNotFoundException {
		keyboard = new Scanner(System.in);
		books = new ArrayList<>();
		loadBookList();
	}

	private void loadBookList() throws FileNotFoundException {
		File file = new File(FILE_PATH).getAbsoluteFile();
		Scanner inFile = new Scanner(file);
		while (inFile.hasNext()) {
			String curline = inFile.nextLine();
			String[] splittedLine = curline.split(";");

			long isbn = Long.parseLong(splittedLine[0]);
			long lastDigitIsbn = isbn % 10;

			if (lastDigitIsbn == 0 || lastDigitIsbn == 1) {
				ChildrensBook tmpBook = new ChildrensBook(isbn, splittedLine[1], Integer.parseInt(splittedLine[2]),
						Integer.parseInt(splittedLine[3]), splittedLine[4], splittedLine[5], splittedLine[6].charAt(0));
				books.add(tmpBook);
			} else if (lastDigitIsbn == 2 || lastDigitIsbn == 3) {
				CookBook tmpBook = new CookBook(isbn, splittedLine[1], Integer.parseInt(splittedLine[2]),
						Integer.parseInt(splittedLine[3]), splittedLine[4], splittedLine[5], splittedLine[6].charAt(0));
				books.add(tmpBook);
			} else if (lastDigitIsbn == 4 || lastDigitIsbn == 7) {
				PaperBack tmpBook = new PaperBack(isbn, splittedLine[1], Integer.parseInt(splittedLine[2]),
						Integer.parseInt(splittedLine[3]), splittedLine[4], splittedLine[5],
						Integer.parseInt(splittedLine[6]), splittedLine[7].charAt(0));
				books.add(tmpBook);
			} else if (lastDigitIsbn == 8 || lastDigitIsbn == 9) {
				Periodical tmpBook = new Periodical(isbn, splittedLine[1], Integer.parseInt(splittedLine[2]),
						Integer.parseInt(splittedLine[3]), splittedLine[4], splittedLine[5].charAt(0));
				books.add(tmpBook);
			}

		}
		inFile.close();
	}

	public void displayMenu() throws IOException {
		int option = -1;
		while (option != 5) {
			System.out.println("Welcome in ABC Book Company: How May We Assist You?");
			System.out.println("1   Checkout Book");
			System.out.println("2   Find Books by Title");
			System.out.println("3   Display Books by Type");
			System.out.println("4   Produce Random Book List");
			System.out.println("5   Save & Exit");
			System.out.print("Enter an option: ");
			option = keyboard.nextInt();
			keyboard.nextLine();
			switch (option) {
			case 1:
				checkoutBook();
				break;

			case 2:
				findBookByTitle();
				break;

			case 3:
				displayBookByType();
				break;

			case 4:
				randomBookList();
				break;

			case 5:
				saveChanges();
				break;

			default:
				System.out.println("Invalid option\n");
				break;
			}
		}
	}

	public void checkoutBook() {
		boolean notMatch = true;
		System.out.print("Enter ISBN of book: ");
		long isbnSearch = keyboard.nextLong();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn() == isbnSearch) {
				notMatch = false;
				if (books.get(i).getAvailable() != 0) {
					System.out.println("The book \"" + books.get(i).getTitle() + "\" has been checked out.");
					System.out.println("It can be located using a call number: " + books.get(i).getCallNumber());
					books.get(i).setAvailable(books.get(i).getAvailable() - 1);
					System.out.println(books.get(i).toString());
				} else {
					System.out.println("Sorry, the book is not avaiable right now!\n");
				}
			}
		}
		if (notMatch) {
			System.out.println("Sorry patron, your ISBN isn't match with us!\n");
		}
	}

	public void findBookByTitle() {
		Boolean notMatching = true;
		String title, titleSearch;
		System.out.print("Enter title to search for: ");
		titleSearch = keyboard.nextLine().toLowerCase();
		System.out.println("Matching book: ");
		for (int i = 0; i < books.size(); i++) {
			title = books.get(i).getTitle().toLowerCase();
			if (title.contains(titleSearch)) {
				notMatching = false;
				System.out.println(books.get(i).toString());
			}
		}
		if (notMatching) {
			System.out.println("We don't have any book matching your title!\n");
		}
	}

	public void displayBookByType() {

		System.out.println("#   Type");
		System.out.println("1   Children's Books");
		System.out.println("2   Cookbooks");
		System.out.println("3   Paperbacks");
		System.out.println("4   Periodicals");
		System.out.print("Enter type of book: ");
		int typeOption = keyboard.nextInt();
		keyboard.nextLine();
		if (typeOption == 1) {
			findBookByFormat();
		} else if (typeOption == 2) {
			findBookByDiet();
		} else if (typeOption == 3) {
			findBookByGenre();
		} else if (typeOption == 4) {
			findBookByFrequency();
		}
	}

	public void findBookByFormat() {
		String userOption;
		Boolean notMatching = true;
		ArrayList<ChildrensBook> childrenBooks = new ArrayList<ChildrensBook>();
		System.out.print("Enter a format (P for Picture book, E for Early Readers, or C for Chapter book): ");
		userOption = keyboard.nextLine().toUpperCase();
		System.out.println("Matching book: ");
		for (int i = 0; i < books.size(); i++) {
			long lastDigitIsbn = books.get(i).getIsbn() % 10;
			if (lastDigitIsbn == 0 || lastDigitIsbn == 1) {
				childrenBooks.add((ChildrensBook) books.get(i));
			}
		}
		for (int i = 0; i < childrenBooks.size(); i++) {
			if (childrenBooks.get(i).getFormat() == userOption.charAt(0)) {
				notMatching = false;
				System.out.println(childrenBooks.get(i).toString());
			}
		}
		if (notMatching) {
			System.out.println("We don't have any book matching your format!\n");
		}
	}

	public void findBookByDiet() {
		String userOption;
		Boolean notMatching = true;
		ArrayList<CookBook> cookBooks = new ArrayList<CookBook>();
		System.out.print(
				"Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None): ");
		userOption = keyboard.nextLine().toUpperCase();
		System.out.println("Matching book: ");
		for (int i = 0; i < books.size(); i++) {
			long lastDigitIsbn = books.get(i).getIsbn() % 10;
			if (lastDigitIsbn == 2 || lastDigitIsbn == 3) {
				cookBooks.add((CookBook) books.get(i));
			}
		}
		for (int i = 0; i < cookBooks.size(); i++) {
			if (cookBooks.get(i).getDiet() == userOption.charAt(0)) {
				notMatching = false;
				System.out.println(cookBooks.get(i).toString());
			}
		}
		if (notMatching) {
			System.out.println("We don't have any book matching your diet!\n");
		}
	}

	public void findBookByGenre() {
		String userOption;
		Boolean notMatching = true;
		ArrayList<PaperBack> paperBacks = new ArrayList<PaperBack>();
		System.out.print(
				"Enter a genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction): ");
		userOption = keyboard.nextLine().toUpperCase();
		System.out.println("Matching book: ");
		for (int i = 0; i < books.size(); i++) {
			long lastDigitIsbn = books.get(i).getIsbn() % 10;
			if (lastDigitIsbn == 4 || lastDigitIsbn == 7) {
				paperBacks.add((PaperBack) books.get(i));
			}
		}
		for (int i = 0; i < paperBacks.size(); i++) {
			if (paperBacks.get(i).getGenre() == userOption.charAt(0)) {
				notMatching = false;
				System.out.println(paperBacks.get(i).toString());
			}
		}
		if (notMatching) {
			System.out.println("We don't have any book matching your genre!\n");
		}
	}

	public void findBookByFrequency() {
		String userOption;
		Boolean notMatching = true;
		ArrayList<Periodical> periodicals = new ArrayList<Periodical>();
		System.out.print(
				"Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Bimonthly, or Q for Quarterly): ");
		userOption = keyboard.nextLine().toUpperCase();
		System.out.println("Matching book: ");
		for (int i = 0; i < books.size(); i++) {
			long lastDigitIsbn = books.get(i).getIsbn() % 10;
			if (lastDigitIsbn == 8 || lastDigitIsbn == 9) {
				periodicals.add((Periodical) books.get(i));
			}
		}
		for (int i = 0; i < periodicals.size(); i++) {
			if (periodicals.get(i).getFrequency() == userOption.charAt(0)) {
				notMatching = false;
				System.out.println(periodicals.get(i).toString());
			}
		}
		if (notMatching) {
			System.out.println("We don't have any book matching your frequency!\n");
		}
	}

	public void randomBookList() {
		System.out.print("Enter number of books: ");
		int numberRandom = keyboard.nextInt();
		System.out.println("Random book: ");
		Collections.shuffle(books);
		for (int i = 0; i < numberRandom; i++) {
			System.out.println(books.get(i).toString());
		}
	}

	public void saveChanges() throws IOException {
		FileWriter fw = new FileWriter(FILE_PATH);
		PrintWriter outputFile = new PrintWriter(fw);
		outputFile.print("");
		for (int i = 0; i < books.size(); i++) {
			long lastDigitIsbn = books.get(i).getIsbn() % 10;
			if (lastDigitIsbn == 0 || lastDigitIsbn == 1) {
				outputFile.println(((ChildrensBook) books.get(i)).toFile());
			} else if (lastDigitIsbn == 2 || lastDigitIsbn == 3) {
				outputFile.println(((CookBook) books.get(i)).toFile());
			} else if (lastDigitIsbn == 4 || lastDigitIsbn == 7) {
				outputFile.println(((PaperBack) books.get(i)).toFile());
			} else if (lastDigitIsbn == 8 || lastDigitIsbn == 9) {
				outputFile.println(((Periodical) books.get(i)).toFile());
			}
		}
		outputFile.close();
		System.out.println("Saving book list...");
		System.out.println("Have a good day!");

	}

}
