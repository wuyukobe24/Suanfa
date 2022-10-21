package 动态规划;
import java.util.Arrays;
import java.util.List;

public class _120_三角形最小路径和 {

	/*
	 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
	 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
	 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
	 * */
	public static void main(String[] args) {
//		int[][] res = new int[][] {{2},{3,4},{6,5,7},{4,1,8,3}};
		List<Integer> res1 = Arrays.asList(2);
		List<Integer> res2 = Arrays.asList(3,4);
		List<Integer> res3 = Arrays.asList(6,5,7);
		List<Integer> res4 = Arrays.asList(4,1,8,3);
		List<List<Integer>> list = Arrays.asList(res1,res2,res3,res4);
		System.out.println(minimumTotal(list));
	}
    public static int minimumTotal(List<List<Integer>> triangle) {
    	int count = triangle.size();
    	int[] dp = new int[count+1];
    	for (int i = count-1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				System.out.println("j:"+dp[j]+" j+1:"+dp[j+1]);
				dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
			}
		}
    	return dp[0];
    }
}
