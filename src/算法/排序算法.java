package 算法;

public class 排序算法 {
	public static void main(String[] args) {
		int[] nums = new int[]{4,5,1,9,3,6,8,7,0};
		// 冒泡排序
//		int[] res = maopaoPort(nums);
		// 选择排序
//		int[] res = selectPort(nums);
		// 快速排序
//		int[] res = quickPort(nums,0,nums.length-1);
//		for (int i = 0; i < res.length; i++) {
//			System.out.println(res[i]);
//		}
		
		int[] nums2 = new int[]{1,2,4,6,7,8,9,13,19};
//		// 二分查找
		System.out.println(erfenPort(nums2, 9));
	}
	
	// 冒泡排序
	public static int[] maopaoPort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		return nums;
	}
	 
	// 选择排序
	public static int[] selectPort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		return nums;
	}
	
	// 快速排序
	/*
	 * 快排在最糟糕得情况下时间复杂度是O(n²)，平均的复杂度是O(nlogn)，
	 * 这里的n和logn, 分别代表了调用栈的高度，和完成每层的时间，在a取
	 * 数组的第一项时候，是最糟的情况，完成每层需要的时间是n，栈的高读是n，
	 * 时间复杂度就是n²，当取中间的值得时候，完成每层的时间是n，
	 * 但是调用栈的高度变成了logn，所以这个时候时间复杂度是nlogn
	 * **/
	public static int[] quickPort(int[] nums, int left, int right) {
		if (left >= right) return null;
		int i = left;
		int j = right;
		int key = nums[left];
		while (i < j) {
			while (i < j & nums[j] >= key) {
				j--;
			}
			nums[i] = nums[j];
			while (i < j & nums[i] <= key) {
				i++;
			}
			nums[j] = nums[i];
		}
		nums[i] = key;
		quickPort(nums, left, i-1);
		quickPort(nums, i+1, right);
		return nums;
	}
	
	// 希尔排序
	public static int[] shellPort(int[] nums) {
		if (nums.length <= 1) return nums;
		int count = nums.length;
		for (int d = count/2; d > 0; d /= 2) {
			for (int i = d; i < count; i++) {
				for (int j = i-d; j >= 0; j -= d) {
					if (nums[j] > nums[j+d]) {
						int tmp = nums[j];
						nums[j] = nums[j+d];
						nums[j+d] = tmp;
					}
				}
			}
		}
		return nums;
	}
	
	// 二分查找
	// 条件：⼆分查找针对的是有序数据.时间复杂度O(logn)
	public static int erfenPort(int[] nums, int target) {
		int i=0, j=nums.length-1;
		while (i<=j) {
			int mid = i+(j-i)/2;
			if (nums[mid] == target) {
				return nums[mid];
			} else if (nums[mid] > target) {
				j = mid-1;
			} else {
				i = mid+1;
			}
		}
		return 0;
	}
}
