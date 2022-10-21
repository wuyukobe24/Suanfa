package 栈;

import java.util.Stack;

/*
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的
 *  min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * */
public class _30_包含min函数的栈 {
	public static void main(String[] args) {
		
	}
	
}
class MinStack {
	Stack<Integer> dataStack;
	Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
    	dataStack = new Stack<>();
    	minStack = new Stack<>();
    }
    
    public void push(int x) {
    	if (minStack.isEmpty() || minStack.peek() > x) {
			minStack.push(x);
		} else {
			minStack.push(minStack.peek());
		}
    	dataStack.push(x);
    }
    
    public void pop() {
    	minStack.pop();
    	dataStack.pop();
    }
    
    public int top() {
    	return dataStack.peek();
    }
    
    public int min() {
    	return minStack.peek();
    }
}
