package 深度搜索优先;

public class _13_机器人的运动范围 {
	/*
	 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
	 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
	 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
	 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
	 * 
	 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
	 * */
	public static void main(String[] args) {
		System.out.println(movingCount(4, 3, 3));
	}
    public static int movingCount(int m, int n, int k) {
        boolean[][] labels = new boolean[m][n];
        return dfs(m, n, 0, 0, k, labels);
    }
    public static int dfs(int m, int n, int i, int j, int k, boolean[][] labels) {
		if (i>=m || i<0 || j>=n || j<0 || labels[i][j] || (i/10 + i%10 + j/10 + j%10 > k)) {
			return 0;
		}
		labels[i][j] = true;
		return 1+dfs(m, n, i+1, j, k,labels)+dfs(m, n, i, j+1, k,labels);
	}
}
