package 数组;

import java.util.HashMap;

public class _53_在排序数组中查找数字 {
	public static void main(String[] args) {
		int[] nums = new int[]{5,7,7,8,8,8,10};
		System.out.println(search(nums, 8));
	}
	/*
	 * 统计一个数字在排序数组中出现的次数。
	 * */
    public static int search(int[] nums, int target) {
    	HashMap<Integer, Integer> dic = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
    		int num = nums[i];
			if (dic.containsKey(num)) {
				int tmp = dic.get(num);
				tmp++;
				dic.put(num, tmp);
			} else {
				dic.put(num, 1);
			}
		}
    	if (dic.containsKey(target)) {
        	return dic.get(target);
		} else return 0;
    }
}
