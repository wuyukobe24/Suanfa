package 算法;

public class _64_求1加到n {

	/*
	 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
	 * 
	 * 思路：使用递归，但是需要有终止条件。
	 * 常见的逻辑运算符有三种，即 “与 && ”，“或 || ”，“非 ! ” ；而其有重要的短路效应，
	 * 本题需要实现 “当 n=1 时终止递归” 的需求，可通过短路效应实现。
	 * n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
	 * 
	 * https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
	 * */
	public static void main(String[] args) {
		System.out.println(sumNums2(100));
	}
	static int res = 0;
	public static int sumNums(int n) {
		Boolean x = n>1 && sumNums(n-1) > 0;
		res += n;
		return res;
	}
	
    public static int sumNums2(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

}
