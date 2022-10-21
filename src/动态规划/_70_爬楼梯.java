package 动态规划;

public class _70_爬楼梯 {

	/*
	 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
	 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	 * */
	public static void main(String[] args) {
		System.out.println(climbStairs2(45));
	}
	// 动态规划思路1:超时
    public static int climbStairs(int n) {
    	if (n <= 2) return n;
    	return climbStairs(n-1) + climbStairs(n-2);
    }
    // 动态规划思路2
    public static int climbStairs2(int n) {
    	int a = 0, b = 1, c = 1;
    	for (int i = 1; i < n; i++) {
			a = b;
			b = c;
			c = a+b;
		}
    	return c; 
    }
    // 动态规划思路3
    public int climbStairs3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
