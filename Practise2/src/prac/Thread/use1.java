package prac.Thread;

public class use1 extends Thread{
	public printNumber print;
	public use1(printNumber print) {
		this.print = print;
	}
	public void run() {
		print.printNum();
	}
}
