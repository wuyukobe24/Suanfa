package 数组;

import java.util.HashMap;

public class _1_两数之和 {

	/*
	 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
	 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
	 * 你可以按任意顺序返回答案。
	 * 
	 * 链接：https://leetcode-cn.com/problems/two-sum
	 * */
	public static void main(String[] args) {
		int[] nums = new int[]{2,7,11,15};
		int[] res = twoSum(nums, 9);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
    public static int[] twoSum(int[] nums, int target) {
    	if (nums.length == 0) return new int[]{};
    	HashMap<Integer, Integer> dict = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
    		int tmp = target-nums[i];
    		if (dict.containsKey(tmp)) {
    	    	int[] res = new int[2];
				res[0] = i;
				res[1] = dict.get(tmp);
				return res;
			}
    		dict.put(nums[i], i);
		}
    	return new int[]{};
    }  
}
