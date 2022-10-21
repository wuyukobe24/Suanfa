package 数组;

public class _39_数组中出现次数超过一半的数字 {
	public static void main(String[] args) {
		int[] res = new int[]{1,2,2,3,4,4,44,4,4,4,4,4,2,5,2,2,2};
		System.out.println(majorityElement(res));
	}
	/**
	 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
	 * 思路：摩尔投票法
	 * 不一样的数两两销毁，剩余的就是众数
	 */
    public static int majorityElement(int[] nums) {
    	int count = 0;
    	int card = nums[0];
    	for (int x : nums) {
			if (count == 0) {
				card = x;
				count++;
			} else {
				count += (card == x) ? +1 : -1;
			}
		}
    	return card;
    }
}
