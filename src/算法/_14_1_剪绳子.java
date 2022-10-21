package 算法;

import java.util.Iterator;

public class _14_1_剪绳子 {
	public static void main(String[] args) {
		int n = 120;
		System.out.println("dp:" + cuttingRope(n));
		System.out.println(cuttingRope2(n));
	}
	
	// 动态规划
	/* 思路
       对于的长度为n的绳子，当 n ≥ 2 时，可以剪成至少两个绳子。
       令 k 是剪出的第一段绳子，则剩下的部分是 n−k，n−k 可以不继续剪，
       或者继续剪成至少两段绳子（一个问题可以分解为相似的子问题因此想到动态规划）。
       由于每个绳子长度对应的最大乘积取决于比它小的绳子对应的最大乘积，因此可以使用动态规划求解。
       链接：https://leetcode.cn/problems/jian-sheng-zi-lcof/solution/by-nehzil-w61p/
	 * */
    public static int cuttingRope(int n) {
    	int[] dp = new int[n+1];
    	dp[2] = 1;
    	for (int i = 3; i < n+1; i++) {
			for (int j = 2; j < i; j++) {
				dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
			}
		}
    	return dp[n];
    }
    
    // 尽可能把绳子分成长度为3的小段，这样乘积最大
	public static int cuttingRope2(int n) {
		if (n==2) return 1;
		if (n==3) return 2;
		if (n==4) return 4;
		int left = n/3;
		int right = n%3;
		if (right == 1) {
			return (int)Math.pow(3, left-1) * 4;
		} else if (right == 2) {
			return (int)Math.pow(3, left) * 2;
		} else {
			return (int)Math.pow(3, left);
		}
	}
	
}
