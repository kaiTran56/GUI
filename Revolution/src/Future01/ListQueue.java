package Future01;

public class ListQueue {
	QueueNode front;
	QueueNode tail;

	public ListQueue() {
		front = null;
		tail = null;
	}

	public boolean isEmpty() {
		return front == tail ? true : false;
	}

	public void enqueue(int item) {
		QueueNode temp = new QueueNode(item);
		if (this.tail == null) {
			this.front = this.tail = temp;
			return;
		}
		this.tail.next = temp;
		this.tail = temp;
	}

	public int dequeue() {
		int temp = this.front.getData();
		this.front = this.front.getNext();
		return temp;
	}

	public int peek() {
		return !isEmpty() ? front.getData() : null;
	}
}
