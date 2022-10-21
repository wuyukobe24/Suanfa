package 动态规划;

public class _47_礼物的最大价值 {

	public static void main(String[] args) {
		int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(maxValue(arr));
	}
	/*
	 * 在一个 m*n 的棋盘的每一格都放有一个礼物，
	 * 每个礼物都有一定的价值（价值大于 0）。
	 * 你可以从棋盘的左上角开始拿格子里的礼物，
	 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。
	 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
	 * 
	 * 输入: 
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物


解题思路：
题目说明：从棋盘的左上角开始拿格子里的礼物，并每次 向右 或者 向下 移动一格、直到到达棋盘的右下角。
根据题目说明，易得某单元格只可能从上边单元格或左边单元格到达。

设 f(i, j)为从棋盘左上角走至单元格 (i ,j)的礼物最大累计价值，
易得到以下递推关系：f(i,j) 等于 f(i,j-1) 和 f(i-1,j)中的较大值加上当前单元格礼物价值 grid(i,j) 。

f(i,j)=max[f(i,j−1),f(i−1,j)]+grid(i,j)

因此，可用动态规划解决此问题，以上公式便为转移方程。
	 * */
	
    public static int maxValue(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i==0 && j==0) {
					continue;
				} else if (i==0) {
					grid[i][j] += grid[i][j-1];
				} else if (j==0) {
					grid[i][j] += grid[i-1][j];
				} else {
					grid[i][j] += Math.max(grid[i][j-1], grid[i-1][j]);
				}
			}
		}
    	return grid[m-1][n-1];
    }
}
