package 算法;

public class _65_不用加减乘除做加法 {

	public static void main(String[] args) {
		
	}
	/*
	 * 写一个函数，求两个整数之和，
	 * 要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
	 * 
	 * 链接：https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/di-gui-he-fei-di-gui-liang-chong-fang-sh-as4v/
	 * */
    public int add(int a, int b) {
        int c = (a & b) << 1;//进位的值
        int d = a ^ b;//不考虑进位，相加的值
        return c | d;//或者 return c ^ d;
    }

    // 链接：https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
    public int add2(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }



}
