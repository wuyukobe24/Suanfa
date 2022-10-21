package 数组;

import java.util.HashMap;

public class _53_0_n_1中缺失的数字 {

	public static void main(String[] args) {
		int[] nums = new int[]{0};
		System.out.println(missingNumber(nums));
	}
	/*
	 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
	 * 并且每个数字都在范围0～n-1之内。
	 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
	 * */
	
    public static int missingNumber(int[] nums) {
    	HashMap<Integer, Boolean> dic = new HashMap<>();
    	for (int i : nums) {
			dic.put(i, true);
		}
    	int n = nums[nums.length-1];
    	for (int i = 0; i <= n; i++) {
			if (!dic.containsKey(i)) return i;
		}
    	return n+1;
    }
}

