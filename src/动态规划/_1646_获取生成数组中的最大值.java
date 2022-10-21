package 动态规划;

public class _1646_获取生成数组中的最大值 {

	/*
	 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
	 * nums[0] = 0
	 * nums[1] = 1
	 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
	 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
	 * 返回生成数组 nums 中的 最大 值。
	 * 
	 * 思路：动态规划
	 * 
	 * 链接：https://leetcode-cn.com/problems/get-maximum-in-generated-array
	 * */
	public static void main(String[] args) {
		System.out.println(getMaximumGenerated(3));
	}
    public static int getMaximumGenerated(int n) {
    	if (n<=1) return n;
    	int[] dp = new int[n+1];
    	dp[0] = 0;
    	dp[1] = 1;
    	int max = 1;
    	for (int i = 2; i < dp.length; i++) {
			if (i%2 == 0) {
				dp[i] = dp[i/2];
			} else {
				dp[i] = dp[(i-1)/2] + dp[(i+1)/2];
			}
			max = Math.max(max, dp[i]);
		}
    	return max;
    }
}
