package 动态规划;

import java.util.Iterator;

public class _42_连续子数组的最大和 {

	public static void main(String[] args) {
		int[] res = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray2(res));
	}
	/*输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
	 * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
	 * 使用动态规划
	 * 
	 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
	 * 输出: 6
	 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	 * */
	
    public static int maxSubArray(int[] nums) {
    	int pre = 0, maxNum = nums[0];
    	for (int num : nums) {
			pre = Math.max(pre + num, num);
			maxNum = Math.max(pre, maxNum);
		}
    	return maxNum;
    }
    
    public static int maxSubArray2(int[] nums) {
    	int count = nums.length;
    	if (count == 0) return -1;
    	int[] dp = new int[count];
    	dp[0] = nums[0];
    	int max = nums[0];
    	for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
			max = Math.max(max, dp[i]);
    		System.out.println("i = " + i + "  dp[i] = "+dp[i]);
		}
    	return max;
    }
  
}
