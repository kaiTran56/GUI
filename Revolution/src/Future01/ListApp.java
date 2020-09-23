package Future01;

public class ListApp {
	public void copyStack(ListStack in, ListStack out) {
		ListStack temp = new ListStack();
		StackNode tem;
		while(true) {
			tem = in.pop();
			if(tem!=null)
				temp.push(tem);
			else
				break;
		}
		while(true) {
			tem = temp.pop();
			if(tem!=null) {
				in.push(tem);
				out.push(tem);
			}else
				break;				
		}
	}
	public void print(ListStack item) {
		ListStack temp = new ListStack();
		StackNode tem;
		copyStack(item,temp);
		while(true) {
			tem = temp.pop();
			if(tem != null) {
				System.out.println(tem.toString());
			}else 
				break;
		}
	}
	public static void main(String[] args) {
		ListApp list = new ListApp();
		ListStack stack = new ListStack();
		char[] item = {'a', 'b','c','d','e'};
		for(int i = 0 ; i < item.length;i++) {
			StackNode item1 = new StackNode(item[i]);
			stack.push(item1);
		}
		list.print(stack);
		System.out.println("POP: "+stack.pop());
		System.out.println("Check:"+ stack.isEmpty());
		System.out.println("Check:"+ stack.peek());		
	}
}
