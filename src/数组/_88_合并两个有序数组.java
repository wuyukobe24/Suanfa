package 数组;
import java.util.Arrays;

public class _88_合并两个有序数组 {

	/*
	 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
	 * 分别表示 nums1 和 nums2 中的元素数目。
	 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
	 * 
	 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
	 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。
	 * nums2 的长度为 n 。
	 * 
	 * 思路1：nums2插入nums1中 再排序
	 * 
	 * 思路2:方法一没有利用数组nums1与nums2已经被排序的性质。
	 * 为了利用这一性质，我们可以使用双指针方法。
	 * 这一方法将两个数组看作队列，每次从两个数组头部取出比较小的数字放到结果中。
	 * 我们为两个数组分别设置一个指针p1 p2来作为队列的头部指针。
	 * 
	 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
	 * */
	
	// 题解1
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	if (n==0) return;
    	for (int i = 0; i < n; i++) {
			nums1[m+i] = nums2[i];
		}
    	Arrays.sort(nums1);
    }
    
    // 题解2
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

}
