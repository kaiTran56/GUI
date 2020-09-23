package Future01;

public class ListStack {
	private StackNode top;
	public ListStack() {
		top = null;
	}
	public boolean isEmpty() {
		return top==null? true : false; 
	}
	public void push(StackNode newItem) {
		newItem.setNext(top);
		top = newItem;
	}
	public StackNode pop() {
		StackNode temp;
		if(!isEmpty()) {
			temp = top;
			top = top.getNext();
			return temp;
		}else 
			return null;
	}
	public StackNode peek() {
		return !isEmpty()? top:null;
	}
}
