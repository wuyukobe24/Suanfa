package 二分查找;

public class _072_求平方根 {

	/*
	 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。

正数的平方根有两个，只输出其中的正数平方根。

如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。

输入: x = 4
输出: 2

输入: x = 8
输出: 2
解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2

链接：https://leetcode.cn/problems/jJ0w9p
	 * */
	
	public static void main(String[] args) {
		System.out.println(mySqrt(2147395599));
	}
	
    public static int mySqrt(int x) {
    	if (x==0 || x==1) return x;
    	int i = 0, j = x, res = -1;
    	while (i<=j) {
			int mid = i+(j-i)/2;
			if ((long)mid * mid > x) {
				j=mid-1;
			} else {
				res=mid;
				i=mid+1;
			}
		}
    	return res;
    }
}
