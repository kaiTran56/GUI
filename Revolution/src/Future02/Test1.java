package Future02;
import java.util.Stack;
public class Test1 {
	public Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) {
		Test1 test = new Test1();
		test.postfix("65+ 9*");
	}
	public void postfix(String count) {
		for(int i = 0 ; i < count.length(); i++) {
			char  a = count.charAt(i);
			if(a>='0'&&a<='9') {
				stack.push(Character.getNumericValue(a));
			}else {
				if(a=='+'&& a=='-'&&a=='*'&&a=='/') {
					int op1 = stack.pop();
					int op2 = stack.pop();
					switch(a) {
					case '+':
						stack.push(op2+1);
					case '-':
						stack.push(op2-op1);
					case '*':
						stack.push(op2*op1);
					case '/':
						stack.push(op2/op1);
					}
				}
			}
		}
		System.out.println(stack.pop());
	}
}
