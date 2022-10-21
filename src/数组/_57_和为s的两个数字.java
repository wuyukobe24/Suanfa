package 数组;

import java.util.HashMap;

public class _57_和为s的两个数字 {
	public static void main(String[] args) {
		
	}
	/*
	 * 输入一个递增排序的数组和一个数字s，
	 * 在数组中查找两个数，使得它们的和正好是s。
	 * 如果有多对数字的和等于s，则输出任意一对即可。
	 * */
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Boolean> dic = new HashMap<>();
    	for (int x : nums) {
			dic.put(x, true);
		}
    	for (int x : nums) {
			int y = target - x;
			if (dic.containsKey(y)) {
				return new int[]{x,y};
			}
		}
    	return new int[0];
    }
}
