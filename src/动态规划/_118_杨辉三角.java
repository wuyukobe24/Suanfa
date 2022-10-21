package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class _118_杨辉三角 {

	/* 
	 * 1、给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
	 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
	 * */
	public static void main(String[] args) {
		
	}
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> list = new ArrayList<>();
    	if (numRows <= 0) return list;
    	for (int i = 0; i < numRows; i++) {
			List<Integer> tmpList = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					tmpList.add(1);
				} else {
					tmpList.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
				}
			}
			list.add(tmpList);
		}
    	return list;
    }
    
    /* 
     * 2、给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
     * */
    public List<Integer> getRow(int rowIndex) {
    	List<List<Integer>> list = new ArrayList<>();
    	if (rowIndex < 0) return new ArrayList<>();
    	for (int i = 0; i <= rowIndex; i++) {
			List<Integer> tmpList = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					tmpList.add(1);
				} else {
					tmpList.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
				}
			}
			list.add(tmpList);
		}
    	return list.get(rowIndex);
    }
}
