package 动态规划;

public class _122_买卖股票的最佳时机2 {

	/*
	 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

返回 你能获得的 最大 利润 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * */
	public static void main(String[] args) {
		int[] nums = new int[] {7,1,5,3,6,4};
		System.out.println(maxProfit(nums));
	}
	
	// 贪心算法：由于不限制交易次数，只要今天股价比昨天高，就交易。
    public static int maxProfit(int[] prices) {
    	if (prices.length < 2) return 0;
    	int max = 0;
    	for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i-1]) {
				max += prices[i] - prices[i-1];
			}
		}
    	return max;
    }
}
