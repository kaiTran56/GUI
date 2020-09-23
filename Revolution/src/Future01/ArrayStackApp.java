package Future01;

public class ArrayStackApp {
	public void copyStack(ArrayStack in, ArrayStack out) {
		ArrayStack temp = new ArrayStack();
		String tem;
		do {
			tem = in.pop();
			if(tem!=null) {
				temp.push(tem);
			}else 
				break;
		}while(tem!=null);
		while(true) {
			tem = temp.pop();
			if(tem!=null) {
				out.push(tem);
				in.push(tem);
			}else break;
		}
	}
	public void print(ArrayStack item) {
		String temp = null;
		ArrayStack temp1 = new ArrayStack();
		copyStack(item,temp1);
		do {
			temp  =temp1.pop();
			if(temp!=null)
				System.out.println(temp);
			else
				break;
		}while(true);
	}
	public static void main(String[] args) {
		ArrayStack s=new ArrayStack();
		ArrayStackApp d = new ArrayStackApp();
        System.out.println("Push three items into the stack:");                
        s.push("One");
        s.push("Two");
        s.push("Three");
        System.out.println("Print out all stack's items:");
        d.print(s);
        System.out.println("The current top item of the stack is: "+s.peek());
        System.out.println("Pop one item from the stack. Returned item is: "+s.pop());
        System.out.println("Now, the current top item of the stack is: "+s.peek());
        System.out.println("Push two items into the stack:");        
        s.push("Four");
        s.push("Five");        

        ArrayStack s1=new ArrayStack();
        d.copyStack(s,s1);
        System.out.println("Copy s to s1. Print out all s1's items:");
        d.print(s1);
	}
}
