package 数组;

import java.util.HashMap;
import java.util.Iterator;

public class _56_数组中数字出现的次数 {
	public static void main(String[] args) {
		
	}
	/*
	 * 在一个数组 nums 中除一个数字只出现一次之外，
	 * 其他数字都出现了三次。请找出那个只出现一次的数字。
	 * **/
    public int singleNumber(int[] nums) {
    	HashMap<Integer, Boolean> dic = new HashMap<>();
    	for (int x : nums) {
			dic.put(x, !dic.containsKey(x));
		}
    	for (int x : nums) {
			if (dic.get(x)) return x;
		}
    	return 0;
    }
}
