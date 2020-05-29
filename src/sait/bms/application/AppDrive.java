package sait.bms.application;

import java.io.IOException;

import sait.bms.managers.BookManagementSystem;

public class AppDrive {

	public static void main(String[] args) throws IOException {
		BookManagementSystem bookManagement = new BookManagementSystem();
		bookManagement.displayMenu();
	}
}
