package 数组;

public class _49_丑数 {

//	public static void main(String[] args) {
//		System.out.println(nthUglyNumber(11));
//	}
	/*
	 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
	 * 求按从小到大的顺序的第 n 个丑数。
	 * 
	 * 输入: n = 10
	 * 输出: 12
	 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
	 * */
    public static int nthUglyNumber(int n) {
    	int[] res = new int[n+1];
    	res[1] = 1;
    	int x2 = 1, x3 = 1, x5 = 1;
    	for (int j = 2; j <= n; j++) {
        	int num = Math.min(Math.min(res[x2] * 2, res[x3] * 3), res[x5] * 5);
        	res[j] = num;
        	if (res[x2] * 2 == num) x2++;
        	if (res[x3] * 3 == num) x3++;
        	if (res[x5] * 5 == num) x5++;
        	System.out.println(num);
        	System.out.println(x2);
        	System.out.println(x3);
        	System.out.println(x5);
        	System.out.println(" ");
		}
    	return res[n];
    }

}
/*
1  1 
2  2 x2++ 1 1 1
3  3 x3++ 2 1 1
4  4 x2++ 2 2 1
5  5 x3++ 3 2 1
6  6 x2++ 3 3 2 
7  8 x1++ 4 3 2
8  9 x2++ 5 3 2
9  10 x1++ 5 4 2
10 12 x1++ 6 4 3
11 14 x1++ 7 5 3
12 3x5 x1++ 8 5 3
13 8x2 x1++ 8 6 4 
14 9x2 x1++ 10 7 4
15 10x2 x1++ 10 7 5
*/