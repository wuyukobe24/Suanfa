package 字符串;

public class _409_最长回文串 {

	/*
	 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
	 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。

输入:s = "abccccdd"
输出:7
解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。

思路：对于每个字符 ch，假设它出现了 v 次，我们可以使用该字符 v / 2 * 2 次，在回文串的左侧和右侧分别放置 v / 2 个字符 ch，其中 / 为整数除法。
例如若 "a" 出现了 5 次，那么我们可以使用 "a" 的次数为 4，回文串的左右两侧分别放置 2 个 "a"。
如果有任何一个字符 ch 的出现次数 v 为奇数（即 v % 2 == 1），那么可以将这个字符作为回文中心，注意只能最多有一个字符作为回文中心。
在代码中，我们用 ans 存储回文串的长度，由于在遍历字符时，ans 每次会增加 v / 2 * 2，因此 ans 一直为偶数。
但在发现了第一个出现次数为奇数的字符后，我们将 ans 增加 1，这样 ans 变为奇数，在后面发现其它出现奇数次的字符时，我们就不改变 ans 的值了。

链接：https://leetcode.cn/problems/longest-palindrome
	 * */
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abccccdd"));
	}
    public static int longestPalindrome(String s) {
    	if (s.length() == 0) return 0;
    	int[] nums = new int[128];
    	for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			nums[c]++;
		}
    	int num = 0;
    	for (int v : nums) {
			num += v/2*2;
			if (v%2 == 1 && num%2 == 0) {
				num++;
			}
		}
    	return num;
    }
    
    
}
