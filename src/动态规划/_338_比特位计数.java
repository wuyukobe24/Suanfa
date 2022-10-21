package 动态规划;

import java.util.HashSet;
import java.util.Set;

public class _338_比特位计数 {

	/*
	 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
	 * 返回一个长度为 n + 1 的数组 ans 作为答案。
	 * 
	 * 输入：n = 5
	 * 输出：[0,1,1,2,1,2]
	 * 解释：
	 * 0 --> 0
	 * 1 --> 1
	 * 2 --> 10
	 * 3 --> 11
	 * 4 --> 100
	 * 5 --> 101
	 * 
	 * 思路：
	 * 从0开始，
	 * res[0] = 0;
	 * res[1] = 1;
	 * 之后判断奇偶，偶数则等于其一半的值，即res[2] = res[1] = 1;
	 * 奇数则等于其上一个值加一（二进制遇2进位，多1则加一）
	 * 
	 * 链接：https://leetcode-cn.com/problems/counting-bits
	 * */
	public static void main(String[] args) {
		int[] res = countBits2(10);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
    public static int[] countBits(int n) {
    	int[] res = new int[n+1];
    	for (int i = 0; i < res.length; i++) {
			if (i==0) {
				res[i] = 0;
			} else if (i==1) {
				res[i] = 1;
			} else if (i%2 == 0) {
				res[i] = res[i/2];
			} else {
				res[i] = res[i-1] + 1;
			}
		}
    	return res;
    }
    
    // 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
    // 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
    public static int[] countBits2(int n) {
    	int[] dp = new int[n+1];
    	dp[0] = 0;
    	for (int i = 1; i < dp.length; i++) {
			if (i%2 == 0) {
				dp[i] = dp[i/2];
			} else {
				dp[i] = dp[i-1] + 1;
			}
		}
    	return dp;
    }
    
    // 面试题 16.17. 连续数列
    // 给定一个整数数组，找出总和最大的连续数列，并返回总和。
    public int maxSubArray(int[] nums) {
    	if (nums.length == 0) return 0;
    	int prv = 0, max = nums[0];
    	for (int num : nums) {
			prv = Math.max(prv+num, num);
			max = Math.max(max, prv);
		}
    	return max;
    }
    
    // 剑指 Offer II 119. 最长连续序列
    // https://leetcode.cn/problems/WhsWhI/
    // 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    //
    // 输入：nums = [100,4,200,1,3,2]
    // 输出：4
    // 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
	
    public int longestConsecutive(int[] nums) {
    	if (nums.length == 0) {
			return 0;
		}
    	Set<Integer> set = new HashSet<>();
    	for (int num : nums) {
			set.add(num);
		}
    	int max = 0;
    	for (int num : nums) {
			if (!set.contains(num-1)) {
	        	int prv = num;
	        	int count = 1;
				while (set.contains(prv+1)) {
					prv++;
					count++;
				}
				max = Math.max(max, count);
			}
		}
    	return max;
    }
    
}
