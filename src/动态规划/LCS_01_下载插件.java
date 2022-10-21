package 动态规划;

public class LCS_01_下载插件 {

	/*
	 * 小扣打算给自己的 VS code 安装使用插件，初始状态下带宽每分钟可以完成 1 个插件的下载。假定每分钟选择以下两种策略之一:

使用当前带宽下载插件
将带宽加倍（下载插件数量随之加倍）
请返回小扣完成下载 n 个插件最少需要多少分钟。

注意：实际的下载的插件数量可以超过 n 个

示例 1：
输入：n = 2

输出：2

解释：
以下两个方案，都能实现 2 分钟内下载 2 个插件

方案一：第一分钟带宽加倍，带宽可每分钟下载 2 个插件；第二分钟下载 2 个插件
方案二：第一分钟下载 1 个插件，第二分钟下载 1 个插件

链接：https://leetcode-cn.com/problems/Ju9Xwi

思路：就拿四个下载量来举个例子
下载四个插件的方法有：一个一个的下载：所以dp[4]=dp[3]+1
翻倍后下载：第一天不下载：下载量2个 第2天不下载：下载量4个 第3天直接下载
也就是下载量为n/2的那天不下载然后花一天下载 dp[4]=dp[2]+1
所以先加倍的方程为：零件数目减半所花的时间加上1天 因为/是整除所以下加上1 可以想象3个零件减半所化的时间应该是2个零件而且不是一个 依次类推 dp[i]=d[(i+1)/2]+1;
所以就可以的到动态规划转移方程：dp[i]=Math.min(dp[i-1]+1,dp[(i+1)/2]+1)

	 * */
	public static void main(String[] args) {
		System.out.println(leastMinutes(10));
	}
    public static int leastMinutes(int n) {
    	if (n<=1) return n;
    	int[] dp = new int[n+1];
    	dp[1] = 1;
    	for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.min(dp[i-1]+1, dp[(i+1)/2]+1);
		}
    	return dp[n];
    }
}
