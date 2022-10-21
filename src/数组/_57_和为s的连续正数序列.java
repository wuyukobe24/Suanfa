package 数组;
import java.util.ArrayList;
import java.util.List;

public class _57_和为s的连续正数序列 {
	/*
	 * 输入一个正整数 target ，
	 * 输出所有和为 target 的连续正整数序列（至少含有两个数）。
	 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
	 * 
	 * 思路：滑动窗口
	 * */
	
    public int[][] findContinuousSequence(int target) {
    	List<int[]> res = new ArrayList<>();
    	int i=1, j=1, sum=0;
    	while (i<=target/2) {
			if (sum < target) {
				sum += j;
				j++;
			} else if (sum > target) {
				sum -= i;
				i++;
			} else {
				int[] arr = new int[j-i];
				for (int k = i; k < j; k++) {
					arr[k-i] = k; 
				}
				res.add(arr);
				// 继续往下查看是否还有
				sum -= i;
				i++;
			}
		}
        return res.toArray(new int[res.size()][]);
    }
}
