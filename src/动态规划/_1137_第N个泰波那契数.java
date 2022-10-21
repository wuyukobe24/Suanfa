package 动态规划;

public class _1137_第N个泰波那契数 {

	/*
	 * 泰波那契序列 Tn 定义如下： 
	 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
	 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
	 * 
	 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
	 * */
	public static void main(String[] args) {
		
	}
    public int tribonacci(int n) {
    	if (n <= 1) return n;
    	if (n == 2) return 1;
    	int[] dp = new int[n+1];
    	dp[0] = 0;
    	dp[1] = 1;
    	dp[2] = 1;
    	for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
    	return dp[n];
    }
    
    //2022.6.30
	public static int tribonacci2(int n) {
    	if (n <= 1) return n;
    	if (n == 2) return 1;
		int a = 0, b = 1, c = 1, res = 2;
		for (int i = 3; i < n; i++) {
			a = b;
			b = c;
			c = res;
			res = a + b + c;
		}
		return res;
	}
	
}
