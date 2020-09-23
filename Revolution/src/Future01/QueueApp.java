package Future01;

public class QueueApp {
	
	public static void main(String[] args) {
		QueueApp que = new QueueApp();
		ListQueue list = new ListQueue();
		int[] item = {1,2,3,4,5};
		for(int i = 0 ; i < item.length;i++) {
			list.enqueue(item[i]);			
		}
		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		System.out.println(list.isEmpty());
		System.out.println(list.peek());
		
	}
}
