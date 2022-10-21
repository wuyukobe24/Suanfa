package 二分查找;

import java.util.Arrays;
import java.util.LinkedList;

//import com.sun.tools.javac.util.List;

public class _04_二维数组中的查找 {
	
	public static void main() {
		System.out.println(123);
	}
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
    	if (matrix == null || matrix.length == 0) {
			 return false;
		}
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int row = 0;
    	int col = n-1;
    	while (row < m && col >= 0) {
			if (matrix[row][col] > target) {
				col--;
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				return true;
			}
		}
    	return false;
    }
}





































