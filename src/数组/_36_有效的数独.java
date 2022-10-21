package 数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _36_有效的数独 {

	/*
	 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 

注意：

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
空白格用 '.' 表示。

链接：https://leetcode.cn/problems/valid-sudoku
	 * */
	
	// 思路：使用 HashMap 判断横 竖 和每块里面是否包含重复的数字
    public boolean isValidSudoku(char[][] board) {
    	if (board.length == 0 || board[0].length == 0) return false;
    	int count = board.length;
    	Map<Integer, Set<Integer>> row = new HashMap<>(), col = new HashMap<>(), block = new HashMap<>();
    	for (int i = 0; i < count; i++) {
			row.put(i, new HashSet<>());
			col.put(i, new HashSet<>());
			block.put(i, new HashSet<>());
		}
    	for (int i = 0; i < count; i++) {
    		for (int j = 0; j < count; j++) {
    			char c = board[i][j];
    			if (c == '.') continue;
    			int u = c - '0';
    			int index = i/3*3 + j/3;
    			if (row.get(i).contains(u) || col.get(j).contains(u) || block.get(index).contains(u)) return false;
    			row.get(i).add(u);
    			col.get(j).add(u);
    			block.get(index).add(u);
			}
		}
    	return true;
    }
}
