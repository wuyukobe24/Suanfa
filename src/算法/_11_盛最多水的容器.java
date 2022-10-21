package 算法;


public class _11_盛最多水的容器 {

	/*
	 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
	 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
	 * 返回容器可以储存的最大水量。
	 * 说明：你不能倾斜容器。
	 * 
	 * 链接：https://leetcode-cn.com/problems/container-with-most-water
	 * */
	public static void main(String[] args) {
		int[] array = new int[]{1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(array));
	}
	public static int maxArea(int[] height) {
		int left = 0, right = height.length-1;
		int max = 0, num = 0;
		while (left < right) {
			num = height[left] > height[right] ? height[right]*(right-left) : height[left]*(right-left);
			max = Math.max(max, num);
			System.out.println("max:"+max);
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return max;
	}
	
	// 暴力解法 超时
//    public static int maxArea(int[] height) {
//    	int max = 0;
//    	int num = 0;
//    	int count = height.length;
//    	for (int i = 0; i < count; i++) {
//			for (int j = i+1; j < count; j++) {
//				num = height[i] > height[j] ? height[j]*(j-i) : height[i]*(j-i);
//				max = Math.max(max, num);
//			}
//		}
//    	return max;
//    }
}
