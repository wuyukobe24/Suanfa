package 数组;

public class _66_构建乘积数组 {
	public static void main(String[] args) {
		int[] tmp = new int[] {1,2,3,4,5};
		int[] res = constructArr(tmp);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	/*
	 * 给定一个数组 A[0,1,…,n-1]，
	 * 请构建一个数组 B[0,1,…,n-1]，
	 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 
	 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
	 * 不能使用除法。
	 * 
	 * 输入: [1,2,3,4,5]
	 * 输出: [120,60,40,30,24]
	 * 
	 * 解体思路：先乘左边的数，再乘右边的数，不包括自己
	 * */
    public static int[] constructArr(int[] a) {
    	int[] res = new int[a.length];
    	int left = 1, right = 1;
    	for (int i = 0; i < res.length; i++) {
			res[i] = left;
			left *= a[i];
		}
    	for (int j = a.length-1; j >= 0; j--) {
			res[j] *= right;
			right *= a[j];
		}
    	return res;
    }
    
}
