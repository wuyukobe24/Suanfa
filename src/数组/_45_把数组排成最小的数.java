package 数组;

public class _45_把数组排成最小的数 {

	public static void main(String[] args) {
		int[] arr = new int[]{3,30,34,5,9};
		System.out.println(minNumber(arr));
	}
	/*
	 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，
	 * 打印能拼接出的所有数字中最小的一个。
	 * 
	 * 思路：本题其实是一道排序题，为什么这么说呢，
	 * 因为这道题不就是需要我们将这些数按照一定的顺序排好，
	 * 然后将所有数拼接起来，组成一个最小的数。
	 * 不过排序规则需要我们根据题目来自定义。
	 * 本题我是通过多写几个例子发现排序规则的。
	 * 例如【30, 3】, "30" + "3" = 303 < "3" + "30" = 330,
	 * 所以 30 应该排在 3 前面。因此排序规则如下
	 * （这里的+是拼接的意思，并不是运算符+）：
	 * 如果 x+y < y+x 则 x "小于" y , 即 x 应该排在 y 前面。
	 * 如果 y+x < x+y 则 x "大于" y , 即 x 应该排在 y 后面。
	 * */
    public static String minNumber(int[] nums) {
    	String[] strs = new String[nums.length];
    	for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
    	for (int i = 0; i < strs.length; i++) {
			for (int j = 0; j < strs.length-1-i; j++) {
				if ((strs[j]+strs[j+1]).compareTo(strs[j+1]+strs[j]) > 0) {
					String tmp = strs[j];
					strs[j] = strs[j+1];
					strs[j+1] = tmp;
				}
			}
		}
    	String res = "";
    	for (String string : strs) {
			res += string;
		}
    	return res;
    }
}
