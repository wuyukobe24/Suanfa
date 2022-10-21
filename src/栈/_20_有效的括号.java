package 栈;

import java.util.Stack;

public class _20_有效的括号 {
	/*
	 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
	 * 有效字符串需满足：
	 * 左括号必须用相同类型的右括号闭合。
	 * 左括号必须以正确的顺序闭合。
	 * 
	 * 思路：遍历，遇见左括号直接入栈，遇见右括号，则从栈中取出最近的括号，比对是否能组成{} [] ()
	 * 
	 * 链接：https://leetcode-cn.com/problems/valid-parentheses
	 * */
	public static void main(String[] args) {
		String str = "[]{}";
		System.out.println(isValid(str));
	}
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char left = stack.pop();
				if (left == '(' && c != ')') return false;
				if (left == '[' && c != ']') return false;
				if (left == '{' && c != '}') return false;
			}
			
		}
		return stack.isEmpty();
	}
}
