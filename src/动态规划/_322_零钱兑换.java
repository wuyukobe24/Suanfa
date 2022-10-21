package 动态规划;

import java.util.Arrays;

public class _322_零钱兑换 {

	/*
	 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
	 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。你可以认为每种硬币的数量是无限的。

输入：coins = [1, 2, 5], amount = 11
输出：3 
解释：11 = 5 + 5 + 1
	 * */
	public static void main(String[] args) {
		int[] coins = new int[] {1,2,5};
		System.out.println(coinChange(coins, 11));
	}
    public static int coinChange(int[] coins, int amount) {
    	if (coins.length == 0) return -1;
    	int[] dp = new int[amount+1];
    	Arrays.fill(dp, amount+1);
    	dp[0] = 0;
    	for (int i = 1; i < amount+1; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i>=coins[j]) {
					dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
					System.out.println("dp[i] = "+dp[i]+" i = "+i);
				}
			}
		}
    	return dp[amount] == (amount+1) ? -1 : dp[amount];
    }
}
