package 算法;

public class _46_把数字翻译成字符串 {

	public static void main(String[] args) {
		int n = 12839;
		System.out.println(translateNum(n));
	}
	/*
	 * 给定一个数字，我们按照如下规则把它翻译为字符串：
	 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
	 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
	 * 
	 * 输入: 12258
	 * 输出: 5
	 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
	 * 
	 * 思路：有条件的动态规划
	 * */
    public static int translateNum(int num) {
    	char[] cs = Integer.toString(num).toCharArray();
    	int n = cs.length;
    	int[] dp = new int[n+1];
    	dp[0] = 1; dp[1] = 1;
    	for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1];
			if (cs[i-2] == '1' || cs[i-2] == '2' && cs[i-1] >= '0' && cs[i-1] <='5') {
				dp[i] += dp[i-2];
			}
		}
    	return dp[n];
    }
    
    // 动态规划另一种写法
    public static int translateNum2(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        int len = ch.length;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= len; i++){
            int n = (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0');
            if(n >= 10 && n <= 25){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}
