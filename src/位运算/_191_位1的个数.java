package 位运算;

public class _191_位1的个数 {

	/*
	 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
	 * 输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。

链接：https://leetcode.cn/problems/number-of-1-bits
	 * 
	 * 思路：利用 n = n&(n-1)的操作，不断清除最后一位1，直到n为0
	 * */
	
	public static void main(String[] args) {
		System.out.println(hammingWeight(100));
	}
    public static int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
			sum++;
			n &= n-1;
			System.out.println("n= "+n);
		}
    	return sum;
    }
    
    // 231. 2 的幂
    // 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
    // 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
    public boolean isPowerOfTwo(int n) {
    	return n>0 && (n&(n-1))==0;
    }
}
