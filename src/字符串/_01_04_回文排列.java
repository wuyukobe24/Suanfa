package 字符串;

import java.util.HashMap;


public class _01_04_回文排列 {
	public static void main(String[] args) {
		
	}
	/**
	 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
	 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
	 * 回文串不一定是字典当中的单词。
	 * 输入："tactcoa"
	 * 输出：true（排列有"tacocat"、"atcocta"，等等）
	 * 
	 * 思路：判断每个字母相同个数为奇数的数量，数量为0或1，则可以组成回文串
	 * 链接：https://leetcode.cn/problems/palindrome-permutation-lcci
	 * */
    public static boolean canPermutePalindrome(String s) {
    	if (s.length() == 0) return false;
    	HashMap<Character, Integer> dict = new HashMap<>();
    	for (char c : s.toCharArray()) {
			if (dict.containsKey(c)) {
				dict.put(c, dict.get(c)+1);
			} else {
				dict.put(c, 1);
			}
		}
    	int single = 0;
    	for (int val: dict.values()) {
			if (val%2 == 1) {
				single++;
			}
		}
    	return single < 2;
    }
}
