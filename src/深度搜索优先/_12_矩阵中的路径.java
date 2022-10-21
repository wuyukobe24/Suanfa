package 深度搜索优先;

public class _12_矩阵中的路径 {
	
	/*
	 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
	 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
	 * 同一个单元格内的字母不允许被重复使用。
	 * 
	 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
	 * 输出：true

	 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
	 * */
	public static void main(String[] args) {
//		char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//		String word = "ABCCED";
		char[][] board = new char[][]{{'A','B'},{'C','D'}};
		String word = "DBAC";
		System.out.println(exist(board, word));
	}
	public static boolean exist(char[][] board, String word) {
		char[] words = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, words, i, j, 0)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean dfs(char[][] board, char[] word, int i, int j, int index) {
		if (i>=board.length || i<0 || j>=board[0].length || j<0 || board[i][j] != word[index]) return false;
		if (index == word.length-1) return true;
		char tmp = board[i][j];
		board[i][j] = '.';
		boolean res = dfs(board, word, i+1, j, index+1) || dfs(board, word, i-1, j, index+1) || dfs(board, word, i, j+1, index+1) || dfs(board, word, i, j-1, index+1);
		board[i][j] = tmp;
		return res;
	}
	
//    public static boolean exist(char[][] board, String word) {
//    	if (board == null || board.length == 0) {
//			return false;
//		}
//    	int colCount = board.length;
//    	int rowCount = board[0].length;
//    	int row = 0;
//    	int col = 0;
//    	if (colCount * rowCount < word.length()) {
//    		return false;
//		}
//    	// 获取每个字符
//    	int i = 0;
//        while (i >= 0 && i < word.length()) {
//        	char w = word.charAt(i); 
//        	if (board[col][row] == word.charAt(i)) {
//        		
//			} else 
//				if (col-1 >= 0 && col-1 < colCount && board[col-1][row] == w) {
//				// 上
//				col--;
//	        	i++;
//	    		System.out.println("上");
//			} else if (row-1 >= 0 && row-1 < rowCount && board[col][row-1] == w) {
//				// 左
//				row--;
//	        	i++;
//	    		System.out.println("左");
//			} else if (col+1 >= 0 && col+1 < colCount && board[col+1][row] == w) {
//				// 下
//				col++;
//	        	i++;
//	    		System.out.println("下");
//			} else if (row+1 >= 0 && row+1 < rowCount && board[col][row+1] == w) {
//				// 右
//				row++;
//	        	i++;
//	    		System.out.println("右");
//			} else {
//	    		System.out.println(222);
//	    		System.out.println(i);
//	        	return false;
//			}
//		}
//    	return true;
//    }
}
