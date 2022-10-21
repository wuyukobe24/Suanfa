package 字符串;

import java.util.HashMap;


public class _48_最长不含重复字符的子字符串 {

	public static void main(String[] args) {
		String string = "abba";
		System.out.println(lengthOfLongestSubstring(string));
//		lengthOfLongestSubstring(string);
	}

	/*
	 * 请从字符串中找出一个最长的不包含重复字符的子字符串，
	 * 计算该最长子字符串的长度。
	 * 
	 * 解题思路
	 * 创建一个哈希表，存储字符串中字符的下标，
	 * 遍历字符串的同时维护一个滑动窗口，
	 * 左指针num，右指针i，如果i处元素在哈希表中存在，
	 * 则更新左指针至num，map.get(ch)两者之间的最大值。
	 * （为什么要更新至最大值，例如用例abba 当num=0，i=2时，
	 * 发现b在哈希表中存在，此时更新num为2，当i为3时，
	 * 发现a在哈希表存在，更新num=1，此时就发生错误，
	 * 正确做法是更新num至两者之间的最大值），
	 * 然后max与当前维护的滑动窗口长度做比较并更新。
	 * */    

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) return 0;
		HashMap<Character, Integer> dict = new HashMap<>();
		int max = 0, count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (dict.containsKey(c)) {
				count = Math.max(i, dict.get(c)+1); // 加一是为了从hash中已存在的值的下一个开始计算
			}
			dict.put(c, i);
			max = Math.max(max, i-count+1);
		}
		return max;
	}
}

/*
 * "abba"
num:0 max:1
num:0 max:2
num:2 max:2
num:2 max:2
 * */
