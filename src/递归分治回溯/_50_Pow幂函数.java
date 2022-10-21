package 递归分治回溯;

public class _50_Pow幂函数 {

	/*
	 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
	 * 
	 * 输入：x = 2.00000, n = 10  输出：1024.00000
	 * 
	 * 输入：x = 2.00000, n = -2 输出：0.25000   
	 * 解释：2-2 = 1/22 = 1/4 = 0.25
	 * 
	 * 思路：分治法，求x^n可以拆分为求 x^n/2，然后根据n奇偶判断x^n 等于 x^n/2 乘以 x^n/2 是否需要再乘以自身x。
	 * */
	public static void main(String[] args) {
		System.out.println(myPow(2, -3));
	}
    public static double myPow(double x, int n) {
    	return n>0 ? halfPow(x, n) : 1/halfPow(x, n);
    }
    public static double halfPow(double x, int n) {
    	if (n==0) return 1.0;
    	double res = 1;
    	double half = halfPow(x, n/2);
    	if (n%2==0) {
			res = half * half;
		} else {
			res = half * half * x;
		}
    	return res;
	}
}
