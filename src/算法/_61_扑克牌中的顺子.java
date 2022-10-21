package 算法;

import java.util.Arrays;
import java.util.HashMap;

public class _61_扑克牌中的顺子 {
	
	/*
	 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
	 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
	 * 
	 * 输入: [0,0,1,2,5]
	 * 输出: True
	 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
	 * 
	 * 思路：
	 * 1、从小到大排序，
	 * 2、遍历，记录0的数量，若有相同，则返回false
	 * 3、遍历完成，校验最后一个和不是0的第一位的差是否小于5
	 * */
	public static void main(String[] args) {
		
	}
    public boolean isStraight(int[] nums) {
    	int joker = 0;
    	Arrays.sort(nums);
    	for (int i = 0; i < 4; i++) {
			if (nums[i] == 0) {
				joker++;
			} else if (nums[i] == nums[i+1]) {
				return false;
			}
		}
    	return nums[4] - nums[joker] < 5;
    }
    
}
