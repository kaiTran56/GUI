package Future01;

public class ArrayStack {
	public String[] item;
	public int top;
	public final int max= 100;
	public ArrayStack() {
		item = new String[max];
		top=-1;
	}
	public boolean isEmty() {
		return top==-1?true:false;
	}
	public boolean isFull() {
		return top==max-1?true:false;
	}
	public void push(String newItem) {
		if(!isFull()) {
			top++;
			item[top] = newItem;
		}
	}
	public String pop() {
		if(!isEmty()) {
			String temp = item[top];
			top--;
			return temp;
		}else 
			return null;
	}
	public String peek() {
		return (!isEmty()) ? item[top]:null;
	}
}
