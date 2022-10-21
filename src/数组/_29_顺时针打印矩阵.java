package 数组;

/*
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 
 * 思路：

根据题意，需要特判，对于空矩阵直接返回空数组。
接下来：

定义出二维数组的左右上下四个边界，left、right、top、bottom;
循环打印：
沿着top，从左向右打印，top++;
沿着right,从上向下打印，right--;
沿着bottom，从右向左打印，bottom++；
沿着left,从下向上打印，left++;
注：在沿着下边界和左边界打印时，要确保left <= right，top <= bottom。
 * */
public class _29_顺时针打印矩阵 {
	public static void main(String[] args) {
		int[][] board = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[] res = spiralOrder(board);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
    public static int[] spiralOrder(int[][] matrix) {
        //特判
        if(matrix == null ||matrix.length == 0){
            return new int[0];
        }
        
        //初始化
        int left = 0, top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length - 1;
        int[] res = new int[(right+1)*(bottom+1)];
        int k = 0;
        
        //循环打印
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){ //从左到右
                res[k++] = matrix[top][i];
            }
            top ++;
            for(int i = top; i <= bottom; i++){ //从上到下
                res[k++] = matrix[i][right];
            }
            right --;
            for(int i = right; i >= left && top <= bottom; i--){    //从右到左
                res[k++] = matrix[bottom][i];
            }
            bottom --;
            for(int i = bottom; i >= top && left <= right; i--){    //从下到上
                res[k++] = matrix[i][left];
            }
            left ++;
        }
        return res;
    }

    // 无法向上
//    public static int[] spiralOrder(int[][] matrix) {
//    	if (matrix.length == 0) return new int[0];
//    	int n = matrix.length;
//    	int m = matrix[0].length;
//    	int x = 0, y = 0, index = 0;
//    	int[] res = new int[m*n];
//    	boolean[][] sign = new boolean[n][m];
//    	
//    	res[0] = matrix[0][0];
//    	index++;
//    	sign[0][0] = true;
//    	while (x < m && x >= 0 && y < n && y >= 0) {
//			if (x+1 < m && x+1 >= 0 && y < n && y >= 0 && !sign[y][x+1]) { // 右
//				res[index] = matrix[y][x+1];
//				sign[y][x+1] = true;
//				System.out.println("右x = " + x);
//				x++;
//				index++;
//			}  else if (x < m && x >= 0 && y+1 < n && y+1 >= 0 && !sign[y+1][x]) { // 下
//				res[index] = matrix[y+1][x];
//				sign[y+1][x] = true;
//				System.out.println("下y = " + y);
//				y++;
//				index++;
//			} else if (x-1 < m && x-1 >= 0 && y < n && y >= 0 && !sign[y][x-1]) { // 左
//				res[index] = matrix[y][x-1];
//				sign[y][x-1] = true;
//				System.out.println("左x = " + x);
//				x--;
//				index++;
//			} else if (x < m && x >= 0 && y-1 < n && y-1 >= 0 && !sign[y-1][x]) { // 上
//				res[index] = matrix[y-1][x];
//				sign[y-1][x] = true;
//				System.out.println("上y = " + y);
//				y--;
//				index++;
//			} else {
//				System.out.println("x = " + x);
//				System.out.println("y = " + y);
//				break;
//			}
//			System.out.println("index = " + index);
//		}
//    	return res;
//    }
    
    // 2022.2.16 复习
    public static int[] spiralOrder2(int[][] matrix) {
    	if (matrix == null || matrix.length == 0) return null;
    	int left = 0, top = 0;
    	int right = matrix[0].length-1;
    	int bottom = matrix.length-1;
    	int[] res = new int[] {(right+1) * (bottom+1)};
    	int k=0;
    	while (left <= right && top <= bottom) {
    		// 从左到右
			for (int i = left; i <= right; i++) {
				res[k++] = matrix[top][i];
			}
			top++;
			// 从上到下
			for (int i = top; i <= bottom; i++) {
				res[k++] = matrix[i][right];
			}
			right--;
			// 从右往左
			for (int i = right; i >= left && top <= bottom; i--) {
				res[k++] = matrix[bottom][i];
			}
			bottom--;
			// 从下往上
			for (int i = bottom; i >= top && left <= right; i--) {
				res[k++] = matrix[i][left];
			}
			left++;
		}
    	return res;
    }
}
