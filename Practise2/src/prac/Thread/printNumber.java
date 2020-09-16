package prac.Thread;

public class printNumber {
	
	public void printNum() {
		for(int i = 0 ; i< 10; i ++) {
			System.out.print(i+ ", ");
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}
