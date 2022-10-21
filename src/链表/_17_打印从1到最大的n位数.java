package 链表;

import java.util.Iterator;

public class _17_打印从1到最大的n位数 {
	public static void main(String[] args) {
		
	}
    public int[] printNumbers(int n) {
    	if (n==0) return new int[0];
    	int num = 1;
    	for (int i = 0; i < n; i++) {
			num *= 10;
		}
    	int[] res = new int[num-1];
    	for (int i = 1; i <= num-1; i++) {
			res[i-1] = i;
		}
    	return res;
    }
}
