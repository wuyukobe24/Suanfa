package 动态规划;

public class _098_路径的数目 {

	/*
	 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
	 * 
	 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
	 * 
	 * 问总共有多少条不同的路径？
	 * 
	 * 输入：m = 3, n = 7 输出：28
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/2AoeFn
	 */
	public static void main(String[] args) {
//		System.out.println(uniquePaths(20, 20));
		
//		int[][] res = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
		int[][] res = new int[][] {{1,0}};
		System.out.println(uniquePathsWithObstacles(res));
	}

	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++)
			dp[i][0] = 1;
		for (int i = 0; i < n; i++)
			dp[0][i] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	/*
	 * 63. 不同路径 II 
	 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
	 * 
	 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
	 * 
	 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
	 * 
	 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/unique-paths-ii
	 */

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		// 为什么 obstacleGrid[i][0] == 0 要放在for循环条件里，而放在for循环里就不行
		for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					dp[i][j] = (dp[i-1][j] + dp[i][j-1]);
				}
			}
		}
		return dp[m-1][n-1];
	}
}
