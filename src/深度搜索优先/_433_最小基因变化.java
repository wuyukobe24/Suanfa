package 深度搜索优先;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _433_最小基因变化 {

	/*
	 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。

假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。

例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）

给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。

注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。

链接：https://leetcode.cn/problems/minimum-genetic-mutation

输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
输出：1
示例 2：

输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
输出：2
	 * */
	
	public static void main(String[] args) {
		
	}
	
//    public int minMutation(String start, String end, String[] bank) {
//
//    	if (start.length() == 0 || bank.length == 0) return -1;
//    	char[] acgt = new char[] {'A','C','G','T'};
//    	List<String> banks = Arrays.asList(bank);
//    	for (int i = 0; i < start.length(); i++) {
//			char c = start.charAt(i);
//			for (int j = 0; j < acgt.length; j++) {
//
//				String tmp = start.replace(c, acgt[j]);
//				if (banks.contains(tmp)) {
//					
//				}
//			}
//		}
//    	return 0;
//    }
}
