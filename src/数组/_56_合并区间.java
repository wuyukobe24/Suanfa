package 数组;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class _56_合并区间 {

	/*
	 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

链接：https://leetcode.cn/problems/merge-intervals
	 * */
	
	// 解题思路(直接看的题解)
	// 1、先将二维数组按照第一个数字进行升序排序；
	// 2、没有重叠区间直接放入结果集，如果有重叠去接，则需要合并重叠区间
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> outputs = new ArrayList<>();
        for(int i = 0; i < intervals.length; ++i) {
            int[] currInterval = intervals[i];
            int left = currInterval[0];
            int right = currInterval[1];
            // 如果符合下面的一个条件，则直接将当前区间放入结果中
            //      1. 当前区间是第一个区间
            //      2. 当前区间和结果中最后一个区间没有重叠
            if(outputs.isEmpty() || outputs.get(outputs.size() - 1)[1] < left) {
                outputs.add(currInterval);
            } else {//有重叠，需要合并
                int newLastRight = Math.max(outputs.get(outputs.size() - 1)[1], right);
                outputs.get(outputs.size() - 1)[1] = newLastRight;
            }
        }
        return outputs.toArray(new int[outputs.size()][]);
    }
}
