package tut01;
import java.util.Scanner;
public class ex2 {
	public Scanner scanner= new Scanner(System.in);
	public String first=null;
	public String last= null;
	
	public void seperate(String name) {
		int space = name.indexOf(" ");
		
			this.first = name.substring(0,space);
			this.last = name.substring(space+1,name.length());

	}
	public void initials() {
		char fi = this.first.charAt(0);
		char la = this.last.charAt(0);
		System.out.println("Your initials is "+fi +la);
	}
	public static void main(String[] args) {
		ex2 ex= new ex2();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try {
				System.out.println("Enter the Fist name and the Last name, seperate by space: ");
				String name = scanner.nextLine();
				if(name.contains(" ")) {
					ex.seperate(name);
				System.out.println("The Fist Name is: "+ex.first +", which has "+ ex.first.length()+" characters");
				System.out.println("The Last Name is: "+ex.last +", which has "+ex.last.length()+" characters");
				ex.initials();
				break;
				}else {
					System.out.println("Need your First and Last name!");
					continue;
				}
			}catch(Exception e) {
				System.err.println("Wrong Role, please enter again!");
			}
		
		}
	}
}
