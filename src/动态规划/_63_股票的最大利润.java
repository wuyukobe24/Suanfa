package 动态规划;

import java.util.Iterator;

public class _63_股票的最大利润 {

	/*
	 * 假设把某股票的价格按照时间先后顺序存储在数组中，
	 * 请问买卖该股票一次可能获得的最大利润是多少？
	 * 
	 * 输入: [7,1,5,3,6,4]
	 * 输出: 5
	 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
	 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
	 * 
	 * 输入: [7,6,4,3,1]
	 * 输出: 0
	 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
	 * 
	 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
	 * */

	public static void main(String[] args) {
		int[] arr = new int[] {1,2};
		System.out.println(maxProfit(arr));
	}
	// 1、暴力解法
    public static int maxProfit(int[] prices) {
    	if (prices.length <= 1) return 0;
    	int n = prices.length;
    	int[] res = new int[n];
    	for (int i = 0; i < n; i++) {
    		res[i] = 0;
			for (int j = i+1; j < n; j++) {
				if (prices[j]-prices[i] > res[i]) {
					res[i] = prices[j]-prices[i];
				}
			}
		}
		for (int j = 0; j < res.length-1; j++) {
			if (res[j] > res[j+1]) {
				int tmp = res[j];
				res[j] = res[j+1];
				res[j+1] = tmp;
			}
		}
    	return res[n-1];
    }
    // 2、动态规划 [7,1,5,3,6,4]
    // 思路：一次遍历，每次记住买入最小值，用当前价格减去最小值，获取当前利润，和之前最大利润比较，取最大值即可。
    public static int maxProfit2(int[] prices) {
    	int cost = Integer.MAX_VALUE, prifit = 0;
    	for (int price : prices) {
			cost = Math.min(cost, price);
			prifit = Math.max(prifit, price-cost);
		}
    	return prifit;
    }
}
