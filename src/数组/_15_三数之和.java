package 数组;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _15_三数之和 {

	/*
	 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ， 使得 a + b + c = 0 ？请你找出所有和为 0
	 * 且不重复的三元组。 注意：答案中不可以包含重复的三元组。
	 * 
	 * 链接：https://leetcode-cn.com/problems/3sum
	 * 
	 * 输入：nums = [-1,0,1,2,-1,-4] 输出：[[-1,-1,2],[-1,0,1]]
	 */
	public static void main(String[] args) {
		int[] array = new int[] {-2,0,1,1,2};
		List<List<Integer>> res = threeSum(array);
		for (int i = 0; i < array.length; i++) {
//			System.out.println(array[i]);
		}
	}

	// -4 -1 -1 0 1 2 
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		int len = nums.length;
		if (nums == null || len < 3) return list;
		Arrays.sort(nums);
		for (int k = 0; k < len; k++) {
			if(nums[k] > 0) break;
			if(k > 0 && nums[k] == nums[k - 1]) continue;
			int i = k+1, j = len - 1;
			while (i<j) {
				int sum = nums[k] + nums[i] + nums[j];
				if (sum < 0) {
					i++;
				} else if (sum > 0) {
					j--;
				} else {
					System.out.println(nums[k] + "_" + nums[i] + "_" + nums[j]);
					list.add(Arrays.asList(nums[k], nums[i], nums[j]));
					while (i<j && nums[i] == nums[i+1]) i++;
					while (i<j && nums[j] == nums[j-1]) j--;
					i++;
					j--;
				}
			}
		}
		return list;
	}

//    public static List<List<Integer>> threeSum(int[] nums) {
//    	List<List<Integer>> list = new ArrayList<>();
//    	if (nums.length < 2) return list;
//    	for (int i = 0; i < nums.length-2; i++) {
//			for (int j = i+1; j < nums.length-1; j++) {
//				for (int j2 = j+1; j2 < nums.length; j2++) {
//					if (nums[i] + nums[j] + nums[j2] == 0) {
//						Integer[] tmp = new Integer[] {nums[i],nums[j],nums[j2]};
//						Arrays.sort(tmp);
//						List<Integer> tmpList = Arrays.asList(tmp);
//						if(!list.contains(tmpList)) {
//							list.add(tmpList);
//							System.out.println(nums[i] + "_" +  nums[j] + "_" + nums[j2]);
//						}
//					}
//				}
//			}
//		}
//    	return list;
//    }
}
