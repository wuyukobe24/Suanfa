package 二分查找;

public class _33_搜索旋转排序数组 {

	/*
	 * 整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4

链接：https://leetcode.cn/problems/search-in-rotated-sorted-array

解题思路：
题目要求 O(logN)O(logN) 的时间复杂度，基本可以断定本题是需要使用二分查找，怎么分是关键。
由于题目说数字了无重复，举个例子：
1 2 3 4 5 6 7 可以大致分为两类，
第一类 2 3 4 5 6 7 1 这种，也就是 nums[start] <= nums[mid]。此例子中就是 2 <= 5。
这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
第二类 6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2。
这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]，则在后半部分找，否则去前半部分找。

作者：reedfan
链接：https://leetcode.cn/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
	 * */
	public static void main(String[] args) {
		int[] nums = new int[] {4,5,6,7,0,1,2};
		System.out.println(search(nums, 0));
	}
    public static int search(int[] nums, int target) {
    	if (nums.length == 0) return -1;
    	int i=0, j=nums.length-1;
    	int mid;
    	while (i<=j) {
    		mid = i+(j-i)/2;
			if (nums[mid] == target) {
				return mid;
			} 
			// 前半部分有序
			if (nums[i] <= nums[mid]) {
				// target在前半部分
				if (nums[mid] > target && target >= nums[i]) {
					j=mid-1;
				} else {
					i=mid+1;
				}
			} else { // 后半部分有序
				// target在后半部分
				if (nums[mid] < target && target <= nums[j]) {
					i=mid+1;
				} else {
					j=mid-1;
				}
			}
		}
    	return -1;
    }
}
