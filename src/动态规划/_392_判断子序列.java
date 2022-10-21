package 动态规划;

public class _392_判断子序列 {

	/*
	 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
	 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
	 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
	 * 
	 * 思路：双指针，循环一次，比较是否相等。s走完返回true，t走完返回false
	 * 
	 * 链接：https://leetcode-cn.com/problems/is-subsequence
	 * */
	public static void main(String[] args) {
		
	}
	public static boolean isSubsequence(String s, String t) {
		if (s.length() == 0) return true;
		if (t.length() == 0) return false;
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		int i = 0, j = 0;
		while (i<sc.length) {
			if (j==tc.length) return false;
			if (sc[i] == tc[j]) {
				i++;
			}
			j++;
		}
		return true;
	}
}
