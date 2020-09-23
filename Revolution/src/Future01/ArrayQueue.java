package Future01;

public class ArrayQueue {
	public char[] item;
	public final int max = 100;
	public int front, rear;
	public ArrayQueue() {
		item = new char[max];
		front = 0;
		rear = 0;
	}
	public boolean isEmpty() {
		return front==rear? true : false;
	}
	public boolean isFull() {
		return front == (rear+1)%max? true: false;
	}
	public void enqueue(char newitem) {
		if(!isFull()) {
			item[rear] = newitem;
			rear= (rear+1)%max;
		}
	}
	public char dequeue() {
		if(!isEmpty()) {
			int temp = front;
			front = (front+1)%max;
			return item[temp];
		}else 
			return '\u0000';
	}
	public char peek() {
		return !isEmpty()? item[front]:'\u0000'; 
	}
}
