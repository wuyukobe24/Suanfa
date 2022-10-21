package 数组;

import java.util.HashMap;

public class _50_第一个只出现一次的字符 {
	public static void main(String[] args) {
		
	}
	/*
	 * 在字符串 s 中找出第一个只出现一次的字符。
	 * 如果没有，返回一个单空格。 s 只包含小写字母。
	 * 
	 * 思路：遍历字符串，使用hash表存储字符是否存在，若不存在为true，若存在为false。
	 * 再次遍历字符串，返回第一个hash中存储为true的字符
	 * */
    public char firstUniqChar(String s) {
    	HashMap<Character, Boolean> dic = new HashMap<>();
    	char[] nums = s.toCharArray();
    	for (char c : nums) {
			dic.put(c, !dic.containsKey(c));
		}
    	for (char c : nums) {
			if (dic.get(c)) return c;
		}
    	return ' ';
    }
}
