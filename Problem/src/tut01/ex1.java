package tut01;

import java.util.Random;

public class ex1 {
	public static void main(String[] args ) {
		Random ran = new Random();
		int number_die=0;
		int total=0;
		for(int i =0; i < 3; i ++) {
			number_die = ran.nextInt(7);
			if(number_die ==0) {
				number_die = 1;
			}
			if(i == 0) {
				System.out.println("The first die comes up: "+number_die);
				total = total+number_die;
			}else if(i==1) {
				System.out.println("The second die comes up: "+number_die);
				total =total +number_die;
			}else if(i ==2) {
				System.out.println("The total roll is: "+total);
				break;
			}
		}
	}
	
}
