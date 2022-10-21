package 动态规划;

public class _088_爬楼梯的最少成本 {

	/*
	 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
	 * 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
	 * 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
	 * 
	 * 思路：由于可以选择下标 00 或 11 作为初始阶梯，
	 * 因此有 dp[0]=dp[1]=0。
	 * 当 2≤i≤n 时，可以从下标 i−1 使用 cost[i−1] 的花费达到下标 i，
	 * 或者从下标i−2 使用 cost[i−2] 的花费达到下标 ii。为了使总花费最小，dp[i] 应取上述两项的最小值，

	 * 链接：https://leetcode-cn.com/problems/GzCJIP
	 * */
    public int minCostClimbingStairs(int[] cost) {
    	int n = cost.length;
    	int[] dp = new int[n+1];
    	dp[0] = dp[1] = 0;
    	for (int i = 2; i <= n; i++) {
			dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
		}
    	return dp[n];
    }
    
    // 2022.6.30
//    public int minCostClimbingStairs(int[] cost) {
//    	if (cost.length <= 1) return 0;
//    	int[] res = new int[cost.length];
//    	res[0] = cost[0];
//    	for (int i = 1; i < cost.length; i++) {
//			if (i==1) {
//				res[i] = cost[i];
//			} else {
//				res[i] = Math.min(res[i-1], res[i-2]+1);
//			}
//		}
//    	return res[res.length-1];
//    }
}
