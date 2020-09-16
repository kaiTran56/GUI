package prac.Thread;

public class Number implements Runnable{
	private int i = 0 ;
	@Override
	public synchronized void run() {
		while(useThread.isStop) {
			System.out.println("Number: "+i);
			i++;
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
