package 数组;

import java.util.HashSet;
import java.util.Set;

public class _119_最长连续序列 {

	/*
	 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
	 * 输入：nums = [100,4,200,1,3,2]
	 * 输出：4
	 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
	 * 
	 * 思路：首先所有元素存入hashset；
	 * 然后遍历哈希表，若发现比当前元素小1的元素存在于哈希表中，说明此元素不是开头，则跳过。
	 * 找到开头元素，一直递增（每次+1）到hashset中不包含为止。 此为连续序列。
	 * 遍历过程中记录参数即可。
	 * 
	 * 链接：https://leetcode.cn/problems/WhsWhI/solution/jian-zhi-offer-by-wan-jia-guo-du-ib5m/
	 * */
	
    public int longestConsecutive(int[] nums) {
    	if (nums.length == 0) {
			return 0;
		}
    	Set<Integer> set = new HashSet<>();
    	for (int num : nums) {
			set.add(num);
		}
    	int max = 0;
    	for (int num : nums) {
			if (!set.contains(num-1)) {
	        	int prv = num;
	        	int count = 1;
				while (set.contains(prv+1)) {
					prv++;
					count++;
				}
				max = Math.max(max, count);
			}
		}
    	return max;
    }
}
