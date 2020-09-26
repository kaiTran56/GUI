package com.Robo;

import java.util.Scanner;

public class TestException {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		

		while (true) {
			try {
				System.out.print("Enter a number: ");
				int number = scanner.nextInt();
				System.out.println("Done");
			} catch (Exception ex) {
				System.out.println("You need a number!");
				scanner.nextLine();
			}
		}
		
	}

}
