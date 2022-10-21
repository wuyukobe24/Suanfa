package 数组;

import java.util.Arrays;

import com.sun.tools.javac.code.Attribute.Array;

public class _1979_找出数组的最大公约数 {

	/*
	 * 给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。
	 * 两个数的 最大公约数 是能够被两个数整除的最大正整数。
	 * 输入：nums = [2,5,6,9,10]
输出：2
解释：
nums 中最小的数是 2
nums 中最大的数是 10
2 和 10 的最大公约数是 2
	 * 
	 * */
	public static void main(String[] args) {
//		int[] nums = new int[] {11,5,7,9,10};
		int[] nums = new int[] {4,8};
		System.out.println(findGCD(nums));
	}
    public static int findGCD(int[] nums) {
    	if (nums.length == 0) return -1;
    	if (nums.length == 1) return nums[0];
    	int a = 1, b = 1;
    	if (nums.length == 2) {
			a = nums[0];
			b = nums[1];
		} else {
			Arrays.sort(nums);
			a = nums[0];
			b = nums[nums.length-1];
		}
    	int res = 1;
    	for (int i = 1; i <= a; i++) {
			if (a%i == 0 && b%i == 0) {
				res = i;
			}
		}
    	return res;
    }
	
}
