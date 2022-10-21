package 字符串;

public class _5_最长回文子串 {

	/* 给你一个字符串 s，找到 s 中最长的回文子串。
	 * 
	 * 输入：s = "babad"
	 * 输出："bab"
	 * 解释："aba" 同样是符合题意的答案。
	 * 
	 * 
	 * 解题思路
	 * 就是开始遍历字符串，每次都已当前字符串为中心向其左右进行字符比对，若是相同则继续比对。
	 * 以此求出以当前字符串为中心的回文串的左右边界；
	 * 与最大长度进行比较，若更长则直接将最长字符串的开始换为当前的左边界；
	 * （在循环中心字符的过程中，若是此中心字符距离最后的距离不足现存最大长度的一半，直接结束循环即可）
	 * 
	 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-fa-by-rfpn3s6hcv-mnlg/
	 * */
	class Solution {
	    public String longestPalindrome(String s) {
	        if(s.length() < 2)
	            return s;
	        int start = 0;
	        int maxLen = 0;
	        int length = s.length();
	        int i = 0;
	        while(i < length){
	            if(length - i < maxLen/2)
	                break;
	            //回文串的左右边界
	            int left = i;
	            int right = i;
	            //重复字符的话直接向后右边界
	            while(right < length - 1 && s.charAt(i) == s.charAt(right+1)) right++;
	            i = right+1;//这里是中心字符的位置，原来是++；现在因为有重复字符的话则就是重复字符位置再+1

	            //计算回文串长度，由中间向两边延伸
	            while(left > 0 && right < length - 1 && s.charAt(left-1) == s.charAt(right+1)){
	                left--;
	                right++;
	            }

	            //对当前的回文串与最长回文串长度进行比较
	            if(right - left + 1 > maxLen){
	                maxLen = right - left + 1;
	                start = left;
	            }

	        }
	        return s.substring(start, start+maxLen);
	    }
	}
}
