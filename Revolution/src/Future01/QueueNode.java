package Future01;

public class QueueNode {
	int data;
	public QueueNode next;
	public QueueNode(int data) {
		this.data= data;
		next = null;
	}
	public int getData() {
		return this.data;
	}
	public QueueNode getNext() {
		return this.next;
	}
	public void setData(int data) {
		this.data = data;
	}
	public void setNext(QueueNode next) {
		this.next = next;
	}	
}
