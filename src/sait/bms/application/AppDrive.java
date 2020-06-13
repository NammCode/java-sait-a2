package sait.bms.application;

import java.io.IOException;

import sait.bms.managers.BookManagementSystem;

/**
 * This program display the menu for user checkout book in the library
 * 
 * @author Nam Khanh Nguyen
 * @version 1.0, Jun 11, 2020
 */
public class AppDrive {

	public static void main(String[] args) throws IOException {
		BookManagementSystem bookManagement = new BookManagementSystem();
		bookManagement.displayMenu();
	}
}
