package 动态规划;

/*
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/

 */
public class _10_斐波那契数列 {
	public static void main(String[] args) {
		System.out.println(fib(48));
	}
    public static int fib(int n) {
    	if (n<1) return n;
    	int a = 0;
    	int b = 1;
    	int c = 1;
    	for (int i = 2; i < n; i++) {
			a = b;
			b = c;
			c = (a+b) % 1000000007;
		}
    	return c;
    } 
    
    // 2022.6.30
//    public int fib(int n) {
//    	int a=0, b=1, res=1;
//    	for (int i = 2; i < n; i++) {
//			a=b;
//			b=res;
//			res = a+b;
//		}
//    	return res;
//    }
}
