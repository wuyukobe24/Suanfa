package 深度搜索优先;

public class _463_岛屿的周长 {

	/*
	 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。

网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。

岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

链接：https://leetcode-cn.com/problems/island-perimeter
	 * */
	public static void main(String[] args) {
		// System.out.println("这是"+i+"行"+j+"列");
		int[][] res = new int[][] {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
//		int[][] res = new int[][] {{1}};
		System.out.println(islandPerimeter2(res));
	}
	
	// 第二种：dfs深度搜索优先
	public static int islandPerimeter2(int[][] grid) {
    	if (grid.length == 0) return 0;
    	int m=grid.length;
    	int n=grid[0].length;
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					return dfs(grid, i, j, m, n);
				}
			}
		}
    	return 0;
	}
	public static int dfs(int[][] grid, int i, int j, int m, int n) {
		if (i<0 || i>=m || j<0 || j>=n) return 1;
		if (grid[i][j] == 0) return 1;
		if (grid[i][j] != 1) return 0;
		grid[i][j] = 2;
		return dfs(grid, i+1, j, m, n) + dfs(grid, i-1, j, m, n) + dfs(grid, i, j+1, m, n) + dfs(grid, i, j-1, m, n);
	}
	// 第一种：遍历判断
    public static int islandPerimeter(int[][] grid) {
    	if (grid.length == 0) return 0;
    	int m = grid.length;
    	int n = grid[0].length;
    	int total = 0;
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					if (i==0) {
						total++;
					} 
					if (j==0) {
						total++;
					}
					if (i==m-1) {
						total++;
					}
					if (j==n-1) {
						total++;
					}
					if (j>0 && grid[i][j-1] == 0) {//  zuo
						total++;
					} 
					if (i>0 && grid[i-1][j] == 0) { // shang
						total++;
					}
					if (j<n-1 && grid[i][j+1] == 0) { // you
						total++;
					}
					if (i<m-1 && grid[i+1][j] == 0) { // xia
						total++;
					}
				}
				
			}
		}
    	return total;
    }
}
