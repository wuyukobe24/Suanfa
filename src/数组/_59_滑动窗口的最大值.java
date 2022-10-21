package 数组;

public class _59_滑动窗口的最大值 {

	public static void main(String[] args) {
		int[] nums = new int[]{9,11};
		int[] res = maxSlidingWindow(nums, 2);
		System.out.println("结果是：");
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	/*
	 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
	 * 
	 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
	 * 输出: [3,3,5,5,6,7] 
	 * */
    public static int[] maxSlidingWindow(int[] nums, int k) {
    	if (nums.length <= 1) return nums;
    	if (nums.length == k) {
    		int[] port = portArray(nums);
			return new int[]{port[0]} ;
		}
    	int count = nums.length;
    	int[] res = new int[count-k+1];
    	int i=0, j=k-1, max=0;
    	while (j < count) {
			if (i==0) {
				int[] aTmp = cutOut(nums, i, j);
				int[] port = portArray(aTmp);
				res[0] = port[0];
				max = port[0];
			} else {
				if (nums[j] >= max) {
					max = nums[j];
				} else {
					if (nums[i-1] == max) {
						// 重排
						int[] aTmp = cutOut(nums, i, j);
						int[] port = portArray(aTmp);
						max = port[0];
					}
				}
				res[i] = max;
			}
			i++;
			j++;
		}
    	
    	return res;
    }
    // 获取对应数据
    public static int[] cutOut(int[] nums, int left, int right) {
    	int[] tmp = new int[right+1-left]; 
		for (int i = 0; i < right+1-left; i++) {
			tmp[i] = nums[i+left];
			System.out.print(tmp[i]);
		}
    	return tmp;
	}
    // 递减排序（注意：可以改成一层循环找最大）
    public static int[] portArray(int[] nums) {
    	int[] tmp = new int[nums.length];
    	for (int i = 0; i < tmp.length; i++) {
			tmp[i] = nums[i]; 
		}
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp.length-i-1; j++) {
				if (tmp[j] < tmp[j+1]) {
					int t = tmp[j];
					tmp[j] = tmp[j+1];
					tmp[j+1] = t;
				}
			}
		}
    	return tmp;
	}
}
