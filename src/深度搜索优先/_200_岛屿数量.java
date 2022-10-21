package 深度搜索优先;

public class _200_岛屿数量 {

	/*
	 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
	 *岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
	 *此外，你可以假设该网格的四条边均被水包围。
	 *
	 *输入：grid = [
  ['1','1','1','1','0'],
  ['1','1','0','1','0'],
  ['1','1','0','0','0'],
  ['0','0','0','0','0']
]
输出：1
	 *链接：https://leetcode.cn/problems/number-of-islands
	 *
	 *思路：使用深度优先搜索dfs。遍历每个元素，如果是1，则将其变为0，然后dfs递归将其上下左右四个方向全遍历。
	 *     当其全部变为0后返回1（说明有一个小岛）。之后依次遍历每个元素和他的上下左右。返回最后的值。
	 *题解：https://leetcode.cn/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
	 * */
	public static void main(String[] args) {
//		char[][] grid = new char[][] {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		char[][] grid = new char[][] {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
		System.out.println(numIslands(grid));
	}
    public static int numIslands(char[][] grid) {
    	if (grid.length == 0) return 0;
    	int m=grid.length;
    	int n=grid[0].length;
    	int num = 0;
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '0') continue;
				num += dfs(grid, i, j, m, n);
			}
		}
    	return num;
    }
    
    public static int dfs(char[][] grid, int i, int j, int m, int n) {
    	if (i<0 || i>=m || j<0 || j>=n) return 0;
    	if (grid[i][j] == '0') return 0; 
    	grid[i][j] = '0';
		dfs(grid, i+1, j, m, n);
		dfs(grid, i-1, j, m, n);
		dfs(grid, i, j+1, m, n);
		dfs(grid, i, j-1, m, n);
    	return 1;
    }
}
