package 字符串;

import java.util.Iterator;

public class _14_最长公共前缀 {

	/*
	 * 编写一个函数来查找字符串数组中的最长公共前缀。
	 * 如果不存在公共前缀，返回空字符串 ""。
	 * 
	 * 输入：strs = ["flower","flow","flight"]
	 * 输出："fl"
	 * 
	 * 思路：遍历第一个元素，然后去和后面元素的每一个字符去比较，如果出现遍历长度和字符长度相等或者字符不一样，则返回之前遍历的字符即可。
	 * */
	public static void main(String[] args) {
		String[] strs = new String[] {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));
	}
    public static String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0) return "";
    	for (int i = 0; i < strs[0].length(); i++) {
    		char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() == i || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
    	return strs[0];
    }
}
