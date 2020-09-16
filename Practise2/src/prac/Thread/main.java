package prac.Thread;

public class main {
	public main() {
		
	}
	public static void main(String[] args) {
		printNumber num = new printNumber();
		use1[] use = new use1[10];
		for(int i = 0 ; i < 10 ; i ++) {
			use[i] = new use1(num);
		}
		for(int i =0 ; i < 10; i++) {
			use[i].start();
		}
		
	}
}