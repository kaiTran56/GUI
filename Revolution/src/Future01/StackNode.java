package Future01;

public class StackNode {
	private char data;
	private StackNode next;
	public StackNode(char data) {
		this.data = data;
		this.next = null;
	}
	public void setNext(StackNode next) {
		this.next = next;
	}
	public void setData(char data) {
		this.data = data;
	}
	public StackNode getNext() {
		return this.next;
	}
	public char getData() {
		return this.data;
	}
	public String toString() {
		return " " +getData();
	}
}
