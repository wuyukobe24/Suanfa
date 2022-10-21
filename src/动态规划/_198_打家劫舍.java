package 动态规划;

public class _198_打家劫舍 {

	/*
	 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
	 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
	 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

链接：https://leetcode.cn/problems/house-robber

思路：动态规划，
如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？对于第 k (k>2) 间房屋，有两个选项：
1）偷窃第 k 间房屋，那么就不能偷窃第 k−1 间房屋，偷窃总金额为前 k−2 间房屋的最高总金额与第 k 间房屋的金额之和。
2）不偷窃第 k 间房屋，偷窃总金额为前 k−1 间房屋的最高总金额。
在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前 k 间房屋能偷窃到的最高总金额。
	 * */
	public static void main(String[] args) {
//		int[] nums = new int[] {2,7,9,3,1};
		int[] nums = new int[] {1,2,3,5};
		System.out.println(rob2(nums));
	}
    public static int rob(int[] nums) {
    	int count = nums.length;
    	if (count == 0) return 0;
    	int[] dp = new int[count+1];
    	dp[0] = 0;
    	dp[1] = nums[0];
    	for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
		}
    	return dp[count];
    }
    
    
    // 213. 打家劫舍 II
    /*
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。

思路：注意到当房屋数量不超过两间时，最多只能偷窃一间房屋，因此不需要考虑首尾相连的问题。
如果房屋数量大于两间，就必须考虑首尾相连的问题，第一间房屋和最后一间房屋不能同时偷窃。
如何才能保证第一间房屋和最后一间房屋不同时偷窃呢？如果偷窃了第一间房屋，则不能偷窃最后一间房屋，
因此偷窃房屋的范围是第一间房屋到最后第二间房屋；如果偷窃了最后一间房屋，则不能偷窃第一间房屋，因此偷窃房屋的范围是第二间房屋到最后一间房屋。

     * */
    public static int rob2(int[] nums) {
    	int count = nums.length;
    	if (count == 0) return 0;
    	if (count == 1) return nums[0];
    	if (count == 2) return Math.max(nums[0], nums[1]);
    	return Math.max(robRange(nums, 1, count-1), robRange(nums, 0, count-2));
    }
    public static int robRange(int[] nums, int left, int right) {
		int[] dp = new int[right-left+1];
		dp[0] = nums[left];
		dp[1] = Math.max(nums[left], nums[left+1]);
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-2] + nums[i+left], dp[i-1]);
			System.out.println("dp[i] = "+dp[i]+" i = "+i);
		}
    	return dp[dp.length-1];
	}
}
