package prac.Thread;

import java.util.Scanner;

public class useThread {
	public static boolean isStop = true;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Number num = new Number();
		Thread thread = new Thread(num);
		thread.start();
		System.out.println("Enter The Stop: ");
		String line = scanner.nextLine();
		if(line.equalsIgnoreCase("stop")) {
			isStop=false;
		}
		System.out.println("Ending!");
	}
}
