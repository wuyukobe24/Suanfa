package 栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _09_用两个栈实现队列 {

	public static void main(String[] args) {
		System.out.println(123);
	}
	
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
    public void CQueue() {
    	stack1 = new Stack<>();
    	stack2 = new Stack<>();
    }
    
    public void appendTail(int value) {
    	stack1.push(value);
    }
    
    public int deleteHead() {
    	if (!stack2.isEmpty()) {
			return stack2.pop();
		} else {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return stack2.isEmpty() ? -1 : stack2.pop();
		}
    }
}
