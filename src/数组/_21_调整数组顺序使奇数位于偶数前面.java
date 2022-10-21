package 数组;


/*
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4] 
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class _21_调整数组顺序使奇数位于偶数前面 {
	public static void main(String[] args) {
//		int[] nums = new int[]{1,2,3,4,5};
//		System.out.println(exchange(nums));
		int[] nums = new int[]{4,2,9,1,5};
		System.out.println(getLeastNumbers2(nums,3));
	}
    public static int[] exchange(int[] nums) {
    	int left = 0;
    	int right = nums.length-1;
    	int[] newNums = new int[nums.length];
    	for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				System.out.println("right = " + right);
				newNums[right] = nums[i];
				right--;
			} else {
				System.out.println("left = " + left);
				newNums[left] = nums[i];
				left++;
			}
		}
    	return newNums;
    }
    /**输入整数数组 arr ，找出其中最小的 k 个数。
     * 例如，输入4、5、1、6、2、7、3、8这8个数字，
     * 则最小的4个数字是1、2、3、4。
     * */
    // 冒泡排序
    public static int[] getLeastNumbers(int[] arr, int k) {
    	if (arr.length == 0 || arr.length <= k) return arr;
    	int[] res = new int[k]; 
    	for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
    	System.out.println(arr);
    	for (int i = 0; i < k; i++) {
			res[i] = i;
		}
    	System.out.println(res);
    	return res;
    }
    
    // 选择排序
    public static int[] getLeastNumbers2(int[] arr, int k) {
    	if (arr.length == 0 || arr.length <= k) return arr;
    	int[] res = new int[k]; 
    	for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
    	System.out.println(arr);
    	for (int i = 0; i < k; i++) {
			res[i] = i;
		}
    	System.out.println(res);
    	return res;
    }
}
